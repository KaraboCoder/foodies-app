console.log('before');



document.addEventListener('DOMContentLoaded', () => {
    console.log("Loaded create recipe script, init create recipe script.....");

    const getFormElementValueByID = (elementId) => {
        return document.getElementById(elementId).nodeValue;
    }

    const getFormValue = () => {

    }

    const generateRequestbody = () => {
        const body = {
            title: "Omlet",
            instructions: [
                {
                    instruction_number: 1,
                    instruction: "Dont use rainbow chicken"
                }
                ],
            ingredients: [
              {
                name: "Eggs",
                unit_of_measurement: "kg",
                quantity: "6"
              }
            ],
            category: {  "name": "General", "description": "Foodies"}
          }
        return body;
    }

    const postDataToApi = (formDataObject, apiEndpoint) => {
        alert(`Recived form object: ${JSON.stringify(formDataObject)}`)
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open("POST", apiEndpoint, false); // false for synchronous request
        xmlHttp.send(JSON.stringify(formDataObject));
        xmlHttp.onreadystatechange = function () {
            if (this.status == 200) {
                console.log(`Response received from API: ${JSON.stringify(xmlHttp.response)}`);
                return xmlHttp.responseText;
            }
        };
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


