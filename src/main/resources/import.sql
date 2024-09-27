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
INSERT INTO type_address (name) VALUES('Residencial'), ('Comercial'), ('Industrial'), ('Oficina'), ('Vacacional');
INSERT INTO users (name, lastname_one, lastname_two, email, password) VALUES ('Juan', 'Pérez', 'Gómez', 'juan.perez@example.com', 'password123'), ('María', 'López', 'Hernández', 'maria.lopez@example.com', 'securepass456'), ('Carlos', 'Rodríguez', 'Martínez', 'carlos.rodriguez@example.com', 'mypassword789'), ('Ana', 'García', 'Ruiz', 'ana.garcia@example.com', 'strongpass012'), ('Luis', 'Fernández', 'Santos', 'luis.fernandez@example.com', 'passwordsecure345');
INSERT INTO address (address, code_user, code_type_address, code_city) VALUES ("Cra 1, Cll 1 - 2", 1, 3, 2);
INSERT INTO gender (name) VALUES ('Masculino'), ('Femenino'), ('No Binario'), ('Prefiere no decir'), ('Otro');
INSERT INTO type_contact (name) VALUES ('Personal'), ('Trabajo');
INSERT INTO payment_method (name) VALUES ('TARJETA_DE_CREDITO'), ('TARJETA_DE_DEBITO'), ('TRANSFERENCIA_BANCARIA'), ('PAYPAL'), ('EFECTIVO'), ('BITCOIN'), ('APPLE_PAY'), ('GOOGLE_PAY'), ('CHEQUE');
INSERT INTO transaction_type (name) VALUES ('compra'), ('pago'), ('reembolso');
INSERT INTO transactions (date_transaction, code_user, code_transaction_type) VALUES ('2024-09-20', 1, 1), ('2024-09-21', 2, 2), ('2024-09-22', 3, 3);
INSERT INTO transaction_detail (transaction_price, code_user, code_payment_method, code_antiquity, code_transaction) VALUES (1500.00, 7, 5, 4, 1), (2500.75, 7, 6, 5, 3), (3200.50, 7, 5, 6, 3), (1800.00, 8, 7, 7, 2), (4200.99, 8, 8, 8, 2);
insert into role values (1, 'ADMIN'), (2, 'USER'), (3, 'GUEST');
insert into user_roles values (4, 1), (5, 2), (1, 3)




