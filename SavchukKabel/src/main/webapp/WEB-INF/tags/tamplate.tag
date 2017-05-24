<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="content" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/css/main-styles.css" />">
<script src="<c:url value="/js/jquery-3.2.1.min.js" />"></script>
<script src="<c:url value="/js/tether.min.js" />"></script>
<script src="<c:url value="/js/bootstrap.min.js" />"></script>
<title>${title}</title>
</head>
<body>
	<div id="main_container">
		<div id="header"></div>

		<div class="container">${content}</div>

		<div id="footer">
			<div class="container">
				<span class="text-muted">Place sticky footer content here.</span>
			</div>
		</div>
	</div>
</body>
</html>