<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="top_header clr_fix">
    <div class="logo_block clr_fix"><a href="#"> <img src="images/logo.png"> </a></div>
    <div class="header_right">
        <ul>
            <li><a href="admindashboard">Home <i class="fa fa-home"></i> </a></li>
            <li><a href="<c:url value='j_spring_security_logout'/>">Log Out <i class="fa fa-sign-in"></i> </a></li>
        </ul>
    </div>
</header>
