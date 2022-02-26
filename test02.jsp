<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 
<html>
	<head>
	    <meta charset="utf-8"/>
		<title>Ajax Test01</title>
		<script type="text/javascript" language="javascript" 
		     src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script type="text/javascript">
			//$(document).ready(function(){
			//}); //준비가 되면 j쿼리사용하겟다 자바스크립트 펑션으로 
			
			$(function(){
				$("#seq").on("keyup" , function(){
					$.ajax({
						url: "../ajax01/search01.do",// 서버의 주소 매칭
						type: "GET", //전송방식
						data: {seq:$("#seq").val()},
						success:function(data) // 서버측에서 준 데이터
						{	//var jsObj = JSON.parse(data); // json -> jsObj
							//let json = JSON.stringify(data); // jsObj - json
							//1 파싱
							//console.log("#data: " + data.name);
							//2 화면갱신
							if(!data){
								alert("존재하지않는 seq");
								return false;
							}
							
							let html = "";
							html += "<form id='ajax'>";
							html += "번호 <input name='seq' value='"+data.seq+"'>";
							html += "이름 <input name='name' value='"+data.name+"'>";
							html += "주소 <input name='addr' value='"+data.addr+"'>";
							html += "</form>";
						}
						}
					});
					
				});
				
				$("#search")
			});
		</script>
	</head>
	<body>
	    <center>
	    <h2>(방법1) response객체에 JSON문자열 담기</h2>
	    
	    번호: <input type="text" name="seq" id="seq"/>
	    <input type="button" value="번호 검색" id="searchOk01"/>
	    <br/>
	    
	    이름: <input type="text" name="name" id="name"/>
	    <input type="button" value="이름 검색" id="searchOk02"/>
	 
        <br/><br/>
		<div id="container"></div>
		<br/><br/>
		
		<a href="../">인덱스</a><br/><br/>
		</center>
	</body>
</html>

-->


<html>
   <head>
       <meta charset="utf-8"/>
      <title>Ajax Test02</title>
      <script type="text/javascript" language="javascript" 
           src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
      <script type="text/javascript">
           /*
           $(document).ready(function(){
           });*/
           $(function(){
              $("#seq").on("keyup", function(){
                 $.ajax({
                    url: "../ajax02/search01.do", 
                    type: "GET", 
                    data: {seq: $("#seq").val()}, 
                    success: function(data){
                       //var jsObj = JSON.parse(data); //json -> jsObj : jQuery버젼이 낮을 때 
                       //var json = JSON.stringify(data); //jsObj -> json 
                       
                       //(1) 파싱 
                       //data; // 현재는 jsObj
                       console.log("#data.name: " + data.name);
                       
                       //(2) 화면갱신
                       if(!data){
                          alert("존재하지 않는 SEQ");
                          return false;
                       }
                       
                       var html = "";
                       html += "<form id='ajax'>";
                       html += "번호 <input name='seq' value='"+data.seq+"'>";
                       html += "이름<input name='name' value='"+data.name+"'>";
                       html += "주소 <input name='addr' value='"+data.addr+"'>";
                       html += "날짜 <input name='rdate' value='"+data.rdate+"'>";
                       html += "</form>";
                       
                       $("#name").val("");
                       $("#container").html(html);
                    }
                 });
              });
              
              $("#searchOk02").on("click", function(){
            	 $.ajax({
            		 url: "../ajax02/search02.do" ,
            		 type:"post" ,
            		 data: {name: $("#name").val()},
            		 success:function(data){
            			 if(!data){
            				 alert("존재하지 않아요");
            				 return false;
            			 }
            			 
            			 let html = "";
            			 html += "<table border='1' width=0'50%'>";
            			 html += "<tr>";
            			 html +="<th>번호</th>";
            			 html +="<th>이름</th>";
            			 html +="<th>주소</th>";
            			 html +="<th>날짜</th>";
            			 html +="</tr>";
            			 
            			 if(data.length == 0){
            				 html += "<tr>";
            				 html +="<td colspan='4' align='center'>암도없다</td>";
            				 html +="</tr>";
            			 } else {
            				 for(let s of data){
                    			 html +="<tr>";
                    			 html +="<td>"+s.seq+"</td>";
                    			 html +="<td>"+s.name+"</td>";
                    			 html +="<td>"+s.addr+"</td>";
                    			 html +="<td>"+s.rdate+"</td>";
                    			 html +="</tr>";
                    			 
            				 }
            			 }
            			 
            			 html +="</table>";
            			 $("#seq").val("");
                         $("#container").html(html);
            		 }
            	 }) ;
              });
           });
      </script>
   </head>
   <body>
       <center>
       <h2>(방법2) response객체에 JSON문자열 담기</h2>
       
       번호: <input type="text" name="seq" id="seq"/>
       <input type="button" value="번호 검색" id="searchOk01"/>
       <br/>
       
       이름: <input type="text" name="name" id="name"/>
       <input type="button" value="이름 검색" id="searchOk02"/>
    
        <br/><br/>
      <div id="container"></div>
      <br/><br/>
      
      <a href="../">인덱스</a><br/><br/>
      </center>
   </body>
</html>