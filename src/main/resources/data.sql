/* DB Seed data */

--Recipes
insert into recipe values (1, 'Mexican Salami', 0, 'No description',
    '1. Start with water', 'no-picture', '2 mins', 'EASY')
ON DUPLICATE KEY UPDATE ID=ID;

insert into recipe values (2, 'Tikka', 0, 'No description',
    '1. Add chilli 2. Water  water', 'no-picture', '2 mins', 'MEDIUM')
ON DUPLICATE KEY UPDATE ID=ID;


--Ingredients
insert into shopping_list_item values (1, 'Chutney')
ON DUPLICATE KEY UPDATE ID=ID;

insert into recipe_ingredient values (1, 1, 1,
'Grams', 23, 'Dont overheat')
ON DUPLICATE KEY UPDATE ID=ID;

--Categories
insert into categories values (1,
'Chinese', 'made in china')
ON DUPLICATE KEY UPDATE ID=ID;

insert into recipe_categories values (1,  1, 1)
ON DUPLICATE KEY UPDATE ID=ID;

--User profiles
insert into userprofiles values (1, 'endee', 'endee@outlook.com')
ON DUPLICATE KEY UPDATE ID=ID;

insert into userprofiles values (2, 'lisa', 'lisa@gmail.com')
ON DUPLICATE KEY UPDATE ID=ID;