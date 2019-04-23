/* DB Seed data */

--Recipes
insert into recipesAlt values (1, 'Tikka', 1, 'No description',
    '1. Start with water', 'no-picture', '2 mins', 'EASY', 1)
ON DUPLICATE KEY UPDATE ID=ID;

insert into recipesAlt values (1, 'Tikka', 1, 'No description',
    '1. Start with water', 'no-picture', '2 mins', 'EASY', 2)
ON DUPLICATE KEY UPDATE ID=ID;


--Ingredients
insert into ingredients values (1, 'Chicken nugets', 'Grams',
23, 15, 'be careful')
ON DUPLICATE KEY UPDATE ID=ID;

insert into ingredients values (2, 'Water', 'Grams',
23, 15, 'Dont overheat')
ON DUPLICATE KEY UPDATE ID=ID;

--Categories
insert into recipeCategories values (1, 'Chinese', 'made in china', 1)
ON DUPLICATE KEY UPDATE ID=ID;

insert into recipeCategories values (2, 'Turkey', 'made in turkey', 1)
ON DUPLICATE KEY UPDATE ID=ID;

--User profiles
insert into userprofiles values (1, 'endee', 'endee@outlook.com')
ON DUPLICATE KEY UPDATE ID=ID;

insert into userprofiles values (2, 'lisa', 'lisa@gmail.com')
ON DUPLICATE KEY UPDATE ID=ID;