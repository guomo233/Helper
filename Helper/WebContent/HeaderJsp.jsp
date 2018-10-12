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
<!-- 把bootstrap的去掉，在引用他的页面包含 -->
</head>

<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="SelectServlet">路人帮</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<!-- 根据是否登录来决定导航栏的按钮 -->
			<c:choose>
				<c:when test="${not empty localUser }" >
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">${localUser.getUsername() }<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li>
								 <a href="UserDetailServlet?username=${localUser.getUsername() }">用户详情</a>
							</li>
							<li>
								 <a href="#modal-updatePassword" data-toggle="modal">修改密码</a>
							</li>
							<li class="divider">
							</li>
							<li>
								 <a href="LogoutServlet">退出登录</a>
							</li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">消息<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li>
								 <a href="#modal-sendMassage" data-toggle="modal">发消息</a>
							</li>
							<li class="divider">
							<li>
								 <a href="SelectMassageServlet?requester=1">发送的消息</a>
							</li>
							<li>
								 <a href="SelectMassageServlet?requester=2">收到的消息</a>
							</li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">任务<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li>
								 <a href="#modal-releaseTask" data-toggle="modal">发布新任务</a>
							</li>
							<li class="divider">
							</li>
							<li>
								 <a href="SelectServlet?requester=1">发布的任务</a>
							</li>
							<li>
								 <a href="SelectServlet?requester=2">接受的任务</a>
							</li>
						</ul>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						 <a href="#modal-login" data-toggle="modal">登录</a>
					</li>
					<li>
						 <a href="#modal-register" data-toggle="modal">注册</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>
<!--登录对话框-->
<div class="modal fade" id="modal-login" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title text-center text-primary">
					用户登录
				</h3>
			</div>
			<form class="form-horizontal" role="form" method="post" action="LoginServlet">
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="username">
							用户名
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="username" name="username" type="text" required />
						</div>
					</div>
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="password">
							密码
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="password" name="password" type="password" required />
						</div>
					</div>
				</div>
				<div class="modal-footer">	
        			<button type="submit" class="btn btn-primary">登录<tton>
        			<button type="button" class="btn btn-default" data-dismiss="modal">取消<tton>
				</div>
			</form>	
		</div>
	</div>
</div>
<!--注册对话框-->
<div class="modal fade" id="modal-register" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title text-center text-primary" id="myModalLabel">
					用户注册
				</h3>
			</div>
			<form class="form-horizontal" role="form" method="post" action="RegisterServlet">
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="username">
							用户名
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="username" name="username" type="text" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="password">
							密码
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="password" name="password" type="password" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="confirmPassword">
							确认密码
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="confirmPassword" name="confirmPassword" type="password" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="phone">
							电话
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="phone" name="phone" type="number" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="sex">
							性别
						</label>
						<div class="col-sm-6">
							<div class="form-control" id="sex">
								<input name="sex" type="radio" value="男" /> 男
								<input name="sex" type="radio" value="女" /> 女
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
        			<button type="submit" class="btn btn-primary">注册<tton>
        			<button type="button" class="btn btn-default" data-dismiss="modal">取消<tton>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- 修改密码 -->
<div class="modal fade" id="modal-updatePassword" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title text-center text-primary" id="myModalLabel">
					修改密码
				</h3>
			</div>
			<form class="form-horizontal" role="form" method="post" action="UpdatePasswordServlet">
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="password">
							密码
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="password" name="password" type="password" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="confirmPassword">
							确认密码
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="confirmPassword" name="confirmPassword" type="password" required />
						</div>
					</div>
				</div>
				<div class="modal-footer">
        			<button type="submit" class="btn btn-primary">修改<tton>
        			<button type="button" class="btn btn-default" data-dismiss="modal">取消<tton>
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="SendMassageJsp.jsp"/>
<jsp:include page="ReleaseTaskJsp.jsp"/>
</body>
</html>