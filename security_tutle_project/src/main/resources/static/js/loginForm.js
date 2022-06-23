function check(form)
{
    if(form.userid.value == "" && form.userpassword.value == "")
    {
        window.open('passwordcreate.html')
        // window로 보내라
    }
    else
    {
        alert("Error UserID or Password");
    }
}

let id = $('#id');
let pw = $('#pw');
let btn = $('#btn');

$(btn).on('click', function() {
    if($(id).val() == ""){
        $(id).next('label').addClass('warning');
        setTimeout(function() {
            $('label').removeClass('warning');
        }, 1500);
    }
    else if($(pw).val() == "") {
        $(pw).next('label').addClass('warning');
        setTimeout(function() {
            $('label').removeClass('warning');
        }, 1500);
    }
});