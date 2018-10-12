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

<body>
<!-- 消息提示 -->
<div class="modal fade" id="modal-showResult" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">
					提示
				</h4>
			</div>
			<div class="modal-body">
				${info }
			</div>
			<div class="modal-footer">
				 <a href="SelectServlet"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></a>
			</div>
		</div>
	</div>
</div>
<c:if test="${not empty needShowResult && needShowResult }">
	<script>
		${needShowResult = false }
		$('#modal-showResult').modal();
	</script>
</c:if>
</body>
</html>