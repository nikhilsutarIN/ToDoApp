package com.github.nikhilsutarIN.todoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private String id;
    private String title;
    private String description;
    private boolean status;
}
