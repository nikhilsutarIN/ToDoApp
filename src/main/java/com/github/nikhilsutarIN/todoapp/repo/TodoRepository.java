package com.github.nikhilsutarIN.todoapp.repo;

import com.github.nikhilsutarIN.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByUserId(int user_id);

    void deleteById(int id);

    @Modifying
    @Query("DELETE FROM Todo t WHERE t.id = :taskId and t.user.id = :userId")
    int deleteByIdAndUserId(@Param("taskId") Integer taskId,  @Param("userId") Integer userId);

}
