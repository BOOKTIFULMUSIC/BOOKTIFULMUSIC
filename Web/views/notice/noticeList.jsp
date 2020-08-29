<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*, com.web.jsp.notice.model.vo.*"%>

<% ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice_QnA_notice_1.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<!-- content 부분-->
        <div class="content">
            <div id="section">
                <table id="notice_menu">
                    <tr>
                        <td class="men_index">
                                <img id="child_1" src="https://hotping.co.kr/something/qnaov_09.jpg">
                        </td>
                        <td class="men_index">
                            <a href="../view/notice_QnA_notice_3.html">
                                <img id="child_2" src="https://hotping.co.kr/something/qnam_02.jpg" 
                             onmouseover="this.src='https://hotping.co.kr/something/qnaov_02.jpg'"
                             onmouseout="this.src='https://hotping.co.kr/something/qnam_02.jpg'">
                            </a>
                         </td>
                        <td class="men_index">
                            <a href="../view/notice_QnA_notice_2.html">
                                <img id="child_3" src="https://hotping.co.kr/something/qnam_05.jpg" 
                                onmouseover="this.src='https://hotping.co.kr/something/qnaov_05.jpg'" 
                                onmouseout="this.src='https://hotping.co.kr/something/qnam_05.jpg'">
                            </a>
                        </td>
                        <td class="men_index">
                            <a href="../view/notice_QnA_notice_4.html">
                                <img id="child_4" src="https://hotping.co.kr/something/qnam_08.jpg" 
                                onmouseover="this.src='https://hotping.co.kr/something/qnaov_08.jpg'" 
                                onmouseout="this.src='https://hotping.co.kr/something/qnam_08.jpg'">
                            </a>
                        </td>
                    </tr>
                </table>

                <div id="menu_name">
                    <p id="title">공지사항</p>
                </div>

                <div id="notice">
                    <table class="notice_list">
                        <thead>
                            <tr class="list_head">
                                <th class="list_number">번호</th>
                                <th class="list_subject">제목</th>
                                <th class="list_name">작성자</th>
                                <th class="list_time">등록일자</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for(Notice n : list) { %>
                            <tr class="list_body">
                                <td class="list_number"><%= n.getNno() %></td>
                                <td class="list_subject"><a href="#" class="subject_content"><%= n.getNtitle() %></a></td>
                                <td class="list_name"><%= n.getNwriter() %></td>
                                <td class="list_time"><%= n.getNdate() %></td>
                            </tr>
                         <% } %>
                        </tbody>

                    </table>
                </div>
                <!-- <div class="write_btn">
                    <button id="btn1" onclick="">글쓰기</button>
                </div> -->

            </div>
            
        </div>



        <div id="best_foot">
            <div id="numberList">
                <ul>
                    <li class="numberList_page" id="leftPage"><a href="#"><img src="../resource/book/btn_L.gif"
                                alt=""></a></li>
                    <li class="numberList_page" id="best_page1"><a href="#">1</a></li>
                    <li class="numberList_page" id="best_page2"><a href="#">2</a></li>
                    <li class="numberList_page" id="best_page3"><a href="#">3</a></li>
                    <li class="numberList_page" id="best_page4"><a href="#">4</a></li>
                    <li class="numberList_page" id="best_page5"><a href="#">5</a></li>
                    <li class="numberList_page" id="rightPage"><a href="#"><img src="../resource/book/btn_R.gif"
                                alt=""></a></li>
                </ul>
            </div>
            <div id="book_search">
                <select class="search_tool" name="" id="select_tool">
                    <option value="제목순">제목순</option>
                    <option value="별점순">별점순</option>
                    <option value="판매순">판매순</option>
                </select>
                <input class="search_tool" type="search" name="" id="text_tool">
                <input class="search_tool" type="button" id="confirm_tool" value="검색">
            </div>
        </div>
        
        <%@ include file="../common/footer.jsp" %>
</body>
</html>