<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>list.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="http://cdn.bootcss.com/angular.js/1.3.15/angular.min.js"></script>
    <style>
    	.list{
			margin:20px;
		}
		.margin80{
			margin-top:80px;
		}
    </style>
  </head>
  <body ng-app="app" style="background:url(<c:url value='/static/images/1.png'/>) no-repeat;">
	<nav class="navbar navbar-default navbar-fixed-top">
	  <div class="container">
			<ul class="nav navbar-nav">
				<li>
					<c:if test="${name!=null}">
						<a href="###">
							welcome ${name}
						</a>
					</c:if>
				</li>
	                <li><a href="<%=basePath%>orders/index">index</a></li>
					<li><a href="<%=basePath%>comm/detail">types</a></li>
					<li><a href="<%=basePath%>comm/cart"> cart </a></li>
					<li><a href="<%=basePath%>comm/list"> billing </a></li>
					<li><a href="<%=basePath%>login/users">users</a></li>
	         </ul>
	  </div>
	</nav>
	<div id="form" class="container margin80" ng-controller="form">
		<div class="row">
			<h1>unpaid</h1>
			<ul class="list-group">
				<li class="list-group-item" ng-repeat="item in items" ng-if="item.pay==0">
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							ADDR:{{item.address}}
						</p>
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							PHONE:{{item.phone}}
						</p>
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							PRICE:{{item.totalPrice}}
						</p>
						<div parse id={{item.orderlist}}>
							<div class="list pull-left" ng-repeat="order in  orderlist">
			        			<div commodity-directive id="{{order.commodityId}}">
			        				<p>name:{{res.name}}</p>
			        				<p>desc:{{res.depict}}</p>
			        				<p>manu:{{res.manufacturer}}</p>
			        				<p>price:{{res.price}}</p>
			        				<p><img ng-src="<%=basePath%>{{com.img}}"  width=50 height=50/></p>
				        			<p>
				        				total:
					        			<span class="badge">
					        				{{order.commodityCount}}
										</span>
				        			</p>
			        			</div>
			        		</div>
		        		</div>
		        	
		        		<button class="btn btn-default" ng-click="pay(item.id)"> pay</button>
	        		<div class="clearfix"></div>
				</li>
			</ul>
			<br>
			<h1>paid</h1>
			<ul>
				<li class="list-group-item" ng-repeat="item in items" ng-if="item.pay==1">
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							ADDR:{{item.address}}
						</p>
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							PHONE:{{item.phone}}
						</p>
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							PRICE:{{item.totalPrice}}
						</p>
						<div parse id={{item.orderlist}}>
							<div class="list pull-left" ng-repeat="order in  orderlist">
			        			<div commodity-directive id="{{order.commodityId}}">
			        				<p>name:{{res.name}}</p>
			        				<p>desc:{{res.depict}}</p>
			        				<p>manu:{{res.manufacturer}}</p>
			        				<p>price:{{res.price}}</p>
			        				<p><img ng-src="<%=basePath%>{{com.img}}"  width=50 height=50/></p>
				        			<p>
				        				account:
					        			<span class="badge">
					        				{{order.commodityCount}}
										</span>
				        			</p>
			        			</div>
			        		</div>
		        		</div>
	        		<div class="clearfix"></div>
				</li>
			</ul>
		</div>
	</div>
	<script>
		var userId = "${id}";
		var app = angular.module("app", []);
        app.directive("commodityDirective", function() {
        	return {
        		restrict : "EA",
        		scope : true,
	        	link : function( $scope ,$el, $iattrs) {
	        		ajaxModule.getComById($iattrs.id, function( res ) {
		        		$scope.res = res[0];
		        		$scope.$apply();
        			});
	        	}
        	}
        });
        app.directive("parse", function() {
        	return {
        		restrict : "EA",
        		scope : true,
	        	link : function( $scope ,$el, $iattrs) {
	        		$scope.orderlist = JSON.parse($iattrs.id);
	        	}
        	}
        });
        
        
		app.controller("form", function( $scope ) {
			$scope.items = [];
			$scope.pay = function( orderformId ) {
				ajaxModule.pay(userId , orderformId, function( res ) {
					if(res) {
						location.reload();
					}else{
						alert("error");
					};
				});
			};
		});
		
		var ajaxModule = {
			getFormList : function( userId,  cb ) {
				$.post("<%=basePath%>orders/getorders",{userId:userId}, cb);
			},
			pay : function( orderformId, cb) {
				$.post("<%=basePath%>orders/setorders", {userId : userId, orderId : orderformId }, cb);
			},
			getComById : function(id , cb) {
        		$.post("<%=basePath%>comm/detail/"+id, cb);
			}
		};
		
		if(userId) {
			$(function() {
				ajaxModule.getFormList(userId, function( res ) {
					$("#form").scope().items = res;
					$("#form").scope().$apply();
				});
			});
		};
	</script>
  </body>
</html>
