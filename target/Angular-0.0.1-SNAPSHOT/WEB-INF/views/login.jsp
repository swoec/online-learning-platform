<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>login.html22</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
     <script src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
     <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
     <script src="http://cdn.bootcss.com/angular.js/1.3.15/angular.min.js"></script>
     <script src="<c:url value='/static/js/app.js' />"></script>
     <script src="<c:url value='/static/js/service/user_service.js' />"></script>
     <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
  </head>
  <body ng-app="myApp" class="ng-cloak">
  <div class="generic-container" ng-controller="LoginController as ltrl">
   <form ng-submit="ctrl.login(ltrl.user)" name="myForm" class="form-horizontal">
    <div class="form-group col-md-12">
          <label class="col-md-2 control-lable" for="file">UserName:</label>
          <div class="col-md-7 control-lable" for="file">
             <input type="text" ng-model="ltrl.user.username" name="uname" class="username form-control input-sm" placeholder="Enter your name" required /> <br/>
          </div>    
    </div>
    
    <div class="row">
       <div class="form-group col-md-12">
          <label class="col-md-2 control-lable" for="file">PassWord:</label>
          <div class="col-md-7">
               <input type="password" ng-model="ltrl.user.password" name="password" class="form-control input-sm" placeholder="Enter your password. [This field is validation free]" required/>
          </div>
           
       </div>
    <div class="row">
       <div class="form-actions floatRight">
          <input type="submit"  class="btn btn-primary btn-lg" ng-disabled="myForm.$invalid">
          <button type="button" ng-click="ltrl.reset()" class="btn btn-warning btn-lg" ng-disabled="myForm.$pristine">Reset Form</button>
       </div>
    </div>
        <!--  input type="submit" id="loginBtn" value="Login" /-->
   </form>
    </div>
</body>
  <!--  body>
  	<div class="container">
  		<div class="row">
		  	<form>
			  <div class="form-group">
			    <label for="user">user</label>
			    <input type="text" class="form-control" id="user" placeholder="user">
			  </div>
			  <div class="form-group">
			    <label for="password">Password</label>
			    <input type="password" class="form-control" id="password" placeholder="password">
			  </div>
			  <a href="###" id="submit" class="btn btn-default">Submit</a>
			</form>
  		</div>
  	</div>
  	
        <script>
        	$("#submit").click(function() {
        		$.post("./login.do", {username : $("#user").val(), password : $("#password").val() }, function(res) {
        			if( res ) {
        				location.href = "index.do";
        			}else{
        				alert("登陆失败");
        			};
        		});
        	});
        	
        </script>
        
  </body-->
</html>
