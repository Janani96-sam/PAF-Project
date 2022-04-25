$(function() {
	$("#last_bill").focus().select();
	//enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			if (e.target.id === 'last_bill') {
				if (validateRequired('last_bill')) {
					$("#this_bill").focus().select();					
				}
			}else if(e.target.id === 'this_bill'){
				if (validateRequired('this_bill')) {
					$("#last_payment").focus().select();					
				}
			}else if(e.target.id === 'last_payment'){
				if (validateRequired('last_payment')) {
					$("#unit_price").focus().select();					
				}
			}else if(e.target.id === 'unit_price'){
				if (validateRequired('unit_price')) {
						validateSubmit(e);					
				}
			}
		}
	});
});

const validateSubmit = (event) => {
	event.preventDefault();
	
	let err = 0;
	
	if(!validateRequired('last_bill')){
		validateRequired('last_bill');
		err++;
	}
	
	if(!validateRequired('this_bill')){
		validateRequired('this_bill');
		err++;
	}
	
	if(!validateRequired('last_payment')){
		validateRequired('last_payment');
		err++;
	}
	
	if(!validateRequired('unit_price')){
		validateRequired('unit_price');
		err++;
	}
	
	
	if(err == 0){
		 addBill(event);
	}else{
		return false;
	}
}

const addBill = (e) => {
	e.preventDefault();


	Swal.fire({
	  title: 'Are you sure?',
	  text: "You won't be able to revert this!",
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'Yes, Save it!'
	}).then((result) => {
	  if (result.isConfirmed) {
	     const customer = $("#customer").val();
	const last_bill = $("#last_bill").val();
	const this_bill = $("#this_bill").val();
	const last_payment = $("#last_payment").val();
	const unit_price = $("#unit_price").val();
	const id = "bill_payment";
	
	
	//add bill api
	
	$.ajax({
		type: "POST",
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		data: $.param({customer: customer,last_bill: last_bill, this_bill : this_bill,last_payment: last_payment,unit_price:unit_price}),
		url: "/payAPI/webapi/postresource/addPayment",
		//url: "/PaymentManagement/payment?customer="+customer+"&last_bill="+last_bill+"&this_bill="+this_bill
		//+"&last_payment="+last_payment+"&unit_price="+unit_price+"&id="+id,
		success: function (data) {
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Bill Details Saved!',
					'success'
				);
				clearForm();
			}else{
				Swal.fire(
					'Error!',
					'Unable to save!',
					'error'
				);
			}
		
			
		}
	});
	  }
	})


	
};

const clearForm = () => {
	$("#addBillForm").trigger('reset');
};


function check_cus(cus_id){
	let id="load_bill";
	if(cus_id=="0"){
		
	}else{
		
		//get selected coustomer id bill info
		$.ajax({
		type: "POST",
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		data: $.param({customer: cus_id}),
		//url: "/PaymentManagement/payment?customer="+cus_id+"&id="+id,
		url: "/payAPI/webapi/postresource/loadBill",
		success: function (data) {
			console.log(data.data);
			$.each(data.data, function (i, bill) {
				$("#unit_price").val(bill.unit_price);
				$("#bill_no").val(bill.idbill);
				$("#unit").val(bill.this_bill);
				
			});
		}
	});
	}
}

function validate_cal(){
	const unit_price = $("#unit_price").val();
	const unit = $("#unit").val();
	const cus = $("#cus").val();

	
	if(cus=="0"){
		Swal.fire(
					'Error!',
					'Please select Customer !',
					'error'
				);
	}else if(unit_price==""){
		Swal.fire(
					'Error!',
					'Please enter Unit Price !',
					'error'
				);
	}else if(unit==""){
		Swal.fire(
					'Error!',
					'Please enter Unit Consumed !',
					'error'
				);
	}else{
	
		let amount=0.0;
		amount=parseFloat(unit_price)*parseFloat(unit);
		 
		$("#amount").val(amount.toFixed(2));
		
	}
}

function change_month(){
		const new_date = $("#date").val();
		const date = new Date(new_date);  // 2009-11-10
const month = date.toLocaleString('default', { month: 'long' });
$("#month").val(month);
}


function save_amount(){
	
	
	const unit_price = $("#unit_price").val();
	const unit = $("#unit").val();
	const cus = $("#cus").val();
	const amount = $("#amount").val();

	
	if(cus=="0"){
		Swal.fire(
					'Error!',
					'Please select Customer !',
					'error'
				);
	}else if(unit_price==""){
		Swal.fire(
					'Error!',
					'Please enter Unit Price !',
					'error'
				);
	}else if(unit==""){
		Swal.fire(
					'Error!',
					'Please enter Unit Consumed !',
					'error'
				);
	}else if(amount==""){
		Swal.fire(
					'Error!',
					'Please check Total Amount !',
					'error'
				);
	}else{
		
	
	Swal.fire({
	  title: 'Are you sure?',
	  text: "You won't be able to revert this!",
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'Yes, Save Amount!'
	}).then((result) => {
	  if (result.isConfirmed) {
	     const customer = $("#cus").val();
	const bill_no = $("#bill_no").val();
	const month = $("#month").val();
	const amount = $("#amount").val();
	const id = "pay_bill";
	
	 //pay bill amount
	
	$.ajax({
		type: "POST",
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		data: $.param({customer: customer,bill_no: bill_no, month : month,amount:amount}),
		url: "/payAPI/webapi/postresource/payBill",
		//url: "/PaymentManagement/payment?customer="+customer+"&bill_no="+bill_no+"&month="+month
		//+"&amount="+amount+"&id="+id,
		success: function (data) {
			console.log(data);
			if(data){
				Swal.fire(
					'Successful!',
					'Successfuly Paid !',
					'success'
				);
				$("#bill_form").trigger('reset');
				$("#addForm").trigger('reset');
			}else{
				Swal.fire(
					'Error!',
					'Unable to save!',
					'error'
				);
			}
		
			
		}
	});
	  }
	})


		
	}
	
	
	
	
}

