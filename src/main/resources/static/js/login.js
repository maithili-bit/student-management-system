window.onload = function(){

    const form = document.getElementById("loginForm");

    form.addEventListener("submit", function(e){
        e.preventDefault();

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        if(username === "admin" && password === "1234"){
            localStorage.setItem("loggedIn","true");
            window.location.href = "index.html";
        }
        else{
            alert("Invalid Username or Password");
        }
    });

};