$(function () {
    var socket = new SockJS('http://localhost:8080/techHandler');
    socket.onopen = function () {
        console.log("open");
    };

    socket.onmessage = function (event) {
        if(event != null){
            console.log("message");
        }
    }

    socket.onclose = function () {
        console.log("close");
    }
    socket.send("test");
})