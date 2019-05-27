(function () {
    'use strict';
    var main = new Vue({
        el: '#main',
        data: {
            userInfo:{
                username:null,
                password:null
            },
            formLabelWidth: '50px',
            message: '页面加载于 ' + new Date().toLocaleString()
        }
    });
    window.main = main;
}());