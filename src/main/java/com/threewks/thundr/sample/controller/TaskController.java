package com.threewks.thundr.sample.controller;

import java.util.HashMap;
import java.util.Map;

import com.threewks.thundr.http.exception.NotFoundException;
import com.threewks.thundr.sample.Task;
import com.threewks.thundr.sample.service.TaskService;
import com.threewks.thundr.sample.service.TaskStatus;
import com.threewks.thundr.view.handlebars.HandlebarsView;
import com.threewks.thundr.view.redirect.RedirectView;

public class TaskController {
	private TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	public HandlebarsView list() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tasks", taskService.list());
		return new HandlebarsView("tasks", model);
	}

	public RedirectView create(Task task) {
		taskService.put(task);
		return new RedirectView("/task/" + task.getId());
	}

	public HandlebarsView view(Long task) {
		Task taskPojo = taskService.get(task);
		if (taskPojo == null) {
			throw new NotFoundException("Could not find task with id '%s'", task);
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("task", taskPojo);
		return new HandlebarsView("task", model);
	}

	public RedirectView update(Task task) {
		Task existingTask = taskService.get(task.getId());
		existingTask.setTitle(task.getTitle());
		existingTask.setDescription(task.getDescription());
		taskService.put(existingTask);
		return new RedirectView("/task/" + task.getId());
	}

	public RedirectView start(Long task) {
		return updateToStatusAndView(task, TaskStatus.Underway);
	}

	public RedirectView stop(Long task) {
		return updateToStatusAndView(task, TaskStatus.Pending);
	}

	public RedirectView done(Long task) {
		return updateToStatusAndView(task, TaskStatus.Done);
	}

	public RedirectView archive(Long task) {
		Task existingTask = taskService.get(task);
		existingTask.setArchived(true);
		taskService.put(existingTask);
		return new RedirectView("/");
	}

	private RedirectView updateToStatusAndView(Long task, TaskStatus status) {
		Task existingTask = taskService.get(task);
		existingTask.setStatus(status);
		taskService.put(existingTask);
		return new RedirectView("/task/" + task);
	}

}
