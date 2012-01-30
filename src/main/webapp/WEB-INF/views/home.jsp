<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>Tom Hermann</title>
</head>

<div class="hero-unit">
	<div class="row">
		<div class="span7">
			<h2>Developer. Geek. Gamer.</h2>
			<p>Hello, my name is Tom. I am a software developer currently residing in <a href="http://en.wikipedia.org/wiki/Columbia,_Missouri">Columbia, Missouri</a>.</p>
			<p>If you are interested in learning more about me: check out my github projects, my resume, or contact me.</p>
			<a href="http://twitter.com/tomhermann"><img src="<c:url value="/resources/img/twitter.png"/>" alt="Twitter" title="Twitter" /></a>
			<a href="http://www.facebook.com/tomhermann"><img src="<c:url value="/resources/img/facebook.png" />" alt="Facebook" title="Facebook" /></a>
			<a href="<c:url value="/contact" />"><img src="<c:url value="/resources/img/gmail.png" />" alt="Email" title="Email" /></a>
			<a href="http://www.youtube.com/user/tom1432"><img src="<c:url value="/resources/img/youtube.png" />" alt="YouTube" title="YouTube"/></a>
		</div>
		<div class="pull-right">
			<img alt="Tom Hermann" src="<c:url value="/resources/img/me.png" />" width="256px" height="256px">
		</div>
	</div>
</div>