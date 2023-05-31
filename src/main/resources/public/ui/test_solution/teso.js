var obj;
var max_sum = 0;
var n = 0;

function f1() {
	if (confirm('Вы уверены, что хотите закрыть этот тест?')) {
	    /*Переход на страницу с тестами*/
	    window.location.href = '/tests';
	}
}
function f2() {
	if (confirm('Вы уверены, что хотите отправить этот тест на проверку?')) {
	    var sum = 0;
		for (let i = 0; i < n; i++) {
			if(document.getElementById(`${i}`).value == obj[i].ranswer)
				sum+= obj[i].points;
		}
		alert(`У вас ${sum}/${max_sum}`);
		var json = {
		    idTest: sessionStorage.getItem("id_test"),
		    login: sessionStorage.getItem("login"),
		    points: `${sum}/${max_sum}`
		}
		postTestResult(JSON.stringify(json))
		//отсюда отправлять результат
        window.location.href = '/tests';
	}
}
function f3(jsonFromServer) {
    obj = JSON.parse(jsonFromServer)
	var Table = document.getElementById("dynamic");
	Table.innerHTML = "";
	var per = document.querySelector('#dynamic');
	max_sum = 0;
	n = obj.length
	for (let i = 0; i < n; i++) 
	{
		max_sum += obj[i].points;
		var inElement = null;
		var tex    = null;				
		inElement = document.createElement("P");
		inElement.className = "d-butts";					 
		tex = document.createElement("text");                   
		tex = document.createTextNode(`_${i+1}_`);         
		inElement.appendChild(tex);
		tex = document.createElement("br");												 
		inElement.appendChild(tex);
		tex = document.createElement("text");
		tex = document.createTextNode(obj[i].question);												 
		inElement.appendChild(tex);
		tex = document.createElement("br");												 
		inElement.appendChild(tex);
		tex = document.createElement("text");												 
		tex = document.createTextNode(`Подсказка: ${obj[i].comment}`);
		inElement.appendChild(tex);
		tex = document.createElement("br");												 
		inElement.appendChild(tex);		
		if (obj[i].type != 4)
		{
			for (let j = 0; j < obj[i].answers.length; j++)
			{
				tex = document.createElement("text");                   
				tex = document.createTextNode(`${j+1}) `);         
				inElement.appendChild(tex);
				tex = document.createElement("text");                   
				tex = document.createTextNode(obj[i].answers[j].answer);
				inElement.appendChild(tex);
				tex = document.createElement("br");												 
				inElement.appendChild(tex);
			}
		}
		tex = document.createElement("input");
		tex.value = "";
		tex.id = i;
		inElement.appendChild(tex);
		let row = document.createElement('tr');
		let data_1 = document.createElement('td');      
		row.appendChild(inElement);
		per.appendChild(row)
	}	
}
function getTestData() {
	var xhr = new XMLHttpRequest();
	var url = "/api/tests?idTest=" + sessionStorage.getItem("id_test");
	xhr.open("GET", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
	xhr.onload = function() {
		f3(this.responseText);
	};
	xhr.send(null);
}
function postTestResult(data) {
	var xhr = new XMLHttpRequest();
	var url = "/api/tests/result";
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", "Bearer " + sessionStorage.getItem("token"))
	xhr.onload = function() {
		return this.responseText;
	};
	xhr.send(data);
}
if(sessionStorage.getItem("token") == null)
    window.location.href = '/auth';