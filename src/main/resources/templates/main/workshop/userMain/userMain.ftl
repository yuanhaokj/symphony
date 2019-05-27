<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <meta http-equiv="x-ua-compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
	<#include "../../resource/common/common.ftl" parse=true/>
</head>
<body>
<div id="main">
    <el-row>
        <el-col :span="24">
            <div class="grid-content bg-purple-dark"></div>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <div class="grid-content bg-purple"></div>
        </el-col>
        <el-col :span="8">
            <div class="grid-content bg-purple-light"></div>
        </el-col>
        <el-col :span="8">
            <div class="grid-content bg-purple">
                <el-form :model="userInfo">

                    <el-form-item label="" :label-width="formLabelWidth" style="margin-top: 20px">
                        <el-input v-model="userInfo.username" placeholder="请输入用户名"></el-input>
                    </el-form-item>
                    <el-form-item label="" :label-width="formLabelWidth" style="margin-top: 20px">
                        <el-input v-model="userInfo.password" placeholder="请输入密码" show-password></el-input>
                    </el-form-item>
                </el-form>

            </div>
        </el-col>
    </el-row>
    <h1>${mvcPath}</h1>
    <el-button>默认按钮</el-button>
    <el-button>默认按钮</el-button>
    <router-view></router-view>
</div>
<#--<script src="${mvcPath}/main/workshop/login/store.js"></script>-->
<script src="${mvcPath}/main/workshop/userMain/js/userMain.js"></script>
</body>
</html>