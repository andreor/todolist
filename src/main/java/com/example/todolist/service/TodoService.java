package com.example.todolist.service;


import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        Sort sortBy = Sort.by(Sort.Order.asc("priority"));
        return todoRepository.findAll(sortBy);
    }

    public List<Todo> delete(Long id)  {
       todoRepository.deleteById(id);
       return list();
    }

    public List<Todo> update(Todo newTodo)  {
        todoRepository.save(newTodo);
        return list();
    }
}
