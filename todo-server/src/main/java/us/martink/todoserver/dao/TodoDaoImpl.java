package us.martink.todoserver.dao;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Component;
import us.martink.todoserver.tables.pojos.TodoItem;

import java.time.LocalDateTime;
import java.util.List;

import static us.martink.todoserver.Sequences.TODO_ITEM_ID;
import static us.martink.todoserver.Tables.TODO_ITEM;

/**
 * Created by tadas.
 */
@Component
public class TodoDaoImpl implements TodoDao {

    private DSLContext dsl;

    public TodoDaoImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<TodoItem> findAllByStatus(Boolean archived, int size, int page) {
        Condition condition = DSL.trueCondition();
        if (archived != null)
            condition = condition.and(TODO_ITEM.ARCHIVED.eq(archived));
        return dsl.select()
                .from(TODO_ITEM)
                .where(condition)
                .orderBy(TODO_ITEM.CREATED.desc())
//                .offset(page)
//                .limit(size)
                .fetchInto(TodoItem.class);
    }

    @Override
    public TodoItem createTodoItem(TodoItem todoItem) {
        return dsl.insertInto(TODO_ITEM)
                .set(TODO_ITEM.ID, TODO_ITEM_ID.nextval())
                .set(TODO_ITEM.CREATED, LocalDateTime.now())
                .set(TODO_ITEM.CONTENT, todoItem.getContent())
                .returning().fetchOne().into(TodoItem.class);
    }

    @Override
    public TodoItem updateTodoItem(Long id, TodoItem todoItem) {
        return dsl.update(TODO_ITEM)
                .set(TODO_ITEM.CONTENT, todoItem.getContent())
                .set(TODO_ITEM.ARCHIVED, todoItem.getArchived())
                .where(TODO_ITEM.ID.eq(id))
                .returning().fetchOne().into(TodoItem.class);
    }
}
