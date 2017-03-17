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
		},
		//Initialize validation logic when a form is created
        formCreated: function (event, data) {
            data.form.find('input[name="employeeName"]').addClass('validate[required]');
            data.form.find('input[name="age"]').addClass('validate[required]');
            data.form.find('input[name="designation"]').addClass('validate[required]');
            data.form.validationEngine();
        },
        //Validate form when it is being submitted
        formSubmitting: function (event, data) {
            return data.form.validationEngine('validate');
        },
        //Dispose validation logic when form is closed
        formClosed: function (event, data) {
            data.form.validationEngine('hide');
            data.form.validationEngine('detach');
        }
	});
	$('#employeeResultsDiv').jtable('load');
});