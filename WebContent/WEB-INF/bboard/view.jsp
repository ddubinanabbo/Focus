<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<script>
var control = "/album";

</script>
<c:if test="${article != null }">
   <h3><i class="ti-clipboard"></i>  책 추천 글보기</h3>      
      
      <div class="container-fluid">
          <table class="table">
          	<tr>
                <td colspan="7" align="right">
                <a href="javascript:listArticle('${bcode }','1','','');" class="btn btn-success" role="button">글 목록</a>
                	<c:if test="${userInfo.m_ID == article.id }">
                	<a href="javascript:deleteArticle('${bcode }','${article.seq }',0);" class="btn btn-danger" role="button">삭제</a>
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
					<img class="img-fluid" src="${root}/upload/${article.SAVEFOLDER}/${article.SAVE_PICTURE}" alt="..." >
                </td>                
          
           </tr>                    
           <tr>
                <td colspan="7">
                <p>${article.content }</p>                             
                </td>                
          
           </tr>     
      </table>
      
      <hr>
      <h4>Leave a Comment:</h4>
      <form role="form">
        <div class="form-group">
          <textarea class="form-control" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
      <br><br>
      
      <p><span class="badge">2</span> Comments:</p><br>
      
      <div class="row">
        <div class="col-sm-2 text-center">
          <img src="bandmember.jpg" class="img-circle" height="65" width="65" alt="Avatar">
        </div>
        <div class="col-sm-10">
          <h4>Anja <small>Sep 29, 2015, 9:12 PM</small></h4>
          <p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
          <br>
        </div>
        <div class="col-sm-2 text-center">
          <img src="bird.jpg" class="img-circle" height="65" width="65" alt="Avatar">
        </div>
        <div class="col-sm-10">
          <h4>John Row <small>Sep 25, 2015, 8:25 PM</small></h4>
          <p>I am so happy for you man! Finally. I am looking forward to read about your trendy life. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
          <br>
          
        </div>
      </div>         
	  </div>
</c:if>
<c:if test="${article == null }">
<script>
alert("글이 삭제되었거나 존재하지 않는 글입니다.");
listArticle('${bcode }','${pg }','${key }','${word }')
</script>
</c:if>

    </div>
    </div>
    </div>

</body>
</html>