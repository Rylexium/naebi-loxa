function f1() {
	window.location.href = '/adus';
}
function f2() {
	window.location.href = '/tests';
    sessionStorage.removeItem("is_admin");
}
function f3() {
	getAllTests();
}
function f4(jsonAllTestsFromServer) {
	//var obj = JSON.parse('[{"id": "1", "name": "101"},{"id": "532165121", "name": "53235"}]');
	var obj = JSON.parse(jsonAllTestsFromServer)
	var Table = document.getElementById("dynamic");
	Table.innerHTML = "";
	var per = document.querySelector('#dynamic');
	for (let i = 0; i < obj.length; i++) 
	{			
		let row = document.createElement('tr');
		let data_1 = document.createElement('td');
		data_1.innerHTML = obj[i].name;	
		row.appendChild(data_1);
		var button    = null;
		var butText   = null;
		button = document.createElement("BUTTON");                   
		button.onclick = function() {
			var tests = {
					id : this.parentNode.id
				};
			var data = JSON.stringify(user);
		};                                        
		butText = document.createTextNode("Отчёт");
		button.appendChild(butText);
		row.appendChild(button);
		button = document.createElement("BUTTON");                   
		button.onclick = function() {
			if (confirm('Вы уверены, что хотите удалить этот тест?')){
                deleteTest(this.parentNode.id);
                location.reload()
			}
		};
		row.id = obj[i].id;
		butText = document.createTextNode("Удалить");//this.parentNode.id;
		button.appendChild(butText);
		row.appendChild(button);
		per.appendChild(row);
	}
}
function getAllTests() {
	var xhr = new XMLHttpRequest();
	var url = "/api/tests/all";
	xhr.open("GET", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
	xhr.onload = function() {
		f4(this.responseText);
	};
	xhr.send(null);
}
function deleteTest(idTest) {
	var xhr = new XMLHttpRequest();
	var url = "/api/tests?idTest=" + idTest;
	xhr.open("DELETE", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
	xhr.send(null);
}
if(sessionStorage.getItem("token") == null)
    window.location.href = '/auth';