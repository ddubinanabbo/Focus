<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

      <h3><i class="ti-pencil-alt2"></i>  글수정</h3>      
      
      <div class="container-fluid">
          <table class="table">
            <tr>
               <td >제목</td>
               <td colspan="5"><input size="50" type="text" value="원래 제목"></td>               
               <td></td>
               
            </tr>
            <tr>
            	<td>
            	글번호 <font class="text_commentnum"> 1</font>
            	</td>
            	<td>
            	작성자 <font class="text_commentnum"> sport1028</font>
            	</td>
            	<td colspan="2">
				작성날짜 <font class="text_commentnum"> 2017.03.21</font>
            	</td>
            	<td></td>
            	<td></td>
            	<td>
				조회수 <font class="text_commentnum"> 2</font>
            	</td>
            </tr>
            <tr>
               <td >파일업로드</td>
               <td colspan="5"><input type="file" id="upfile" name="upfile"></td>               
               <td></td>
            </tr>                    
           <tr>
                <td colspan="7">
                <textarea rows="28" cols="137">
원래글          
                </textarea>                             
                </td>                
          
           </tr>     
      </table>
      <div class="row">
      	<div class="col-sm-12" align="right">
      		<a href="#" class="btn btn-danger" role="button">취소</a>
      		<a href="#" class="btn btn-primary" role="button">완료</a>
      	</div>
      </div>         
	  </div>

</body>
</html>
