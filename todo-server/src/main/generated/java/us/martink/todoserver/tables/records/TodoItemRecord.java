/*
 * This file is generated by jOOQ.
*/
package us.martink.todoserver.tables.records;


import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;

import us.martink.todoserver.tables.TodoItem;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TodoItemRecord extends TableRecordImpl<TodoItemRecord> implements Record4<Long, LocalDateTime, String, Boolean> {

    private static final long serialVersionUID = -1641332666;

    /**
     * Setter for <code>PUBLIC.TODO_ITEM.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.TODO_ITEM.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>PUBLIC.TODO_ITEM.CREATED</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.TODO_ITEM.CREATED</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>PUBLIC.TODO_ITEM.CONTENT</code>.
     */
    public void setContent(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.TODO_ITEM.CONTENT</code>.
     */
    public String getContent() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.TODO_ITEM.ARCHIVED</code>.
     */
    public void setArchived(Boolean value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.TODO_ITEM.ARCHIVED</code>.
     */
    public Boolean getArchived() {
        return (Boolean) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, LocalDateTime, String, Boolean> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Long, LocalDateTime, String, Boolean> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return TodoItem.TODO_ITEM.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field2() {
        return TodoItem.TODO_ITEM.CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TodoItem.TODO_ITEM.CONTENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field4() {
        return TodoItem.TODO_ITEM.ARCHIVED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component2() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component4() {
        return getArchived();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value2() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value4() {
        return getArchived();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TodoItemRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TodoItemRecord value2(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TodoItemRecord value3(String value) {
        setContent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TodoItemRecord value4(Boolean value) {
        setArchived(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TodoItemRecord values(Long value1, LocalDateTime value2, String value3, Boolean value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TodoItemRecord
     */
    public TodoItemRecord() {
        super(TodoItem.TODO_ITEM);
    }

    /**
     * Create a detached, initialised TodoItemRecord
     */
    public TodoItemRecord(Long id, LocalDateTime created, String content, Boolean archived) {
        super(TodoItem.TODO_ITEM);

        set(0, id);
        set(1, created);
        set(2, content);
        set(3, archived);
    }
}
