package com.example.api;

import com.example.dto.*;
import com.example.entity.*;
import com.example.repository.*;
import lombok.*;
import org.bson.types.*;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    private final MongoTemplate mongoTemplate;

    @GetMapping
    public ResponseEntity<?> getTodos() {

//        List<Todo> todos = todoRepository.findAll();
//        List<Todo> todos = todoRepository.findIncompleteTodos();

//        List<Todo> todos = mongoTemplate.findAll(Todo.class);
        Query query = new Query();
        query.addCriteria(Criteria.where("completed").is(false));
        List<Todo> todos = mongoTemplate.find(query, Todo.class);

        List<TodoResponseDto> todoRequestDtos = todos.stream().map(todo -> {
                    TodoResponseDto todoResponseDto = new TodoResponseDto();
                    todoResponseDto.setId(todo.getId().toString());
                    todoResponseDto.setTitle(todo.getTitle());
                    todoResponseDto.setCompleted(todo.isCompleted());
                    ProjectResponseDto projectResponseDto = new ProjectResponseDto();
                    projectResponseDto.setName(todo.getProject().getName());
                    todoResponseDto.setProject(projectResponseDto);
                    UserResponseDto userResponseDto = new UserResponseDto();
                    userResponseDto.setId(todo.getUser().getId().toString());
                    userResponseDto.setName(todo.getUser().getName());
                    todoResponseDto.setUser(userResponseDto);
                    return todoResponseDto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(todoRequestDtos);
    }

    @GetMapping("/todosCountByProject")
    public ResponseEntity<?> getTodosCountByProject() {

        GroupOperation groupOperation = Aggregation.group("project.name").sum("_id").as("totalTodos");;
        SortOperation sortOperation = Aggregation.sort(Sort.Direction.DESC, "totalTodos");
        Aggregation aggregation
                = Aggregation.newAggregation(groupOperation, sortOperation);
        AggregationResults<AggregateDto> results = mongoTemplate.aggregate(aggregation, "todos", AggregateDto.class);

        return ResponseEntity.ok(results.getMappedResults());

    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        Todo todo = new Todo();
        todo.setTitle(todoRequestDto.getTitle());
        Project project = new Project();
        project.setName(todoRequestDto.getProjectName());
        todo.setProject(project);
        User user = new User();
        user.setId(new ObjectId(todoRequestDto.getUserId()));
        todo.setUser(user);
        todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
