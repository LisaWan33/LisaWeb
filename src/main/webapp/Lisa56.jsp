<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.lisa.api.LisaUtils" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="score">${LisaUtils.createScore() }</c:set>
		Score: ${score }<br />
		
		<c:if test="${score >= 90 }">A</c:if>
		<c:if test="${score >= 80 }">B</c:if>
		<c:if test="${score >= 70 }">C</c:if>
		<c:if test="${score >= 60 }">D</c:if>
		<c:if test="${score < 90 }">E</c:if>
		<hr />
		
		<c:choose>
			<c:when test="${score >= 90} ">A</c:when>
			<c:when test="${score >= 80}">B</c:when>
			<c:when test="${score >= 70}">C</c:when>
			<c:when test="${score >= 60}">D</c:when>
			<c:otherwise>E</c:otherwise>
		</c:choose>
		
		<hr />
		<c:choose>
			<c:when test="${score >= 90 }">A</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${score >= 80 }">B</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${score >= 70 }">C</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${score >= 60 }">D</c:when>
									<c:otherwise>
										E
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</body>
</html>