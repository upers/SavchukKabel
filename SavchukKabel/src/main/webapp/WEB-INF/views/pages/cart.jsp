<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Корзина</h2>
<table class="table">
	<tr>
		<td>Ид</td>
		<td>Имя</td>
		<td>количество</td>
	</tr>
	<c:forEach items="${orderElements}" var="element">
		<tr>
			<td>${element.product.id}</td>
			<td>${element.product.name}</td>
			<td>${element.amount}</td>
		</tr>
	</c:forEach>
</table>
