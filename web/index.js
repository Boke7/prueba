var app=angular.module("app",[]);

function PruebaController($scope){
    
        $scope.direccion= {
            codigoPostal:"46900",
            nombreVia:"Virgén de las Angustias",
            puerta:"35-7"
        };
        
        $scope.onClickButtonCambiar=function(){
            $scope.direccion.nombreVia="Falsa";
        }
    
}


