$(function () {
    var socket = new WebSocket('ws://localhost:8080/tech-handler');
    socket.onopen = function () {
        console.log("open");
        socket.send('I am the client and I\'m listening!');
        heartCheck.start();
    };
    socket.onmessage = function (event) {
        if(event != null){
            console.log("message");
        }
        console.log("message");
        heartCheck.reset();
    };
    socket.onclose = function () {
        console.log("onclose");
    }
    socket.onerror = function (event) {
        console.log("error");
        console.log(event)
        reconnect();
    };

    function reconnect() {
        if (socket != null){
            socket.close();
        }
        socket = new SockJS('http://localhost:8080/tech-handler',1000);
    };

    var timeout = 60000;
    var heartCheck = {
        timeoutObj: null,
        reset: function () {
            clearTimeout(this.timeoutObj);
            this.start;
        },
        start: function () {
            this.timeoutObj = setTimeout(function () {
                socket.send("heart beat");
                console.log("heart beat");
            },timeout);
        }
    }
});

