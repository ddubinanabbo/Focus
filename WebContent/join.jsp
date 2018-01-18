<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

      <h3><i class="ti-pencil-alt2"></i>  글쓰기</h3>      
      
          <div class="container-fluid">
            <div class="row justify-content-center">            	
            	<div class="col-lg-2"></div>
                <div class="col-lg-6">
                    <div class="login-content">
                        <div class="login-form">
                            <h4>회원가입</h4>
                            <form>
                            	<div class="row">
                            	<div class="form-group">
                                    <label>아이디</label>
                                    <input type="text" class="form-control" placeholder="아이디">
                                </div>
                                <div class="form-group pl-3">
                                    <label>패스워드</label>
                                    <input type="password" class="form-control" placeholder="비밀번호">
                                </div>
                                </div>
                                <div class="row">
                                <div class="form-group">
                                    <label>이름</label>
                                    
                                    <input type="text" size="10" class="form-control" placeholder="이름">
                                </div>
                                <div class="form-group pl-3">
                                    <label>직업</label>
                                    <input type="text" size="10" class="form-control" placeholder="직업">
                                </div>                                
                                <div class="form-group pl-3">
                                    <label>나이</label>
                                    <input type="number" class="form-control" placeholder="나이">
                                </div>
                                </div>
                                <div class="row">
                                <div class="form-group">
                                    <label>이메일</label>
                                    <input type="email" class="form-control" placeholder="이메일">
                                </div>
                                <div class="form-group pl-3">
                                    <label>전화번호</label>
                                    <input type="text" class="form-control" placeholder="전화번호">
                                </div>
                                </div>                                
                                <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">Register</button>
                                <div class="social-login-content">
                                    <div class="social-button">
                                        <button type="button" class="btn btn-primary bg-facebook btn-flat btn-addon m-b-10"><i class="ti-facebook"></i>Register with facebook</button>
                                        <button type="button" class="btn btn-primary bg-twitter btn-flat btn-addon m-t-10"><i class="ti-twitter"></i>Register with twitter</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>       

</body>
</html>
