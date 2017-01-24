CREATE TABLE hotel (
	id 			INTEGER PRIMARY KEY	AUTOINCREMENT,
	nome		VARCHAR(200)	NOT NULL,
	email		VARCHAR(200),
	indirizzo	VARCHAR(200),
	tel			VARCHAR(200),
	cap			VARCHAR(200),
	citta		VARCHAR(200),
	stelle		NUMERIC	CHECK(0 < stelle <= 5)
);