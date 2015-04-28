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