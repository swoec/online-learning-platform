<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS $http Example</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
     <script src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
     <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
     <script src="http://cdn.bootcss.com/angular.js/1.4.4/angular.min.js"></script>
     <script src="<c:url value='/static/js/app.js' />"></script>
     <script src="<c:url value='/static/js/service/user_service.js' />"></script>
     <script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div  id="div-all" class="generic-container" ng-controller="UserController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">User Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" name="uuuuid" ng-model="ctrl.user.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.name" name="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">phone</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.phone" name="uphone"  class="form-control input-sm" placeholder="Enter your phone. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 " for="file">sex</label>
                              <div class="form-group col-md-7">
                                 <div class="form-group col-md-3  ">
                                  <label class="col-md-1 ">male</label>
                                      <div class="col-md-2 ">
                                         <input type="radio" ng-model="ctrl.user.sex" value="male" name="sex"/>
                                      </div>
                                 </div>
                                  
                                  <div class="form-group col-md-3 ">
                                    <label class="col-md-1">female</label>
                                        <div class="col-sm-offset-1 col-md-2">
                                         <input type="radio" ng-model="ctrl.user.sex" value="female" name="sex"/>
                                        </div>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  id ="dttd" value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>phone</th>
                              <th>sex</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                              <td><span ng-bind="u.phone"></span></td>
                              <td><span ng-bind="u.sex"></span></td>
                              <td>
                              <button type="button" value='{{u.id}}u' ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" value={{u.id}} ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <!--  script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script-->
      
  </body>
</html>