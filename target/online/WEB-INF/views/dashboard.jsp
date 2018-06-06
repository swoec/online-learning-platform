<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="row">
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat blue">
            <div class="visual">words
                <i class="fa fa-comments"></i>
            </div>
            <div class="details">
                <div class="number">1349</div>
            </div>
            <a class="more" href="###" onclick="loadPage('<%=basePath%>rest/word/context')"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat green">
            <div class="visual">videos
                <i class="fa fa-shopping-cart"></i>
            </div>
            <div class="details">
                <div class="number">549</div>
            </div>
            <a class="more" href="#"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat purple">
            <div class="visual">friends
                <i class="fa fa-globe"></i>
            </div>
            <div class="details">
                <div class="number">89</div>
            </div>
            <a class="more" href="/rest/word/context"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat yellow">
            <div class="visual">books
                <i class="fa fa-bar-chart-o"></i>
            </div>
            <div class="details">
                <div class="number">12</div>
            </div>
            <a class="more" href="#"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
</div>
<script type="text/javascript">
function display(url){
	if (url != null && url != 'javascript:;') {
		$('#main-content',window.parent.document).load(url);
        //$.get(url, function(data) {        	
        	// $('#main-content',window.parent.document).html(data);  	 
       // });
	}
}

function loadPage(url){
	
	//$('#context',window.parent.document).src = url;
	var iframe = "<iframe id='context' name='context' src='"+url+"'frameborder'='0' marginheight='0' marginwidth='0' style='width:100%;height:500px;border:0px'></iframe>";
	 window.parent.document.getElementById("main-content").innerHTML = iframe;
    //window.parent.open(url,'context','');// testLoad为iframe的name属性
	 //self.opener.location.reload();
	 //parent.location.reload();
}

</script>