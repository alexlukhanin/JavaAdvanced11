function loginRegisterSwitch() {
    $('form').animate({
        height: "toggle",
        opacity: "toggle"
    }, "slow");
}

function showAlertAfterRegistration() {
    $('div.alert.alert-success').show();
}

function showAlertAfterLoginFailed() {
    $('div.alert.alert-loginFailed').show();
}

$('.message a').click(function () {
    loginRegisterSwitch();
});

$("button.register")
    .click(
        function () {
            let firstName = $("form.register-form input.firstName").val();
            let lastName = $("form.register-form input.lastName").val();
            let email = $("form.register-form input.email").val();
            let password = $("form.register-form input.password").val();
            let cpassword = $("form.register-form input.cpassword").val();

            if (firstName == '' || lastName == '' || email == ''
                || password == '' || cpassword == '') {
                alert("Please fill all fields...!!!!!!");
            } else if ((password.length) < 8) {
                alert("Password should atleast 8 character in length...!!!!!!");
            } else if (!(password).match(cpassword)) {
                alert("Your passwords don't match. Try again?");
            } else {
                let userRegistration = {
                    firstName: firstName,
                    lastName: lastName,
                    email: email,
                    password: password
                };

                $.post("registration", userRegistration,
                    function (data) {
                        if (data == 'Success') {
                            $("form")[0].reset();
                            $("form")[1].reset();
                            loginRegisterSwitch();
                            showAlertAfterRegistration();
                        }
                    });
            }
        });

$("button.login").click(function () {
    let email = $("form.login-form input.email").val();
    let password = $("form.login-form input.password").val();

    if (email == '' || password == '') {
        alert("Please fill login form!");
    } else {
        let userLogin = {
            email: email,
            password: password
        };
        $.post("login", userLogin, function (data) {
            if (data == 'Login failed') {
                 $("form")[1].reset();
                loginRegisterSwitch();
                alert("Login Failed! Try again.");
                showAlertAfterLoginFailed();
            } else if (data == 'Login success') {
                $("form")[1].reset();
                window.location = "/cabinet.jsp";
            }
        });
    }
});

