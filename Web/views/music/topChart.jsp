<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.web.jsp.Music.model.vo.*"%>

    
<% ArrayList<Music> list = (ArrayList<Music>)request.getAttribute("list"); %>    
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Music_Chart</title>
    <!-- <link rel="stylesheet" href="../resource/CSS/music_chart_content.css"> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/music_chart_content.css?ver=1.1"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
         <%@ include file="../common/header.jsp" %>
         
    <div class="content">
        <div class="section">
            <div id="sub_menu">
            <ul id="music_chart_navi">
                <li><a onclick="music_chart()">음원차트TOP100</a></li>
                <li><a href="../views/music/topChart.jsp">|&nbsp;전체</a></li>
                <li><a href="../views/music/topChart.jsp">|&nbsp;국내</a></li>
                <li><a href="../views/music/topChart.jsp">|&nbsp;해외</a></li>
            </ul>
            </div>
            <table id="music_chart_info">
                <tr>
                    <th>순위</th>
                    <th>곡 정보</th>
                    <th>♥좋아요</th>
                    <th>곡 리뷰</th>
                    <th>듣기</th>
                </tr>
            </table>
            <!-- 음원차트TOP100 순서 -->
            <table>
            
                <tr id="music_chart_TOP100">
                
               <% for(Music mu : list){ int rank; %>
                  <%for(int i=1; i<101; i++){ rank = i; %>
                    <td><%= rank %></td>
                    <td><a href="../view/Music_Info.html"><img src="${pageContext.request.contextPath}/resources/images/music/<%= mu.getAlbumImage() %>" alt=""></a></td>
                    <td>
                        <ul>
                            <li style="font-size: 14pt; color: black;"><a href="../view/Music_Info.html"><%= mu.getMusicNm()%></a></li>
                            <li style="font-size: 14pt; color: lightgray;"><%= mu.getMusicArtist()%></li>
                        </ul>
                    </td>
                    <td><label onclick="like(this);" id="heart">♥</label><label><%= mu.getLikeMusic()%></label></td>
                    <td><a href="리뷰창"><%= mu.getReviewAlbum() %></a></td>
                    <td><label onclick="streaming(this);"><%= '▶' %></label></td>
                </tr>
              <% } %>
                <% } %>
                
                
               
            </table>
        </div>
    </div>
    
</div>     
     <%@ include file="/views/common/footer.jsp" %>

<script>

function music_chart(){
   location.href="/BOOKTIFULMUSIC//mTop100.mo";
}
</script>

</body>
</html>