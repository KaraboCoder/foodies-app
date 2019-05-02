document.addEventListener('DOMContentLoaded', () => {
    console.log("Loaded create recipe script, init create recipe script.....");

    const getFormElementValueByID = (elementId) => {
        let elem = document.getElementById(elementId);
        // Todo: If required field is null, do something
        return elem.value ? elem.value : null;
    }

    const getSelectedValue = (selectionInputId) =>{
        const e = document.getElementById(selectionInputId);
        return e.options[e.selectedIndex].value;
    }

    const getInstrValuesFromTable = (tableQuerySelector) =>{
        const results = [];
        const dataRows = Array.from(document.querySelectorAll(tableQuerySelector));
        dataRows.map( (row, index) => {
            let cells = row.getElementsByTagName('td');
            let instr = {
                instruction_number: index,
                instruction: cells[0].innerText 
            };
            results.push(instr);
        });

        return results;
    }

    const getIngrValuesFromTable = (tableQuerySelector) =>{
        const results = [];
        const dataRows = Array.from(document.querySelectorAll(tableQuerySelector));
        dataRows.map( (row, index) => {
            let cells = row.getElementsByTagName('td');
            let ingr = {
                name: cells[0],
                unit_of_measurement: cells[1],
                quantity: cells[2],
                more_info: cells[3]
            }
            results.push(ingr);
        });

        return results;
    }

    const generateRequestbody = () => {
        alert(`Check if form elem exists: ${JSON.stringify(document.getElementById("create-recipe-form"))}.`);
        const body = {
            title: getFormElementValueByID('title'),
            description: getFormElementValueByID('description'),
            display_pic_url: getFormElementValueByID('display_pic_url'),
            time_to_prepare: getFormElementValueByID('time_to_prepare'),
            difficulty_level: getSelectedValue('difficulty_level'),
            category: getSelectedValue('category'),
            instructions: getInstrValuesFromTable("Instructions-table"),
            ingredients: getIngrValuesFromTable("Ingredients-table")
          }
        return body;
    }

    function postData(data = {}, url = ``, ) {
        // Default options are marked with *
        return fetch(url, {
            method: "POST", // *GET, POST, PUT, DELETE, etc.
            mode: "cors", // no-cors, cors, *same-origin
            cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
            credentials: "same-origin", // include, *same-origin, omit
            headers: {
                "Content-Type": "application/json",
                // "Content-Type": "application/x-www-form-urlencoded",
            },
            redirect: "follow", // manual, *follow, error
            referrer: "no-referrer", // no-referrer, *client
            body: JSON.stringify(data), // body data type must match "Content-Type" header
        })
        .then(response => response.json()); // parses JSON response into native Javascript objects 
    }

    const addPageEventListeners = () => {
        // 1. Create recipe form
        document.getElementById("create-recipe-btn")
            .addEventListener('click', (e) => {
                console.log('new request to save form...')

                postData(generateRequestbody(), 'http://localhost:8080/api/create')
                    .then(data => console.log(JSON.stringify(data))) // JSON-string from `response.json()` call
                    .catch(error => console.error(error));
            })
    }

    addPageEventListeners();

});


// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
    'use strict';
    window.addEventListener('load', function() {
      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.getElementsById('create-recipe-form');
      // Loop over them and prevent submission
      var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', function(event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  })();


