package com.threewks.thundr.sample.service;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.threewks.thundr.sample.Task;

public class TaskServiceImpl implements TaskService {

	public List<Task> list() {
		return ofy().load().type(Task.class).filter("archived", false).list();
	}

	public List<Task> list(TaskStatus status) {
		return ofy().load().type(Task.class).filter("archived", false).filter("status", status).list();
	}

	public Task put(Task task) {
		ofy().save().entity(task).now();
		return task;
	}

	public Task get(Long id) {
		return ofy().load().type(Task.class).id(id).get();
	}
}
