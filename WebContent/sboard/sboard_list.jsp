<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

<script>
var root = "${root}";
function movView()	{
	document.location.href = root + "/aboard/view.jsp";
}

</script>

      <h3><i class="ti-search"></i>  전체 게시글 검색결과</h3>
      
      <hr>
      <table class="table table-hover ">
                   <tr>
                      <th>글번호</th>
                      <th>글제목</th>
                      <td align="right"><b>작성자</b></th>
                      <td align="right"><b>작성날짜</b></td>
                   </tr>
          <tbody>
           <tr onclick="javascript:movView();">
                <th scope="row">1</th>
                <td>Kolor Tea Shirt For Man</td>
                <td align="right"><span class="badge badge-primary">Sale</span></td>
                <td align="right">January 22</td>
           </tr>
           <tr>
                <th scope="row">2</th>
                <td>Kolor Tea Shirt For Women</td>
                <td align="right"><span class="badge badge-success">Tax</span></td>
                <td align="right">January 30</td>
           </tr>
                <tr>
                <th scope="row">3</th>
                <td>Blue Backpack For Baby</td>
                <td align="right"><span class="badge badge-danger">Extended</span></td>
                <td align="right">January 25</td>
      		</tr>
      	</tbody>
      </table>
      <hr>

</body>
</html>
