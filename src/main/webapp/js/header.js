

$(document).ready(function() {
    $('.leftmenutrigger').on('click', function(e) {
        $('.side-nav').toggleClass("open");
        e.preventDefault();

    });
});

$(document).ready(function() {
    $.get("user-role", function(data) {
        if (data !== '') {
            userRole = data;
        }
    }).done(function() {
        if (userRole === 'ADMINISTRATOR') {
            $('li.user-element').hide();
        } else {
            $('li.admin-element').hide();
        }
    });
});
