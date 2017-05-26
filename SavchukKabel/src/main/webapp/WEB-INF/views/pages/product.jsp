<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>${product.name}</h2>
<table>
	<tr>
		<td>name: ${product.name}</td>
	</tr>
	<tr>
		<td>unit name: ${product.unit.name}</td>
	</tr>
	<tr>
		<td>meta title: ${product.metatTitle}</td>
	</tr>
	<tr>
		<td>key words: ${product.metaKeyWords}</td>
	</tr>

</table>
