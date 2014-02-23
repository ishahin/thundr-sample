import com.threewks.thundr.action.method.MethodAction;
import com.threewks.thundr.route.Route;
import com.threewks.thundr.route.Routes;
import com.threewks.thundr.sample.controller.TaskController;

import static com.threewks.thundr.route.RouteType.*;

public class ApplicationRoutes {
	public static class Names {
		public static final String Home = "home";
		public static final String CreateTask = "create-task";
		public static final String ViewTask = "view-task";
		public static final String UpdateTask = "update-task";
		public static final String StartTask = "start-task";
		public static final String StopTask = "stop-task";
		public static final String FinishedTask = "finished-task";
		public static final String ArchiveTask = "archive-task";
	}
	
	public void addRoutes(Routes routes){
		routes.addRoute(new Route(GET, 	"/", 					Names.Home), 		new MethodAction(TaskController.class, "list"));
		routes.addRoute(new Route(POST,	"/task/create", 		Names.CreateTask), 	new MethodAction(TaskController.class, "create"));
		routes.addRoute(new Route(GET, 	"/task/{task}",			Names.ViewTask), 	new MethodAction(TaskController.class, "view"));
		routes.addRoute(new Route(POST,	"/task/{task}", 		Names.UpdateTask), 	new MethodAction(TaskController.class, "update"));
		routes.addRoute(new Route(GET,	"/task/{task}/start", 	Names.StartTask), 	new MethodAction(TaskController.class, "start"));
		routes.addRoute(new Route(GET,	"/task/{task}/stop", 	Names.StopTask), 	new MethodAction(TaskController.class, "stop"));
		routes.addRoute(new Route(GET,	"/task/{task}/done", 	Names.FinishedTask),new MethodAction(TaskController.class, "done"));
		routes.addRoute(new Route(GET,	"/task/{task}/archive", Names.ArchiveTask),	new MethodAction(TaskController.class, "archive"));
	}
}
