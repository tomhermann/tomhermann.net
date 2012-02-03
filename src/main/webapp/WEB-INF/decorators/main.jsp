<%@ page import="java.util.Calendar" session="false" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title><decorator:title default="Tom Hermann" /></title>
    <meta name="author" content="Tom Hermann">
    <meta name="description" content="Somewhere around the intersection of zombies and tanks.">

	<!-- html5 shim -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.js"></script>

	<!-- styles -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <style type="text/css">
      body {
        padding-top: 60px;
      }
    </style>

    <link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico?v03" />">
	<decorator:head />
  </head>

  <body>
    <div class="topbar">
		<div class="fill">
			<div class="container">
				<a class="brand" href="<c:url value="/" />" title="Home">Tom Hermann</a>
				<ul class="nav">
					<li><a href="https://github.com/tomhermann" title="github.com/tomhermann">Projects</a></li>
					<li><a href="<c:url value="/resources/files/tom-hermann-resume.docx" />" title="My résumé">Résumé</a></li>
					<li><a href="<c:url value="/contact" />" title="Contact me">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
    <div class="container">
	  <decorator:body />
      <footer>
        <p>&copy; tomhermann.net <%= Calendar.getInstance().get(Calendar.YEAR) %></p>
      </footer>
    </div>
  </body>
</html>
