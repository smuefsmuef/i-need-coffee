-- Todo adjust data

-- Add first Beans
INSERT IGNORE INTO BEAN (id, type, origin, altitude) VALUES (1, 'Arabica', 'Veracruz, MX', 1500);
INSERT IGNORE INTO BEAN (id, type, origin, altitude) VALUES (2, 'Robusta K1', 'Veracruz, MX', 1000);
INSERT IGNORE INTO BEAN (id, type, origin, altitude) VALUES (3, 'Arabica I', 'Indonesia', 500);

-- Add first Coffee Mixes
INSERT IGNORE INTO COFFEE_MIX (id, name, roast_degree, price_per_kg) VALUES (1, 'Mexico High Mountain', 3, 20);
INSERT IGNORE INTO COFFEE_MIX (id, name, roast_degree, price_per_kg) VALUES (2, 'Java Blend ',2, 32);

-- Add Beans to Coffee Mixes
INSERT IGNORE INTO COFFEE_MIX_BEANS(coffee_mix_id, beans_id) VALUES (1, 1);
INSERT IGNORE INTO COFFEE_MIX_BEANS(coffee_mix_id, beans_id) VALUES (1, 2);
INSERT IGNORE INTO COFFEE_MIX_BEANS(coffee_mix_id, beans_id) VALUES (2, 3);

-- Add one first Rating/Review
INSERT IGNORE INTO RATING ( AMOUNT, GRIND, NAME, RATING, REVIEW, COFFEE_MIX_ID)
VALUES(  14,  5, 'Petra K.', 2, 'Aromatic, Notes of Chocolate. One of the best Coffee Cups I ever drank!',  1);
