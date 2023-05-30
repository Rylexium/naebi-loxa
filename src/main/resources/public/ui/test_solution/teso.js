var obj;
var max_sum = 0;
var n = 0;
function f1() {
	if (confirm('Вы уверены, что хотите закрыть этот тест?'))
	{ /*Переход на страницу с тестами*/}
}
function f2() {

	if (confirm('Вы уверены, что хотите отправить этот тест на проверку?'))
	{ var sum = 0;
		for (let i = 0; i < n; i++)
		{
			if(document.getElementById(`${i}`).value == obj[i].ranswer)
				sum+= obj[i].points;
		}
		alert(`У вас ${sum}/${max_sum}`);
	}
}
function f3() {
	obj = JSON.parse('[{"type":1,"comment":"one answer","question":"2+2=?","answers":["1", "2", "3", "4", "5"],"ranswer": "4","points": 10},{"type":3,"comment":"matching","question":"choose right: a)2+2=?;  b)1+1=?;  c)3+3=?;","answers":["1", "2", "3", "4", "5", "6"],"ranswer": "426","points": 100},{"type":4,"comment":"write correct","question":"7+7=?","answers":[],"ranswer": "49","points": 200}]');
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
				tex = document.createTextNode(obj[i].answers[j]);         
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