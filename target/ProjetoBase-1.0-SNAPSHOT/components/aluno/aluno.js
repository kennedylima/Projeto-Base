angular.module('app.aluno',['ngNewRouter'])
    .controller('AlunoController',function($scope,$http){
        $scope.aluno={}

        $scope.salvar = function () {
            $http.post("ws/alunos/", $scope.aluno).success(function(dados){
                window.alert("salvo com sucesso");
                $scope.aluno= {};
            });
        }
    });
