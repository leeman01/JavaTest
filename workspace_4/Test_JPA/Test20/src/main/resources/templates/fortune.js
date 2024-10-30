$(function () {
    alert("잘된다");
    $('#click').on('click', confirm);

});

function click() {
    $.ajax({
        url: '/target',
        type: 'POST',
        success: function (response) {
            $('#target').html = "<textarea name='' id=''>" + response + "</textarea>";
        }
    })

}