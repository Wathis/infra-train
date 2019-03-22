# Interface sender-consumer

## Réservation
### Requête
**NOM TOPIC KAFKA** : creer_reservation
```json
{
	"idReservationInterneTransporteur" : "string",
	"pointDepart" : "string [A-Z]",
	"pointArrivee" : "string [A-Z]",
	"tempsDepart" : long //timestamp
}
```

### Réponse
**NOM TOPIC KAFKA** : reponse_reservation
```json
{
	"idCourse" : integer,
	"idReservationInterneTransporteur" : "string",
	"pointDepart" : "string [A-Z]",
	"pointArrivee" : "string [A-Z]",
	"tempsDepart" : long, //timestamp
	"erreur" : boolean,
	"message" : "string"
}
```

## Travaux (read only)
### Notification d'annulation de course
```json
{
	"idCourse" : "integer",
	"idReservationInterneTransporteur" : "string",
	"tempsDebut" : "timestamp",
	"tempsFin" : "timestamp"
}
```

### Lister les travaux en cours
```json
[
	{
		"pointDepart" : "string [A-Z]",
		"pointArrivee" : "string [A-Z]",
		"tempsDebut" : "timestamp",
		"tempsFin" : "timestamp"
	}
]
```
