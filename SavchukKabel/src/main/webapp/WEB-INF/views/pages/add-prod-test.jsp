<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>"TEST ADD TO CART</h2>
<form id="formoid" action="${pageContext.request.contextPath}/cart/add" title="" method="post">
	<div>
		<label class="title">Product id: </label> <input type="text" id="id" name="id">
	</div>
	<div>
		<label class="title">amount: </label> <input type="text" id="amount" name="amount">
	</div>
	<div>
		<input type="submit" id="submitButton" name="submitButton" value="Submit">
	</div>
</form>

<script type='text/javascript'>
	/* attach a submit handler to the form */
	$("#formoid").submit(function(event) {

		/* stop form from submitting normally */
		event.preventDefault();

		/* get the action attribute from the <form action=""> element */
		var $form = $(this), url = $form.attr('action');

		var order = {
			'id' : $('#id').val(),
			'amount' : $('#amount').val(),

		}
		$.ajax({
			'url' : url,
			'type' : 'POST',
			'data' : JSON.stringify(order),
			'dataType' : "json",
			'contentType' : "application/json",
			'success' : function(data) {
				console.log(data.message);
			},
			'error' : function(data) {
				console.log(data.error);
			}
		});
	});
</script>
