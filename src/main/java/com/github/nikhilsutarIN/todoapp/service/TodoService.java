package com.github.nikhilsutarIN.todoapp.service;

import com.github.nikhilsutarIN.todoapp.entity.Todo;
import com.github.nikhilsutarIN.todoapp.entity.User;
import com.github.nikhilsutarIN.todoapp.repo.TodoRepository;
import com.github.nikhilsutarIN.todoapp.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Todo> getAllTasks() {
        return todoRepository.findAll();
    }

    public List<Todo> getTasksById(int user_id) {
        return todoRepository.findByUserId(user_id);
    }

    public void addTask(String title, String description, String email) {

        User u = userRepository.findByEmail(email).orElse(null);

        Todo todo = new Todo();
        todo.setTitle(title.toUpperCase());
        todo.setDescription(description);
        todo.setStatus(false);
        todo.setUser(u);
        todoRepository.save(todo);
    }

    public void toggleTask(int id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("Invalid todo id") );
        todo.setStatus(!todo.isStatus());
        todoRepository.save(todo);
    }

    @Transactional
    public void deleteTask(int id, String email) {

        User user = userRepository.findByEmail(email).orElse(null);
        Integer userId = user.getId();

        int rows = todoRepository.deleteByIdAndUserId(id, userId);
//        System.out.println("rows: " + rows);

//        todoRepository.deleteById(id);
    }

    public Integer getUserIdByTaskId(int id) {
        Todo todo = todoRepository.findById(id).orElse(null);

        if(todo != null) {
            return todo.getUser().getId();
        }

        return null;
    }

}
