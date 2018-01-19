<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <div class="panel-title">
          <a data-toggle="collapse" href="#collapse1"><i class="ti-pencil-alt"> 자바</i></a>
        </div>
         <div id="collapse1" class="panel-collapse collapse" style="color : #868e96;">
        <div class="panel-body"><a href="${root }/kboard/kboard_list.jsp"><i class="ti-clipboard"> 지식 게시판</i></a></div>
        <div class="panel-body"><a href="${root }/bbs/bbs_list.jsp"><i class="ti-files"> 자바 자료실</i></a></div>
        <div class="panel-body"><a href="${root }/bboard/bboard_list.jsp"><i class="ti-book"> 책 추천하기</i></a></div>
      </div>
      </div>
      <div class="panel-heading" style="background-color:#343957; color : #868e96;">
        <div class="panel-title">
          <a data-toggle="collapse" href="#collapse2"><i class="ti-pencil-alt"> 씨</i></a>
        </div>
         <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body"><i class="ti-clipboard"> 지식 게시판</i></div>
        <div class="panel-body"><i class="ti-files"> 씨 자료실</font></i></div>
        <div class="panel-body"><i class="ti-book"> 책 추천하기</i></div>
      </div>
      </div>
      <div class="panel-heading" style="background-color:#343957; color : #868e96;">
        <div class="panel-title">
          <a data-toggle="collapse" href="#collapse3"><i class="ti-pencil-alt"> 씨++</i></a>
        </div>
         <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body"><i class="ti-clipboard"> 지식 게시판</i></div>
        <div class="panel-body"><i class="ti-files"> 씨++ 자료실</font></i></div>
        <div class="panel-body"><i class="ti-book"> 책 추천하기</i></div>
      </div>
      </div>
      <div class="panel-heading" style="background-color:#343957; color : #868e96;">
        <div class="panel-title">
          <a data-toggle="collapse" href="#collapse4"><i class="ti-pencil-alt"> 파이썬</i></a>
        </div>
        <div id="collapse4" class="panel-collapse collapse">
        <div class="panel-body"><i class="ti-clipboard"> 지식 게시판</i></div>
        <div class="panel-body"><i class="ti-files"> 파이썬 자료실</i></div>
        <div class="panel-body"><i class="ti-book"> 책 추천하기</i></div>
      </div>
      </div>
      <div class="panel-heading" style="background-color:#343957; color : #868e96;">
        <div class="panel-title">
          <a data-toggle="collapse" href="#collapse5"><i class="ti-pencil-alt"> 씨#</i></a>
        </div>
        <div id="collapse5" class="panel-collapse collapse">
        <div class="panel-body"><i class="ti-clipboard"> 지식 게시판</i></div>
        <div class="panel-body"><i class="ti-files"> 씨# 자료실</i></div>
        <div class="panel-body"><i class="ti-book"> 책 추천하기</i></div>
      </div>
      </div>
      <div class="panel-heading" style="background-color:#343957; color : #868e96;">
        <div class="panel-title">
          <a data-toggle="collapse" href="#collapse6"><i class="ti-pencil-alt"> 알</i></a>
        </div>
        <div id="collapse6" class="panel-collapse collapse">
        <div class="panel-body"><i class="ti-clipboard"> 지식 게시판</i></div>
        <div class="panel-body"><i class="ti-files"> 알 자료실</i></div>
        <div class="panel-body"><i class="ti-book"> 책 추천하기</i></div>
      </div>
      </div>
      <div class="panel-heading" style="background-color:#343957; color : #868e96;">
        <div class="panel-title">
          <a data-toggle="collapse" href="#collapse7"><i class="ti-pencil-alt"> 루비</i></a>
        </div>
        <div id="collapse7" class="panel-collapse collapse">
        <div class="panel-body"><i class="ti-clipboard"> 지식 게시판</i></div>
        <div class="panel-body"><i class="ti-files"> 루비 자료실</i></div>
        <div class="panel-body"><i class="ti-book"> 책 추천하기</i></div>
      </div>
      </div>
    </div>
  </div>
  
      