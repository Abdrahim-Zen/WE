use market;

INSERT INTO amministratore (nome, cognome, password)
VALUES 
('Mario', 'Rossi', 'adminpass1'),
('Lucia', 'Bianchi', 'adminpass2');


INSERT INTO utente (nome, cognome, password, creato_da)
VALUES
('Giuseppe', 'Verdi', 'userpass1', 1),   -- creato da Mario Rossi
('Anna', 'Neri', 'userpass2', 1),
('Marco', 'Gialli', 'userpass3', 2),     -- creato da Lucia Bianchi
('Sara', 'Blu', 'userpass4', 2);


INSERT INTO utenteRegistrato (ID_Utente, budget_disponibile)
VALUES
(1, 1500.00),   -- Giuseppe
(2, 800.00);   -- Anna



INSERT INTO tecnico (ID_Tecnico, data_assunzione)
VALUES
(3, '2022-03-15'),   -- Marco Gialli
(4, '2023-01-10');   -- Sara Blu


INSERT INTO categoria (nome)
VALUES
('Computer Portatili'),
('Smartphone'),
('Stampanti'),
('Monitor');


INSERT INTO specifica_categoria (ID_categoria, nome_specifica)
VALUES
(1, 'RAM'),
(1, 'Processore'),
(1, 'Dimensione Schermo'),
(2, 'Memoria Interna'),
(2, 'Fotocamera'),
(2, 'Batteria'),
(3, 'Tecnologia Stampa'),
(3, 'Velocità Pagine/Minuto'),
(4, 'Pollici'),
(4, 'Risoluzione');
