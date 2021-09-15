function addCart(){
	alert("Added to cart");
 }

function tong1SP(){
	$("col-sp").each(function(){
        var sum = parseFloat($(this).find("td:eq(3)").text()) + parseFloat($(this).find("td:eq(4)").text());
    	alert(sum);
	})
}

function tinhTong(){
	var qty = document.getElementById("soluong");
	var pri = document.getElementById("giatien");
	var price=pri.getAttribute("data-price");
	var quantity = qty.value;
    var total = price * quantity;
	alert(quantity+"..."+price);
	document.getElementById("tongtien").innerText = total;
 }