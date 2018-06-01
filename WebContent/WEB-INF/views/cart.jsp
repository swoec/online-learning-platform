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
<title>cart.html</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/angular.js/1.3.15/angular.min.js"></script>
</head>
<style>
.commodity {
	margin: 10px;
}

#cart {
	margin-top: 100px;
}
</style>
<body ng-app="app"
	style="background:url(<c:url value='/static/images/1.png'/>) no-repeat;">

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="row">
				<ul class="nav navbar-nav">
					<li class="text-success"><c:if test="${name!=null}">
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
	<div class="container">
		<div id="cart" class="row" ng-controller="cart">
			<ul class="list-group">
				<li class="list-group-item pull-left commodity"
					ng-repeat="order in list">
					<p>product</p>
					<div commodity-directive id="{{order.commodityId}}">
						<p>name:{{res.name}}</p>
						<p>desc:{{res.depict}}</p>
						<p>manu:{{res.manufacturer}}</p>
						<p>price:{{res.price}}</p>
						<p>
							<img ng-src="<%=basePath%>{{com.img}}" width=50 height=50 />
						</p>
						<p>
							total: <span class="badge"> {{order.commodityCount}} </span>
						<p style="display: none">{{order.price=res.price}}</p>
						</p>
						<button class="btn btn-danger"
							ng-click="comCount(-1, order.commodityId)">one less</button>
						<button class="btn btn-warning"
							ng-click="comCount(1, order.commodityId)">one more</button>
					</div>
				</li>
			</ul>
			<div class="clearfix">
				<p>account:{{sum}}</p>
			</div>
			<input type="hidden" value="${id}" class="form-control" id="userId">
			<br> <label class="clearfix"> addr: <input type="text"
				class="form-control" id="address">
			</label> <br> <label class="clearfix"> phone: <input
				type="number" class="form-control" id="phone">
			</label> <br>
			<button id="submit" class="btn btn-success">submit </button>
		</div>
	</div>

	<script>
		var userId = "${id}";

		var app = angular.module("app", []);

		app.directive("commodityDirective", function() {
			return {
				restrict : "EA",
				scope : true,
				link : function($scope, $el, $iattrs) {
					$.post("<%=basePath%>comm/detail/"+userId,function(res) {
						$scope.res = res[0];
						$scope.$apply();
					});
				}
			}
		});

		app.controller("cart", function($scope) {
			var list = [];//[{"id":1,"userId":19,"commodityId":1,"commodityCount":1},{"id":2,"userId":19,"commodityId":2,"commodityCount":5},{"id":3,"userId":19,"commodityId":3,"commodityCount":2},{"id":4,"userId":19,"commodityId":5,"commodityCount":4},{"id":5,"userId":19,"commodityId":4,"commodityCount":3}]
			$scope.list = list;
			$scope.scope = 0;

			$scope.comCount = function(constant, commodityId) {
				$.each($scope.list, function(i, e) {
					if (e.commodityId == commodityId) {
						$scope.list[i].commodityCount += constant;
					}
					;
					if (e.commodityCount <= 0) {
						e.commodityCount = 0;
					}
					;
				});
				$scope.upDateSum();
			};
			$scope.upDateSum = function() {
				$scope.sum = util.calcSum($scope.list);
			};
		});
		var util = {
			calcSum : function(list) {
				var sum = 0;
				$.each(list, function(i, e) {
					sum += (e.commodityCount * e.price);
				});
				return sum;
			}
		};
		if (userId) {
			$.post("<%=basePath%>orders/orderlist/"+userId
			, function(res) {
				$("#cart").scope().list = res;
				setInterval(function() {
					$("#cart").scope().upDateSum();
					$("#cart").scope().$apply();
				}, 1000);
			});
		};
		$("#submit").click(function() {
			$.post("<%=basePath%>orders/addorders", {
				userId : $("#userId").val(),
				address : $("#address").val(),
				phone : $("#phone").val(),
				totalPrice : $("#cart").scope().sum,
				orderList : JSON.stringify($("#cart").scope().list)
			}, function(res) {
				if (res === true) {
					location.href = "<%=basePath%>comm/list";
				} else {
					alert("error");
				}
				;
			});
		});
		//addForm
	</script>
</body>
</html>
