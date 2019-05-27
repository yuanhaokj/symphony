<!DOCTYPE HTML>
<html lang="zxx">

<head>
    <title>Login</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>
    <meta name="keywords" content=""/>
	<#include "../../resource/common/common.ftl" parse=true/>
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- Meta tag Keywords -->
    <!-- css files -->
    <link rel="stylesheet" href="${mvcPath}/templates/mainlates/main/workshop/login/css/style.css" type="text/css" media="all"/>
    <!-- Style-CSS -->
    <link rel="stylesheet" href="${mvcPath}/templates/mainlates/main/workshop/login/css/fontawesome-all.css">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //css files -->
    <!-- web-fonts -->
    <#--<link href="http://maxcdn.bootstrapcdn.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i"-->
          <#--rel="stylesheet">-->
    <#--<link href="http://maxcdn.bootstrapcdn.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"-->
          <#--rel="stylesheet">-->
    <!-- //web-fonts -->
</head>

<body>

<!-- bg effect -->
<div id="bg">
    <canvas></canvas>
    <canvas></canvas>
    <canvas></canvas>
</div>
<div id="main">
<!-- //bg effect -->
<!-- title -->
<h1>Message Stock Login</h1>
<!-- //title -->
<!-- content -->
<div class="sub-main-w3">
    <form action="#" method="post">
        <h2>Login Now
            <i class="fas fa-level-down-alt"></i>
        </h2>
        <div class="form-style-agile">
            <label>
                <i class="fas fa-user"></i>
                Username
            </label>
            <input v-model="params.username" placeholder="Username" name="Name" type="text" required="">
        </div>
        <div class="form-style-agile">
            <label>
                <i class="fas fa-unlock-alt"></i>
                Password
            </label>
            <input v-model="params.password" placeholder="Password" name="Password" type="password" required="">
        </div>
        <!-- checkbox -->
        <div class="wthree-text">
            <ul>
                <li>
                    <label class="anim">
                        <input type="checkbox" class="checkbox" required="">
                        <span>Stay Signed In</span>
                    </label>
                </li>
                <li>
                    <a href="#">Forgot Password?</a>
                </li>
            </ul>
        </div>
        <!-- //checkbox -->
        <el-button type="danger"  content="Log In" label="Log In" @click="login">Log In</el-button>
    </form>
</div>
<!-- //content -->

<!-- copyright -->
<div class="footer">
    <p>Copyright &copy; 2019.yanhaokj.cn All rights reserved.</p>
</div>
<!-- //copyright -->
</div>
<!-- effect js -->
<script src="${mvcPath}/templates/mainlates/main/workshop/login/js/canva_moving_effect.js"></script>


<!-- //effect js -->
<script src="${mvcPath}/templates/mainlates/main/workshop/userMain/js/userMain.js"></script>

</body>

</html>