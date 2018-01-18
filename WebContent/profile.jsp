<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

<style>
div {
	padding:5px;
}
</style>
      <h3><i class="ti-pencil-alt2"></i>  프로필</h3>      
      
      <div class="container-fluid">         
          <!-- /# row -->
              <div class="col-lg-12">
                <div class="card">
                  <div class="card-body">
                    <div class="user-profile">
                      <div class="row">
                        <div class="col-lg-4">
                          <div class="user-photo m-b-30">
                            <img class="img-fluid" src="<%= root %>/images/user-profile.jpg" alt="" height="300" width="300">
                          </div>
                        </div>
                        <div class="col-lg-8">                          
                          <div class="custom-tab user-profile-tab">
                          <div>이름</div>
                          <div>정승호</div>
                          <ul class="nav nav-tabs" role="tablist"></ul>                          
                          <div>직업</div>
                          <div>컴퓨터</div>                      
                          <ul class="nav nav-tabs" role="tablist"></ul>
                                  <h4>기본 정보</h4>
                                  <div>나이 27</div>
                                  <div>전화번호 +8801629599859</div>
                                  <div>이메일 hello@Admin Board.com</div>
                          <ul class="nav nav-tabs" role="tablist"></ul>
                                  <h4>자기 소개</h4>
                                  <div>
                                    <p>안녕하세요 잘 부탁드립니다.</p>                                    
                                  </div>
                                 </div>
                            <ul class="nav nav-tabs" role="tablist"></ul>
                            <h4>직장 이력</h4>
                            <div>
                              <p><b>It Solution </b></p>
                              <p>123, South Mugda</p>
                              <p>New York, 1214</p>
                            </div>
                            <ul class="nav nav-tabs" role="tablist"></ul>
                            <h4>스킬</h4>
                           <div>
                            <ul>
                              <li><a href="#">Branding</a></li>
                              <li><a href="#">UI/UX</a></li>
                              <li><a href="#">Web Design</a></li>
                              <li><a href="#">Wordpress</a></li>
                              <li><a href="#">Magento</a></li>
                            </ul>
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
