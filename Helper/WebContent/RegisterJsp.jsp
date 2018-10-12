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
<!--注册对话框-->
<div class="modal fade" id="modal-register" role="dialog" aria-hidden="true" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" aria-hidden="true" type="button" data-dismiss="modal">
					×
				<tton>
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
							<input class="form-control" id="username" name="un" type="text" required />
						</div>
					</div>
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="password">
							密码
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="pwd" name="pw" type="password" required />
						</div>
					</div>
					
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="phone">
							电话
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="phone" name="tel" type="number" required />
						</div>
					</div>
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="address">
							性别
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="sex" name="addr" type="text" required />
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
</body>
</html>