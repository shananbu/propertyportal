
<div class="inner_search row_main clr_fix">
    <nav class="tab_menu clr_fix">
        <ul>
            <li class="tab_active tab_1"> Buy</li>
            <li class="tab_2"> Rent</li>
            <li class="tab_3"> New Project</li>
        </ul>
    </nav>
    <div class="tab_info clr_fix box_shadow">
        <div class="tab_info_1 tab_view clr_fix" style="display:block;">
            <form method="post" id="tab_info_1" action="searchViewPage">
                <div class="clr_fix">
                    <div class="search_loc">
                        <div class="pro_type">
                            Property Type <i class="fa fa-caret-down"></i>
                        </div>

                        <div class="pro_list">
                            <c:forEach var="data" items="${response.module[0].moduleResponse.mainPropertyTypes}">
                                <h1> ${data.name}</h1>
                                <ul>
                                    <c:forEach var="innerData" items="${data.propertyTypesById}">
                                        <li>
                            <span class="jq_chk">
                                <input type="checkbox" id="0${innerData.id}" value="${innerData.id}" name="search.propertyTypeId">
                                 <label for="0${innerData.id}"></label>
                            </span>  ${innerData.name}
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="text_panel">
                        <input type="text" placeholder="Type Location or Project"  name="search.searchString">
                        <input type="submit" value="Search" id="searchBtn1" class="searchBtn">
                    </div>
                </div>

                <div class="clr_fix loc_list">
                    <ul>
                        <li class="list_3">
                            <label> Price</label>
                            <select  placeholder="Select Price" class="SlectBox" name="search.expectedPrice">
                                <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="list_3">
                            <label> Bed Rooms</label>
                            <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox" name="search.bedRoomId">
                                <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="list_3">
                            <label> Posted By </label>
                            <select class="dropdown" placeholder="select" name="search.userTypeId">
                                <c:forEach var="data" items="${response.module[0].moduleResponse.userType}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="list_4"><span> Clear All </span></li>
                    </ul>
                </div>
            </form>
        </div>
        <div class="tab_info_2 tab_view clr_fix">
            <form method="post" id="tab_info_2" action="searchViewPage">
                <div class="clr_fix">
                    <div class="search_loc">
                        <div class="pro_type">
                            Property Type <i class="fa fa-caret-down"></i>
                        </div>

                        <div class="pro_list">
                            <c:forEach var="data" items="${response.module[0].moduleResponse.mainPropertyTypes}">
                                <h1> ${data.name}</h1>
                                <ul>
                                    <c:forEach var="innerData" items="${data.propertyTypesById}">
                                        <li>
                            <span class="jq_chk">
                                 <input type="checkbox" id="00${innerData.id}" value="${innerData.id}" name="search.propertyTypeId">
                                 <label for="00${innerData.id}"></label>
                            </span>  ${innerData.name}
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:forEach>

                        </div>

                    </div>
                    <div class="text_panel">
                        <input type="text" placeholder="Type Location or Project"  name="search.searchString">
                        <input type="submit" value="Search" id="searchBtn2" class="searchBtn">
                    </div>
                </div>
                <div class="clr_fix loc_list">
                    <ul>
                        <li class="list_3">
                            <label> Price</label>
                            <select placeholder="Select Price" class="SlectBox" name="search.expectedPrice">
                                <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="list_3">
                            <label> Bed Rooms</label>
                            <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox" name="search.bedRoomId">
                                <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>

                        </li>
                        <li class="list_3">
                            <label> Posted By </label>
                            <select class="dropdown" placeholder="select" name="search.userTypeId">
                                <c:forEach var="data" items="${response.module[0].moduleResponse.userType}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="list_4"><span> Clear All </span></li>
                    </ul>
                </div>
            </form>
        </div>
        <div class="tab_info_3 tab_view clr_fix">
            <form method="post" id="tab_info_3" action="searchViewPage">
                <div class="clr_fix">
                    <div class="search_loc">
                        <div class="pro_type">
                            Property Type <i class="fa fa-caret-down"></i>
                        </div>

                        <div class="pro_list">
                            <c:forEach var="data" items="${response.module[0].moduleResponse.mainPropertyTypes}">
                                <h1> ${data.name}</h1>
                                <ul>
                                    <c:forEach var="innerData" items="${data.propertyTypesById}">
                                        <li>
                            <span class="jq_chk">
                                 <input type="checkbox" id="000${innerData.id}" value="${innerData.id}" name="search.propertyTypeId">
                                 <label for="000${innerData.id}"></label>
                            </span>  ${innerData.name}
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:forEach>

                        </div>

                    </div>
                    <div class="text_panel">
                        <input type="text" placeholder="Type Location or Project"  name="search.searchString">
                        <input type="submit" value="Search" id="searchBtn3" class="searchBtn">
                    </div>
                </div>
                <div class="clr_fix loc_list">
                    <ul>
                        <li class="list_3">
                            <label> Price</label>
                            <select placeholder="Select Price" class="SlectBox" name="search.expectedPrice">
                                <c:forEach var="data" items="${response.module[0].moduleResponse.budgets}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="list_3">
                            <label> Bed Rooms</label>
                            <select multiple="multiple" placeholder="Select Bed Rooms" class="SlectBox" name="search.bedRoomId">
                                <c:forEach var="data" items="${response.module[0].moduleResponse.bedrooms}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>

                        </li>
                        <li class="list_3">
                            <label> Posted By </label>
                            <select class="dropdown" placeholder="select" name="search.userTypeId">
                                <c:forEach var="data" items="${response.module[0].moduleResponse.userType}">
                                    <option value="${data.id}">${data.name}</option>
                                </c:forEach>
                            </select>
                        </li>
                        <li class="list_4"><span> Clear All </span></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="js/site/userSmallSearchMenu.js"></script>