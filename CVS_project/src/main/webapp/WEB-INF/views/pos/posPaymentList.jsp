<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="../resources/css/posPaymentList.css?v=<%=System.currentTimeMillis()%>">

<script type="text/javascript"
	src="../resources/plugins/jQuery/jquery-3.4.1.min.js"></script>
<script
	src="../resources/js/posPaymentList.js?v=<%=System.currentTimeMillis()%>"></script>
</head>
<body>
	<header></header>
	<div>
		<table border="1" class="totallist">
			<tr>
				<td>거래번호</td>
				<td>시간</td>
				<td>매출</td>
				<td>카드</td>
				<td>현금</td>
			</tr>
			<c:forEach var="Pos_boardVO" items="${PaymentList}">
				<tr>
					<td>${Pos_boardVO.list_no}</td>
					<td>${Pos_boardVO.sale_time}</td>
					<td>${Pos_boardVO.total_price}</td>
					<td>${Pos_boardVO.total_price}</td>
					<td>${Pos_boardVO.total_price}</td>

				</tr>
			</c:forEach>
		</table>
		<table border="1" class="detaillist">
			<tr>
				<td>상품명</td> md_name
				<td>수량</td> md_ea
				<td>판매가</td> price
				<td>할인</td>
				<td>합계</td> total_price
			</tr>

			<tr>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
			</tr>

		</table>
		<table border="1" class="paymentinfo">
			<tr>
				<td>구분</td>
				<td>수금액</td>
				<td>결제정보</td>
			</tr>
			<tr>
				<td>1</td>
				<td>1</td>
				<td>1</td>
			</tr>

		</table>
	</div>
</body>
</html>