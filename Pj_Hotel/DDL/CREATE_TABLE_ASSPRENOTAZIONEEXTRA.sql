CREATE TABLE assprenotazioneextra (
	idprenotazione	INTEGER	NOT NULL,
	idextra			INTEGER	NOT NULL,
	FOREIGN KEY(idprenotazione)	REFERENCES prenotazione(id)	NOT NULL,
	FOREIGN KEY(idextra)	REFERENCES extra(id)	NOT NULL,
	PRIMARY KEY(idprenotazione,idextra)
);