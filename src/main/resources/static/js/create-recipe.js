console.log('before');
document.addEventListener('DOMContentLoaded', () => {
    console.log("Loaded create recipe script, init create recipe script.....");
    addPageEventListeners();

    const getFormElementValueByID = (elementId) => {
        return document.getElementById(elementId).nodeValue;
    }

    const getFormValue = () => {

    }

    const generateRequestbody = () => {
        const body = {
            "recipe":
            {
                "title": "Chinese Lamb steak",
                "instructions": "1. Preheat oven",
                "recipeName": "",
                "preparationTime": ""
            },

            "ingredients": [
                {
                    "shopping_item": {
                        "name": "Carrots",
                        "estimated_price": 23.34
                    },
                    "unit_of_measurement": "ml",
                    "quantity": "5"
                }
            ],

            "category": { "name": "Chinese", "description": "All things chinese" }

        }
        return body;
    }

    const postDataToApi = (formDataObject, apiEndpoint) => {
        alert(`Recived form object: ${JSON.stringify(formDataObject)}`)
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open( "POST", apiEndpoint, false ); // false for synchronous request
        xmlHttp.send( formDataObject );
        return xmlHttp.responseText;
    }

    const addPageEventListeners = ()=>{
        // 1. Create recipe form
        document.getElementById("create-recipe-btn")
                .addEventListener('click', (e)=> {
                    console.log('new request to save form!')
                    postDataToApi(generateRequestbody(), 'http://localhost:8080/api/create');
                })
    }

});


