<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:tamplate title="Корзина">
	<jsp:attribute name="content">
	
	<h2>Корзина</h2>	
	<table>
		<tr>
			<td>Ид</td><td>Имя</td><td>количество</td>
		</tr>
		<c:forEach items="${orderElements}" var="element">
			<tr>
			<td>${element.product.id}</td>
			<td>${element.product.name}</td>
			<td>${element.amount}</td>
			</tr>
		</c:forEach>
	</table>
	</jsp:attribute>
</mt:tamplate>