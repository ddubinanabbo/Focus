<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<script>
control = "/album";

function searchArticle() {
	document.getElementById("searchForm").action = root + control + "/list.focus";
	document.getElementById("searchForm").submit();
}

function myArticle(myid) {
	$("#commonForm #bcode").val("${bcode}");
	$("#commonForm #pg").val("1");
	$("#commonForm #key").val("id");
	$("#commonForm #word").val(myid);
	document.getElementById("commonForm").action = root + control + "/list.focus";
	document.getElementById("commonForm").submit();
}
</script>
	<h3><i class="ti-book"></i>  책 추천하기</h3>
<div align="right" style="padding:5px;"><a href="javascript:moveWrite('${bcode}');" class="btn btn-info" role="button">글쓰기</a></div>
<div class="row">
<c:forEach varStatus="i" var="article" items="${articlelist}">
    <div class="col-sm-3 ">
      <div class="thumbnail">
        <a href="javascript:viewArticle('${bcode }','${ pg }','${ key }','${ word }','${article.seq }');"><img class="img-fluid" src="${root}/upload/${article.SAVEFOLDER}/${article.SAVE_PICTURE}" alt="..."  height="100" width="200"></a>
          <div class="caption">
            <h3>${article.subject }</h3>
            <p>${article.content }</p>
        </div>
      </div>
    </div> 
    <c:if test="${i.index % 4 == 3}">
		</div>
		<div class="row">
	</c:if>
</c:forEach>     
 
</div>
</div>
</div>
	

	
</body>
</html>