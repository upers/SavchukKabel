<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>${category.name}</h2>
<table>
	<tr>
		<td>NAME</td>
		<td>Joining Date</td>
		<td>Salary</td>
		<td>SSN</td>
		<td></td>
	</tr>
	<c:forEach items="${products}" var="prod">
		<tr>
			<td>${prod.name}</td>
			<td>${prod.description}</td>
		</tr>
	</c:forEach>
</table>
