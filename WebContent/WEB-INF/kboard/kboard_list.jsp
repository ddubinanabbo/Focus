<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header_board.jsp" %>
<script>
control = "/reboard";

</script>
      <h3><i class="ti-announcement"></i>  지식 게시판</h3>
      
      <hr>
      <table class="table table-hover ">
                  <tr>
                      <td colspan="7" align="right">
                      <a href="javascript:moveWrite('${bcode }');" class="btn btn-info" role="button">글쓰기</a>
                      </td>
                   </tr>
                   <tr>
                      <th>글번호</th>
                      <th>글제목</th>
                      <td align="right"><b>작성자</b></th>
                      <td align="right"><b>작성날짜</b></td>
                   </tr>
          <tbody>
          <c:forEach var="article" items="${articlelist }">
           <tr >
                <th scope="row">${article.seq }</th>
                <td> <a href="javascript:viewArticle('${bcode }','${ pg }','${ key }','${ word }','${article.seq }');">${article.subject }</a></td>
                <td align="right"><span class="badge badge-primary">${article.name }</span></td>
                <td align="right">${article.logtime }</td>
           </tr>
           </c:forEach>
      	</tbody>
      </table>
      <hr>

</body>
</html>
