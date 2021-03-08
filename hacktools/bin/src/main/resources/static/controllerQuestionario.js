var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {

  $scope.questionario = new Object();


$scope.salvar = function() {
  	$http.post("http://localhost:8080/questionario", {
    'titulo':$scope.titulo,
    'primeiraPergunta':$scope.primeiraPergunta,
    'segundaPergunta':$scope.segundaPergunta,
    'usuario':$scope.usuario
    
  })
  };  
   
  $scope.buscarTodos = function() {
  	console.log("teste")
	  $http.get("http://localhost:8080/questionario/buscarTodos").then(function(resposta) {
		$scope.questionario = resposta.data;  
		console.log($scope.questionario.modelResposta);
	  });
  }
  $scope.buscarTodos();

});