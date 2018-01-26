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

    
    if (response.status === 'connected') {
    	testAPI();
    } else {
    
    	  document.getElementById('status').innerHTML = 'Please log ' +
          'into this app.';
      }
    }
    
function checkLoginState() {
	  FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	  });
	}

  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1977452862474788',
      cookie     : true,
      xfbml      : true,
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
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
  
  function testAPI() {
	    console.log('Welcome!  Fetching your information.... ');
	    FB.api('/me', function(response) {
	      console.log('Successful login for: ' + response.name);
	      document.getElementById('status').innerHTML =
	        'Thanks for logging in, ' + response.name + '!';
	    });
	  }
 
  

/*   {
      status: 'connected',
      authResponse: {
          accessToken: '...',
          expiresIn:'...',
          signedRequest:'...',
          userID:'...'
      }
  }
  
   */

/* window.fbAsyncInit = function() {
    FB.init({
      appId            : 'your-app-id',
      autoLogAppEvents : true,
      xfbml            : true,
      version          : 'v2.11'
    });
  }; */
  
 /* FB.getLoginStatus(function(response) {
	  if (response.status === 'connected') {
	    console.log('Logged in.');
	  }
	  else {
	    FB.login();
	  }
	}); */

  /* (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(docum ent, 'script', 'facebook-jssdk'));*/

 
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
                               <fb:login-button onlogin="checkLoginState();" scope="public_profile, email" >
								</fb:login-button>
								<div class="fb-login-button" onclick="checkLoginState();" data-max-rows="1" data-size="large" data-button-type="login_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="false"></div>
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
