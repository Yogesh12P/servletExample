
<jsp:useBean id = "bean" class="com.loginForm.model.userModel" scope="request">
<jsp:setProperty name="bean" property="*" />  
</jsp:useBean>
<jsp:forward page="registration"/>