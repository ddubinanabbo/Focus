<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>

<script type="text/javascript">
var control = "/bbs";

function modifyArticle() {
	if($("#subject").val() == "") {
		alert("제목입력!!!");
		return;
	} else if($("#content").val() == "") {
		alert("내용입력!!!");
		return;
	} else {
		document.writeForm.action = root + control + "/modify.focus";
		document.writeForm.submit();
	}
}

</script>

      <h3><i class="ti-pencil-alt2"></i>  글수정</h3>   
<form id="writeForm" name="writeForm" method="post" action="" enctype="multipart/form-data">   
      
      <input type="hidden" name="bcode" value="${bcode }">
		<input type="hidden" name="pg" value="1">
		<input type="hidden" name="key" value="">
		<input type="hidden" name="word" value="">
		<input type="hidden" name="seq" value="${article.seq }"><!-- 왜 커먼폼에 있는 seq는 못불러오는걸까? -->
		    
      
      <div class="container-fluid">
          <table class="table">
            <tr>
               <td >제목</td>
               <td colspan="5"><input id="subject" name="subject" size="50" type="text" value="${article.subject }"></td>               
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
            	</td>
            	<td></td>
            	<td></td>
            	<td>
				조회수 <font class="text_commentnum"> ${article.hit }</font>
            	</td>
            </tr>
            <tr>
               <td >파일업로드</td>
               <td colspan="5"><input type="file" id="upfile" name="upfile"></td>               
               <td></td>
            </tr>                   
           <tr>           		
                <td colspan="7">
                <p>글 내용</p>
                <textarea id="content" name="content" rows="28" cols="137">
${article.content }
                </textarea>                             
                </td>                
          
           </tr>     
      </table>
      <div class="row">
      	<div class="col-sm-12" align="right">
      		<a href="#" class="btn btn-danger" role="button">취소</a>
      		<a href="javascript:modifyArticle();" class="btn btn-primary" role="button">완료</a>
      	</div>
      </div>          
	  </div>
</form>
</body>
</html>
