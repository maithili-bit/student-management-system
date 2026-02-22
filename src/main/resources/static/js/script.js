// check login
if(localStorage.getItem("loggedIn") !== "true"){
    window.location.href="login.html";
}


window.onload = function(){

    const id = localStorage.getItem("editId");

    if(id){
        document.querySelector('input[name="name"]').value = localStorage.getItem("editName");
        document.querySelector('input[name="email"]').value = localStorage.getItem("editEmail");
        document.querySelector('input[name="course"]').value = localStorage.getItem("editCourse");

        document.getElementById("studentForm").dataset.editing = id;
    }
};


document.getElementById("studentForm").addEventListener("submit", function(e) {

    e.preventDefault(); // stop page refresh

    const student = {
        name: document.querySelector('input[name="name"]').value,
        email: document.querySelector('input[name="email"]').value,
        course: document.querySelector('input[name="course"]').value
    };

	const editId = document.getElementById("studentForm").dataset.editing;

	const url = editId 
	    ? `http://localhost:8080/api/students/${editId}`
	    : "http://localhost:8080/api/students";

	const method = editId ? "PUT" : "POST";

	fetch(url, {
	    method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })
    .then(response => response.json())
    .then(data => {
        alert("Student Registered Successfully!");
        document.getElementById("studentForm").reset();
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Failed to register student");
    });
	
	
});

function logout(){
	    localStorage.removeItem("loggedIn");
	    window.location.href="login.html";
	}
