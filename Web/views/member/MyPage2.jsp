<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.web.jsp.Member.model.vo.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>My Page - 장바구니</title>
    <link rel="stylesheet" href="../resource/css/all_common.css">
    <link rel="stylesheet" href="../resource/css/shopping basket.css">

</head>
<body>
    <div class="wrapper">
    <%@ include file="../common/header.jsp" %>
   
       
        <div id="sub_menu">
            <ul>
                <li><a href="../member/MyPage1.jsp" >나의정보</a></li>
                <li><a href="../member/MyPage2.jsp">장바구니</a></li>
                <li>| <a href="../member/MyPage3.jsp">구매목록</a></li>
                <li>| <a href="../member/MyPage4.jsp">이용권구매</a></li>
            </ul>
        </div>



    <div id="con1">
        <div class="user_info">
            <img src="../resource/images/icon/ICON.png" id="photo">
            <ul id="circle_ul">
                <li>아이디&nbsp;&nbsp;<%=m.getUserId() %></li>
                <li>이&nbsp;&nbsp;&nbsp;름&nbsp;&nbsp;<%=m.getUserName() %></li> 
                <li>이메일&nbsp;&nbsp;<%=m.getEmail() %></li>
            </ul>
            <div id="btn">
                <button id="btn1" onclick="test1();">#취향수정</button>
                <button id="btn2" onclick="test2();">개인정보수정</button>
            </div>
        </div>


        <div id="user_basket">
            <ul class="basket_list1">
                <li id="list1">장바구니</li>
                <li id="list2">장바구니에 담은 목록입니다.</li>
            </ul>

            
            <div class="basket_list2">
                <div id="basket">
                    
                    <div id="line_1">
                        <ul id="top_m">
                            <li id="all_check"><input type="checkbox" id="check_1"><label for="check_1">&nbsp;전체선택</label></li>
                            <li>도서정보</li>
                            <li>가격</li>
                            <li>수량</li>
                            <li>삭제</li>
                        </ul>
                    </div>
                    <div id="wishlist">
                    <div id="line_2">
                        <ul id="detail">
                            <li><input type="checkbox" id="b1"></li>
                            <li><a href="#"><img src="../resource/images/book/4178687.jpg"><br><p>제목제목제목</p></a></li>
                            <li>19,000</li>
                            <li><input type="number" min="1" max="999" value="1"></li>
                            <li><input type="button" id="deletebtn" value="삭제"></li>
                        </ul>
                    </div>
                    <div id="line_2">
                        <ul id="detail">
                            <li><input type="checkbox" id="b1"></li>
                            <li><a href="#"><img src="../resource/images/book/4178687.jpg"><br><p>제목제목제목</p></a></li>
                            <li>19,000</li>
                            <li><input type="number" min="1" max="999" value="1"></li>
                            <li><input type="button" id="deletebtn" value="삭제"></li>
                        </ul>
                    </div>
                    <div id="line_2">
                        <ul id="detail">
                            <li><input type="checkbox" id="b1"></li>
                            <li><a href="#"><img src="../resource/images/book/4178687.jpg"><br><p>제목제목제목</p></a></li>
                            <li>19,000</li>
                            <li><input type="number" min="1" max="999" value="1"></li>
                            <li><input type="button" id="deletebtn" value="삭제"></li>
                        </ul>
                    </div>
                    <div id="line_2">
                        <ul id="detail">
                            <li><input type="checkbox" id="b1"></li>
                            <li><a href="#"><img src="../resource/images/book/4178687.jpg"><br><p>제목제목제목</p></a></li>
                            <li>19,000</li>
                            <li><input type="number" min="1" max="999" value="1"></li>
                            <li><input type="button" id="deletebtn" value="삭제"></li>
                        </ul>
                    </div>
                    <div id="line_2">
                        <ul id="detail">
                            <li><input type="checkbox" id="b1"></li>
                            <li><a href="#"><img src="../resource/images/book/4178687.jpg"><br><p>제목제목제목</p></a></li>
                            <li>19,000</li>
                            <li><input type="number" min="1" max="999" value="1"></li>
                            <li><input type="button" id="deletebtn" value="삭제"></li>
                        </ul>
                    </div>
                    <div id="line_2">
                        <ul id="detail">
                            <li><input type="checkbox" id="b1"></li>
                            <li><a href="#"><img src="../resource/images/book/4178687.jpg"><br><p>제목제목제목</p></a></li>
                            <li>19,000</li>
                            <li><input type="number" min="1" max="999" value="1"></li>
                            <li><input type="button" id="deletebtn" value="삭제"></li>
                        </ul>
                    </div>
                    </div>

            <div id="buy">
                <input type="submit" id="buybtn" value="구매하기">
            </div>        
            </div>
            

            
        </div>
    </div>
</div>



 <%@ include file="/views/common/footer.jsp" %>
</div>


<script>
    function test1(){
        window.open("../view/pop_genre_select.html","취향수정","width=1000, height=1000, left=450,top=50,location=0, directories=0,resizable=0,status=0,toolbar=0,menubar=0")

    }
    function test2(){
    window.open("../view/modifying_Information.html","정보수정","width=1000, height=1000, left=450,top=50,location=0, directories=0,resizable=0,status=0,toolbar=0,menubar=0")
    }
</script>
</body>
</html>