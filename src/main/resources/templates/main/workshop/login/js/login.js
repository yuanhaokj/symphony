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
            message: '页面加载于 ' + new Date().toLocaleString(),
            params: {
                username: "longcheng",
                password: "abc",
                phoneNumber: "15108213757"
            }
        },
        methods:{
            login: function(){
                var self = this;
                axios.post(_contextPath + '/api/user/login', self.params)
                    .then(function (response) {
                        if (response.data.success == true) {
                            self.$message({
                                message: '登陆成功',
                                type: 'success'
                            });
                            self.toUserMain();
                        } else {
                            console.log(response.data.message);
                        }
                    }).catch(function (error) {
                    console.log(error);
                });
            },
            //跳转页面
            toUserMain:function(){
                var _self = this;
                // var href = _self.$router.resolve({ path: '/userMain',query: {id: JSON.stringify(id)}});
                // window.open(href, '_blank');
                // _self.$router.push("/userMain");
                // .push("/userMain");
                // _self.$router.redirect({
                //     path: '/userMain',
                //     redirect: '/userMain'
                // });
                //
                // _self.$nextTick(function () {
                //     _self.$router.push({path: '/userMain'});
                // });
            }
        }
    });
    window.main = main;
}());