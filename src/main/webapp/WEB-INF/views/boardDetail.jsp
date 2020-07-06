<%--
  Created by IntelliJ IDEA.
  User: nexgrid
  Date: 2020-06-30
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>등록일</th>
        <th>조회수</th>
    </tr>
    </thead>
    <tbody id="boardBody">

    </tbody>
</table>

    <button onclick="location.href='/'">홈화면</button>
    <button onclick="updateBtn()" >수정</button>
    <button onclick="deleteBtn()">삭제</button>
</body>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    let localhost = "http://localhost:8080/";
    let timeout = 10000;
    let boardList = "";
    let room_idx = <%=request.getParameter("Number")%>


    $(()=>{
        bodyRegistr();
    })

    function updateBtn(){
        location.href = "boardUpdate?Number="+room_idx;
        location.forward();
    }

    function deleteBtn(){
        $.ajax({
            type:"POST",
            contentType:"application/json",
            timeout:timeout,
            url:localhost+"boardDelete.dao",
            data:JSON.stringify({"room_idx":room_idx}),
            dataType:"json",
            success:function(data){
                if (data == 1){
                    console.log("성공");
                    location.href = "/";
                    location.forward();
                }
            },
            error:function (error) {
                console.log(error)
            }
        });
    }


    function bodyRegistr() {

        $.ajax({
            type: "GET",
            contentType: "application/json",
            timeout: timeout,
            url: localhost + "boardDetail.dao",
            data: "Number=" + room_idx,
            dataType: "json",
            success: function (data) {
                // ======================================게시판===========================================

                let BoardBody = data;
                boardList += '<tr id="sequence_idx_' + room_idx + '" class="board-list">' + '\n';
                boardList += '<td>' + '';
                boardList += BoardBody.room_idx;
                boardList += '<td>' + '\n';
                boardList += '<td>' + '';
                boardList += BoardBody.user_name;
                boardList += '<td>' + '\n';
                boardList += '<td>' + '';
                boardList += BoardBody.title;
                boardList += '<td>' + '\n';
                boardList += '<td>' + '';
                boardList += BoardBody.content_text;
                boardList += '<td>' + '\n';
                boardList += '<td>' + '';
                boardList += BoardBody.first_date;
                boardList += '<td>' + '\n';
                boardList += '<td>' + '';
                boardList += BoardBody.upload_date;
                boardList += '<td>' + '\n';
                boardList += '<td>' + '';
                boardList += BoardBody.click_idx;
                boardList += '<td>' + '\n';
                boardList += '</tr>' + '\n';

                $('#boardBody').html(boardList);
                //======================================게시판===========================================
            },
            error: function (error) {
                console.log(error);
            }
        });

    }

</script>
</html>