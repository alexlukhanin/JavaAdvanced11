$("button.createProduct")
		.click(
				function() {
					
					let name = $("form.createProduct input.productName").val();
					let description = $("form.createProduct input.productDescription").val();
					let price = $("form.createProduct input.productPrice").val();

					if (name == '' || price == '')  {
						alert("Please fill the name and price, please!");
					}  else {
						let product = {
							name : name,
							description : description,
							price : price
						};
						$.post("product", product,
							function(data) {
								if (data == 'Success') {
									alert('Success');
								}
							});
					}
				});




$("button.buy-product").click(function() {
	let productId = jQuery(this).attr("product-id");

	$.post("buy", {'productId':productId},
			function(data) {
				if (data == 'Success') {
					$('#buyProductModal').modal('hide');
					alert('Successfully added to the bucket');
					window.location = "/cabinet.jsp";
				}
			});
});






