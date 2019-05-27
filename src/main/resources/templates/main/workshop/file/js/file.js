(function () {
    var options = {
        muted: true,
        controls : true/false,
        height:300,
        width:300,
        loop : true,
        // 更多配置.....
    };

    // var player = videojs('my-player',);


    var player1 = videojs('my-player', options, function onPlayerReady() {
        videojs.log('Your player is ready!');

        // In this context, `this` is the player that was created by Video.js.
        this.play();

        // How about an event listener?
        this.on('ended', function() {
            videojs.log('Awww...over so soon?!');
        });
    });
    'use strict';
    var main = new Vue({
        el: '#main',
        data: {
            userInfo: {
                username: null,
                password: null
            },
            formLabelWidth: '50px',
            message: '页面加载于 ' + new Date().toLocaleString(),
            doUpload: '/api/file/fileupload',
            pppss: {
                srid: ''
            }
        },
        computed: {

        },
        watch: {

        },
        methods: {
            getUsers: function () {
                var self = this;
                axios.get(_contextPath + '/open/datastash/warnRule/users')
                    .then(function (response) {
                        self.users = response.data;
                    })
                    .catch(function (error) {
                    });
            }
        },
        created: function () {
            var self = this;
        },
        mounted: function () {
            var self = this;
        }
    });
    window.main = main;
}());