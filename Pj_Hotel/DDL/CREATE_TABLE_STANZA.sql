CREATE TABLE stanza (
	id 				INTEGER			PRIMARY KEY	AUTOINCREMENT,
	nome			VARCHAR(200),
	costopernotte	REAL			NOT NULL,
	fumatori		INT				NOT NULL	CHECK(0 <= fumatori <= 1),
	numeropersona	NUMERIC 		NOT NULL	CHECK(0 < numeropersona),
	descrizione		VARCHAR(200),
	idhotel			INTEGER			NOT NULL,
	FOREIGN KEY(idhotel)	REFERENCES hotel(id)
);