<%@page import="com.helper.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/bootstrap3.3.5/css/bootstrap.min.css">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=request.getContextPath() %>/jquery1.11.3/jquery-1.11.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath() %>/bootstrap3.3.5/js/bootstrap.min.js"></script>
        <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<jsp:include page="HeaderJsp.jsp"/>
			<div class="page-header">
				<h1>
					<c:if test="${requester eq 1 }">
						发布的任务
					</c:if>
					<c:if test="${requester eq 2 }">
						接受的任务
					</c:if>
					<small>历史的进程</small>
				</h1>
			</div>
			<jsp:include page="TaskListJsp.jsp"/>
		</div>
	</div>
</div>
<jsp:include page="ShowResultJsp.jsp"/>
</body>
</html>