$(function() {
	getBill();
});

const getBill = () => {
	
	//load all bill info
	
	$.ajax({
		type: "GET",
		url: "/payAPI/webapi/postresource",
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		//data: $.param({username: $scope.userName, password: $scope.password}),
		success: function (data) {
			 
			$('#tblViewBill > tbody').html('');
			$.each(data.data, function (i, bill) {
				appendBillTable(bill);
			});
		}
	});
}

const appendBillTable = (item) => {
	
	let textToInsert = '';
	textToInsert += addRow(item);
	$('#tblViewBill > tbody').append(textToInsert);
};

const addRow = (item) => {
	
	const statusChangeBtn = '<button type="button" class="btn btn-info btn-xs" id="' + item.idbill + 'changeStatus" onclick="changeStatus(\'' + item.idbill + '\',\'' + item.status + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Change Status</button>';
	const delete_btn = '<button type="button" class="btn btn-danger btn-xs" id="' + item.idbill + 'delete" onclick="deleteBill(\'' + item.idbill + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Delete Bill</button>';
	
	let statusBadge;
	if(item.status == 1){
		statusBadge = '<span class="badge badge-success">Paid</span>'
	}else{
		statusBadge = '<span class="badge badge-danger">Unpaid</span>'
	}
//idpay_bill, cus_id, bill_no, month, tot_amount, status
	let row = '<tr id="' + item.idpay_bill + '">'
		+ '<td>' + item.cus_id + '</td>'
		+ '<td>' + item.bill_no + '</td>'
		+ '<td>' + item.month + '</td>'
		+ '<td>' + item.tot_amount + '</td>'
		+ '<td>' + statusBadge + '</td>'
		+ '<td>'
			+ statusChangeBtn
		+ '</td>'
		+ '<td>'
			+ delete_btn
		+ '</td>'
		+ '</tr>';
	return row;
};

const changeStatus = (id, status) => {
	 
	$("#"+id+"changeStatus").prop("disabled", true);
	Swal.fire({
		title: 'Are you sure?',
		text: "Do you want to change status?",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, proceed!'
	}).then((result) => {
		if (result.value) {
			
			//update bill status
			
			console.log("data sent id "+id+ " st "+status);
			
			$.ajax({
				type: "POST",
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data: $.param({newid: id,statuss:status}),
				url: "/payAPI/webapi/postresource/updateBill",
				success: function (data) {
					if(data){
						getBill();						
					}
					  
				}
			});
			$("#"+id+"changeStatus").prop("disabled", false);
		}else{
			$("#"+id+"changeStatus").prop("disabled", false);
		}
	})
};

const deleteBill = (id) => {
	
	$("#"+id+"changeStatus").prop("disabled", true);
	Swal.fire({
		title: 'Are you sure?',
		text: "Do you want to delete ?",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, proceed!'
	}).then((result) => {
		if (result.value) {
			
			// delete bill
			
			console.log("remove id "+id);
			
			$.ajax({
				type: "POST",
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				data: $.param({customer: id}),
				url: "/payAPI/webapi/postresource/removeBill",
				success: function (data) {
					if(data){
						getBill();						
					}
				}
			});
			$("#"+id+"changeStatus").prop("disabled", false);
		}else{
			$("#"+id+"changeStatus").prop("disabled", false);
		}
	})
};