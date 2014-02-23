package com.threewks.thundr.sample.service;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.threewks.thundr.gae.objectify.repository.BaseRepository;
import com.threewks.thundr.sample.Task;

public class TaskServiceImpl implements TaskService {
	private BaseRepository<Task> taskRepository = new BaseRepository<>(Task.class, null, null);

	public List<Task> list() {
		return taskRepository.loadByField("archived", false);
	}

	public List<Task> list(TaskStatus status) {
		return ofy().load().type(Task.class).filter("archived", false).filter("status", status).list();
	}

	public Task put(Task task) {
		return taskRepository.save(task).complete();
	}

	public Task get(Long id) {
		return taskRepository.load(id);
	}
}
