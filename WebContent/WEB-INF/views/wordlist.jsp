<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Words for learning today</title>
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
	margin: 40px;
	overflow: hidden;
}

.padding20 {
	padding: 60px;
}

#index {
	margin-top: 25px;
}
#test{animation:change 30s linear 0s infinite;font-size:20px;font-weight:300;}
@keyframes change{0%   {color:#333;}25%{color:#ff0;}50%{color:#f60;}75%{color:#cf0;}100% {color:#f00;}}

#test1{animation:change 5s linear 0s infinite;font-size:30px;font-weight:400;font-family: Arial, Helvetica, sans-serif;}
@keyframes change{0%   {color:#333;}25%{color:#ff0;}50%{color:#f60;}75%{color:#cf0;}100% {color:#f00;}}
</style>

<body ng-app="ngapp"
	style="background:url(<c:url value='/static/images/1.png'/>) no-repeat;">
	<nav class="navbar navbar-default navbar-fixed-top ">
		<div class="container ">
			<div class="row ">
				<ul class="nav navbar-nav">
					<li><c:if test="${name!=null}">
							<a href="###" id="test1" class="test1"> welcome!  ${name} </a>
						</c:if>	
					</li>

					<li><a href="<%=basePath%>orders/index">Courses</a></li>
					<li><a href="<%=basePath%>comm/detail">Plan</a></li>
					<li><a href="<%=basePath%>comm/cart"> Community&Friends </a></li>
					<li><a href="<%=basePath%>login/users">My profile</a></li>

				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<div id="index" class="row" ng-controller="index">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="thumbnail pull-center com" ng-repeat="com in coms">
					    <i ng-bind-html="Mp3Path1 | trustUrl"> </i>
						<img ng-src="<%=basePath%>{{com.img}}" class="img-rounded" width="150"
							height="150" ng-click="playAudio(com.pronouncation)">
							 
						<div class="caption">
					       
							   <h3 id="test" class="test"><span class="glyphicon glyphicon-heart-empty"></span>{{com.word}}</h3>
							
							<li class="text-info">Explanation: {{com.explanation}}</li>
							<li class="text-success">Example: {{com.sentance}}</li>
							<li class="text-muted">Synonym: {{com.synonym}}</li>
						    <video ng-src="{{videoUrlFun(com.pic)}}" controls width="320" height="240"></video>
							
							<!--  p>
								<a href="#" class="btn btn-primary" role="button"
									ng-click="addToCart(com.id)">add   </a>
							</p>
							<p>
								<button class="btn btn-info" ng-click="showDetail(com)">
									details</button>
							</p-->
							
						</div>
						<div class="row">
								<div class="col-xs-6">
								   
									<a href="" class="btn btn-default" role="button" ng-click="getNewWord(com.id-1)">previous
										</a>
								</div>
								<div class="col-xs-6">
									<a href="" class="btn btn-default" role="button" ng-click="getNewWord(com.id+1)">next
										</a>
								</div>
		               </div>
					</div>
				</div>
			</div>
			
		</div>
		
	</div>
	<script type="text/javascript">
	    var userId = ${id};
		
		var app = angular.module("ngapp", []);
		
		app.filter('trustUrl',function($sce){
	        return function (input) {
	            return $sce.trustAsResourceUrl(input);
	        }
	      });

		app.controller("index", function($scope,$sce) {
			$scope.coms = [];
			$scope.addToCart = function(comId) {
				ajaxModule.addOrder(userId, comId);
			};
			$scope.getNewWord = function(id){
				
				ajaxModule.getWordById(id,function(res){
					
					if(res != null && typeof res != undefined && res!= ""){
						
						$("#index").scope().coms = res;
						$("#index").scope().$apply();
						$scope.reloadPage = function(){window.location.reload();}
					}else{
						alert("Last word!")
					}
				});
			};
			$scope.playAudio = function(audio) {
		        var audio = new Audio(audio);
		        audio.play();
		    };
			$scope.MP3click = function (HSK) {
	            $scope.Mp3Path1 = "<audio  controls='controls' id='Audio1'><source ng-src='{{videoUrlFun(HSK)}}' type='audio/mpeg'/></audio>";
	        };
	                   
			$scope.videoUrlFun = function(url){
		        //$sce.trustAsResourceUrl方法把普通路径处理加工成一个angular环境可识别，并认为是安全的路径来使用
		       
		        var urlFun = $sce.trustAsResourceUrl(url);
		        
		        return urlFun;
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
		
		
		var ajaxModule = {
				getAllCom : function(cb) {
				$.post("<%=basePath%>comm/wordlist", cb);
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
			getWordById : function(id, cb) {
				$.post("<%=basePath%>comm/word/"+id, cb);
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
		
		function getword(id) {
			ajaxModule.getWordById(id,function(res) {
				$("#index").scope().coms = res;
				$("#index").scope().$apply();
				window.location.reload();
			});
		};

		$(function() {
			index();
		});
		
		</script>
</body>
</html>