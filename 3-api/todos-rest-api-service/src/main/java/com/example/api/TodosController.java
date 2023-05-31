package com.example.api;

import com.example.resource.Todo;
import com.example.resource.TodoType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/todos")
public class TodosController {

    private static final Map<Integer, Todo> todos = new HashMap<>(); // in-memory database

    static {
        todos.put(1, new Todo() {{
            setId(1);
            setTitle("Learn Akka");
            setCompleted(false);
            setType(TodoType.WORK);
        }});
        todos.put(2, new Todo() {{
            setId(2);
            setTitle("Learn Spring Boot");
            setCompleted(false);
            setType(TodoType.WORK);
        }});
        todos.put(3, new Todo() {{
            setId(3);
            setTitle("Learn Life");
            setCompleted(false);
            setType(TodoType.HOME);
        }});
        todos.put(4, new Todo() {{
            setId(4);
            setTitle("Learn Cooking");
            setCompleted(false);
            setType(TodoType.HOBBY);
        }});
    }


    //------------------------------------------------
    // read
    //------------------------------------------------

    @GetMapping()
    public Iterable<Todo> getTodos() {
        return todos.values();
    }

    @GetMapping(params = {"limit", "!type"})
    public Iterable<Todo> getTodosByLimit(@RequestParam(required = false, defaultValue = "0") int limit) {
        return todos.values().stream().limit(limit)::iterator;
    }

    @GetMapping(params = {"type", "!limit"})
    public Iterable<Todo> getTodosByType(@RequestParam String type) {
        return todos.values().stream().filter(todo -> todo.getType().equals(TodoType.valueOf(type.toUpperCase())))::iterator;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTodo(@PathVariable int id) {
//        if(todos.containsKey(id)){
//            return ResponseEntity.ok(todos.get(id));
//        }else{
//            return ResponseEntity.notFound().build();
//        }
        Todo todo = todos.get(id);
        if (todo != null) {
            return ResponseEntity.ok(todo);
        } else {
            throw new NotFoundException(id);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.HEAD)
    public ResponseEntity<?> getTodoHead(@PathVariable int id) {
        Todo todo = todos.get(id);
        if (todo != null) {
            HttpHeaders headers=new HttpHeaders();
            headers.add("X-Total-Count","1");
            return ResponseEntity.ok().headers(headers).build();
        } else {
            throw new NotFoundException(id);
        }
    }


    //------------------------------------------------
    // write
    //------------------------------------------------

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> postTodo(@RequestBody Todo todo) {
        todo.setId(todos.size() + 1);
        todos.put(todo.getId(), todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

//    @PutMapping(value = "/{id}",consumes = "application/json")
    @PatchMapping(value = "/{id}",consumes = "application/json")
    public ResponseEntity<?> putTodo(@PathVariable int id,@RequestBody Todo todo) {
        todo.setId(id);
        todos.put(todo.getId(), todo);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable int id) {
        todos.remove(id);
        return ResponseEntity.noContent().build();
    }



}
