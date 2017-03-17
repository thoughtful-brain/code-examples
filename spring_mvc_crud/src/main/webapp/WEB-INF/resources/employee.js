$(document).ready(function() {
	$('#employeeResultsDiv').jtable({
//		paging : false,
//		sorting : false, 
//		clientSort : true, // this needs jquery.tablesorter.min.js
//		columnResizable : false,
//		columnSelectable : false,
//		selecting : false,
//		multiselect : false,
//		selectingCheckboxes : true,
//		ajaxSettings: { type: 'GET', dataType: 'json' },
		title :'List of Employees',
		actions : {
//			listAction : 'get',
			listAction : function (postData, jtParams) {
			    return $.Deferred(function ($dfd) {
			        $.ajax({
			            url: 'get',
			            type: 'GET',
			            dataType: 'json',
			            data: postData,
			            success: function (data) {
			                $dfd.resolve(data);
			            },
			            error: function () {
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
			employeeId : {
				title : 'Employee ID',
				key : true,
				width : '15%'
			},
			employeeName : {
				title : 'Full Name',
				width : '30%',
				type : 'hidden-edit'
			},
			age : {
				title : 'Age',
				width : '15%'
			},
			designation : {
				title : 'Designation',
				width : '25%'
			}
		}
	});
	$('#employeeResultsDiv').jtable('load');
});