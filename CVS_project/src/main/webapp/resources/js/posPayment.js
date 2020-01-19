
$(document).ready(function() {

	
	
	var cnt=1;
	var ea=1;
	var sale=0;
	var list = Array();
	var bar =0;
	var price=0;
	var ead=0;
	var totalpr = 0;
	 var classname ="";
	$("#md_update").on("click", function() {
		
		var barcode_no = $("#barcode_no").val();

		var str ="";
		$.getJSON("posList?barcode_no="+barcode_no,function(data){
			console.log(data);
			$(data).each(
					
				
					function(){
						bar = $("."+barcode_no+"").html();
						
						
						console.log(bar);
						console.log(barcode_no);
						
						if(bar == barcode_no){
							 ead = parseInt($("."+barcode_no+"ea").html())+1;
							 pricet = parseInt($("."+barcode_no+"pr").html())*ead;

							console.log(ead);
							console.log(pricet);
							
							$("."+barcode_no+"ea").html(ead);
							$("."+barcode_no+"total").html(pricet);
							totalpr += parseInt($("."+barcode_no+"pr").html());

						}else{
						
							str += "<tr class='no"+cnt+"'>";
							str +=		"<td> "+cnt+"</td>";
							str +=		"<td> <a id=bar"+cnt+" class="+this.barcode_no+">"+this.barcode_no+"</a></td>";
							str +=		"<td> <a class="+this.md_name+">"+this.md_name+"</a></td>";
							str +=		"<td> <a class="+this.barcode_no+"pr>"+this.price+"</a></td>";
							str +=		"<td> <a id=ea"+cnt+" class="+this.barcode_no+"ea>"+ea+"</a></td>";
							str +=		"<td> <a class="+sale+">"+sale+"</a></td>";
							str +=		"<td> <a class="+this.barcode_no+"total>"+(this.price)*ea+"</a></td>";
							str +=	"</tr>";
							
							
							cnt++;
							totalpr += parseInt(this.price);
						}
						
						$(".listTotalPr").html(totalpr);	//리스트 총합계
						$(".listSalePr").html(sale);		//할인금액
						$(".listPaymentPr").html(totalpr-sale);	//합계-할인금액
						
						var inputPr = parseInt($(".listInputPr").val());	
						var totalPr = parseInt($(".listTotalPr").html());
					
						if(inputPr<totalPr){
								$(".listOutputPr").html(0);	//받은돈 - 합계

						}
						
								
					});
			$(".listtable").append(str);
		});
		
	});
	$(".listInputPr").on("keyup", function() {
		
		var inputPr = parseInt($(".listInputPr").val());
		
		var totalPr = parseInt($(".listTotalPr").html());

		console.log(inputPr);	
		console.log(totalPr);	
		
		if(inputPr>totalPr){
			$(".listOutputPr").html(inputPr-totalPr);	//받은돈 - 합계
			$(".listPaymentPr").html(0);	//받을 금액


			console.log(inputPr-totalPr);	
			
			

		}else{
			$(".listOutputPr").html(0);	//거스름돈 = 받은돈 - 합계
			if(isNaN(inputPr)==false)
			$(".listPaymentPr").html(totalPr-inputPr);	//받을 금액

		}
		
	});
	
	 $("input[type=text]").on("focus",function(){
		 
			idname = $(this).attr("id");
			console.log(idname);	
	 });

	
	$(".numkey tr td").on("click",function(){
		 var inputKey = $(this).text();
		 
		if(isNaN(inputKey)==false){
	

		 var txtArea = document.getElementById(""+idname+"");
			console.log(txtArea);	

		 
		 var txtValue = txtArea.value;
		 var selectPos = txtArea.selectionStart; // 커서 위치 지정
		 var beforeTxt = txtValue.substring(0, selectPos);  // 기존텍스트 ~ 커서시작점 까지의 문자
		 var afterTxt = txtValue.substring(txtArea.selectionEnd, txtValue.length);   // 커서끝지점 ~ 기존텍스트 까지의 문자
		 var addTxt = inputKey; // 추가 입력 할 텍스트

		 txtArea.value = beforeTxt + addTxt + afterTxt;

		 selectPos = selectPos + addTxt.length;
		 txtArea.selectionStart = selectPos; // 커서 시작점을 추가 삽입된 텍스트 이후로 지정
		 txtArea.selectionEnd = selectPos; // 커서 끝지점을 추가 삽입된 텍스트 이후로 지정
		
	
		
	
		}
	 });
	
	$(".paymentList").on("click",function(){
		
		//$(location).attr('href', 'posPaymentList');



		
	 });//판매내역
	$(".payment td").on("click",function(){
		var paymentType = $(this).text();

		for(var i =1;i<cnt;i++){
					
			var barcode_no = $("#bar"+i+"").text();
			
			var md_ea = $("#ea"+i+"").text();
			

			$.ajax({

				type : "post",
				url : "Payment",
				contentType : "application/json;charset=utf-8",
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : "text",
				data : JSON.stringify({
					barcode_no : barcode_no,
					md_ea : md_ea,
				
				
				}),

				success : function(data) {
					
				},
				error : function(err) {

					alert("등록에 실패했습니다.");
				}
	   
	
			});

			
			
		}//for문 끝
		
		$.ajax({

			type : "post",
			url : "Auto_increment",
			contentType : "application/json;charset=utf-8",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : "text",
			data : JSON.stringify({
				list_no : 1
			
			
			}),

			success : function(data) {
				$(location).attr('href', 'posPayment');

			},
			error : function(err) {

				alert("등록에 실패했습니다.");
			}
   

		});
		
	 });//현금결제
	
	
	
	
});