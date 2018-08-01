


$(document).ready(function(){
	
/*	  //Stops the submit request
    $("#myajaxform").submit(function(e){
           e.preventDefault();
    });
*/
    $("#country").change(function(){
        var id = $(this).val();
       // alert(id);

        $.ajax({
            url: 'states.do',
            type: 'GET',
            data: {"id":id},
            dataType: 'json',
            success:function(response){
console.log(response);
                var len = response.length;
               // alert(response);
               // alert(len)
               

                $("#sel_user").empty();
                for( var i = 0; i<len; i++){
                	// alert(response[i]+".................");
                    var id = response[i];
                   
                   // alert(id)
                    
                    $("#sel_user").append("<option value='"+id+"'>"+id+"</option>");

                }
            }
        });
    });

});
/*$(document).ready(function() {

    //Stops the submit request
    $("#myajaxform").submit(function(e){
           e.preventDefault();
    });
   
    //checks for the button click event
    $("#country").change(function(e){
          
            //get the form data and then serialize that
            dataString = $("#myajaxform").serialize();
           
            

            $("#country").change(function() {
                alert(this.value);
            });
            //get the form data using another method 
            var countryCode = $("option#country").val(); 
            dataString = "id=" + countryCode;
            alert(countryCode+"......................")
           
            //make the AJAX request, dataType is set to json
            //meaning we are expecting JSON data in response from the server
            $.ajax({
                type: "POST",
                url: "states.do",
                data: dataString,
                dataType: "json",
               
                //if received a response from the server
                success: function( data, textStatus, jqXHR) {
                	//alert(data);
                    //our country code was correct so we have some information to display
                     if(data.success){
                         $("#ajaxResponse").html("");
                         $("#ajaxResponse").append("<b>Country Code:</b> " + data.countryInfo.code + "<br/>");
                         $("#ajaxResponse").append("<b>Country Name:</b> " + data.countryInfo.name + "<br/>");
                         $("#ajaxResponse").append("<b>Continent:</b> " + data.countryInfo.continent + "<br/>");
                         $("#ajaxResponse").append("<b>Region:</b> " + data.countryInfo.region + "<br/>");
                         $("#ajaxResponse").append("<b>Life Expectancy:</b> " + data.countryInfo.lifeExpectancy + "<br/>");
                         $("#ajaxResponse").append("<b>GNP:</b> " + data.countryInfo.gnp + "<br/>");
                     
                    	 
                    	  	alert(data+"...cccccc.....");
                    	  	} 
                     //display error message
                     else {
                         $("#ajaxResponse").html("<div><b>Country code in Invalid!</b></div>");
                     }
                },
               
                //If there was no resonse from the server
                error: function(jqXHR, textStatus, errorThrown){
                     console.log("Something really bad happened " + textStatus);
                      $("#ajaxResponse").html(jqXHR.responseText);
                },
               
                //capture the request before it was sent to server
                beforeSend: function(jqXHR, settings){
                    //adding some Dummy data to the request
                    settings.data += "&dummyData=whatever";
                    //disable the button until we get the response
                    $('#myButton').attr("disabled", true);
                },
               
                //this is called after the response or error functions are finsihed
                //so that we can take some action
                complete: function(jqXHR, textStatus){
                    //enable the button 
                    $('#myButton').attr("disabled", false);
                }
     
            });        
    });

});

*/