/*
 * This file is generated by jOOQ.
*/
package us.martink.todoserver;


import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import us.martink.todoserver.tables.Databasechangeloglock;
import us.martink.todoserver.tables.TodoItem;
import us.martink.todoserver.tables.records.DatabasechangeloglockRecord;
import us.martink.todoserver.tables.records.TodoItemRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DatabasechangeloglockRecord> PK_DATABASECHANGELOGLOCK = UniqueKeys0.PK_DATABASECHANGELOGLOCK;
    public static final UniqueKey<TodoItemRecord> PK_TODO = UniqueKeys0.PK_TODO;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<DatabasechangeloglockRecord> PK_DATABASECHANGELOGLOCK = Internal.createUniqueKey(Databasechangeloglock.DATABASECHANGELOGLOCK, "pk_databasechangeloglock", Databasechangeloglock.DATABASECHANGELOGLOCK.ID);
        public static final UniqueKey<TodoItemRecord> PK_TODO = Internal.createUniqueKey(TodoItem.TODO_ITEM, "pk_todo", TodoItem.TODO_ITEM.ID);
    }
}
