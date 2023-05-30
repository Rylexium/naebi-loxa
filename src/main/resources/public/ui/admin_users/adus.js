function f1() {
	alert("Hello!");
}
function f2() {
	alert("Goodbye!");
}
function f3() {

	postData1();
}
function f4() {
	var obj = JSON.parse('[{"login": "1"},{"login": "532165121"}]');
	var Table = document.getElementById("dynamic");
	Table.innerHTML = "";
	var per = document.querySelector('#dynamic');
	for (let i = 0; i < obj.length; i++) 
	{			
		let row = document.createElement('tr');
		let data_1 = document.createElement('td');
		data_1.innerHTML = obj[i].login;	
		row.appendChild(data_1);
		var button    = null;
		var butText   = null;
		button = document.createElement("BUTTON");                   
		button.onclick = function() {
			var user = {
					login : this.parentNode.id
				};
			var data = JSON.stringify(user);
			postData2(data);
		};                                        
		butText = document.createTextNode("Отчёт");
		button.appendChild(butText);
		row.appendChild(button);
		button = document.createElement("BUTTON");                   
		button.onclick = function() {
			if (confirm('Вы уверены, что хотите удалить этого пользователя?')){
				var user = {
					login : this.parentNode.id
				};
				alert(JSON.stringify(user));/*Удаление пользоваетеля*/
			}
		};
		row.id = obj[i].login;
		butText = document.createTextNode("Удалить");//this.parentNode.id;
		button.appendChild(butText);
		row.appendChild(button);
		per.appendChild(row);
	}
}
function postData1() {
	var xhr = new XMLHttpRequest();
	var url = "/login-form"; /*ЛЁША, БЛЯТЬ. НУЖНО ПОМЕНЯТЬ!!!!*/
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onload = function() {
		f4(this.responseText);
	};
	var data = JSON.stringify(tests);
	xhr.send(data);
}
function postData2(data) {
	var xhr = new XMLHttpRequest();
	var url = "/login-form"; /*ЛЁША, БЛЯТЬ. НУЖНО ПОМЕНЯТЬ!!!!*/
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onload = function() {
		return this.responseText;
	};
	xhr.send(data);
}
if(sessionStorage.getItem("token") == null)
    window.location.href = '/auth';