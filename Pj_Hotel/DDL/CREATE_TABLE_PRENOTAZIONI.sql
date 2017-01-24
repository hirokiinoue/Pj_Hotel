CREATE TABLE prenotazioni (
	id 				INTEGER PRIMARY KEY	AUTOINCREMENT,
	datacheckin		TEXT	NOT NULL,
	datacheckout	TEXT	NOT NULL,
	descrizione		VARCHAR(200),
	idstanza		INTEGER	NOT NULL,
	idcliente		INTEGER	NOT NULL,
	FOREIGN KEY(idstanza)	REFERENCES stanza(id),
	FOREIGN KEY(idcliente)	REFERENCES cliente(id)
);