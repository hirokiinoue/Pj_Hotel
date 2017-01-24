CREATE TABLE assprenotazioneutente (
	idprenotazione	INTEGER	NOT NULL,
	idutente		INTEGER	NOT NULL,
	FOREIGN KEY(idprenotazione)	REFERENCES prenotazione(id)	NOT NULL,
	FOREIGN KEY(idutente)	REFERENCES utente(id)	NOT NULL,
	PRIMARY KEY(idprenotazione,idutente)
);