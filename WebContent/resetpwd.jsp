<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#sendmailbtn").click(function(){
		if($("#M_MAIL").val() == "") {
			alert("메일을 입력하세요!!!!");
			return;
		}else {
			document.mailform.submit();
		}
	})
})
</script>

      <h3><i class="ti-pencil-alt2"></i>  비밀번호 재설정</h3>      
      
      <div class="container-fluid">
          <div class="row justify-content-center">
            	<div class="col-lg-2"></div>
                <div class="col-lg-6">
                    <div class="login-content">
                    
                        <div class="login-form">
                            <form name="mailform" method="post" action="${root}/mail/mail.focus">
                                <div class="form-group">
                                	<label>등록한 아이디를 적으세요</label>
                                    <input type="text" id="M_ID" name="M_ID" class="form-control" placeholder="아이디">
                                    <br>
                                    <label>등록한 이메일을 적으세요</label>
                                    <input type="email" id="M_EMAIL" name="M_EMAIL" class="form-control" placeholder="이메일">
                                </div>
                                <div align="right">
                                 <button type="submit" id="sendmailbtn" class="btn btn-primary btn-flat m-b-15">메일전송</button>
                                 </div>
                                 
                            </form>
                        </div>
                    </div>
                </div>
            </div>                 
	  </div>

</body>
</html>
