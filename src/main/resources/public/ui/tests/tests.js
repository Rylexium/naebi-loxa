function f1() {
    sessionStorage.setItem("subject", document.querySelector('#subject').value)
    sessionStorage.setItem("grade", document.querySelector('#grade').value)
	window.location.href = '/uste';
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
		row.id = obj[i].idTest;
		row.onclick = function() {
            sessionStorage.setItem("id_test", this.id)
            window.location.href = '/teso';
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
	var url = "api/tests";
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
	xhr.onload = function() {
		f4(this.responseText);
	};
	xhr.send(JSON.stringify(dictSubjectAndGrade));
}

function restoreState() {
    if(sessionStorage.getItem("subject") !== null) {
        document.getElementById("subject").value = sessionStorage.getItem("subject");
    }

    if(sessionStorage.getItem("grade") !== null) {
        document.getElementById("grade").value = sessionStorage.getItem("grade");
    }
    f3()
}

if(sessionStorage.getItem("token") === null)
    window.location.href = '/auth';

sessionStorage.removeItem("is_admin")

