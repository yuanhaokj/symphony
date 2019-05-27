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
            <div class="grid-content bg-purple">

                <video
                        id="my-player"
                        class="video-js"
                        <#--controls-->
                        preload="auto"
                        poster="//vjs.zencdn.net/v/oceans.png"
                        <#--data-setup='{}'-->
                >
                    <source src="//vjs.zencdn.net/v/oceans.mp4" type="video/mp4"></source>
                    <source src="//vjs.zencdn.net/v/oceans.webm" type="video/webm"></source>
                    <source src="//vjs.zencdn.net/v/oceans.ogv" type="video/ogg"></source>
                    <p class="vjs-no-js">
                        To view this video please enable JavaScript, and consider upgrading to a
                        web browser that
                        <a href="http://videojs.com/html5-video-support/" target="_blank">
                            supports HTML5 video
                        </a>
                    </p>
                </video>


            </div>
        </el-col>
        <el-col :span="8">
            <div class="grid-content bg-purple-light">
                <el-upload
                        class="upload-file"
                        drag
                        :action="doUpload"
                        :data="pppss">
                    <i class="el-icon-upload"></i>
                    <#--<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>-->
                </el-upload>
            </div>
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

</div>
<#--<script src="${mvcPath}/main/workshop/login/store.js"></script>-->
<script src="${mvcPath}/templates/mainlates/main/workshop/file/js/file.js"></script>
</body>
</html>