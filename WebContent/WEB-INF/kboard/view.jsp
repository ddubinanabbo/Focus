<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<c:if test="${article != null }">
<script>
control = "/reboard";

function moveReply() {
   document.getElementById("bcode").value = "${bcode}";
   document.getElementById("pg").value = "1";
   document.getElementById("key").value = "";
   document.getElementById("word").value = "";
   document.getElementById("seq").value = "${article.seq}";
   
   document.getElementById("commonForm").action = root+ control + "/comment.focus";
   document.getElementById("commonForm").submit();
}

</script>

      <h3><i class="ti-clipboard"></i>  글보기</h3>      
      
      <div class="container-fluid">
          <table class="table">
          	<tr>
                <td colspan="7" align="right">
                <a href="javascript:listArticle('${bcode }','1','','');" class="btn btn-success" role="button">글 목록</a>
                <a href="javascript:moveReply();" class="btn btn-info" role="button">답글 쓰기</a>
                	<c:if test="${userInfo.m_ID == article.id }">
                	<a href="javascript:deleteArticle('${bcode }','${article.seq }','${article.reply }');" class="btn btn-danger" role="button">삭제</a>
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
            	<td></td>
            	<td></td>
            	<td>
				조회수 <font class="text_commentnum"> ${article.hit }</font>
            	</td>
            </tr>                   
           <tr>
                <td colspan="7">
                <p>${article.content }</p>                             
                </td>                
          
           </tr>     
      </table>          
	  </div>
</c:if>
<c:if test="${article == null }">
<script>
alert("글이 삭제되었거나 존재하지 않는 글입니다.");
listArticle('${bcode }','${pg }','${key }','${word }')
</script>
</c:if>
</body>
</html>
