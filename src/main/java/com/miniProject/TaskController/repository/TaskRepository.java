package com.miniProject.TaskController.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniProject.TaskController.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

