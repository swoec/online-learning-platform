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
<title>detail.html</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/angular.js/1.3.15/angular.min.js"></script>
<style>
.commodity {
	margin: 10px;
}

.content {
	margin: 80px;
}

.commentBody {
	max-heiht: 200px;
}
</style>
</head>
<body ng-app="app" style="background:url(<c:url value='/static/images/1.png'/>) no-repeat;">

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="row">
				<ul class="nav navbar-nav">
					<li><c:if test="${name!=null}">
							<a href="###"> welcome ${name} </a>
						</c:if></li>
					<li><a href="<%=basePath%>orders/index">index</a></li>
					<li><a href="<%=basePath%>comm/detail">types</a></li>
					<li><a href="<%=basePath%>comm/cart"> cart </a></li>
					<li><a href="<%=basePath%>comm/list"> billing </a></li>
					<li><a href="<%=basePath%>login/users">users</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container content">
		<div class="row">
			<p>
				<span class="glyphicon glyphicon-cd" aria-hidden="true"></span> <input
					class="form-control" id="keyword" placeholder="keyword"><br>
				<button id="search" class="btn btn-primary">search</button>
			</p>
		</div>
		<div id="groups" class="row" ng-controller="groups">
			<div ng-repeat="coms in groups">
				<h3>
					<span class="glyphicon glyphicon-fire" aria-hidden="true"></span> <span
						class="label label-default"> {{coms[0].type}} </span>
				</h3>
				<div class="panel panel-default pull-left commodity"
					ng-repeat="com in coms">
					<div class="panel-heading panel-primary">
						<p>{{com.name}}</p>
					</div>
					<div class="panel-body">
						<p>{{com.depict}}</p>
						<p>manu:{{com.manufacturer}}</p>
						<p>price:{{com.price}}</p>
						<p>
							<img ng-src="<%=basePath%>{{com.img}}" width=50 height=50 />
						</p>
						<button class="btn btn-default" ng-click="addToCart(com.id)">
							add to cart </button>
						<button class="btn btn-default" ng-click="showDetail(com)">
							detail</button>
					</div>
				</div>
				<div class="clearfix "></div>
			</div>
		</div>
		<div class="row">
			<a href="<%=basePath%>comm/cart?id=${id}&name=${name}" class="btn btn-default" role="button">cart</a>
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
					<h4 class="modal-title" id="myModalLabel">information</h4>
				</div>
				<div class="modal-body">
					<p>{{com.name}}</p>
					<p>{{com.depict}}</p>
					<p>{{com.manufacturer}}</p>
					<p>{{com.price}}</p>
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
								id="text" placehoder="comment" ng-model="comment" />
							<button id="submit" class="btn btn-success"
								ng-click="appendComment(com.id)">comment</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal ---end  -->

</body>

<script>
	var userId = "${id}";
	var app = angular.module("app", []);
	app.controller("groups", function($scope) {

		$scope.groups = {};

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
				ajaxModule.addComment(commodityID, $scope.comment, function() {
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

	function updateIndex() {
		ajaxModule.getAllCom(function(res) {
			var result = util.groupByType(res);
			$("#groups").scope().groups = result;
			$("#groups").scope().$apply();

		});
	};

	function bind() {
		$("#search").click(function() {
			ajaxModule.search($("#keyword").val(), function(res) {
				var result = util.groupByType(res);
				$("#groups").scope().groups = result;
				$("#groups").scope().$apply();
			});
		});
	};

	/**
	 *@desc
	 */
	var util = {
		/**
		 *@desc 
		 *@return Object;
		 */
		groupByType : function(res) {
			var obj = {};
			for (var i = 0; i < res.length; i++) {
				obj[res[i].type] = obj[res[i].type] || [];
				obj[res[i].type].push(res[i]);
			}
			;
			return obj;
		}
	};

	/**
	 *@desc ajax
	 */
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
					alert("error");
				}
				;
			});
		},
		search : function(keyword, cb) {
			$.post("<%=basePath%>comm/search", {
				keyword : keyword
			}, cb);
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
					alert("error");
				}
			});
		}
	};

	$(function() {
		updateIndex();
		bind();
	});
</script>
</html>
