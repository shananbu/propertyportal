<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="js/site/userHeader.js"></script>
<div class="row_main">
    <div class="col_1 clr_fix"><a href="index" class="logo"> <img src="images/logo.png"> </a></div>
    <div class="col_2 clr_fix">
        <div class="clr_fix">
            <ul class="nav_2 clr_fix">
                <sec:authorize access="hasAnyRole('ROLE_ANONYMOUS')">
                    <li><a href="userLogin"> <i class="fa fa-user"></i> Login</a></li>
                    <li><a href="userRegistration"> <i class="fa fa-pencil-square-o"></i> Register</a></li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_USER')">
                    <li class="top_loc_list"><a href="#"> <i class="fa fa-user"></i> Hi <sec:authentication property="principal.firstName"/> ! </a>
                        <div class="loc_list_view clr_fix">
                            <h1> <sec:authentication property="principal.firstName"/>
                            </h1>
                            </h2>${pageContext.request.userPrincipal.name}</h2>
                            <ul>
                                <li><a href="#">Manage Profile</a></li>
                                <li><a href="#">Manage Advertisements</a></li>
                                <li><a href="<c:url value='j_spring_security_logout'/>" >Sign out</a></li>
                            </ul>
                        </div>
                    </li>
                </sec:authorize>
            </ul>
        </div>
        <nav class="clr_fix nav_1">
            <ul>
                <li><a href="postProperty"> Post Property </a><span class="new_pop">Free</span></li>
                <li class="menu_active"><a href="propertyAlertRegisteration">Property Alerts </a></li>
                <li><a href="advertiseWithUs?name=Owner"> Advertise with us </a></li>
            </ul>
        </nav>
    </div>
</div>