<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<script type="text/javascript">
control = "/board";

</script>

       <h3><i class="ti-pencil-alt2"></i> 지식게시판 글쓰기 실패</h3>      
		
      <div class="container-fluid">
          
      <div class="row">
      	<div class="col-sm-12" align="right">
      		<a href="javascript:listArticle('${bcode}', '${pg}', '${key}', '${word}');" class="btn btn-danger" role="button">목록 보기</a>
      	</div>
      </div>
	  </div>
</body>
</html>
