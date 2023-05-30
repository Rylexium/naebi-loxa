function f1() {
	window.location.href = '/tests';
}
function f2() {
	alert("Goodbye!");
	sessionStorage.removeItem("token");
	sessionStorage.removeItem("is_admin");
	window.location.href = '/auth';
}
function f3() {
	postData1();
}
function f4(jsonResultTestFromServer) {
	var obj = JSON.parse(jsonResultTestFromServer)
	var Table = document.getElementById("dynamic");
	Table.innerHTML = "";
	var per = document.querySelector('#dynamic');
	for (let i = 0; i < obj.length; i++) 
	{			
		let row = document.createElement('tr');
		let data_1 = document.createElement('td');
		data_1.innerHTML = obj[i].name;	
		row.appendChild(data_1);
		let data_2 = document.createElement('td');
		data_2.style="width:120px";                                                         
		data_2.innerHTML = `${obj[i].score}`;
		row.appendChild(data_1);
		row.appendChild(data_2);
		per.appendChild(row);
	}
}
function postData1() {
	var xhr = new XMLHttpRequest();
	var url = "/api/tests/result?login=" + sessionStorage.getItem("login");
	xhr.open("GET", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
	xhr.onload = function() {
		f4(this.responseText);
	};
	xhr.send(null);
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
