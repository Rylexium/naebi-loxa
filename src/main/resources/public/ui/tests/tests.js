function f1() {
	alert("Hello!");
}
function f2() {
	alert("Goodbye!");
}
function f3() { <!--  document.getElementById(“subject”).value; -->
	var per1 = document.querySelector('#subject').value;
	var per2 = document.querySelector('#grade').value;
	var tests = {
		subject: per1,
		grade: per2
	};
	postData(tests);
}
function f4(jss) {
	var obj = JSON.parse(jss);
	var Table = document.getElementById("dynamic");
	Table.innerHTML = "";
	var per = document.querySelector('#dynamic');
	for (let i = 0; i < obj.length; i++) 
	{		
		let row = document.createElement('tr');
		row.id = obj[i].id_test;
		row.onclick = function() {
		const id = this.id;
		alert(id);
		};
		let data_1 = document.createElement('td');
		data_1.innerHTML = obj[i].name;
		/**/
		row.appendChild(data_1);
		per.appendChild(row);
	}
}
function postData(tests) {
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
function stringToHash(string) {
	var hash = 0;
	if (string.length == 0) return hash;
	for (i = 0; i < string.length; i++) {
		char = string.charCodeAt(i);
		hash = ((hash << 5) - hash) + char;
		hash = hash & hash;
	}            
	return hash;
}
if(sessionStorage.getItem("token") == null)
    window.location.href = '/auth';