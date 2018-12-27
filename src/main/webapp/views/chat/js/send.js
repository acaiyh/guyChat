$(function () {
    $('.send').click(function () {
        sendMessage();
    });
});

var guyId = Math.floor(Math.random() * 100000);

var getCookie = $.cookie('username');

var socket = io.connect("http://localhost:9092?guyId=123");

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
    var element;
    if(getCookie != null && getCookie.length > 0){
        if(guy == "guy"+guyId){
            element = '<div class="bubble me">'+ message +' </div>';
        }else{
            element = '<div class="bubble you">'+ message +' </div>';
        }
    }else{
        if(guy == "guy"+guyId){
            element = '<div class="bubble me">大家好，我是 gay! </div>';
        }else{
            element = '<div class="bubble me">大家好，我是 gay! </div>';
        }
    }
    $('.chat').append(element);
}

$(document).keydown(function(e){
    if(e.keyCode == 13) {
        sendMessage();
    }
});

if(getCookie == null || getCookie == ''){
    alert("不登录就尬聊，贵客一定是 gay...");
    if(window.confirm("不做 gay,现在就去登录去 go.")){
        window.location.href = "/views/index.html";
    }
}
