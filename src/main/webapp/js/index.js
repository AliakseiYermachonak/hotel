function main(form){
    if(testLogin(form) && testPassword(form)){
        return true;
    }
    return false;
}

function testLogin(form){
    var login = form.login.value;
    if(!/^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$/.test(login)){
        alert("Login not OK");
        return false;
    }
    return true;
}

function testPassword(form){
    var password = form.password.value;
    var repeatPassword = form.rePassword.value;
    if(!/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$/.test(password)){
        alert("Password not OK");
        return false;
    }
    if(password != repeatPassword){
        alert("Pass doesn't match");
        return false;
    }
    return true;
}