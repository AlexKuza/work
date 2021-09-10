<%@include file="../init.jsp"%>
<%@ page contentType="text/html;charset=utf-8" %>


<portlet:actionURL var="uploadFile" name="uploadFileAction">

</portlet:actionURL>
<aui:form action="<%=uploadFile %>" method="post" enctype="multipart/form-data">
 <aui:input type="file" accept=".zip" name="sampleFile" label="Загрузить реестры (старые удалятся)" />
 <button type="submit" class="defaultButton">Upload</button>
</aui:form>

</br>

<h2><liferay-ui:message key="Топ по сумме проданных товаров"/></h2>

<liferay-ui:search-container total="<%=EmpltopSumLocalServiceUtil.getEmpltopSumsCount()%>" orderByCol="<%="sum"%>" orderByType="<%="desc"%>">
<liferay-ui:search-container-results
    results="<%=EmpltopSumLocalServiceUtil.getEmpltopSums(searchContainer.getStart(),
                    searchContainer.getEnd())%>" />

<liferay-ui:search-container-row
    className="sbild.model.EmpltopSum" modelVar="topsum">

    <liferay-ui:search-container-column-text property="position" />
    <liferay-ui:search-container-column-text property="lastname" />

    <liferay-ui:search-container-column-text
            name="sum"
            property="sum"
            orderableProperty="sum"
            orderable="<%= true %>"
        />
    
</liferay-ui:search-container-row>

<liferay-ui:search-iterator />

</liferay-ui:search-container>

</br>

<h2><liferay-ui:message key="Топ по количеству проданных товаров"/></h2>

<liferay-ui:search-container total="<%=EmpltopCntLocalServiceUtil.getEmpltopCntsCount()%>" orderByCol="<%="count"%>" orderByType="<%="desc"%>">
<liferay-ui:search-container-results
    results="<%=EmpltopCntLocalServiceUtil.getEmpltopCnts(searchContainer.getStart(),
                    searchContainer.getEnd())%>" />

<liferay-ui:search-container-row
    className="sbild.model.EmpltopCnt" modelVar="topcnt">

    <liferay-ui:search-container-column-text property="position" />
    <liferay-ui:search-container-column-text property="lastname" />
    <liferay-ui:search-container-column-text property="count" orderable="<%= true %>"/>

    
</liferay-ui:search-container-row>

<liferay-ui:search-iterator />

</liferay-ui:search-container>

