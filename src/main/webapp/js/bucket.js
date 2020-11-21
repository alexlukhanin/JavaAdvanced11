
$(document).ready(function(){
    $("#datatable").DataTable();

})

let buckets = null;
$.get("bucket", function(data) {
    if (data !== '') {
        buckets = data;
    }
}).done(function() {

    let tableHeadContent = "<tr class='thead-dark'>"+
        "<th style='width: 20%;'>Name</th>"+
        "<th style='width: 45%;'>Description</th>"+
        "<th style='width: 10%;'>Price</th>"+
        "<th style='width: 15%;'>PurchaseDate</th>"+
        "<th style='width: 10%;'>Options</th>"+
        "</tr>";
    $('#datatable thead').html(tableHeadContent);


    let tableBodyContent = "";
    jQuery.each(buckets, function(i, value) {

         tableBodyContent +="<tr>"+
            "<td>" + value.name + "</td>"+
            "<td>" + value.description + "</td>"+
            "<td>" + value.price + "</td>"+
            "<td>" + value.purchaseDate + "</td>"+
            "<td><button class='btn btn-primary' onclick='deleteOrderFromBucket(" + value.bucketId + ")'>delete</button></td>"+
            "</tr>"
    });

    $('#datatable tbody').html(tableBodyContent);

});

function deleteOrderFromBucket(bucketId) {
    let customUrl = '';
    let urlContent = window.location.href.split('/');
    for (let i = 0; i < urlContent.length-1; i++) {
        customUrl+=urlContent[i]+'/'
    }
    customUrl+='buy?bucketId='+bucketId;

    $.ajax({
        url: customUrl,
        type: 'DELETE',
        success: function(data) {
            if (data == 'Success') {
                location.reload();
            }
        }
    });
}


/*

$('#something').click(function() {
    location.reload();
});
*/



