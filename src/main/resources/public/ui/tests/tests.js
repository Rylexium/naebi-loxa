function f1() {
    sessionStorage.setItem("subject", document.querySelector('#subject').value)
    sessionStorage.setItem("grade", document.querySelector('#grade').value)
	window.location.href = '/teso';
}
function f2() {
	alert("Goodbye!");
	sessionStorage.removeItem("token");
	sessionStorage.removeItem("is_admin");
	window.location.href = '/auth';
}
function f3() { <!--  document.getElementById(“subject”).value; -->
	postData({
	        "subject": document.querySelector('#subject').value,
	        "grade": document.querySelector('#grade').value
	        });
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
function postData(dictSubjectAndGrade) {
	var xhr = new XMLHttpRequest();
	var url = "/tests";
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onload = function() {
		f4(this.responseText);
	};
	xhr.send(JSON.stringify(dictSubjectAndGrade));
}

if(sessionStorage.getItem("token") == null)
    window.location.href = '/auth';

sessionStorage.removeItem("is_admin")

//if(sessionStorage.getItem("subject") !== null)
//    document.getElementById('subject').getElementsByTagName('option')[sessionStorage.getItem("subject")].selected = 'selected'
//
//if(sessionStorage.getItem("grade") !== null)
//    document.getElementById('grade').getElementsByTagName('option')[sessionStorage.getItem("grade")].selected = 'selected'
