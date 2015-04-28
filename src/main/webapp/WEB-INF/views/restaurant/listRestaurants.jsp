<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Restaurants</title>

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.4.2/pure-min.css">

<link rel="stylesheet"
       href='<c:url value="/resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet" 
       href='<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>'>
<style type="text/css">
  th {
       text-align: left
  }

</style>
</head>

<body>
   <div style="width: 95%; margin: 0 auto;">
       
        <div id="restaurantDialog" style="display: none;">
            <%@ include file="restaurantForm.jsp"%>
        </div>

        <h1>List Of Restaurants</h1>

        <button class="pure-button pure-button-primary" onclick="addRestaurant()">
            <i class="fa fa-plus"></i> Add Restaurant
         </button>
         <br>
         <table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="4%">S.N</th>
                  <th width="12%">English Name</th>
                  <th width="12%">Chinese Name</th>
                  <th width="12%">Address1</th>
                  <th width="12%">Address2</th>
                  <th width="12%">City</th>
                  <th width="12%">State</th>
                  <th width="12%">Post Code</th>
                  <th width="12%"></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${restaurantList}" var="restaurant" varStatus="loopCounter">
               <tr>
                   <td><c:out value="${loopCounter.count}" /></td>
                   <td><c:out value="${restaurant.englishName}" /></td>
                   <td><c:out value="${restaurant.chineseName}" /></td>
                   <td><c:out value="${restaurant.address1}" /></td>
                   <td><c:out value="${restaurant.address2}" /></td>
                   <td><c:out value="${restaurant.city}" /></td>
                   <td><c:out value="${restaurant.state}" /></td>
                   <td><c:out value="${restaurant.postCode}" /></td>

                   <td>
                     <nobr>
                        <button onclick="editRestaurant(${restaurant.restaurantId});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${restaurant.restaurantId}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this restaurant?');">
                             <i class="fa fa-times"></i>Delete
                        </a>
                      </nobr>
                   </td>
                </tr>
                </c:forEach>
            </tbody>
         </table>
     </div>

     <!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->
     
    <script type="text/javascript"
       src='<c:url value="/resources/js/lib/jquery-1.10.2.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/resources/js/lib/jquery.ui.datepicker.js"/>'></script>
    <script type="text/javascript">
    function addRestaurant() {
        $('#restaurantDialog').dialog("option", "title", 'Add Restaurant');
        $('#restaurantDialog').dialog('open');
 }

 function editRestaurant(id) {

        $.get("get/" + id, function(result) {

               $("#restaurantDialog").html(result);
               $('#restaurantDialog').dialog("option", "title", 'Edit Restaurant');
               $("#restaurantDialog").dialog('open');

               initializeDatePicker();
        });
 }

 function initializeDatePicker() {
        $(".datepicker").datepicker({
               dateFormat : "yy-mm-dd",
               changeMonth : true,
               changeYear : true,
               showButtonPanel : true
        });
 }

 function resetDialog(form) {

        form.find("input").val("");
 }

 $(document).ready(function() {

        $('#restaurantDialog').dialog({

               autoOpen : false,
               position : 'center',
               modal : true,
               resizable : false,
               width : 440,
               buttons : {
                      "Save" : function() {
                            $('#restaurantForm').submit();
                      },
                      "Cancel" : function() {
                            $(this).dialog('close');
                      }
               },
               close : function() {

                      resetDialog($('#restaurantForm'));
                      $(this).dialog('close');
               }
        });

        initializeDatePicker();
 });
    </script>
</body>
</html> 
