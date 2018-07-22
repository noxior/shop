var ajaxUrlCart = "ajax/profile/carts/";

function updateCartTable() {
    $.get(ajaxUrlCart, updateTableByData);
}

$(function () {
    datatableApi = $("#datatableCart").DataTable({
        "ajax": {
            "url": ajaxUrlCart,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "fuelStationName"
            },
            {
                "data": "amount"
            },
            {
                "data": "price"
            },
            {
                "data": "fuelName"
            },
            {
                "data": "quantity"
            },
            {
                "render": renderEditCartBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteCartBtn,
                "defaultContent": "",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ],
        "initComplete": makeEditableCart
    });
});

$("#quantity").change(function () {
    var input_value = $("#quantity").val();
    var input_value2 = $("#price").val();

    $("#amount").val(input_value * input_value2);

});