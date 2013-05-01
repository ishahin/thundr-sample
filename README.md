## Sample thundr application

The thundr-sample project contains sample implementations of the thundr
framework for different deployment environments.

You can read more about thundr [here](http://3wks.gitub.com/thundr)

## Handlebars

This branch of thundr-sample shows simple usage of handlebars templating on the server side with the thundr framework.
You can see sample app running on appengine [here](http://handlebars.thundr-sample.appspot.com/)

The handlebars implementation is provided by [jknack](https://github.com/jknack/handlebars.java).

Read more about handlebars [here](http://handlebarsjs.com/)


### Getting it
You can obtain the source by cloning the git repository from github:

	git clone https://github.com/3wks/thundr-sample.git
	
Each branch is for a different employment environment. You can list the examples
available by using, 
	
	git branch
	
Switch to a particular example by checking out the branch
		
	git checkout <branch-name>
	e.g. git checkout handlebars
	
You can also use the samples as scaffolding - just checkout the branch you want,
remove the git repository and delete any sample code you're not interested in.

	e.g.
	git checkout handlebars
	rm -rf .git
	
### thundr-handlebars

This branch contains a working implementation of a thundr for google appengine which uses
handlebars as a templating engine.

Read more about thundr-handlebars [here](http://3wks.github.io/thundr/modules/thundr-handlebars/handlebars.html)
Read more about thundr-gae [here](http://3wks.github.io/thundr/modules/thundr-gae/appengine.html)

To run, use the appengine maven plugin:

	mvn appengine:devserver
	
--------------    
thundr sample application - Copyright (C) 2013 3wks