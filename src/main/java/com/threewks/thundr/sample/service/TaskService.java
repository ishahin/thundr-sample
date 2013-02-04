package com.threewks.thundr.sample.service;

import java.util.List;

import com.threewks.thundr.sample.Task;

public interface TaskService {
	public List<Task> list();

	public List<Task> list(TaskStatus status);

	public Task put(Task task);

	public Task get(Long id);
}
