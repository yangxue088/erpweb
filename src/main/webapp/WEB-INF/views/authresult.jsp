<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<body>

	<style type="text/css">
	.pLeft10 {
		padding-left: 10px;
	}

	.p10 {
		padding: 10px;
	}

	.border3 {
		border: 1px solid #ccc;
	}

	.bgColor5 {
		background-color: #eee;
	}

	.fW600 {
		font-weight: 600;
	}

	.f14 {
		font-size: 14px;
	}

	.fColor5 {
		color: #f40;
	}

	</style>

	<div class="container">
		<div class="col-xs-12 bgColor5 border3 p10 pLeft10 fColor5 f14 fW600">
			<span id="result">授权成功, </span><span id="timer">5</span><span>秒后页面自动关闭...</span>
		</div>
	</div>

	<script type="text/javascript">
	var result = ${result};

	if(result){
		$("#result").innerText = "授权成功";
	}
	else{
		$("#result").innerText = "授权失败";
	}

	var counter = setInterval(timer, 1000);

	function timer(){
		count = $("#timer").text() - 1;
		$("#timer").text(count);

		if (count <= 0){
			clearInterval(counter);
			window.close();
			return;
		}
	}
	</script>
	
</body>
</html>