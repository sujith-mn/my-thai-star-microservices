
-- Plate
INSERT INTO Dish (id, modificationCounter, name, description, price, idImage) VALUES (0, 1, 'Thai Spicy Basil Fried Rice', 'This is a staple of Thai cooking. Adjust the spices to your own tastes for a really great use for leftover rice!! I get the basil from a local Asian market. It has a different flavor than that of regular basil and makes all the difference in this recipe. It is fast and fairly easy to make, but requires constant stirring', '12.9900000000', 0);
INSERT INTO Dish (id, modificationCounter, name, description, price, idImage) VALUES (1, 1, 'Garlic Paradise Salad', 'From the world-famous Gilroy Garlic Festival to a fierce 40-clove garlic salad in San Francisco and a gut-busting garlic sandwich in Philly, we feature the tastiest places to get your garlic on.', '7.9900000000', 1);
INSERT INTO Dish (id, modificationCounter, name, description, price, idImage) VALUES (2, 1, 'Thai green chicken curry', 'Master this aromatic, creamy & extremely tasty chicken Thai green curry recipe from Jamie Oliver & treat yourself to an authentic taste of South East Asia.', '14.7500000000', 2);
INSERT INTO Dish (id, modificationCounter, name, description, price, idImage) VALUES (3, 1, 'Thai Peanut Beef', 'This easy no-cook peanut sauce has a terrific authentic Thai taste. It is spicy and peanutty, and is perfect as a dipping sauce for Beef, shrimp ...or even to use tossed with warm cooked noodles for a quick pasta dish.', '12.2500000000', 3);
INSERT INTO Dish (id, modificationCounter, name, description, price, idImage) VALUES (4, 1, 'Thai Thighs Fish/Prawns', 'Grill over a smoker or just brown in the oven - these moreish Fish pieces or prawns are marinated in a blend of lime and pineapple juice, chilli and ginger.', '8.9900000000', 4);
INSERT INTO Dish (id, modificationCounter, name, description, price, idImage) VALUES (5, 1, 'Beer','Types: Ales, Lagers, Stouts & Porters, Malts. Styles: Amber, Blonde, Brown, Cream, Dark, Fruit, Golden, Honey, India Pale Ale, Light, Lime, Pale, Pilsner, Red, Strong, Wheat', '4', 5);
INSERT INTO Dish (id, modificationCounter, name, description, price, idImage) VALUES (6, 1, 'Tea','Assam Black Tea, Ceylon Black Tea, Darjeeling Black Tea, English Breakfast, Assam Green, Darjeeling Green Tea, Moonlight White', '4', 6);

--Ingredient
INSERT INTO Ingredient (id, modificationCounter, name, description, price) VALUES (0, 1, 'Tofu', 'Also known as bean curd, is a food made by coagulating soy milk and then pressing the resulting curds into soft white blocks. ', '1.0000000000');
INSERT INTO Ingredient (id, modificationCounter, name, description, price) VALUES (1, 1, 'Extra curry', 'The common feature is the use of complex combinations of spices or herbs, usually including fresh or dried hot chillies.', '1.0000000000');

--DishIngredient
INSERT INTO DishIngredient (id, modificationCounter, idDish, idIngredient) VALUES (0, 1, 0, 1);
INSERT INTO DishIngredient (id, modificationCounter, idDish, idIngredient) VALUES (1, 1, 0, 0);
INSERT INTO DishIngredient (id, modificationCounter, idDish, idIngredient) VALUES (2, 1, 1, 1);
INSERT INTO DishIngredient (id, modificationCounter, idDish, idIngredient) VALUES (3, 1, 2, 0);
INSERT INTO DishIngredient (id, modificationCounter, idDish, idIngredient) VALUES (4, 1, 2, 1);
INSERT INTO DishIngredient (id, modificationCounter, idDish, idIngredient) VALUES (5, 1, 3, 0);
INSERT INTO DishIngredient (id, modificationCounter, idDish, idIngredient) VALUES (6, 1, 4, 1);

--Category
INSERT INTO Category (id, modificationCounter, name, description, showOrder) VALUES (0, 1, 'Main Dishes', 'Main Dishes', 0);
INSERT INTO Category (id, modificationCounter, name, description, showOrder) VALUES (1, 1, 'Starter', 'Starter Dishes', 1);
INSERT INTO Category (id, modificationCounter, name, description, showOrder) VALUES (2, 1, 'Dessert', 'Dessert', 2);
INSERT INTO Category (id, modificationCounter, name, description, showOrder) VALUES (3, 1, 'Noodle', 'Dishes that contain noodles', 2);
INSERT INTO Category (id, modificationCounter, name, description, showOrder) VALUES (4, 1, 'Rice', 'Dishes that contain rice', 2);
INSERT INTO Category (id, modificationCounter, name, description, showOrder) VALUES (5, 1, 'Curry', 'Dishes with curry', 2);
INSERT INTO Category (id, modificationCounter, name, description, showOrder) VALUES (6, 1, 'Vegan', 'Vegan food', 2);
INSERT INTO Category (id, modificationCounter, name, description, showOrder) VALUES (7, 1, 'Vegetarian', 'Vegetarian food', 2);
INSERT INTO Category (id, modificationCounter, name, description, showOrder) VALUES (8, 1, 'Drinks', 'Hot & Cold Drinks', 2);

--DishCategory
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (0, 1, 0, 0);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (1, 1, 0, 4);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (2, 1, 0, 7);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (3, 1, 1, 0);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (4, 1, 2, 0);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (5, 1, 2, 5);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (6, 1, 3, 6);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (7, 1, 3, 7);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (8, 1, 4, 1);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (10, 1, 5, 8);
INSERT INTO DishCategory (id, modificationCounter, idDish, idCategory) VALUES (11, 1, 6, 8);
