public class RecipeViewModel {
    public  long id;
    @NotNull
    public String title;
    public String description;
    public String display_pic_url;
    public String time_to_prepare;
    public String difficulty_level;

    @NotNull
    public RecipeCategoryDao category;

    @NotNull
    public List<InstructionDao> instructions;

    @NotNull
    public List<IngredientDao> ingredients;
    
   }
   
   // Sample json object expected by api
   // Only required fields are shown here
   /*
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
      */
