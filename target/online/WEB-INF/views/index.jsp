<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->

<html lang="en" class="no-js">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <head>
        <base href="<%=basePath%>">
        <meta charset="utf-8" />
        <title>Online learning</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <meta name="MobileOptimized" content="320">

        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->

        <!-- BEGIN THEME STYLES -->
        <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/plugins.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
        <link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css" />
        <!-- END THEME STYLES -->

        <link rel="shortcut icon" href="app/img/favicon.ico" />
        
        <!-- --------------------begin--------------------------------- -->
        <script src="http://cdn.bootcss.com/angular.js/1.3.15/angular.min.js"></script>
        <link rel="stylesheet"
				href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	        
        <!-- -------------------end -------------------------------------- -->
    </head>
    <!-- END HEAD -->
    
    <!-- begin---------------------------------------------------------------------------------------------------------------------------- -->
    
		
    <!-- ----------------------------end --------------------------------------------------------------------------------------------------- -->

    <!-- BEGIN BODY -->
    <body class="page-header-fixed">
        <!-- BEGIN HEADER -->
        <div class="header navbar navbar-inverse navbar-fixed-top">
            <!-- BEGIN TOP NAVIGATION BAR -->
            <div class="header-inner">
                <!-- BEGIN LOGO -->
                <a class="navbar-brand" href="javascript:;">
                    <img src="assets/img/logo.png" alt="logo" class="img-responsive" />
                </a>
                <!-- END LOGO -->
                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <img
                    src="assets/img/menu-toggler.png" alt="" />
                </a>
                <!-- END RESPONSIVE MENU TOGGLER -->
                <!-- BEGIN TOP NAVIGATION MENU -->
                <ul class="nav navbar-nav pull-right">
                    <li class="dropdown user">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                            <img alt="" src="assets/img/avatar1_small.jpg"/>
                            <span class="username"> ${userInfo.username } </span>
                            <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="javascript:;" id="trigger_fullscreen">
                                    <i class="fa fa-move"></i> Full Screen
                                </a>
                            </li>
                            <li>
                                <a href="extra_lock.html">
                                    <i class="fa fa-lock"></i> Lock Screen
                                </a>
                            </li>
                            <li>
                                <a href="rest/user/logout">
                                    <i class="fa fa-key"></i> login out
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!-- END USER LOGIN DROPDOWN -->
                </ul>
                <!-- END TOP NAVIGATION MENU -->
            </div>
            <!-- END TOP NAVIGATION BAR -->
        </div>
        <!-- END HEADER -->
        <div class="clearfix"></div>
        <!-- BEGIN CONTAINER -->
        <div class="page-container">
            <!-- BEGIN SIDEBAR -->
            <div class="page-sidebar-wrapper">
                <div class="page-sidebar navbar-collapse collapse">
                    <!-- BEGIN SIDEBAR MENU -->
                    <ul class="page-sidebar-menu" id="page-sidebar-menu">
                        <li class="sidebar-toggler-wrapper">
                            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                            <div class="sidebar-toggler hidden-phone"></div>
                            <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                        </li>

                        <li class="start active">
                            <a href="rest/page/dashboard" addcontent id="btn-dashboard">
                            <!--a href="###" onclick="addcontent('rest/page/dashboard')"  id="btn-dashboard"-->
                            <!--a href="rest/word/context" id="btn-dashboard"-->
                            
                                <i class="fa fa-home"></i><span class="title"> First page </span><span
                                class="selected"> </span>
                            </a>
                        </li>

                        <li class="">
                            <a href="###">
                                <i class="fa fa-gears"></i><span class="title"> My learning </span><span
                                class="arrow"> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="###" onclick="loadright('<%=basePath%>rest/word/context')">
                                        Words in plan
                                    </a>
                                </li>
                                <li>
                                    <a href="###" onclick="loadright('<%=basePath%>rest/word/context')">
                                        Courses
                                    </a>
                                </li>
                                <li>
                                    <a href="###" onclick="loadright('<%=basePath%>rest/word/context')">
                                        Community
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <li class="">
                            <a href="javascript:;">
                                <i class="fa fa-user"></i><span class="title"> Profile </span><span
                                class="arrow "> </span>
                            </a>
                            <ul class="sub-menu">
                                <li>
                                    <a href="javascript:;">
                                        modify profile
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        password reset
                                    </a>
                                </li>
                                
                                <!-- 测试权限控制 -->
                                <shiro:hasAnyRoles name="super_admin">
                                    <li>
                                        <a href="javascript:;">super_admin own the role</a>
                                    </li>
                                </shiro:hasAnyRoles>
                                
                                <shiro:hasPermission name="user:create">
                                    <li>
                                        <a href="javascript:;">user:create own the privilege</a>
                                    </li>
                                </shiro:hasPermission>
                                
                                <shiro:hasPermission name="user:update">
                                    <li>
                                        <a href="javascript:;">user:update own the privilege</a>
                                    </li>
                                </shiro:hasPermission>
     
                            </ul>
                        </li>

                    </ul>
                    <!-- END SIDEBAR MENU -->
                </div>
            </div>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="page-content-wrapper">
                <div class="page-content">
                    <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
                    <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                                    <h4 class="modal-title">Modal title</h4>
                                </div>
                                <div class="modal-body">
                                    Widget settings form goes here
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn blue">
                                        Save changes
                                    </button>
                                    <button type="button" class="btn default" data-dismiss="modal">
                                        Close
                                    </button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal -->
                    <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
                    <!-- BEGIN STYLE CUSTOMIZER -->
                    <div class="theme-panel hidden-xs hidden-sm">
                        <div class="toggler"></div>
                        <div class="toggler-close"></div>
                        <div class="theme-options">
                            <div class="theme-option theme-colors clearfix">
                                <span> Color </span>
                                <ul>
                                    <li class="color-black current color-default" data-style="default"></li>
                                    <li class="color-blue" data-style="blue"></li>
                                    <li class="color-brown" data-style="brown"></li>
                                    <li class="color-purple" data-style="purple"></li>
                                    <li class="color-grey" data-style="grey"></li>
                                    <li class="color-white color-light" data-style="light"></li>
                                </ul>
                            </div>
                            <div class="theme-option">
                                <span> Layout </span>
                                <select class="layout-option form-control input-small">
                                    <option value="fluid">flow</option>
                                    <option value="boxed">box</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> title </span>
                                <select class="header-option form-control input-small">
                                    <option value="fixed">fixed</option>
                                    <option value="default">default</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> tools bar </span>
                                <select class="sidebar-option form-control input-small">
                                    <option value="fixed">fixed</option>
                                    <option value="default">default</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> tools bar position </span>
                                <select class="sidebar-pos-option form-control input-small">
                                    <option value="left">left</option>
                                    <option value="right">right</option>
                                </select>
                            </div>
                            <div class="theme-option">
                                <span> foot </span>
                                <select class="footer-option form-control input-small">
                                    <option value="fixed">fixed</option>
                                    <option value="default">default</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- END STYLE CUSTOMIZER -->

                    <!-- BEGIN PAGE HEADER-->
                    <div class="row">
                        <div class="col-md-12">
                            <!-- BEGIN PAGE TITLE & BREADCRUMB-->
                            <h3 class="page-title" id="index-page-title">Dashboard</h3>
                            <ul class="page-breadcrumb breadcrumb">
                                <li>
                                    <i class="fa fa-home"></i>
                                    <a href="javascript:;">
                                        first page
                                    </a>
                                    <i class="fa fa-angle-right"></i>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        Dashboard
                                    </a>
                                </li>
                            </ul>
                            <!-- END PAGE TITLE & BREADCRUMB-->
                        </div>
                    </div>
                    <!-- END PAGE HEADER-->

                    <!-- BEGIN DASHBOARD STATS -->
                    <!--div id="main-content"></div-->
     <!---------------------------- begin ------------------------------------------------------------------------------------ -->
                    
       <div id="main-content">
       <iframe id="context" name="context" src="rest/word/context" frameborder="0" marginheight="0" marginwidth="0" style="width:100%;height:500px;border:0px"></iframe>
       </div>
                    
   <!------------------------ ------------------end ------------------------------------------------------------------------------------------- -->

                    <!-- END PORTLET-->
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END CONTAINER -->
        <!-- BEGIN FOOTER -->
        <div class="footer">
            <div class="footer-inner">
                2018 &copy; online learning - Alex Wang.
            </div>
            <div class="footer-tools">
                <span class="go-top"><i class="fa fa-angle-up"></i></span>
            </div>
        </div>
        <!--[if lt IE 9]-->
        <script src="assets/plugins/respond.min.js"></script>
        <script src="assets/plugins/excanvas.min.js"></script>
        <!-- [endif]-->
        
        <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
        <!--script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script-->
        <script src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
        <script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

        <!--  script src="assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script-->
        <script type="text/javascript" src="assets/plugins/select2/select2.min.js"></script>

        <script src="assets/scripts/app.js" type="text/javascript"></script>
        <script type="text/javascript" src="app/js/index.js"></script>

       <script type="text/javascript">
        
        /*
         * 对选中的标签激活active状态，对先前处于active状态但之后未被选中的标签取消active
         * （实现左侧菜单中的标签点击后变色的效果）
         */
        $(document).ready(function () {
            $('ul.sub-menu > li').click(function (e) {
                //e.preventDefault();    加上这句则导航的<a>标签会失效
                $('ul.sub-menu > li').removeClass('active');
                $(this).addClass('active');
            });
        });
        
        function loadright(url){
        	var iframe = "<iframe id='context' name='context' src='"+url+"'frameborder'='0' marginheight='0' marginwidth='0' style='width:100%;height:500px;border:0px'></iframe>";
       	    document.getElementById("main-content").innerHTML = iframe;
        }
        function addcontent(url){
        	 $.get(url, function(data) {
             	
                 $('#main-content').html(data);
             });
        }
        
        /*
         * 解决ajax返回的页面中含有javascript的办法：
         * 把xmlHttp.responseText中的脚本都抽取出来，不管AJAX加载的HTML包含多少个脚本块，我们对找出来的脚本块都调用eval方法执行它即可
         */
        function executeScript(html)
        {
            
            var reg = /<script[^>]*>([^\x00]+)$/i;
            //对整段HTML片段按<\/script>拆分
            var htmlBlock = html.split("<\/script>");
            for (var i in htmlBlock) 
            {
                var blocks;//匹配正则表达式的内容数组，blocks[1]就是真正的一段脚本内容，因为前面reg定义我们用了括号进行了捕获分组
                if (blocks = htmlBlock[i].match(reg)) 
                {
                    //清除可能存在的注释标记，对于注释结尾-->可以忽略处理，eval一样能正常工作
                    var code = blocks[1].replace(/<!--/, '');
                    try 
                    {
                        eval(code) //执行脚本
                    } 
                    catch (e) 
                    {
                    }
                }
            }
        }
        
        /*
         * 利用div实现左边点击右边显示的效果（以id="content"的div进行内容展示）
         * 注意：
         *   ①：js获取网页的地址，是根据当前网页来相对获取的，不会识别根目录；
         *   ②：如果右边加载的内容显示页里面有css，必须放在主页（即例中的index.jsp）才起作用
         *   （如果单纯的两个页面之间include，子页面的css和js在子页面是可以执行的。 主页面也可以调用子页面的js。但这时要考虑页面中js和渲染的先后顺序 ）
        */
        function showAtRight(url) {
            var xmlHttp;
            
            if (window.XMLHttpRequest) {
                // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlHttp=new XMLHttpRequest();    //创建 XMLHttpRequest对象
            }
            else {
                // code for IE6, IE5
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
        
            xmlHttp.onreadystatechange=function() {        
                //onreadystatechange — 当readystate变化时调用后面的方法
                
                if (xmlHttp.readyState == 4) {
                    //xmlHttp.readyState == 4    ——    finished downloading response
                    
                    if (xmlHttp.status == 200) {
                        //xmlHttp.status == 200        ——    服务器反馈正常            
                        
                        document.getElementById("main-content").innerHTML=xmlHttp.responseText;    //重设页面中id="content"的div里的内容
                        executeScript(xmlHttp.responseText);    //执行从服务器返回的页面内容里包含的JavaScript函数
                    }
                    //错误状态处理
                    else if (xmlHttp.status == 404){
                        alert("出错了☹   （错误代码：404 Not Found），……！"); 
                        /* 对404的处理 */
                        return;
                    }
                    else if (xmlHttp.status == 403) {  
                        alert("出错了☹   （错误代码：403 Forbidden），……"); 
                        /* 对403的处理  */ 
                        return;
                    }
                    else {
                        alert("出错了☹   （错误代码：" + request.status + "），……"); 
                        /* 对出现了其他错误代码所示错误的处理   */
                        return;
                    }   
                } 
                    
              }
            
            //把请求发送到服务器上的指定文件（url指向的文件）进行处理
            xmlHttp.open("GET", url, true);        //true表示异步处理
            xmlHttp.send();
        }        
        </script>
    </body>
</html>