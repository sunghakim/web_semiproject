window.onload = function() {
	var comment_form = document.getElementById("comment_form");
	comment_form.addEventListener("submit", commentSubmit);
}

function commentSubmit() {
	var now = new Date();
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	
	this.date.value = year + "-" + month + "-" + date;
}
