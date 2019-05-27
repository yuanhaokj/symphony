(function () {
    const main = new Vue({
        el: '#main',
        router,
        data: {
            userInfo:{
                username:null,
                password:null
            },
            formLabelWidth: '50px',
            message: '页面加载于 ' + new Date().toLocaleString(),
            params: {
                username: "longcheng",
                password: "abc",
                phoneNumber: "15108213757"
            }
        },
        methods:{
            initMain: function(){
                var _self = this;
            }
        },
        created: function () {
            var _self = this;
        },
        mounted: function () {
            var _self = this;
            // _self.$nextTick(function () {
            //     _self.$router.push({path: '/foo'});
            // });
            this.router.push({ path: 'login'}); // -> /user/123
        }
    });
    window.main = main;
}());