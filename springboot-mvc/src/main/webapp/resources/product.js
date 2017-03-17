$(document).ready(function() {
	$('#ResultsDiv').jtable({
		title : 'List of Employees',
		actions : {
			// listAction : 'get',
			listAction : function(postData, jtParams) {
				return $.Deferred(function($dfd) {
					$.ajax({
						url : 'get',
						type : 'GET',
						dataType : 'json',
						data : postData,
						success : function(data) {
							$dfd.resolve(data);
						},
						error : function() {
							$dfd.reject();
						}
					});
				});
			},
			createAction : 'save-edit',
			updateAction : 'save-edit',
			deleteAction : 'delete'
		},
		fields : {
			productId : {
				title : 'Product ID',
				key : true,
				width : '15%',
				edit:true,
				create:true
			},
			productName : {
				title : 'Product Name',
				width : '30%',
				type : 'hidden-edit'
			},
			productDesc : {
				title : 'Product Desc',
				width : '15%'
			},
			quantity : {
				title : 'Quantity',
				width : '25%'
			}
		}
	});
	$('#ResultsDiv').jtable('load');
});