CREATE TABLE utente (
	id 			INTEGER PRIMARY KEY	AUTOINCREMENT,
	nome		VARCHAR(200),
	cognome		VARCHAR(200),
	email		VARCHAR(200),
	password	VARCHAR(8),
	tel			VARCHAR(200),
	ruolo		NUMERIC	CHECK(1 < ruolo < 2),
	descrizione	VARCHAR(200)
);