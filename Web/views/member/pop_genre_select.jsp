<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.web.jsp.Member.model.vo.*"%>
<%  Member m = (Member)session.getAttribute("member");  %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>BOOKTIFUL MUSIC</title>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <style>
    body{
        border-top: 30px solid rgb(227, 233, 255);
        border-bottom:30px solid rgb(227, 233, 255);
        width: 1000px;
        height: 1000px;
        margin: 0;
    }
    .header{ text-align: center; margin-top: 60px;}
    .header b{ font-size: 24px; }
    #page_logo{ font-size: 36px; color: rgb(227, 233, 255); font-weight: 600;}
    form{ width: 500px; margin: auto;}
    #check {
        width: 450px;
        height: 230px;
        border: 0;
        border: 1px solid rgb(105,140,255);
        
        margin: auto;
        margin-top: 30px;
        text-align:center;
    }
    #subject{ font-size: 20px; margin: 0 20px 0 20px;}

    #check ul {
        width: 420px;
        height: 200px;
        margin: 5px 0 0 15px;
        padding: 0;
        
    }

    #check ul>li {
        list-style: none;
        float: left;
        padding: 1.5%;
        border-radius: 15px;
        cursor: pointer;
        margin: 6px 3% 6px 3%;
        
    }

    #check input{ display: none;}

    #btn{ border: 0; width: 300px; height: 45px; background:rgb(227, 233, 255); margin: 60px 0 30px 97px;}

    </style>
</head>

<body>
    <div class="header">
        <p id="page_logo">BOOKTIFUL<br>MUSIC</p>
        <b># 취향 수정</b>
        <p id="info">반갑습니다. 원하시는 장르를 선택해주세요.</p>
    </div>
    <form id="pop_select_b" method="get" action="/BOOKTIFULMUSIC/pop_insert.b">
    <fieldset id="check">
    <legend><p id="subject"># 도서</p></legend>
        <ul>
            <li><input type="checkbox" id="bgenre1" name="genre"><label for="bgenre1"># 인문</label></li>
            <li><input type="checkbox" id="bgenre2" name="genre"><label for="bgenre2"># 소설</label></li>
            <li><input type="checkbox" id="bgenre3" name="genre"><label for="bgenre3"># 경제/경영</label></li>
            <li><input type="checkbox" id="bgenre4" name="genre"><label for="bgenre4"># 정치/사회</label></li>
            <li><input type="checkbox" id="bgenre5" name="genre"><label for="bgenre5"># 자기계발</label></li>
            <li><input type="checkbox" id="bgenre6" name="genre"><label for="bgenre6"># 시/에세이</label></li>
            <li><input type="checkbox" id="bgenre7" name="genre"><label for="bgenre7"># 역사</label></li>
            <li><input type="checkbox" id="bgenre8" name="genre"><label for="bgenre8"># 과학</label></li>
            <li><input type="checkbox" id="bgenre9" name="genre"><label for="bgenre9"># 문화</label></li>
            <li><input type="checkbox" id="bgenre10" name="genre"><label for="bgenre10"># 건강</label></li>
            <li><input type="checkbox" id="bgenre11" name="genre"><label for="bgenre11"># 외국어</label></li>
            <li><input type="checkbox" id="bgenre12" name="genre"><label for="bgenre12"># 어린이</label></li>
            <li><input type="checkbox" id="bgenre13" name="genre"><label for="bgenre13"># 가정/육아</label></li>
            <li><input type="checkbox" id="bgenre14" name="genre"><label for="bgenre14"># 예술/대중문화</label></li>
            <li><input type="checkbox" id="bgenre15" name="genre"><label for="bgenre15"># 만화</label></li>
        </ul>
    </fieldset>
    </form>
    
        <form id="pop_select_m" method="get" action="/BOOKTIFULMUSIC/pop_insert.m">
    <fieldset id="check">
    <legend><p id="subject"># 음악</p></legend>
        
        <ul>
            <li><input type="checkbox" id="mgenre1" name="genre"><label for="mgenre1"># 댄스</label></li>
            <li><input type="checkbox" id="mgenre2" name="genre"><label for="mgenre2"># 발라드</label></li>
            <li><input type="checkbox" id="mgenre3" name="genre"><label for="mgenre3"># 락/힙합</label></li>
            <li><input type="checkbox" id="mgenre4" name="genre"><label for="mgenre4"># R&B/Soul</label></li>
            <li><input type="checkbox" id="mgenre5" name="genre"><label for="mgenre5"># 인디</label></li>
            <li><input type="checkbox" id="mgenre6" name="genre"><label for="mgenre6"># 재즈</label></li>
            <li><input type="checkbox" id="mgenre7" name="genre"><label for="mgenre7"># 트로트</label></li>
            <li><input type="checkbox" id="mgenre8" name="genre"><label for="mgenre8"># 포크/블루스</label></li>
            <li><input type="checkbox" id="mgenre9" name="genre"><label for="mgenre9"># OST</label></li>
            <li><input type="checkbox" id="mgenre10" name="genre"><label for="mgenre10"># POP</label></li>
            <li><input type="checkbox" id="mgenre11" name="genre"><label for="mgenre11"># 월드뮤직</label></li>
            <li><input type="checkbox" id="mgenre12" name="genre"><label for="mgenre12"># 뉴에이지</label></li>
            <li><input type="checkbox" id="mgenre13" name="genre"><label for="mgenre13"># 클래식</label></li>
            <li><input type="checkbox" id="mgenre14" name="genre"><label for="mgenre14"># 종교음악</label></li>
            <li><input type="checkbox" id="mgenre15" name="genre"><label for="mgenre15"># 어린이/태교</label></li>
        </ul>
    
    </fieldset>
    <button type="submit" id="btn">수정 완료</button>
    </form>
    <script>
        $(document).ready(function(){
            var a = document.getElementsByName('genre');

            $("input:checkbox").on('click', function () {
                for (i = 0; i < a.length; i++) {
                    if (a[i].checked)  {
                        a[i].parentNode.style.background = "rgb(227, 233, 255)";
                    }else {
                        a[i].parentNode.style.background = "white";
                    }
                }
            }); 
            
        });

    </script>

    
</body>

</html>