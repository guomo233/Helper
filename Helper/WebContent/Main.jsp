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
			<!-- 导航 -->
			<jsp:include page="HeaderJsp.jsp"/>
			<div class="jumbotron well">
				<h1>
					路人帮
				</h1>
				<p>
					可以利用此平台发布携带需求，同城用户可以在此平台上通过接受其他用户发布的需求来赚取跑腿费。发动群众的力量，大家一同来交易(￣▽￣)
				</p>
				<p>
					点击↓，发布需求
				</p>
				<p>
				 	<c:choose>
					 	<c:when test="${empty localUser}">
							<a class="btn btn-primary btn-large" href="#modal-login" data-toggle="modal">登录啊 щ(ﾟДﾟщ)</a>
						</c:when>
						<c:otherwise>
							<a class="btn btn-primary btn-large" href="#modal-releaseTask" data-toggle="modal">我要交易(ﾟ▽ﾟ)/</a>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
			<div class="page-header">
				<h1>
					待接任务 <small>Let's Make a deal</small>
				</h1>
			</div>
			<jsp:include page="TaskListJsp.jsp"/>
		</div>
	</div>
</div>
<jsp:include page="ReleaseTaskJsp.jsp"/>
<jsp:include page="ShowResultJsp.jsp"/>
</body>
</html>