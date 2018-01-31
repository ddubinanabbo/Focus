<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
var idflag = false;

$(document).ready(function(){
	$("#registerbtn").click(function(){
		if($("#M_JOB").val() == "") {
			alert("직업을 입력해 주세요!!!!");
			return;
		} else if($("#M_AGE").val() == "") {
			alert("나이를 입력하세요!!!!");
			return;
		} else if($("#M_EMAIL").val() == "") {
			alert("메일을 입력하세요!!!!");
			return;
		} else if($("#M_TEL").val() == "") {
			alert("전화번호를 입력하세요!!!!");
			return;
		} 
		else {
			document.snsmemberform.action = "${root}/user/snsjoin.focus";
			document.snsmemberform.submit();
		}
	})
})

</script>

      <h3><i class="ti-pencil-alt2"></i>  회원가입</h3>      
      
          <div class="container-fluid">
            <div class="row justify-content-center">            	
            	<div class="col-lg-2"></div>
                <div class="col-lg-6">
                    <div class="login-content">
                        <div class="login-form">
                            <form name="snsmemberform" method="post" action="">
                            	<div class="row">
                            	<div class="form-group">
                                    <label>아이디</label>
                                    <input type="text" id="M_ID" name="M_ID" class="form-control" value="${snsUser.m_ID}" readonly="readonly">
                                	<br>
                                	<div id="idckresult"></div>
                                </div>
                                <div class="form-group pl-3">
                                    <label>패스워드</label>
                                    <input type="password" id="M_PASS" name="M_PASS" class="form-control" value="${snsUser.m_PASS}" readonly="readonly">
                                </div>
                                <div class="form-group pl-3">
                                    <label>패스워드 확인</label>
                                    <input type="password" id="passok" name="passok" class="form-control" value="${snsUser.m_PASS}" readonly="readonly">
                                </div>
                                </div>
                                <div class="row">
                                <div class="form-group">
                                    <label>이름</label>
                                    
                                    <input type="text" id="M_NAME" name="M_NAME" size="10" class="form-control" placeholder="이름">
                                </div>
                                <div class="form-group pl-3">
                                    <label>직업</label>
                                    <input type="text" id="M_JOB" name="M_JOB" size="10" class="form-control" placeholder="직업">
                                </div>                                
                                <div class="form-group pl-3">
                                    <label>나이</label>
                                    <input type="text" id="M_AGE" name="M_AGE" class="form-control" placeholder="나이" maxlength="3">
                                </div>
                                </div>
                                <div class="row">
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input type="email" id="M_EMAIL" name="M_EMAIL" class="form-control" placeholder="이메일">
                                </div>
                                <div class="form-group pl-3">
                                    <label>전화번호</label>
                                    <input type="text" id="M_TEL" name="M_TEL" class="form-control" placeholder="전화번호" maxlength="11">
                                </div>
                                </div> 
                                <div align="right" style="padding-bottom:5px;">                               
                                <button type="submit" id="registerbtn" class="btn btn-primary btn-flat m-b-30 m-t-30">등록</button>
                                </div>
                            </form>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>       

</body>
</html>
