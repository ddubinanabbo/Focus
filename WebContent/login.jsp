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
function statusChangeCallback(response) {
	 
    console.log('statusChangeCallback');
    console.log(response);

    
    if (response.status == 'connected') {
    	testAPI();
    } /* else {
    
    	  document.getElementById('status').innerHTML = '페이스북으로 로그인을 해보세요';
      } */
    }
    
function checkLoginState() {
	  FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	  });
	}

  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1984491501767294',
      cookie     : false,
      xfbml      : false,
      version    : 'v2.11'
    });
      
    FB.AppEvents.logPageView();
    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
      });
      
  };
  

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.11&appId=1984491501767294&autoLogAppEvents=1";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
  
  
  function testAPI() {
	    console.log('Welcome!  Fetching your information.... ');
	    var slname = "";
	    var slid = "";
	    FB.api('/me/', function(response) {
	      console.log('Successful login for: ' + response.name + '' + response.id);
			/* slname = $("#slname").val(response.name);
			slid = $("#slid").val(response.id);
			alert(slname);
			alert(slid); */
	      document.location.href="${root}/user/sociallogin.focus?slname=" + response.name + "&slid=" + response.id;
	     /*  
	       innerHTML = 'Thanks for logging in, ' + response.name + '!';  */
	    });
	  }
  
  
  FB.logout(function(response) {
	   // Person is now logged out
	});
  

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
                                <!-- <div align="right">
                               <fb:login-button onlogin="checkLoginState();" scope="public_profile, email" width="100" data-auto-logout-link="true">
								</fb:login-button> 
								</div> -->
								<div align="center">
 								<div class="fb-login-button" onlogin="checkLoginState();" data-max-rows="1" data-size="large" data-button-type="login_with" data-show-faces="false" data-auto-logout-link="true" data-use-continue-as="false"></div>
								</div>
								<div id="status">
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
