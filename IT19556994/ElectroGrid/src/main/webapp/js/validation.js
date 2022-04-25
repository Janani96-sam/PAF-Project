function ValidateEmail(mail) {
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
		return (true)
	}
	//alert("You have entered an invalid email address!")
	return (false)
}
function phonenumber(inputtxt) {
	var phoneno = /^\d{10}$/;
	if ((inputtxt.match(phoneno))) {
		return true;
	}
	else {
		//alert("message");
		return false;
	}
}

function CheckPassword(inputtxt) 
{ 
var passw=  /^[A-Za-z]\w{7,14}$/;
if(inputtxt.value.match(passw)) 
{ 
alert('Correct, try another...')
return true;
}
else
{ 
alert('Wrong...!')
return false;
}
}