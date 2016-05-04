var appAluno = angular.module('app',
    ['ngMaterial',
        'ngNewRouter',
        'ngAnimate',
        'ngAria',
        'app.aluno'
    ]);
appAluno.controller('AppController',['$scope','$http','$router',AppController]);

function AppController($scope,$http,$router){
    $router.config([
        {path: '/'    ,      redirectTo: '/home'},
        {path: '/aluno' ,      components: 'aluno'}
    ]);
}
