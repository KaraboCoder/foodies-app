$(".chosen-select").chosen({width: "100%"});


$(document).ready(function () {
    $("#add-ingredient-btn").click(function () {
        var ingredient = $("#Ingredient").val();
        var quantity = $("#Quantity").val();
        var unit = $("#Unit").val();

        var table = $("#Ingredients-table tbody");
        console.log(table);
        table.append("<tr><td>"+ingredient+"</td><td>"+quantity+"</td> <td>"+unit+"</td></tr>");
        console.log(ingredient,quantity,unit);
    });

});

$(document).ready(function () {
    $("#add-instruction-btn").click(function () {
        var instruction = $("#Instruction").val();

        var table = $("#Instructions-table tbody");
        console.log(table);
        table.append("<tr><td>"+instruction+"</td></tr>");
        console.log(instruction);
    });

});

