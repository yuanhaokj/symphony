(function () {
    'use strict';
    var main = new Vue({
        el: '#main',
        data: {
            code: 'import sys',
            socket: null,
            execResult: '',
            openResult: ''
        },
        computed: {},
        watch: {},
        methods: {
            initWebSocket() {
                var _self = this;
                if (typeof(WebSocket) == "undefined") {
                    console.log("您的浏览器不支持WebSocket");
                } else {
                    console.log("您的浏览器支持WebSocket");
                }
                this.socket = new WebSocket("ws://www.jaagool.com:8981/websocket");
                //打开事件
                this.socket.onopen = function () {
                    console.log("Socket 已打开");
                    _self.openResult = "链接成功";
                    //socket.send("这是来自客户端的消息" + location.href + new Date());
                };
                //获得消息事件
                this.socket.onmessage = function (msg) {
                    console.log(msg.data);
                    _self.execResult = _self.execResult + '\r\n' + msg.data;
                    // 发现消息进入, 调后台获取
                    // getCallingList();
                };
                //关闭事件
                this.socket.onclose = function () {
                    console.log("Socket已关闭");
                };
                //发生了错误事件
                this.socket.onerror = function () {
                    alert("Socket发生了错误");
                }

            },
            exec(){
                var _self = this;
                _self.execResult = '';
                axios.get(_contextPath + '/api/web/socket/python/code', {
                    params: {
                        code: _self.code
                    }
                }).then(function (response) {
                    var data = response.data;
                    if (data) {
                        _self.execResult = _self.execResult + '\r\n' + data.execResult;
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }

        },
        created: function () {
            var self = this;
            self.initWebSocket();
        },
        mounted: function () {
            var self = this;

        }
    });
    window.main = main;
}());