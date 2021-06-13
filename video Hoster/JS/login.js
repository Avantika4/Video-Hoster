
var formsup=document.getElementById("singupji");
formsup.addEventListener('submit', signup);

function signup(event)
{
	let usrid = document.getElementById("signup_uid").value;
	let pass = document.getElementById("signup_pass").value;
    let uname=document.getElementById("signup_pass").value;
    let mobile=document.getElementById("signup_mobile").value;
    let email=document.getElementById("signup_email").value;
    event.preventDefault();
    var xhttp = new XMLHttpRequest();
   // xhttp.open("POST", "https://userdetailsbybal.herokuapp.com/add", true);
     xhttp.open("POST", "http://localhost:8080/user/signin", true);
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText === "false") {
                alert("NOt added");
                event.preventDefault();
                return
            } else {
                alert("Useradded");
                event.preventDefault();
                sessionStorage.setItem("userid",this.responseText);
                window.location=("./home.html");

            }

        }
    };
    var data = {
            "email": email,
            "mobileno": mobile,
            "password": pass,
            "userName": uname,
            "user_id": usrid
    };
    xhttp.send(JSON.stringify(data));
}
var formClass=document.getElementById("loginji");
formClass.addEventListener('submit', loginbtn);

function loginbtn(event)
{
	let usrid = document.getElementById("login_uid").value;
	let pass = document.getElementById("login_pass").value;
    console.log(usrid+pass);
    event.preventDefault();
    var xhttp = new XMLHttpRequest();
   // xhttp.open("POST", "https://userdetailsbybal.herokuapp.com/add", true);
     xhttp.open("POST", "http://localhost:8080/user/login", true);
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText === "false") {
                alert("UserInvalid");
                event.preventDefault();
                return
            } else {
                alert("You are logged in");
                event.preventDefault();
                
                sessionStorage.setItem("userid",this.responseText);
                window.location=("./home.html");

            }

        }
    };
    var data = {
			"password": pass,
			"user_id": usrid
    };
    xhttp.send(JSON.stringify(data));
}
