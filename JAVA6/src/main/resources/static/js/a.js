var app=angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl",function($scope,$http){
	
	$scope.cart={
		items:[],
		
		add(id){
			alert(id)
		},
			
		remove(id){},
		
		clear(){},
		
		amt_of(item){},
		
		get count(){},
		
		get amount(){},
		
		saveToLocalStorage(){},
	}
});
