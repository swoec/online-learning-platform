<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>index</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="https://www.digipulse.io/assets/favicon/ms-icon-144x144-764a0eb9b84c682fb7c9bd12e67ef847aa5f30435a47206d7fb97fb1c0e1b5fe.png">
<meta name="theme-color" content="#ffffff">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/angular.js/1.3.15/angular.min.js"></script>
</head>
<style>
.com {
	margin: 20px;
	height: 240px;
	overflow: hidden;
}

.padding20 {
	padding: 20px;
}

#index {
	margin-top: 100px;
}
</style>
<body ng-app="app"
	style="background:url(<c:url value='/static/images/1.png'/>) no-repeat;">
	<nav class="navbar navbar-default navbar-fixed-top ">
		<div class="container ">
			<div class="row ">
				<ul class="nav navbar-nav">
					<li><c:if test="${name!=null}">
							<a href="###"> welcome ${name} </a>
						</c:if>	
					</li>

					<li><a href="<%=basePath%>orders/index">index</a></li>
					<li><a href="<%=basePath%>comm/detail">types</a></li>
					<li><a href="<%=basePath%>comm/cart"> cart </a></li>
					<li><a href="<%=basePath%>comm/list"> billing </a></li>
					<li><a href="<%=basePath%>login/users">users</a></li>

				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div id="index" class="row" ng-controller="index">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="thumbnail pull-left com" ng-repeat="com in coms">
						<img ng-src="<%=basePath%>{{com.img}}" class="img-rounded" width="40"
							height="40">
						<div class="caption">
							<h3>{{com.name}}</h3>
							<p>{{com.depict}}</p>
							<p>
								<a href="#" class="btn btn-primary" role="button"
									ng-click="addToCart(com.id)">add   </a>
							</p>
							<p>
								<button class="btn btn-info" ng-click="showDetail(com)">
									details</button>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<a href="<%=basePath%>comm/cart?id=${id}&name=${name}" class="btn btn-default" role="button">to
				cart</a>
		</div>
	</div>
	</div>

	<!-- Modal --start  -->
	<div class="modal fade" id="detail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" ng-controller="detail">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">product details</h4>
				</div>
				<div class="modal-body">
					<p>name:  {{com.name}}</p>
					<p>desc:  {{com.depict}}</p>
					<p>manufacture:  {{com.manufacturer}}</p>
					<p>price:  {{com.price}}</p>
					<p>
						<img ng-src="<%=basePath%>{{com.img}}" width=50 height=50 />
					</p>
					<div class="commentBody">
						<div ng-repeat="c in comments">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
							{{c.userName}}
							<div class="alert" role="alert">{{c.comment}}</div>
						</div>
						<form>
							<label for="text"></label> <input type="text" name="text"
								id="text" placehoder="add comments" ng-model="comment" />
							<button id="submit" class="btn btn-success"
								ng-click="appendComment(com.id)">comment</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal ---end  -->

	<script>
		var userId = ${id};
		
		var app = angular.module("app", []);

		app.controller("index", function($scope) {
			$scope.coms = [];
			$scope.addToCart = function(comId) {
				ajaxModule.addOrder(userId, comId);
			};
			$scope.showDetail = function(com) {

				$("#detail").modal('show');
				$("#detail").scope().com = com;
				ajaxModule.getCommentById(com.id, function(res) {
					$("#detail").scope().comments = res;
					$("#detail").scope().$apply();
				});

			};
		});

		app.controller("detail", function($scope) {
			$scope.comments = [];

			//添加评论
			$scope.appendComment = function(commodityID) {
				if ($scope.comment) {
					ajaxModule.addComment(commodityID, $scope.comment,
							function() {
								$scope.comments.push({
									userName : "${name}",
									commment : $scope.comment
								});
								$scope.$apply();
							});
				}
				;
			};
		});

		var ajaxModule = {
			getAllCom : function(cb) {
				$.post("<%=basePath%>comm/alllist", cb);
			},
			addOrder : function(userId, commodityIds, cb) {
				$.post("<%=basePath%>orders/addorderlist", {
					userId : userId,
					commodityIds : commodityIds,
					commodityCounts : "1"
				}, function(res) {
					console.log("addOrder.do response is " + res);
					if (res) {
						alert("added");
					} else {
						alert("error try again");
					}
					;
				});
			},
			getCommentById : function(id, cb) {
				$.post("<%=basePath%>comm/comment/"+id, cb);
			},
			addComment : function(commodityID, comment, cb) {
				$.post("<%=basePath%>comm/comment/add/", {
					userId : '${id}',
					userName : '${name}',
					commodityID : commodityID,
					comment : comment
				}, function(res) {
					if (res) {
						cb && cb();
					} else {
						alert("error ");
					}
				});
			}
		};

		function index() {
			ajaxModule.getAllCom(function(res) {
				$("#index").scope().coms = res;
				$("#index").scope().$apply();
			});
		};

		$(function() {
			index();
		});
	</script>
</body>
</html>
