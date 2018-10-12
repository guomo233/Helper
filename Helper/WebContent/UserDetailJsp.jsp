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
			<div class="row clearfix">
				<div class="col-md-12 column">
					<jsp:include page="HeaderJsp.jsp"/>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								个人信息：
							</h3>
						</div>
						<div class="panel-body">
							<address>
								<strong>${user.getUsername() }</strong><br />
								<abbr title="Phone">手机：</abbr>${user.getPhone() }<br /> 
								${user.getSex() }<br />
							</address>
							<c:choose>
								<c:when test="${user.getUsername() eq localUser.getUsername() }">
									<a href="#modal-updateUserInfo" data-toggle="modal">编辑个人信息</a>
								</c:when>
								<c:otherwise>
									<a href="#modal-sendMassage" data-toggle="modal">发消息</a>
								</c:otherwise>
							</c:choose>
							
						</div>
					</div> 
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-8 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								动态：
							</h3>
						</div>
						<div class="panel-body">
							<c:forEach items="${recordingList }" var="recording">
								<!-- 一条动态↓ -->
								<div class="panel panel-info">
									<div class="panel-heading">
										<h3 class="panel-title">
											<fmt:formatDate value="${recording.getUpdateTime() }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
										</h3>
									</div>
									<div class="panel-body">
										${recording.getAction() }
									</div>
								</div>
								<!-- 一条动态↑ -->
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="col-md-4 column">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								历史的进程
							</h3>
						</div>
						<div class="panel-body">
							<ul>
								<li>
									成单数量：${user.getFinishTimes() }
								</li>
								<li>
									评价值：${user.getEvaluate() } / 5.0
								</li>
							</ul>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 编辑个人资料 -->
<div class="modal fade" id="modal-updateUserInfo" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title text-center text-primary" id="myModalLabel">
					编辑个人信息
				</h3>
			</div>
			<form class="form-horizontal" role="form" method="post" action="UpdateUserInfoServlet">
				<div class="modal-body">
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
        			<button type="submit" class="btn btn-primary">提交<tton>
        			<button type="button" class="btn btn-default" data-dismiss="modal">取消<tton>
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="SendMassageJsp.jsp"/>
<jsp:include page="ShowResultJsp.jsp"/>
</body>
</html>