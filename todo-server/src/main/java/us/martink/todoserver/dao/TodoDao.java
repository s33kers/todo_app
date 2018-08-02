package us.martink.todoserver.dao;

import us.martink.todoserver.tables.pojos.TodoItem;

import java.util.List;

/**
 * Created by tadas.
 */
public interface TodoDao {

    List<TodoItem> findAllByStatus(Boolean archived, int size, int page);

    TodoItem createTodoItem(TodoItem todoItem);

    TodoItem updateTodoItem(Long id, TodoItem todoItem);

}
