
<div class="inner_search row_main clr_fix">
    <div class="inner_tab clr_fix">
        <ul class="tabs_2">
            <li class="inner_tab_active" rel="top_tab_1"><a>Buy</a> </li>
            <li rel="top_tab_2"><a>REnt</a> </li>
            <li rel="top_tab_3"><a> New Project</a> </li>
        </ul>
    </div>
    <div class="inner_loc clr_fix">
        <form method="post" id="form_top_tab_1" action="searchViewPage">
        <ul id="top_tab_1" class="tab_content_2">
            <li class="inner_city">
                <select  name="locality.parentId" id="parentId1" class="dropdown">
                    <option value="-1">--Select--</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.cities}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="inner_loc_search">
                <input type="text" placeholder="Enter Locally or Project">
            </li>
            <li class="inner_pro_type">
                <select multiple="multiple" placeholder="Select Property Type" class="SlectBox">
                    <option>Select Property Type</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.mainPropertyTypes}">
                        <%--  <optGroup label="${data.name}">--%>
                        <c:forEach var="innerData" items="${data.propertyTypesById}">
                            <option value="${innerData.id}">${innerData.name}</option>
                        </c:forEach>
                        <%--  </optGroup>--%>
                    </c:forEach>
                </select>

            </li>
            <li class="inner_bedroom">
                <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="inner_max_price">
                <select multiple="multiple" placeholder="Select Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" class="SlectBox">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="inner_top_btn">
                <input type="button" value="Search" class="btn_5" id="searchBtn1">
            </li>
        </ul>
        </form>
        <form method="post" id="form_top_tab_2" action="searchViewPage">
        <ul id="top_tab_2" class="tab_content_2">
            <li class="inner_city">
                <select  name="locality.parentId" id="parentId2" class="dropdown">
                    <option value="-1">--Select--</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.cities}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="inner_loc_search">
                <input type="text" placeholder="Enter Locally or Project">
            </li>
            <li class="inner_pro_type">
                <select multiple="multiple" placeholder="Select Property Type" class="SlectBox">
                    <option>Select Property Type</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.mainPropertyTypes}">
                        <%--  <optGroup label="${data.name}">--%>
                        <c:forEach var="innerData" items="${data.propertyTypesById}">
                            <option value="${innerData.id}">${innerData.name}</option>
                        </c:forEach>
                        <%--  </optGroup>--%>
                    </c:forEach>
                </select>

            </li>
            <li class="inner_bedroom">
                <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="inner_max_price">
                <select multiple="multiple" placeholder="Select Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" class="SlectBox">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="inner_top_btn">
                <input type="button" value="Search" class="btn_5"  id="searchBtn2">
            </li>
        </ul>
        </form>
        <form method="post" id="form_top_tab_3" action="searchViewPage">
        <ul id="top_tab_3" class="tab_content_2">
            <li class="inner_city">
                <select  name="locality.parentId" id="parentId3" class="dropdown">
                    <option value="-1">--Select--</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.cities}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="inner_loc_search">
                <input type="text" placeholder="Enter Locally or Project">
            </li>
            <li class="inner_pro_type">
                <select multiple="multiple" placeholder="Select Property Type" class="SlectBox">
                    <option>Select Property Type</option>
                    <c:forEach var="data" items="${response.module[0].moduleResponse.mainPropertyTypes}">
                        <%--  <optGroup label="${data.name}">--%>
                        <c:forEach var="innerData" items="${data.propertyTypesById}">
                            <option value="${innerData.id}">${innerData.name}</option>
                        </c:forEach>
                        <%--  </optGroup>--%>
                    </c:forEach>
                </select>

            </li>
            <li class="inner_bedroom">
                <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="inner_max_price">
                <select multiple="multiple" placeholder="Select Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" class="SlectBox">
                    <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                        <option value="${data.id}">${data.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li class="inner_top_btn">
                <input type="button" value="Search" class="btn_5" id="searchBtn3">
            </li>
        </ul>
        </form>
    </div>
</div>
</div>
<script src="js/site/userSmallSearchMenu.js"></script>