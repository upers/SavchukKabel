<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>List of Employees</h2>
<table>
	<tr>
		<td>NAME</td>
		<td>Joining Date</td>
		<td>Salary</td>
		<td>SSN</td>
		<td></td>
	</tr>
	<c:forEach items="${categories}" var="category">
		<tr>
			<td>${category.name}</td>
			<td>${category.description}</td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="<c:url value='/new' />">Add New Category</a>
