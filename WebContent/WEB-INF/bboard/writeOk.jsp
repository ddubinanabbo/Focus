<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<script type="text/javascript">
control = "/album";

</script>

       <h3><i class="ti-pencil-alt2"></i> 책 추천 글쓰기 완료</h3>      
		
      <div class="container-fluid">
          
      <div class="row">
      	<div class="col-sm-12" align="right">
      		<a href="javascript:listArticle('${bcode}', '${pg}', '${key}', '${word}');" class="btn btn-danger" role="button">목록 보기</a>
      		<a href="javascript:viewArticle('${bcode}', '${pg}', '${key}', '${word}', '${seq}');" class="btn btn-primary" role="button">작성한 글 확인</a>
      	</div>
      </div>
	  </div>
</body>
</html>
