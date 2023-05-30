function f1() {
	window.location.href = '/adte';
}
function f2() {
    window.location.href = '/tests';
    sessionStorage.removeItem("is_admin");
}
function f3() {
	postData1();
}
function f4(jsonUsersFromServer) {
	var obj = JSON.parse(jsonUsersFromServer);
	//var obj = JSON.parse('[{"login": "1"},{"login": "532165121"}]');
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
				}; /*Удаление пользоваетеля*/
				postData2({ login : this.parentNode.id })
                location.reload()
			}
		};
		row.id = obj[i].login;
		butText = document.createTextNode("Удалить");//this.parentNode.id;
		button.appendChild(butText);
		row.appendChild(button);
		per.appendChild(row);
	}
}
function postData1() { //получение список пользователей
	var xhr = new XMLHttpRequest();
	var url = "/api/admin/users";
	xhr.open("GET", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
	xhr.onload = function() {
		f4(this.responseText);
	};
	xhr.send(null);
}
function postData2(data) { //запрос на удаление пользователя по id
	var xhr = new XMLHttpRequest();
	var url = "/api/admin/users"; /*ЛЁША, БЛЯТЬ. НУЖНО ПОМЕНЯТЬ!!!!*/
	xhr.open("DELETE", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
    alert(JSON.stringify(data))
	xhr.onload = function() {
		//pass after deleted user
	};
	xhr.send(JSON.stringify(data));
}
if(sessionStorage.getItem("token") == null)
    window.location.href = '/auth';
if(sessionStorage.getItem("is_admin") === null)
    window.location.href = '/tests';