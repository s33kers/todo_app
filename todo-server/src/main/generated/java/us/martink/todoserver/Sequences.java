/*
 * This file is generated by jOOQ.
*/
package us.martink.todoserver;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in PUBLIC
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>PUBLIC.TODO_ITEM_ID</code>
     */
    public static final Sequence<Long> TODO_ITEM_ID = new SequenceImpl<Long>("TODO_ITEM_ID", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
