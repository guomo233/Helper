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
<!-- 发任务 -->
<div class="modal fade" id="modal-releaseTask" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title text-center text-primary" id="myModalLabel">
					发布任务
				</h3>
			</div>
			<form class="form-horizontal" role="form" method="post" action="ReleaseServlet">
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="city">
							城市
						</label>
						<div class="col-sm-6">
							<select class="form-control" id="city" name="city">
							      <option value="大连" selected="selected">大连</option>
							      <option value="北京">北京</option>
							      <option value="长沙">长沙</option>
							      <option value="蚌埠">蚌埠</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="beginPosition">
							物品所在地
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="beginPosition" name="beginPosition" type="text" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="endPosition">
							物品送达地
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="endPosition" name="endPosition" type="text" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="beginTime">
							最早送达时间
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="beginTime" name="beginTime" type="text" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="endTime">
							最晚送达时间
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="endTime" name="endTime" type="text" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="pay">
							跑腿费
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="pay" name="pay" type="number" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="remark">
							备注
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="remark" name="remark" type="text" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="demand">
							需求
						</label>
						<div class="col-sm-6">
							<textarea class="form-control" id="demand" name="demand" required>需求描述</textarea>
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