<%--
  Created by IntelliJ IDEA.
  User: nexgrid
  Date: 2020-06-30
  Time: 오전 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="EUC-KR" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Title</title>



</head>
<body>
<div>
    <p>게시판 수정</p>
    <form name="boardForm">
        작성자  : <input type="text" name="user_name"/>
        제목    : <input type="text" name="title"/>
        게시글  : <input type="text" name="content_text"/>
        <input type="button" onclick="boaBtn()" value="버튼">
    </form>
</div>
</body>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

    let localhost = "http://localhost:8080/";
    let timeout = 10000;
    let room_idx = <%=request.getParameter("Number")%>

        function boaBtn(){

            let boardForm = document.boardForm;
            let bodyRequest ={
                room_idx:room_idx,
                user_name:boardForm.user_name.value,
                title:boardForm.title.value,
                content_text:boardForm.content_text.value
            };
            BoardRegistr(bodyRequest);
        };

    function BoardRegistr(bodyRequest) {

        $.ajax({
            type: "POST",
            contentType: "application/json",
            data:JSON.stringify(bodyRequest),
            timeout:timeout,
            url: localhost+"boarUpDate.dao",
            dataType: "json",
            success:function (data) {
                if (data===1) {
                    console.log("성공");
                    location.href = "boardDetail?Number="+room_idx;
                    location.forward();
                }

            },
            error:function(error) {
                console.log(error);
            }
        });
    };
</script>
</html>
