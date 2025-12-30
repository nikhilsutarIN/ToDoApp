package com.github.nikhilsutarIN.todoapp.service;

import com.github.nikhilsutarIN.todoapp.entity.Todo;
import com.github.nikhilsutarIN.todoapp.entity.User;
import com.github.nikhilsutarIN.todoapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {

    @Autowired
    private UserRepository userRepository;

    public List<Todo> getTasksById(String user_id) {
        User user = userRepository.findById(user_id).orElse(null);
        if(user != null && user.getTodos() != null) {
            return user.getTodos();
        }
        return new ArrayList<>();
    }

    public void addTask(String title, String description, String email) {
        User u = userRepository.findByEmail(email).orElse(null);

        Todo todo = new Todo();
        todo.setId(UUID.randomUUID().toString());
        todo.setTitle(title.toUpperCase());
        todo.setDescription(description);
        todo.setStatus(false);

        if(u.getTodos() == null) {
            u.setTodos(new ArrayList<>());
        }

        u.getTodos().add(todo);
        userRepository.save(u);
    }

    public void toggleTask(String todoId, String email) {
        User user = userRepository.findByEmail(email).orElse(null);

        if(user == null) {
            return ;
        }

        if(user.getTodos() != null) {
            Todo todo = user.getTodos().stream()
                    .filter(t -> t.getId().equals(todoId))
                    .findFirst()
                    .orElse(null);

            todo.setStatus(!todo.isStatus());
            userRepository.save(user);
        }
    }

    public void deleteTask(String todoId, String email) {
        User user = userRepository.findByEmail(email).orElse(null);

        if(user != null) {
            if(user.getTodos() != null) {
                user.getTodos().removeIf(t -> t.getId().equals(todoId));
                userRepository.save(user);
            }
        }
    }

}
