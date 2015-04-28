<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<form:form id="restaurantForm" commandName="restaurant" method="post"
       action="${actionUrl }" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="name">English Name</label>
              <form:input path="englishName" placeholder="English Name" />
          </div>
          
          <div class="pure-control-group">
              <label for="name">Chinese Name</label>
              <form:input path="chineseName" placeholder="Chinese Name" />
          </div>
          
          <div class="pure-control-group">
               <label for="code">Address1</label>
               <form:input path="address1" placeholder="Address1" maxlength="15" />
          </div>
          <div class="pure-control-group">
              <label for="price">Address2</label>
              <form:input path="address2" placeholder="Address2" maxlength="15" />
          </div>
          <div class="pure-control-group">
              <label for="authors">City</label>
              <form:input path="city" placeholder="City" />
          </div>
          <div class="pure-control-group">
              <label for="isbn">State</label>
              <form:input path="state" placeholder="State" />
          </div>
          <div class="pure-control-group">
              <label for="publisher">Post Code</label>
              <form:input path="postCode" placeholder="PostCode" />
          </div>
          <form:input path="restaurantId" type="hidden" />
      </fieldset>
</form:form>