<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
   <h3><i class="ti-clipboard"></i>  글보기</h3>      
      
      <div class="container-fluid">
          <table class="table">
            <tr>
               <td >제목</td>
               <td colspan="5">제목 넣을 곳</td>
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
				조회수 <font class="text_commentnum"> 123</font>
            	</td>
            </tr>
            <tr>
                <td colspan="7">
                <img src="#" alt="...">                            
                </td>                
          
           </tr>                    
           <tr>
                <td colspan="7">
                <p>글 내용</p>                             
                </td>                
          
           </tr>     
      </table>
      <hr>
      <div class="row">
      	<div class="col-sm-12" align="right">
      		<a href="#" class="btn btn-danger" role="button">삭제</a>
      		<a href="#" class="btn btn-primary" role="button">수정</a>
      	</div>
      </div> 
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
    </div>
    </div>
    </div>
   
<footer class="container-fluid">
  <p>Footer Text</p>
</footer>
</body>
</html>