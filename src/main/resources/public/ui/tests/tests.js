function f1() {
    alert("Hello!");
}
function f2() {
    alert("Goodbye!");
    document.location.href = "/auth"
}
function f3() { <!--  document.getElementById(“subject”).value; -->
    var per1 = document.querySelector('#subject').value;
    var per2 = document.querySelector('#grade').value;
    alert(per1);
    alert(per2);
}
