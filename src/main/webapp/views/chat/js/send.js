$(function () {
    $('.send').click(function () {
        sendMessage();
    });
});

var guyId = Math.floor(Math.random() * 100000);
var info = $.cookie('info');
var id; //本人
var username; //本人
if(info != null){
    var vs = info.split(':');
    id = vs[0];
    username = vs[1];
}
if(username == null || username == ''){
    username = 'one guy';
}

var socket = io.connect("http://localhost:9092?guyId=123");

socket.on('connect',function () {
    var div_person =  '<li class="person" data-chat="person'+ id + '">\n' +
                    '<img src="img/thomas.jpg" alt="" />\n' +
                    '<span class="name">'+username+'</span>\n' +
                    '<span class="time">00:00 PM</span>\n' +
                    '<span class="preview">I am single...</span>\n' +
                    '</li>';
    var div_chat = '<div class="chat" data-chat="person'+ id + '">\n' +
                    '<div class="conversation-start">\n' +
                    '    <span>Today</span>\n' +
                    '</div>\n' +
                    '<div class="bubble you">\n' +
                    '    Hello, How are you today? Guy.\n' +
                    '</div>\n' +
                    '</div>';
    $('.people').append(div_person);
    $('.right').find('.write').before(div_chat);
    document.querySelectorAll('.left .person').forEach(function (f) {
        f.addEventListener('mousedown', function () {
            f.classList.contains('active') || setAciveChat(f);
        });
    });
    output('Guy ' + guyId + ' has connected to the server!');
});

socket.on('chatevent',function (data) {
    output(data.message,data.userName,data.id,data.toUserId);
});

socket.on('disconnect',function () {
    $('.people').find('div[data-chat="person' + id + '"]').remove();
    output('The guy ' + guyId + ' has disconnected!')
});

function sendDisconnect() {
    socket.disconnect();
}

function sendMessage() {
    var message = $('#message').val();
    $('#message').val('');
    if(window.to_guy == null){
        window.to_guy = '2';
    }
    var jsonObject = {userName: username,
                      message: message,
                      id:id,
                      toUserId:window.to_guy};
    socket.emit('chatevent',jsonObject);
}
//userId 发给谁的
function output(message,guy,userId,toUserId) {
    var date = $('<div class="conversation-start">\n' +
        ' <span> ' + moment().format('HH:mm:ss.SSS') + ' </span>\n' +
        ' </div>');
    var element;
    if(id != null && id.length > 0){
        if(id == userId){
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
    if(userId != null){
        $('.right').find('div[data-chat="person' + toUserId + '"]').append(element);
    }else{
        $('.right').find('.chat').append(element);
    }
}

function output_all(message,guy) {
    var date = $('<div class="conversation-start">\n' +
        ' <span> ' + moment().format('HH:mm:ss.SSS') + ' </span>\n' +
        ' </div>');
    var element;
    if(guy == "guy"+guyId){
        element = '<div class="bubble me">大家好，我是 gay! </div>';
    }else{
        element = '<div class="bubble me">大家好，我是 gay! </div>';
    }
    $('.chat').append(element);
}

$(document).keydown(function(e){
    if(e.keyCode == 13) {
        sendMessage();
    }
});

if(info == null || info == ''){
    alert("不登录就尬聊，贵客一定是 gay...");
    if(window.confirm("不做 gay,现在就去登录去 go.")){
        window.location.href = "/views/index.html";
    }
}
