<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <script>
  var root ="${root}";
  function movSearch() {
	  document.location.href = root + "/sboard/sboard_list.jsp";
  }
  
  </script>
  <style>
  #search {
  	font-size:20px;
  
  }
  a {
  color : #868e96;
  }
  
  a:hover{
  color : #868e96;
  }
  
  </style>  
<c:if test="${boardmenu != null }">
    <div class="input-group">
        <input type="text" class="form-control" placeholder="Search Blog..">
        <span class="input-group-btn">
          <button id="search" class="btn btn-default" type="button" onclick="javascript:movSearch();">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>
    
    <h5 id="focuscafe"> 메인</h5>
    <div class="panel-group">
	    <div class="panel panel-default" style="border-color: #343957; background-color: #343957;">
		      <div class="panel-heading" style="background-color:#343957; color : #868e96;">
			        <div class="panel-title">
			          <a data-toggle="collapse" href="#notice"><i class="ti-home"> 공지사항</i></a>
			        </div>
			         <div id="notice" class="panel-collapse collapse" style="color : #868e96;">
			        <div class="panel-body"><a href="${root }/aboard/aboard_list.jsp"><i class="ti-announcement"> 전체 공지사항</i></a></div>
			      </div>
		      </div>
	      </div>
      </div>

<h5 id="focuscafe"> 프로그래밍 언어</h5>
  <div class="panel-group">
    <div class="panel panel-default" style="border-color: #343957; background-color: #343957;">
      <div class="panel-heading" style="background-color:#343957; color : #868e96;">
		<c:set var="ccode" value="0"/>
        <c:forEach varStatus="n" var="board" items="${boardmenu }">
	        	<c:if test="${ccode ne board.ccode}">
	        		<c:set var="ccode" value="${board.ccode }"/>
					<div class="panel-title">
			          		<a data-toggle="collapse" href="#collapse${n.count}"><i class="ti-pencil-alt"> ${board.cname }</i></a>
			        	</div>
			        		
	        	</c:if>
				        <c:choose>
				        	<c:when test="${board.controller eq 'reboard' }"><div class="panel-body"><a href="${root }/${board.controller }/list.focus?bcode=${board.bcode}&pg=1&key=&word="><i class="ti-clipboard"> 지식 게시판</i></a></div></c:when>
				        	<c:when test="${board.controller eq 'bbs' }"><div class="panel-body"><a href="${root }/${board.controller }/list.focus?bcode=${board.bcode}&pg=1&key=&word="><i class="ti-files"> 자바 자료실</i></a></div></c:when>
				        	<c:when test="${board.controller eq 'album' }"><div class="panel-body"><a href="${root }/${board.controller }/list.focus?bcode=${board.bcode}&pg=1&key=&word="><i class="ti-book"> 책 추천하기</i></a></div></c:when>
				        	<c:otherwise>test</c:otherwise>
						</c:choose>
      </c:forEach>      
      </div>      
    </div>
  </div>
 </c:if>
<c:if test="${boardmenu == null }">
 	<c:redirect url="/boardadmin/sidebar.focus"/>
 </c:if>  