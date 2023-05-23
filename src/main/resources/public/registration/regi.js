function isCorrect() 
{
	if (isCorrectLogin()&&isCorrectPassword()) 
	{
	    postData();
	}
}

function isCorrectLogin()
{
	var login = document.querySelector('#login').value;
	if (login.length < 5)
	{
		alert('Минимальная длина логина 5 символов.'); 
		return 0;
	}
	else if (!login.match(/^[a-zA-Z0-9]+$/))
	{
		alert('Введены недопустимые символы.'); 
		return 0;
	}
	else 
	{
		return 1;
	}
}

function isCorrectPassword() 
{
	var pwd_1 = document.querySelector('#pwd_1').value;
	var pwd_2 = document.querySelector('#pwd_2').value;
	if (pwd_1.length < 8)
	{
		alert('Минимальная длина пароля 8 символов.');
	}
	else if (!pwd_1.match(/[a-zA-Z]/)||!pwd_1.match(/[0-9]/)||!pwd_1.match(/^[a-zA-Z0-9]+$/)) 
	{
		alert('Введены недопустимые символы.');
	}
	else if (pwd_1 !== pwd_2) 
	{
		alert('Пароли должны совпадать.');
	}
	else 
	{
		return 1;
	}
    document.getElementById("pwd_1").value = ""
    document.getElementById("pwd_2").value = ""
    return 0;
}

window.onbeforeunload = function() {
     sessionStorage.setItem("login", document.getElementById("login").value);
}
window.onload = function() {
    var login = sessionStorage.getItem("login")
    if(login != null || login != "") {
        document.getElementById("login").value = login
    }
}
function postData() {
    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/regi";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function() {
            if(this.responseText == "success") {
                document.getElementById("login").value = ""
                sessionStorage.removeItem("login")
                alert('Регистрация прошла успешно!');
            }
            document.getElementById("pwd_1").value = ""
            document.getElementById("pwd_2").value = ""
        };
    var data = JSON.stringify({
            "fieldLogin": document.getElementById("login").value,
            "fieldPass": document.getElementById("pwd_1").value
         });
    xhr.send(data);
}
