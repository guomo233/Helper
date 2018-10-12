<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<c:forEach items="${massageList }" var="massage">
<!-- 一条消息↓ -->
<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">
			主题：${massage.getTitle() }
		</h3>
		<p>
			<c:if test="${requester eq 1 }">
				发给：<a href="UserDetailServlet?username=${massage.getTargetUsername() }">${massage.getTargetUsername() }</a>
			</c:if>
			<c:if test="${requester eq 2 && massage.getSenderUsername() ne 'Admin' }">
				来自：<a href="UserDetailServlet?username=${massage.getSenderUsername() }">${massage.getSenderUsername() }</a>
			</c:if>
		</p>
		<p>发送时间：<fmt:formatDate value="${massage.getSendTime() }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></p>
	</div>
	<div class="panel-body">
		内容：${massage.getContent() }
	</div>
</div>
<!-- 一条消息↑ -->
</c:forEach>
</body>
</html>