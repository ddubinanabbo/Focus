<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<script>
var control = "/bbs";
 
function download() {
	alert("javascript");
	document.location.href = root + control + "/download.focus?path=${article.SAVEFOLDER}&fileName=${article.SAVE_FILE}";
}

</script>
      <h3><i class="ti-clipboard"></i>  글보기</h3>      
      
      <div class="container-fluid">
          <table class="table">
          	<tr>
                <td colspan="7" align="right">
				<a href="javascript:listArticle('${bcode }','1','','');" class="btn btn-success" role="button">글 목록</a>
                	<c:if test="${userInfo.m_ID == article.id }">
                	<a href="javascript:deleteArticle('${bcode }','${article.seq }',0);" class="btn btn-danger" role="button">삭제</a>
      				<a href="javascript:moveModify('${bcode }','${pg }','${key }','${word }','${article.seq }');" class="btn btn-primary" role="button">수정</a>
      				</c:if>	
				</td>
            </tr>
            <tr>
               <td >제목</td>
               <td colspan="5">${article.subject }</td>
               <td></td>
            </tr>
            <tr>
            	<td>
            	글번호 <font class="text_commentnum"> ${article.seq }</font>
            	</td>
            	<td>
            	작성자 <font class="text_commentnum"> ${article.name }</font>
            	</td>
            	<td colspan="2">
				작성날짜 <font class="text_commentnum"> ${article.logtime }</font>
            	</td>
            	<td colspan="2">
            	파일첨부  <font class="text_commentnum"> 
            	<a href="javascript:download();">${article.ORIGIN_FILE }</a></font>
		
            	</td>
            	<td>
				조회수 <font class="text_commentnum"> ${article.hit }</font>
            	</td>
            </tr>                   
           <tr>
                <td colspan="7">
                <p>${article.content}</p>                             
                </td>                
          
           </tr>     
      </table>          
	  </div>

</body>
</html>
