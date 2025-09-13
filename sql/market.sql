
DROP DATABASE IF EXISTS market;
 DROP USER IF EXISTS 'admin'@'localhost';
CREATE USER 'admin'@'localhost' IDENTIFIED BY '0000';
GRANT ALL PRIVILEGES ON market.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;

CREATE DATABASE  IF NOT EXISTS market;
USE market;



CREATE TABLE amministratore (
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    cognome VARCHAR(50),
    password VARCHAR(255) NOT NULL
);

CREATE TABLE utente(
ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(200) NOT NULL,
cognome VARCHAR(200) NOT NULL,
password VARCHAR(255) NOT NULL,
creato_da INT UNSIGNED NOT NULL,
FOREIGN KEY (creato_da) REFERENCES Amministratore(ID)
);

CREATE TABLE utenteRegistrato (
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    ID_Utente INT UNSIGNED ,
    budget_disponibile DECIMAL(10, 2),
    FOREIGN KEY (ID_Utente) REFERENCES Utente(ID)
    
);

CREATE TABLE tecnico(
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    ID_Tecnico INT UNSIGNED ,
    data_assunzione DATE NOT NULL,
    FOREIGN KEY (ID_Tecnico) REFERENCES Utente(ID)
    );
    
CREATE TABLE categoria (
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE prodotto(
ID_prodotto INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
ID_categoria INT UNSIGNED NOT NULL,
prezzo DECIMAL(10,2) NOT NULL,
descrizione TEXT NOT NULL ,
FOREIGN KEY (ID_categoria) REFERENCES categoria(ID)
);

CREATE TABLE specifica_categoria (
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    ID_categoria INT UNSIGNED NOT NULL,
    nome_specifica VARCHAR(100) NOT NULL,
    FOREIGN KEY (ID_categoria) REFERENCES categoria(ID)
);



CREATE TABLE richiestaAcquisto (
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    ID_utente INT UNSIGNED NOT NULL,
    ID_categoria INT UNSIGNED NOT NULL,
    importo_totale DECIMAL(10,2),
    note TEXT NOT NULL ,
    stato ENUM('in_attesa', 'approvata', 'rifiutata','in_valutazione','soddisfatta') NOT NULL DEFAULT 'in_attesa',
    data_inserimento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ID_utente) REFERENCES utenteRegistrato(ID_Utente)  ON DELETE CASCADE,
    FOREIGN KEY (ID_categoria) REFERENCES categoria(ID) ON DELETE CASCADE
);

CREATE TABLE tecniciIncaricati (
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    ID_tecnico INT UNSIGNED NOT NULL,
    ID_richiesta INT UNSIGNED NOT NULL,
    data_incarico TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ID_tecnico) REFERENCES tecnico(ID)  ON DELETE CASCADE,
    FOREIGN KEY (ID_richiesta) REFERENCES richiestaAcquisto(ID) ON DELETE CASCADE,
    UNIQUE (ID_tecnico, ID_richiesta) -- evita duplicati tra tecnico e richiesta
);
CREATE TABLE valore_specifica_richiesta (
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    ID_richiesta INT UNSIGNED NOT NULL,
    ID_specifica_categoria INT UNSIGNED NOT NULL,
    valore VARCHAR(255) NOT NULL,  -- es: "16GB", "Intel i5"
    FOREIGN KEY (ID_richiesta) REFERENCES richiestaAcquisto(ID) ON DELETE CASCADE,
    FOREIGN KEY (ID_specifica_categoria) REFERENCES specifica_categoria(ID) ON DELETE CASCADE
);

CREATE TABLE prodottoCandidato (
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descrizione TEXT,
    prezzo DECIMAL(10,2) NOT NULL,
    ID_tecnico INT UNSIGNED NOT NULL,
    ID_richiesta INT UNSIGNED NOT NULL,
    data_proposta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ID_tecnico, ID_richiesta)
        REFERENCES tecniciIncaricati(ID_tecnico, ID_richiesta) ON DELETE CASCADE
);


CREATE TABLE ordine (
    ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    data_ordine TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    stato ENUM('in_attesa', 'approvato', 'spedito', 'chiuso', 'rifiutato') NOT NULL DEFAULT 'in_attesa',
    motivazione_rifiuto TEXT NULL,
    ID_utente INT UNSIGNED NOT NULL,
    ID_prodotto_candidato INT UNSIGNED NOT NULL,
    FOREIGN KEY (ID_utente) REFERENCES utenteRegistrato(ID_Utente) ON DELETE CASCADE,
    FOREIGN KEY (ID_prodotto_candidato) REFERENCES prodottoCandidato(ID) ON DELETE CASCADE
);









