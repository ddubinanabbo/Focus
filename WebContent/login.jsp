<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

      <h3><i class="ti-pencil-alt2"></i>  접속</h3>      
      
      <div class="container-fluid">
            <div class="row justify-content-center">
            	<div class="col-lg-2"></div>
                <div class="col-lg-6">
                    <div class="login-content">                      
                        <div class="login-form">
                            <h4>접속</h4>
                            <form>
                                <div class="form-group">
                                    <label>아이디</label>
                                    <input type="text" id="id" class="form-control" placeholder="아이디">
                                </div>
                                <div class="form-group">
                                    <label>비밀번호</label>
                                    <input type="password" class="form-control" placeholder="비밀번호">
                                </div>
                                <div class="checkbox">
                                    <label>
										<input type="checkbox"> 기억
									</label>
                                    <label class="pull-right">
										<a href="<%= root %>/resetpwd.jsp">비밀번호를 잃어버렸나요?</a>
									</label>

                                </div>
                                <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">입장</button>
                                <div class="social-login-content">
                                    <div class="social-button">
                                        <button type="button" class="btn btn-primary bg-facebook btn-flat btn-addon m-b-10"><i class="ti-facebook"></i>페이스북으로 로그인</button>
                                        <button type="button" class="btn btn-primary bg-twitter btn-flat btn-addon m-t-10"><i class="ti-twitter"></i>카카오톡으로 로그인</button>
                                    </div>
                                </div>
                                <div class="register-link m-t-15 text-center">
                                    <p>계정이 없나요? <a href="<%= root %>/join.jsp"> 회원가입</a></p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

</body>
</html>