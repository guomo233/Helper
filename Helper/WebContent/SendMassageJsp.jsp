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
<!-- 发消息 -->
<div class="modal fade" id="modal-sendMassage" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title text-center text-primary" id="myModalLabel">
					发消息
				</h3>
			</div>
			<form class="form-horizontal" role="form" method="post" action="SendMassageServlet">
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="targetUsername">
							发给
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="targetUsername" name="targetUsername" type="text" value="${user.getUsername() }" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="title">
							主题
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="title" name="title" type="text" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="content">
							内容
						</label>
						<div class="col-sm-6">
							<textarea class="form-control" id="content" name="content" required>消息内容</textarea>
						</div>
					</div>
				</div>
				<div class="modal-footer">
        			<button type="submit" class="btn btn-primary">发送<tton>
        			<button type="button" class="btn btn-default" data-dismiss="modal">取消<tton>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>