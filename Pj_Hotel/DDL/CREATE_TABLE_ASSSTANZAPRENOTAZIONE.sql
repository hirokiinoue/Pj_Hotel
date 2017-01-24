CREATE TABLE assstanzaprenotazione (
	idstanza		INTEGER	NOT NULL,
	idprenotazione	INTEGER NOT NULL,
	FOREIGN KEY(idstanza)	REFERENCES stanza(id)	NOT NULL,
	FOREIGN KEY(idprenotazione)	REFERENCES prenotazione(id)	NOT NULL,
	PRIMARY KEY(idstanza,idprenotazione)
);