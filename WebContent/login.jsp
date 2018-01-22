<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String saveid = "";
String checkid = "";

Cookie cookie[] = request.getCookies();
if(cookie != null) {
	int len = cookie.length;
	for(int i=0;i<len;i++) {
		if("nid_sid".equals(cookie[i].getName())) {
			saveid = cookie[i].getValue();
			checkid = " checked=\"checked\"";
			break;
		}
	}
}
%>  
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#loginbtn").click(function(){
		if("#M_ID" == "") {
			alert("아이디 입력~~~~");
			return;
		} else if("#M_PASS" == "") {
			alert("비밀번호 입력~~~~");
			return;
		} else {
			document.loginform.action = "${root}/user/login.focus";
			document.loginform.submit();
		}
	});
});
</script>

      <h3><i class="ti-pencil-alt2"></i>  접속</h3>      
      
      <div class="container-fluid">
            <div class="row justify-content-center">
            	<div class="col-lg-2"></div>
                <div class="col-lg-6">
                    <div class="login-content">                      
                        <div>                            
                            <form name="loginform" method="post" action="">
                                <div class="form-group">
                                    <label>아이디</label>
                                    <input type="text" id="M_ID" name="M_ID" class="form-control" value="${saveid}" placeholder="아이디">
                                </div>
                                <div class="form-group">
                                    <label>비밀번호</label>
                                    <input type="password" id="M_PASS" name="M_PASS" class="form-control" placeholder="비밀번호">
                                </div>
                                <div class="checkbox">
                                    <label>
										<input type="checkbox" value="saveid"${checkid}> 아이디 기억하기
									</label>
                                    <label class="pull-right">
										<a href="${root }/resetpwd.jsp">비밀번호를 잃어버렸나요?</a>
									</label>

                                </div>
                                <div align="right">
                                <button type="submit" id="loginbtn" class="btn btn-primary btn-flat m-b-30 m-t-30">입장</button>
                                </div>
                                    <div align="center">
                                        <button type="button" class="btn btn-primary bg-facebook btn-flat btn-addon m-b-10"><i class="ti-facebook"></i>페이스북으로 로그인</button>
                                    </div>
                                <div align="center" style="padding-top:5px;">
                                    <p>계정이 없나요? <a href="${root }/join.jsp"> 회원가입</a></p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

</body>
</html>
