thundr sample application.
Copyright (C) 2013 3wks

## Sample thundr application

This branch contains a working implementation of a thundr application
running using Google's AppEngine (GAE).

You can download this code and run it, or use it as an application template.

To run, use the appengine maven plugin:

	mvn appengine:devserver
	
To deploy, update the <application> element in /src/main/webapp/WEB-INF/appengine-web.xml to an app-id you own,
then run:

    mvn appengine:update