<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>"TEST ADD TO CART</h2>
<form id="formoid" action="${pageContext.request.contextPath}/cart/add-multiple" title="" method="post">
	<div class="product">
		<div>
			<label class="title">Product id: </label> <input type="text" name="id">
		</div>
		<div>
			<label class="title">amount: </label> <input type="text" name="amount">
		</div>
	</div>

	<div class="product">
		<div>
			<label class="title">Product id: </label> <input type="text" name="id">
		</div>
		<div>
			<label class="title">amount: </label> <input type="text" name="amount">
		</div>
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

		var multipleOrder = $('.product').map(function() {
			var id = $(this).find("input[name='id']").val();
			var amount = $(this).find("input[name='amount']").val();
			var productForm = {
				'id' : id,
				'amount' : amount
			}
			return productForm;
		}).get();

		console.log(multipleOrder);
		/* Send the data using post with element id name and name2*/
		$.ajax({
			'url' : url,
			'type' : 'POST',
			'data' : JSON.stringify(multipleOrder),
			'dataType' : "json",
			'contentType' : "application/json"
		});
	});
</script>
