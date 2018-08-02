package us.martink.todoserver.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import us.martink.todoserver.dao.TodoDao;
import us.martink.todoserver.tables.pojos.TodoItem;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by tadas.
 */
@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    private TodoDao todoDao;

    public TodoController(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<TodoItem> getTodoItems(
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "archived", required = false) Boolean archived){
        return todoDao.findAllByStatus(archived, size, page);
    }

    @RequestMapping(method = RequestMethod.POST)
    public TodoItem createTodo(@RequestBody TodoItem todoItem) {
        return todoDao.createTodoItem(todoItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TodoItem editTodo(@PathVariable("id") Long id,
                             @Valid @RequestBody TodoItem todoItem) {
        return todoDao.updateTodoItem(id, todoItem);
    }
}
