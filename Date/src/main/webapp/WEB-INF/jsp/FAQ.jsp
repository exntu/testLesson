<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${repp }
	
	
	<script type="text/javaScript">
	$(function() {
		$.ajax({
			url : "Date/faq",
			success : function(data) {
				loadCombo($("#combobox"), data.locations);
                                $("#combobox").val("");
			}
		});
 
		$("#combobox").change(function() {
			alert("Selected : " + $("#combobox option:selected").val());
		});
	});
 
	function loadCombo(target, data) {
		var dataArr = [];
		var inx = 0;
		target.empty();
 
		$(data).each( function(key,val) {
			dataArr[inx++] = "<option value=" + val.title + ">" +val.num + "</option> ";
		});
 
		target.append(dataArr);
	}
</script>
 
<select id="combobox">
	<option>===locations===</option>
</select>
</body>
</html>