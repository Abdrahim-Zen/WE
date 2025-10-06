-- Inserimento amministratori
INSERT INTO amministratore (email,nome, cognome, password)
VALUES 
('mario.rossi@email.com','Mario', 'Rossi', '00857f170da08391d3dfc0e41de269bf2ec3a2a9ed5a4e22a611540c5f9358f2b2b33d67bd719792f04b08bb8f492aac'), -- adminpass1
('lucia.bianchi@email.com','Lucia', 'Bianchi', '$2y$10$sT4WpLmU9vX2yZ3k5j7nQ.RoGdM8tVqC3nOq4mR7sWxY2zU8pF'); -- adminpass2

-- Inserimento utenti
INSERT INTO utente (email, nome, cognome, password, creato_da)
VALUES
('giuseppe.verdi@email.com', 'Giuseppe', 'Verdi', '3ff5c57969298a058da7b3cd63aa124d7038f199f06599258ab982a6d5b1dfaa1d7f11b57d44872f4e06d0fdaa4229c2', 1), -- userpass1
('anna.neri@email.com', 'Anna', 'Neri', 'b135b56b8e5d0cd8298ade5129789b4300b56a7910d978dba8294ea83a3e5d2cc69df5dc21e8807981f611285ea3204a', 1),    -- userpass2
('marco.gialli@email.com', 'Marco', 'Gialli', 'b47be6810ec1f40a841aa891a59b9f19f52e4ef999a082ff414569f9bb9349a0247e00620f0a67084aa0d6c124dd6747', 2), -- userpass3
('sara.blu@email.com', 'Sara', 'Blu', '91d2c8c2452c09cdd3ab44a0db8cec341524a63c1e9440d2d8895a44a1941ee37f33efd1ffad725542c70ff5935904cb', 2);       -- userpass4

-- Inserimento utenti registrati
INSERT INTO utenteRegistrato (ID, budget_disponibile)
VALUES
(1, 1500.00),   -- Giuseppe
(2, 800.00);    -- Anna

-- Inserimento tecnici
INSERT INTO tecnico (ID, data_assunzione, stato)
VALUES
(3, '2022-03-15', 'in_attesa'),   -- Marco Gialli
(4, '2023-01-10', 'in_attesa');   -- Sara Blu

-- Inserimento categorie
INSERT INTO categoria (nome)
VALUES
('Computer Portatili'),
('Smartphone'),
('Stampanti'),
('Monitor');

-- Inserimento specifiche categorie
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

-- Inserimento richieste di acquisto
INSERT INTO richiestaAcquisto (ID_utente, ID_categoria, importo_totale, note, stato)
VALUES
(1, 1, 1200.00, 'Necessario per lavoro da remoto', 'in_attesa'),
(2, 2, 800.00, 'Smartphone con buona fotocamera', 'in_attesa');

-- Inserimento specifiche richieste
INSERT INTO specifiche_richiesta (ID_richiesta, ID_specifica_categoria, valore)
VALUES
(1, 1, '16GB'),         -- RAM per computer portatile
(1, 2, 'Intel i7'),     -- Processore per computer portatile
(1, 3, '15.6"'),        -- Dimensione schermo per computer portatile
(2, 4, '128GB'),        -- Memoria interna per smartphone
(2, 5, '48MP'),         -- Fotocamera per smartphone
(2, 6, '4000mAh');      -- Batteria per smartphone

-- Inserimento richieste in carico
INSERT INTO richiesteInCarico (ID_tecnico, ID_richiesta)
VALUES
(3, 1),   -- Marco si occupa della richiesta 1
(4, 2);   -- Sara si occupa della richiesta 2

-- Inserimento prodotti candidati
INSERT INTO prodottoCandidato (nome, descrizione, prezzo, ID_richiestaInCarico)
VALUES
('Dell XPS 15', 'Portatile di alta gamma con processore Intel i7 e 16GB RAM', 1199.99, 1),
('iPhone 13', 'Smartphone Apple con fotocamera da 12MP e memoria 128GB', 799.99, 2);

-- Inserimento ordini
INSERT INTO ordine (stato, ID_utente, ID_prodotto_candidato)
VALUES
('in_attesa', 1, 1),
('in_attesa', 2, 2);