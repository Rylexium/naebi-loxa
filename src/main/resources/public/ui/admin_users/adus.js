function f1() {
	window.location.href = '/adte';
}
function f2() {
    window.location.href = '/tests';
    sessionStorage.removeItem("is_admin");
}
function f3() {
	getAllUsers();
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
            getTestsByLogin(this.parentNode.id)
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
				deleteUserByLogin({ login : this.parentNode.id })
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
function getAllUsers() { //получение список пользователей
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
function deleteUserByLogin(data) { //запрос на удаление пользователя по id
	var xhr = new XMLHttpRequest();
	var url = "/api/admin/users";
	xhr.open("DELETE", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
    alert(JSON.stringify(data))
	xhr.send(null);
}

function getTestsByLogin(login) {
	var xhr = new XMLHttpRequest();
	var url = "/api/tests/user?login=" + login;
	xhr.open("GET", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
    xhr.onload = function() {
        if(this.responseText.length !== 2) { //если что-то пришло
            fa(this.responseText);
        }
    };
	xhr.send(null);
}
function fa(jss) {
    //var data = JSON.parse('[{"score": "23/32","login": "admin"},{"score": "5/61","login": "admin"}]');
    var data = JSON.parse(jss);
    var mas = [["Тест", "Результат"]];
    for (let i = 0; i < data.length; i++)
    {
        mas.push([data[i].name, data[i].score]);
    }
    var res = `Всего количество прохождений: ${data.length}`;
    mas.push([res, ""]);
    var workbook = XLSX.utils.book_new();
    var worksheet = XLSX.utils.aoa_to_sheet(mas);
    workbook.SheetNames.push("First");
    workbook.Sheets["First"] = worksheet;
    XLSX.writeFile(workbook, "report_adus.xlsx");
}

if(sessionStorage.getItem("token") == null)
    window.location.href = '/auth';
if(sessionStorage.getItem("is_admin") === null)
    window.location.href = '/tests';