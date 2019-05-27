<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Sign Up</title>
    <meta http-equiv="x-ua-compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
	<#include "../../resource/common-component/public/public.ftl" parse=true/>
    <#include "../../resource/common-component/nav/nav.ftl" parse=true/>
    <#include "../../resource/common-component/search/search.ftl" parse=true/>
    <link rel="stylesheet" href="${mvcPath}/templates/mainlates/main/workshop/signUp/css/signUp.css">

</head>
<body>
<div id="main">
    <div id="wrapper">
        <search-common></search-common>
        <nav-common></nav-common>


        <el-container style="height: fit-content">
            <el-aside width="400px">

            </el-aside>
            <el-container>
                <el-header>Header</el-header>
                <el-main>
                    <el-aside width="400px">
                        <el-form :model="userInfo">

                            <el-form-item label="" :label-width="formLabelWidth" style="margin-top: 20px">
                                <el-input v-model="userInfo.username" placeholder="请输入用户名"></el-input>
                            </el-form-item>
                            <el-form-item label="" :label-width="formLabelWidth" style="margin-top: 20px">
                                <el-input v-model="userInfo.password" placeholder="请输入密码" show-password></el-input>
                            </el-form-item>
                        </el-form>
                    </el-aside>
                </el-main>
                <el-footer>Footer</el-footer>
            </el-container>

        </el-container>

    </div>
</div>

<script type="text/javascript">
    //这里写公用头部
    //官网提供了vue.extend构造方法,直接用
    // 创建构造器
    var Profile = Vue.extend({
        template: '<p>{{firstName}} {{lastName}} aka {{alias}}</p>',
        data: function () {
            return {
                firstName: '龙',
                lastName: '阿发',
                alias: '打发'
            }
        }
    });
    // 创建 Profile 实例，并挂载到一个元素上。
    new Profile().$mount('#mount-point');
</script>

<#--<script src="${mvcPath}/main/workshop/login/store.js"></script>-->
<script src="${mvcPath}/templates/mainlates/main/workshop/signUp/js/signUp.js"></script>


</body>


</html>