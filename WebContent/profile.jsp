<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#uploadprofile").click(function(){
		document.profileForm.action = "${root}/user/upprofile.focus";
		document.profileForm.submit();
	});
});

$(document).ready(function(){
	$("#modifybtn").click(function(){
		if($("#M_PASS").val() != $("#passok").val()) {
			alert("비밀번호를 확인하세요!!!!");
			return;
		}else if($("#M_PASS").val() == "" || $("#passok").val() == "") {
			alert("비밀번호가 비어있을순 없습니다.");
			return;
		}
		document.profileForm.action = "${root}/user/upprofile.focus";
		document.profileForm.submit();
	});
});
</script>
<style>
#profile div {
	padding:5px;
}

</style>
      <h3><i class="ti-info-alt"></i>  프로필</h3>      
      
      <div id="profile" class="container-fluid">         
          <!-- /# row -->
              <div class="col-lg-12">
                <div class="card">
                  <div class="card-body">
                    <div class="user-profile">
                      <div class="row">
                        <div class="col-lg-4">
                        <form id="profileForm" name="profileForm" method="post" action="" enctype="multipart/form-data" style="margin: 0px">
                          <div class="user-photo m-b-30">
                          	<div class="thumbnail">
                          	<c:if test="${profileInfo != null}">
						       <img src="${root}/profile/${profileInfo.SAVEFOLDER}/${profileInfo.SAVE_PHOTO}" height="500" width="500">
						        </c:if>
						        <c:if test="${profileInfo == null}">
						         <img class="img-fluid"  src="${root}/images/user-profile.jpg" alt="" height="500" width="500">
						         </c:if>
						        <br>
						        <input type="file" id="upfile" name="upfile">
						          <div class="caption">
						        </div>
						      </div>
						      <button type="submit" id="uploadprofile" class="btn btn-primary btn-flat m-b-30 m-t-30">프로필 저장</button>
                          </div>
                          </form>
                          <h4>기본 정보</h4>
                          <div>이름</div>
                          <div>${userInfo.m_NAME}</div>
                          <ul class="nav nav-tabs" role="tablist"></ul>
                          <div>직업</div>
                          <div>${userInfo.m_JOB}</div>
                                  <ul>
                                  	<li>나이  ${userInfo.m_AGE }</li>
                                  	<li>전화번호  ${userInfo.m_TEL}</li>
                                  	<li>이메일  ${userInfo.m_EMAIL}</li>
                                  </ul> 
                        </div>
                        <div class="col-lg-8">
                        <form id="modifyForm" name="modifyForm" method="post" action="">
                          <div class="custom-tab user-profile-tab">
                          <div>비밀번호</div> 
                          <div><input type="password" id="M_PASS" name="M_PASS" class="form-control" value="${userInfo.m_PASS}"></div>  
                          <div>비밀번호 확인</div> 
                          <div><input type="password" id="passok" name="passok" class="form-control" value="${userInfo.m_PASS}"></div>                     
                                               
                          
                          <ul class="nav nav-tabs" role="tablist"></ul>
                                  <h4>자기 소개</h4>
                                  <div>
                                    <input type="text" id="M_INTRODUCE" name="M_INTRODUCE" class="form-control" value="${userInfo.m_INTRODUCE}">                                    
                                  </div>
                                 </div>
                            <ul class="nav nav-tabs" role="tablist"></ul>
                            <h4>직장 이력</h4>
                            <div>
                              <input type="text" id="M_CAREER" name="M_CAREER" class="form-control" value="${userInfo.m_CAREER}"> 
                            </div>
                            <ul class="nav nav-tabs" role="tablist"></ul>
                            <h4>스킬</h4>
                           <div>
                            <ul>
                              <li><input type="text" id="M_CAREER" name="M_CAREER" class="form-control" value="${userInfo.m_SKILL}"></li>
                            </ul>
                          </div>
                          </form>
                          <div align="right" style="padding-bottom:5px;">                               
                                <button type="submit" id="modifybtn" class="btn btn-primary btn-flat m-b-30 m-t-30">수정</button>
                                <button type="submit" id="registerbtn" class="btn btn-danger">취소</button>
                                </div>                         
                          </div>
                           
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>       

</body>
</html>
