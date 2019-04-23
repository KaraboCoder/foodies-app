/* DB Seed data */

--Recipes
insert into recipes values (1, 'Tikka', 1, 'No description',
    '1. Start with water', 'no-picture', '2 mins', 'EASY')
ON DUPLICATE KEY UPDATE ID=ID;

--Ingredients
insert into ingredients values (1, 'Chicken nugets', 'Grams',
23, 15, 'be careful', 1)
ON DUPLICATE KEY UPDATE ID=ID;

--Categories
insert into recipeCategories values (1, 'Chinese', 'made in china')
ON DUPLICATE KEY UPDATE ID=ID;

--User profiles
insert into userprofiles values (1, 'endee', 'endee@outlook.com')
ON DUPLICATE KEY UPDATE ID=ID;

insert into userprofiles values (1, 'lisa', 'lisa@gmail.com')
ON DUPLICATE KEY UPDATE ID=ID;