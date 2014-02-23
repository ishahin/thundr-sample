## Sample thundr application

The thundr-sample project contains sample implementations of the thundr
framework for different deployment environments.

You can read more about thundr [here](http://3wks.github.com/thundr).

## Velocity

This branch of thundr-sample shows simple usage of velocity templating on the server side with the thundr framework.
You can see the sample app running on appengine [here](http://velocity.thundr-sample.appspot.com/)

Read more about Apache Velocity [here](http://velocity.apache.org/)


### Getting it
You can obtain the source by cloning the git repository from github:

	git clone https://github.com/3wks/thundr-sample.git
	
Each branch is for a different employment environment. You can list the examples
available by using, 
	
	git branch
	
Switch to a particular example by checking out the branch
		
	git checkout <branch-name>
	e.g. git checkout velocity
	
To run, use the appengine maven plugin:

	mvn appengine:devserver
		
You can also use the samples as scaffolding - just checkout the branch you want,
remove the git repository and delete any sample code you're not interested in.

	e.g.
	git checkout velocity
	rm -rf .git
	
--------------    
thundr sample application - Copyright (C) 2013 3wks
