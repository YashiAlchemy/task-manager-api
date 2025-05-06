package com.miniProject.TaskController.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniProject.TaskController.model.Task;
import com.miniProject.TaskController.repository.TaskRepository;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskRepository taskRepo;

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskRepo.save(task);
	}

	@GetMapping
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id) {
		Optional<Task> task = taskRepo.findById(id);
		if (task.isPresent()) {
			Task t = task.get();
			t.setCompleted(true);
			return ResponseEntity.ok(taskRepo.save(t));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskRepo.deleteById(id);
	}
}