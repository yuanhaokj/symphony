<!DOCTYPE html>
<html style="height: 100%">
<head>
    <meta charset="utf-8">
    <title>StockDetail</title>
    <meta http-equiv="x-ua-compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <#include "../../resource/common/common.ftl" parse=true/>
    <link rel="stylesheet" href="${mvcPath}/main/workshop/python/css/python.css">
</head>
<body style="height: 100%; margin: 0">
<#--<div id="container" style="height: 50%"></div>-->
<div id="main" style="height: 100%">
    <p class="code-detail">Python Code: <code>{{code}}</code>  </p>
    <el-input
            type="textarea"
            :autosize="{ minRows: 4, maxRows: 8}"
            placeholder="请输入内容"
            v-model="code">
    </el-input>
    <el-row>
        <el-button @click.native="exec"> 执行 </el-button>
    </el-row>
    <p class="code-detail">
        链接状态: {{openResult}} <br/>
        {{execResult}}
    </p>

</div>

<script src="${mvcPath}/main/workshop/python/js/python.js"></script>
</body>
</html>