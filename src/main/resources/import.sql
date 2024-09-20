INSERT INTO country (name) VALUES ('Spain'), ('France'), ('Germany'), ('Italy'), ('Canada');
INSERT INTO region (name, code_country) VALUES ('Andalucía', 1), ('Île-de-France', 2), ('Bavaria', 3), ('Tuscany', 4), ('Ontario', 5);
INSERT INTO city (name, code_region) VALUES ('Seville', 1), ('Paris', 2), ('Munich', 3), ('Florence', 4),('Toronto', 5);
INSERT INTO company (name) VALUES ('Tech Innovators Inc.'), ('Global Solutions Ltd.'), ('Creative Minds Corp.');
INSERT INTO branch (code_city, code_company, name) VALUES (1, 1, 'Tech Innovators Seville'), (2, 2, 'Global Solutions Paris'),(5, 3, 'Creative Minds Toronto');   -- Toronto, Creative Minds Corp.
INSERT INTO category (name) VALUES ('Antique Furniture'), ('Vintage Jewelry'), ('Classic Art'), ('Ancient Coins'), ('Historical Documents');
INSERT INTO period (name) VALUES ('Renaissance'), ('Victorian Era'), ('Medieval Period'), ('Ancient Rome'), ('Art Deco');
INSERT INTO conservation_status (name) VALUES ('Excelente'), ('Bueno'), ('Regular'), ('Malo');
INSERT INTO availability (name) VALUES ('En venta'), ('Vendido'), ('Retirado');
INSERT INTO antiquity (name, description, price, origin, code_availability, code_branch, code_category, code_period, code_status) VALUES ("Lukas", "Lukas es mi perrito", 0.0, "unknow origin", 3, 3, 3, 3, 4);
INSERT INTO gallery (url_photo, code_antiquity) VALUES ("https://img.freepik.com/vector-gratis/ilustracion-estilo-picasso-dibujada-mano_23-2149577316.jpg?w=826&t=st=1726843294~exp=1726843894~hmac=8baca8eb1cf15a3e26d5ee33f9fa75259932a6d288c3102aec8bfe1a87b188cf", 1), ("www.img.com/imgNothing", 1);




