let allStudents = [];


fetch("http://localhost:8080/api/students")
.then(response => response.json())
.then(data => {
	
	allStudents = data;
	    displayStudents(allStudents);

		function displayStudents(students){

		    const table = document.getElementById("studentTable");
		    table.innerHTML = "";

		    students.forEach(student => {
		        const row = `
		        <tr>
		            <td>${student.id}</td>
		            <td>${student.name}</td>
		            <td>${student.email}</td>
		            <td>${student.course}</td>
		            <td>
		                <button class="btn btn-warning btn-sm" onclick="editStudent(${student.id},'${student.name}','${student.email}','${student.course}')">
		                    Edit
		                </button>

		                <button class="btn btn-danger btn-sm" onclick="deleteStudent(${student.id})">
		                    Delete
		                </button>
		            </td>
		        </tr>
		        `;
		        table.innerHTML += row;
		    });
		}
		
		
		
    const table = document.getElementById("studentTable");
    table.innerHTML = "";

    data.forEach(student => {
		const row = `
		<tr>
		    <td>${student.id}</td>
		    <td>${student.name}</td>
		    <td>${student.email}</td>
		    <td>${student.course}</td>
		    <td>
		        <button class="btn btn-warning btn-sm" onclick="editStudent(${student.id},'${student.name}','${student.email}','${student.course}')">
		            Edit
		        </button>

		        <button class="btn btn-danger btn-sm" onclick="deleteStudent(${student.id})">
		            Delete
		        </button>
		    </td>
		</tr>
		`;
        table.innerHTML += row;
    });

})
.catch(error => {
    console.error("Error:", error);
    alert("Failed to load students");
});

function deleteStudent(id){

    if(!confirm("Are you sure you want to delete this student?")){
        return;
    }

    fetch(`http://localhost:8080/api/students/${id}`,{
        method:"DELETE"
    })
    .then(() => {
        alert("Student Deleted Successfully");
        location.reload();
    })
    .catch(error => console.error("Error:",error));
}

function editStudent(id,name,email,course){

    // store in browser temporarily
    localStorage.setItem("editId",id);
    localStorage.setItem("editName",name);
    localStorage.setItem("editEmail",email);
    localStorage.setItem("editCourse",course);

    // go back to form page
    window.location.href="index.html";
}

document.getElementById("searchBox").addEventListener("keyup", function(){

    const value = this.value.toLowerCase();

    const filtered = allStudents.filter(student =>
        student.name.toLowerCase().includes(value)
    );

    displayStudents(filtered);
});
