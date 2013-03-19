package com.threewks.thundr.sample;

import com.googlecode.objectify.ObjectifyService;
import com.threewks.thundr.http.exception.NotFoundException;
import com.threewks.thundr.injection.BaseInjectionConfiguration;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.sample.service.TaskService;
import com.threewks.thundr.sample.service.TaskServiceImpl;
import com.threewks.thundr.view.ViewResolverRegistry;
import com.threewks.thundr.view.handlebars.SpecificHandlebarsViewResolver;

public class SampleInjectionConfiguration extends BaseInjectionConfiguration {
	@Override
	protected void addServices(UpdatableInjectionContext injectionContext) {
		injectionContext.inject(TaskServiceImpl.class).as(TaskService.class);

		configureObjectify();
		super.addServices(injectionContext);
	}

	private void configureObjectify() {
		ObjectifyService.register(Task.class);
	}

	@Override
	protected void addViewResolvers(ViewResolverRegistry viewResolverRegistry, UpdatableInjectionContext injectionContext) {
		super.addViewResolvers(viewResolverRegistry, injectionContext);
		viewResolverRegistry.addResolver(NotFoundException.class, new SpecificHandlebarsViewResolver<NotFoundException>("404.hbs", true));
	}
}
