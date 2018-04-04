<#assign base = request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<base href="${base}"/>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="xxr">
	<![endif]-->
	<script src="${base}/lib/jquery-1.11.0.min.js"></script>
	<script>
		$(function(){
			$("button").click(function(){
				$.getJSON("${base}/getDataList",function(data){
					$("h3").html(data.join("-"));
				});
				<#--$.getJSON("${base}/updateName",{name:"语文2018"},function(data){-->
					<#--$("h4").html(data);-->
				<#--});-->
			});
		});
	</script>
</head>

<body style="background: pink">
    <h1>hello spring boot</h1>
    <h2>哈哈哈及时发布</h2>
    <p>${say}</p>
    <p>${base}</p>
	<h3></h3>
	<h4></h4>
<button value="2222">22222</button>
</body>