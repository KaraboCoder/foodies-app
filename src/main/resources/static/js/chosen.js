$(".chosen-select").chosen({width: "100%"});

var counter = 0;
$(document).ready(function () {
    $("#add-ingredient-btn").click(function () {
        var ingredient = $("#Ingredient").val();
        var quantity = $("#Quantity").val();
        var unit = $("#Unit").val();

        if (unit.length == 0 || quantity.length == 0 || ingredient.length == 0) return;
        var table = $("#Ingredients-table tbody");
        console.log(table);
        table.append("<tr id=\"tr-"+counter+"\"><td>"+ingredient+"</td><td>"+quantity+"</td> <td>"+unit+"</td><td><button data-id=\"tr-"+counter+"\"type=\"button\" id=\"remove-ingredient-btn-"+counter+"\" class=\"btn btn-primary\">Delete</button></td></tr>");
        $("#remove-ingredient-btn-" + counter).click(function(e){
            $("#" + e.target.dataset.id).remove();
        });
        counter++;
        console.log(ingredient,quantity,unit);
    });


});

$(document).ready(function () {
    $("#add-instruction-btn").click(function () {
        var instruction = $("#Instruction").val();

        if (instruction.length == 0) return;

        var table = $("#Instructions-table tbody");
        console.log(table);
        table.append("<tr id=\"tr-"+counter+"\"><td class=\"Instructions-cell\">"+instruction+"</td><td class=\"Instructions-cell-delete-button\"><button data-id=\"tr-"+counter+"\"type=\"button\" id=\"remove-instruction-btn-"+counter+"\" class=\"btn btn-primary\">Delete</button></td></tr>");
        $("#remove-instruction-btn-" + counter).click(function(e){
            $("#" + e.target.dataset.id).remove();
        });
        counter++;

        console.log(instruction);
    });

});

