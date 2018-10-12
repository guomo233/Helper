<%@page import="com.helper.pojo.Task"%>
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
<table class="table">
	<thead>
		<tr>
			<th>物品所在地</th>
			<th>物品送达地</th>
			<th>跑腿费</th>
			<th>发布时间</th>
			<th>状态</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${taskList }" var="task" varStatus="forStatus">
			<c:if test="${task.getStatus() eq Task.FINISHED }">
				<c:set var="tableStyle" value="success" />
				<c:set var="tableStatus" value="已完成" />
			</c:if>
			<c:if test="${task.getStatus() eq Task.WAIT_RECEIVE }">
				<c:set var="tableStyle" value="warning" />
				<c:set var="tableStatus" value="未接受" />
			</c:if>
			<c:if test="${task.getStatus() eq Task.ING }">
				<c:set var="tableStyle" value="error" />
				<c:set var="tableStatus" value="正在进行" />
			</c:if>
			<!-- 一个task ↓ -->
			<tr class="${tableStyle }">
				<!-- 开始地点 -->
				<td>${task.getBeginPosition() }</td>
				<!-- 目标地点 -->
				<td>${task.getEndPosition() }</td>
				<!-- 跑腿费 -->
				<td>￥${task.getPay() }</td>
				<!-- 发布时间 -->
				<td><fmt:formatDate value="${task.getUpdateTime() }" type="time" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<!-- 状态 -->
				<td>${tableStatus }</td>
				<!-- 任务详情按钮 -->
				<td><a class="panel-title" data-toggle="collapse" href="#panel-element-${forStatus.index }"> >> </a></td>
				<td width="250px">
					<!-- 任务详情 -->
					<div id="panel-element-${forStatus.index }" class="panel-collapse collapse ">
						<!-- 发布者请求 -->
						<c:if test="${requester eq 1 }">
							<c:if test="${task.getStatus() ne 0 }">
								<h5>接受用户：<a href="UserDetailServlet?username=${task.getReceiveUsername() }">${task.getReceiveUsername() }</a></h5>
							</c:if>
						</c:if>
						<!-- 接受者请求、首页请求 -->
						<c:if test="${requester ne 1 }">
							<h5>发布用户：<a href="UserDetailServlet?username=${task.getReleaseUsername() }">${task.getReleaseUsername() }</a></h5>
						</c:if>
						<h5>送达时间：</h5>
						<h5>从：<fmt:formatDate value="${task.getBeginTime() }" type="time" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
						<h5>到：<fmt:formatDate value="${task.getEndTime() }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
						<h5>备注：${task.getRemark() }</h5>
						<h5>需求：</h5>
						${task.getDemand() }<br><br>
						<!-- 首页请求 -->
						<c:if test="${requester eq 0 }">
							<c:if test="${empty localUser }">
								<a href="ReceiveServlet?taskId=${task.getTaskId() }"><button type="button" class="btn btn-default btn-success disabled">接受任务</button></a>
							</c:if>
							<c:if test="${not empty localUser }">
								<a href="ReceiveServlet?taskId=${task.getTaskId() }"><button type="button" class="btn btn-default btn-success">接受任务</button></a>
							</c:if>							
						</c:if>
						<!-- 发布者请求 -->
						<c:if test="${requester eq 1 }">
							<c:if test="${task.getStatus() eq 0}" >
								<a href="DeleteServlet?taskId=${task.getTaskId() }"><button type="button" class="btn btn-default btn-success">删除任务</button></a>
							</c:if>
							<c:if test="${task.getStatus() eq 1 }">
								<a href="#modal-evaluat-${forStatus.index }" data-toggle="modal"><button type="button" class="btn btn-default btn-success">完成任务</button></a>
								<!-- 评价用户 -->
								<div class="modal fade" id="modal-evaluat-${forStatus.index }" role="dialog" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h3 class="modal-title text-center text-primary" id="myModalLabel">
													评价用户
												</h3>
											</div>
											<form class="form-horizontal" role="form" method="post" action="FinishServlet?taskId=${task.getTaskId() }">
												<div class="modal-body">
													<div class="form-group">
														<label class="col-sm-4 control-label" for="evaluate">
															评价值：0~5
														</label>
														<div class="col-sm-6">
															<input class="form-control" id="evaluate" name="evaluate" type="number" required />
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
							</c:if>
						</c:if>
						<!-- 接受者请求 -->
						<c:if test="${requester eq 2 && task.getStatus() eq 1}">
							<a href="AbandonServlet?taskId=${task.getTaskId() }"><button type="button" class="btn btn-default btn-success">放弃任务</button></a>
						</c:if>
					</div>
				</td>
			</tr>
			<!-- 一个task ↑ -->
		</c:forEach>
	</tbody>
</table>
</body>
</html>