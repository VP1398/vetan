
//Function to initialize some of the basic functionalities on load of the page
function initListeners(){
      //Set font color for amount fields based on value
    styleAmountFields();
    
    //Onclick of 'Browse' button
    document.getElementById("inputGroupFile02").onchange = function(){

    // Allowing file types
    var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;

    if (!allowedExtensions.exec(this.value)) {
        alert('Invalid file type');
        this.value = '';
        return false;
    }else{
        var x = document.getElementsByClassName("imgContainer");
        for (var i=0; i < x.length; i++) {
            if(x[i].id == (document.getElementById("modal-id").value+"_"+this.files.item(0).name)){
                alert("File with the same name already exists.")
                return false;
            }
        }
    }
    document.getElementById("inputGroupFile02_val").innerHTML = this.files.item(0).name;
}

    //Onclick of 'Upload' button
    document.getElementById("inputGroupFile03").onclick = function(){
        if(document.getElementById("inputGroupFile02").value == null || document.getElementById("inputGroupFile02").value == ""){
            alert('Please select a file to upload');
            return;
        }
        var file    = document.getElementById("inputGroupFile02").files[0];
        var reader  = new FileReader();
        var modalId = document.getElementById("modal-id").value;

        //Create image thumbnail while upload
        var thumbnailId = "preview_"+file.name;
        document.getElementById("attachmentThumbnails").innerHTML += ""+
        "<div class=\"imgContainer\" id=\'"+modalId+"_"+file.name+"\'>"+
        "<img class=\"thumbnail\"id=\'"+thumbnailId+"\' src=\"\" alt=\"\" style=\"display:none\"></img>"+
        "<div class=\"overlay\" onclick=\"removeAttachment(\'"+modalId+"_"+file.name+"\')\"><a href=\"#\" class=\"removeIcon\"><i class=\"bi bi-x-circle\"></i></a></div>"+
        "</div>";
        var preview = document.getElementById(thumbnailId);
        reader.onloadend = function () {
            preview.src = reader.result;
            preview.style.display = "block";
        }
        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "";
        }

        //Ajax call to upload files to the server and save it in the database
        var myFormData = new FormData();
        myFormData.append('pictureFile', file);
        myFormData.append('id', modalId);
        $.ajax({
          url: '/CardView/emplvprivilege/uploadFile',
          type: 'POST',
          processData: false,
          contentType: false,
          dataType : 'json',
          data: myFormData,
          success: function(data) {
            // Do something after Ajax completes
          }
        });
        document.getElementById("inputGroupFile02").value = "";
        document.getElementById("inputGroupFile02_val").innerHTML = "";
    }

    //Called on click of the card to edit
    $('#exampleModal').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget) // Button that triggered the modal
      // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
      // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
      var modal = $(this)
      modal.find('#modal-id').val(button.data('id'))
          modal.find('#exampleModalLabel').text(button.data('leavetype')+' - '+button.data('openingbalance'))
        modal.find('#modal-leaveType').val(button.data('leavetype'))
        modal.find('#modal-openingBalance').val(button.data('openingbalance'))
        modal.find('#modal-credit').val(button.data('credit'))
        modal.find('#modal-total').val(button.data('total'))
        modal.find('#modal-availed').val(button.data('availed'))
        modal.find('#modal-balance').val(button.data('balance'))
        modal.find('#modal-applicationDate').val(button.data('applicationdate'))
        modal.find('#modal-startDate').val(button.data('startdate'))
        modal.find('#modal-endDate').val(button.data('enddate'))
        modal.find('#modal-days').val(button.data('days'))
        modal.find('#modal-noOfDays').val(button.data('noofdays'))
        modal.find('#modal-noteForApprover').val(button.data('noteforapprover'))
        modal.find('#modal-status').val(button.data('status'))

 //Change font color for amount fields based on value
      styleAmountFields();
      $('.amt').on('change', function (event) {
          styleAmountFields();
      })
      
      //Based on the attachements, thumbnails are created and displayed during edit
      document.getElementById("attachmentThumbnails").innerHTML = "";
      if(button.data('attachments') != null && button.data('attachments').length > 0){
        var attachments = button.data('attachments').split("|");
        for(var i=0; i<attachments.length; i++){
            if(attachments[i].trim().length > 0){
                var modalId = button.data('id');
                var thumbnailId = "preview_"+attachments[i];
                document.getElementById("attachmentThumbnails").innerHTML += ""+
                "<div class=\"imgContainer\" id=\'"+attachments[i]+"\'>"+
                "<img class=\"thumbnail\"id=\'"+thumbnailId+"\' src=\"images/"+attachments[i]+"\" alt=\"\" style=\"display:block;\"></img>"+
                "<div class=\"overlay\" onclick=\"removeAttachment(\'"+attachments[i]+"\')\"><a href=\"#\" class=\"removeIcon\"><i class=\"bi bi-x-circle\"></i></a></div>"+
                "</div>";
            }
        }
      }
    })

    //Assign function to update button
    $('#updateButton').on('click', function (event) {
    console.log('UdpateAndSubmit');
        updateAndSubmit();
    })
}

//Function to change the font colour of amount fields based on its value
function styleAmountFields(){
    var min = 1000;
    var max = 2000;

    var amtElems = document.getElementsByClassName("amt");

    var allAmountsCount = amtElems.length;

    //console.log('inside styleAmountFields');
    //console.log('allAmountCount: '+ allAmountsCount);
    //console.log('All Amount Elements: '+JSON.stringify(amtElems.parentNode));

    // if condition with claimed amount < sanctioned amount colour is red
    // if claimed amount > invoice amount than colour is orange.
    //if claimed amount is greater than sanctioned amount it is redcolour

    //Invoice Amount    - a[0]
    //Sanctioned Amount - a[1]
    //Claimed Amount    - a[2]

    for(var i=0;i<amtElems.length; i=i+3){

        var invoiceAmount = 0;
        var sanctionedAmount = 0;
        var claimedAmount = 0;
        
        if(i<3){
            //Model Elements
            invoiceAmount = amtElems[i].value;
            sanctionedAmount = amtElems[i+1].value;
            claimedAmount = amtElems[i+2].value;
        }else{
            //Div Elements
            invoiceAmount = amtElems[i].innerText;
            sanctionedAmount = amtElems[i+1].innerText;
            claimedAmount = amtElems[i+2].innerText;
        }

        //console.log('invoiceAmount \t'+ invoiceAmount);
        //console.log('sanctionedAmount \t'+ sanctionedAmount);
        //console.log('claimedAmount \t'+ claimedAmount);

        if( claimedAmount < sanctionedAmount){
            console.log('color red')
            amtElems[i].style.color = 'green'; //Invoice Amount
            amtElems[i+1].style.color = 'orange';//Sanctioned Amount
            amtElems[i+2].style.color = 'red';//Claimed Amount

            //console.log('color orange - second condition - first condition');
        }

       if( claimedAmount > invoiceAmount){
            amtElems[i].style.color = 'orange'; //Invoice Amount
            amtElems[i+1].style.color = 'red';//Sanctioned Amount
            amtElems[i+2].style.color = 'orange';//Claimed Amount

            //console.log('color orange - second condition');
       }

       if( claimedAmount > sanctionedAmount){
        amtElems[i].style.color = 'green'; //Invoice Amount
        amtElems[i+1].style.color = 'orange';//Sanctioned Amount
        amtElems[i+2].style.color = 'red';//Claimed Amount

        //console.log('color red - third condition');
       }


    }


   /** 
    for(var i=0; i<amtElems.length; i++){

        //console.log('Index'+i+'TagName: '+amtElems[i].tagName.toLowerCase());
        //console.log('Index'+i+'innerText : '+  amtElems[i].innerText );
        //console.log('Index'+i+ '->  amtElems[i].value  : '+  amtElems[i].value );
        //console.log('Index'+i+' ->  amtElems[i].id  : '+  amtElems[i].id );
        


     
        if(amtElems[i].tagName.toLowerCase() == "input"){
            if(amtElems[i].value <= min){
                amtElems[i].style.color = "orange";
            }else if(amtElems[i].value > min && amtElems[i].value <= max){
                amtElems[i].style.color = "green";
            }else {
                amtElems[i].style.color = "red";
            }
        }else if(amtElems[i].tagName.toLowerCase() == "p"){
            if(amtElems[i].innerText <= min){
                amtElems[i].style.color = "orange";
            }else if(amtElems[i].innerText > min && amtElems[i].innerText <= max){
                amtElems[i].style.color = "green";
            }else {
                amtElems[i].style.color = "red";
            }
        }
    }
    **/
}
//Function to submit the form with all the values
function updateAndSubmit(){
    var x = document.getElementsByClassName("imgContainer");
    var splitKey = "|";
    var y = "";
    for (var i=0; i < x.length; i++) {
        y += x[i].id+splitKey;
    }
    console.log(y);
    document.getElementById("attachments").value = y;
    document.getElementById("emplvprivilegeForm").submit();
}

//Function to remove attachments on hover and click on the thumbnail during edit
function removeAttachment(id){
    var myFormData = new FormData();
    myFormData.append('filename', id);
    $.ajax({
      url: '/CardView/emplvprivilege/deleteFile',
      type: 'POST',
      processData: false,
      contentType: false,
      dataType : 'json',
      data: myFormData,
      success: function(data) {
        // Do something after Ajax completes
      }
    });
    var element = document.getElementById(id);
    element.parentNode.removeChild(element);
}