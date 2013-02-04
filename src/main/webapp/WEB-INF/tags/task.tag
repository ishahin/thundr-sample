<%@ attribute name="task" required="true" type="com.threewks.thundr.sample.Task"%>
<%@ taglib prefix="t" uri="http://threewks.com/thundr/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<article id="${task.id}" class="task media">

	<div class="span1" style="font-size: 4em;">
	  	<t:if condition="${task.status == 'Done'}">
	  		<i class="media-object icon icon-thumbs-up" style="color: #BDB"></i>
	  	</t:if>
	  	<t:elseif condition="${task.status == 'Underway'}">
	  		<i class="media-object icon icon-hand-right" style="color: #A0C0EE"></i>
	  	</t:elseif>
	  	<t:else>
	  	 	<i class="media-object icon icon-thumbs-down" style="color: #CCC"></i>
	  	</t:else>
  	</div>
  	
	<div class="media-body span7">
	    <h4 class="media-heading">
	    <a href="/task/${task.id}">${task.title}</a>	
	    </h4>
		<div>
			${task.description}
		</div>
  	</div>
  	
  	<div class="span3">
  		
	  	<t:if condition="${task.status == 'Done'}">
			<a href="/task/${task.id}/stop" class="btn">Reset</a>
	  		<a href="/task/${task.id}/archive" class="btn">Archive</a>
	  	</t:if>
	  	<t:elseif condition="${task.status == 'Underway'}">
	  		<a href="/task/${task.id}/stop" class="btn">Reset</a>
	  		<a href="/task/${task.id}/done" class="btn btn-success">Done</a>
	  	</t:elseif>
	  	<t:else>
	  	 	<a href="/task/${task.id}/start" class="btn">Start</a>
	  	 	<a href="/task/${task.id}/archive" class="btn">Archive</a>
	  	</t:else>
	  	
 	</div>
</article>