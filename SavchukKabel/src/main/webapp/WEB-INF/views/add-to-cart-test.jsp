<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<mt:tamplate title="TEST ADD TO CART">
	<jsp:attribute name="content">
	
	<h2>"TEST ADD TO CART</h2>	
    <form id="formoid" action="/SavchukKabel/cart/add" title=""
			method="post">
        <div>
            <label class="title">Product id: </label>
            <input type="text" id="id" name="id">
        </div>
        <div>
            <label class="title">Name</label>
            <input type="text" id="name" name="name">
        </div>
        <div>
            <input type="submit" id="submitButton" name="submitButton"
					value="Submit">
        </div>
 </form>
 
	<script type='text/javascript'>
		/* attach a submit handler to the form */
		$("#formoid").submit(function(event) {

			/* stop form from submitting normally */
			event.preventDefault();

			var id = $('#id').val();
			var name = $('#name').val();
			/* get the action attribute from the <form action=""> element */
			var $form = $(this), url = $form.attr('action');

			/* Send the data using post with element id name and name2*/
			var posting = $.post(url, {
				id : $('#id').val(),
				name : $('#name').val()
			});

			/* Alerts the results */
			posting.done(function(data) {
				alert('success');
			});
		});
	</script>
	</jsp:attribute>
</mt:tamplate>