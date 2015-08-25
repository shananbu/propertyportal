<script src="js/site/userHeader.js"></script>
<div class="row_main">
    <div class="col_1 clr_fix"><a href="/" class="logo"> <img src="images/logo.png"> </a></div>
    <div class="col_2 clr_fix">
        <div class="clr_fix">
            <ul class="nav_2 clr_fix">
                <li><a href="userLogin"> <i class="fa fa-user"></i> Login</a></li>
                <li><a href="userRegistration"> <i class="fa fa-pencil-square-o"></i> Register</a></li>
 <%--               <li class="top_loc_list"><a href="#"> <i class="fa fa-map-marker"></i> Location </a>
                    <div class="loc_list_view clr_fix">
                        <h1>Popular Cities</h1>
                        <ul>
                            <c:forEach var="data" items="${response.module[0].moduleResponse.cities}">
                                <c:if test="${data.isPopular == '1'}">
                                     <li><a href="${data.id}">${data.name}</a></li>
                                </c:if>
                            </c:forEach>
                        </ul>
                        <h1>Other Cities</h1>
                        <ul>
                            <c:forEach var="data" items="${response.module[0].moduleResponse.cities}">
                                <c:if test="${data.isPopular ne '1'}">
                                     <li><a href="${data.id}">${data.name}</a></li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </li>--%>
            </ul>
        </div>
        <nav class="clr_fix nav_1">
            <ul>
                <li><a href="postProperty"> Post Property </a><span class="new_pop">Free</span></li>
                <li class="menu_active"><a href="propertyAlertRegisteration">Property Alerts </a></li>
                <li><a href="advertiseWithUs?name=planOwner"> Advertise with us </a></li>
            </ul>
        </nav>
    </div>
</div>