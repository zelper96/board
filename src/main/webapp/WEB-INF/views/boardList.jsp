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
<div>
    <table id="boardTable">
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
    <input type="button" value="게시판글쓰기" onclick="location.href='boardRegistr'">
    <div id="board_move_btn">
        <ul>

        </ul>
    </div>
</div>
</div>
</body>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

    let localhost = "http://localhost:8080/";
    let timeout = 10000;
    let boardList = "";


    $(()=>{
        $.ajax({
            type : "GET", //전송방식을 지정한다 (POST,GET)
            contentType : "application/json",
            data:"page=1",
            url : localhost+"boarList",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
            dataType :"json",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
            timeout:timeout,
            error : function(error){
                console.log(error);
            },
            success : function(data){



                // ========================================================================
                for(let idx in data.boardList){
                    let BoardBody = data.boardList[idx];
                    boardList += '<tr id="sequence_idx_'+idx+'" class="board-list">'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.room_idx;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.user_name;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.title;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.content_text;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.upload_date;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.click_idx;
                    boardList += '<td>'+'\n';
                    boardList += '</tr>'+'\n';
                }
                $('#boardBody').html(boardList);
                // ========================================================================



                //=====================================상세보기=========================================Z
                $('#boardBody tr').click(function () {
                    let idx = $(this).index();
                    let boardBody = data.boardList[idx];
                    // let url ="boardDetail.jsp?room_idx="+boardBody.room_idx;
                    let url ="boardDetail?Number="+boardBody.room_idx;
                    window.location.href = url;
                    window.open(url);
                    console.log(url);
                });
                //=====================================상세보기=========================================Z


                //=====================================페에징=========================================
                let boardMoveBtn = "";
                // 페이지 계수
                for (let i =0;i<data.boardPageGing[1];i++){
                    boardMoveBtn += '<li><button>'+(i+1)+'</button></li>';
                }
                $('#board_move_btn ul').html(boardMoveBtn);

                $('#board_move_btn ul li').click(function (){
                    let idx = $(this).index();
                    coonection("page="+(idx+1));
                });
                //=====================================페에징=========================================




            }
        });
    });

    // 페이징
    function coonection(bodyRequest) {
        boardList="";
        $.ajax({
            try: "GET",
            contentType: "application/json",
            data:bodyRequest,
            timeout:timeout,
            url: localhost+"boarList",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
            dataType: "json",
            success: function (data) {
                for(let idx in data.boardList){
                    let BoardBody = data.boardList[idx];
                    boardList += '<tr id="sequence_idx_'+idx+'" class="board-list">'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.room_idx;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.user_name;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.title;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.content_text;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.first_date;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.upload_date;
                    boardList += '<td>'+'\n';
                    boardList += '<td>'+'';
                    boardList +=  BoardBody.click_idx;
                    boardList += '<td>'+'\n';
                    boardList += '</tr>'+'\n';
                }
                $('#boardBody').html(boardList);
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

</script>

</html>
