$(function () {
    $('.send').click(function () {
        sendMessage();
    });
});

var guyId = Math.floor(Math.random() * 100000);

var socket = io.connect("http://localhost:9092");

socket.on('connect',function () {
    output('Guy ' + guyId + ' has connected to the server!');
});

socket.on('chatevent',function (data) {
    output(data.message,data.userName);
});

socket.on('disconnect',function () {
    output('The guy ' + guyId + ' has disconnected!')
});

function sendDisconnect() {
    socket.disconnect();
}

function sendMessage() {
    var message = $('#message').val();
    $('#message').val('');
    var jsonObject = {userName: 'guy' + guyId,
        message: message};
    socket.emit('chatevent',jsonObject);
}

function output(message,guy) {
    var date = $('<div class="conversation-start">\n' +
        ' <span> ' + moment().format('HH:mm:ss.SSS') + ' </span>\n' +
        ' </div>');
    if(guy == "guy"+guyId){
        var element = '<div class="bubble me">'+ message +' </div>';
    }else{
        var element = '<div class="bubble you">'+ message +' </div>';
    }
    $('.chat').append(element);
}

$(document).keydown(function(e){
    if(e.keyCode == 13) {
        sendMessage();
    }
});
