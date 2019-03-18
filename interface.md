# Interface sender-consumer
## Reservation
### Requête
```json
{
	"idReservationInterneTransporteur" : "string",
	"pointDepart" : "string [A-Z]",
	"pointArrivee" : "string [A-Z]",
	"tempsDepart" : "timestamp"
}
```

### Réponse
```json
{
	"idCOurse" : "integer",
	"idReservationInterneTransporteur" : "string",
	"pointDepart" : "string [A-Z]",
	"pointArrivee" : "string [A-Z]",
	"tempsDepart" : "timestamp",
	"erreur" : "boolean",
	"message" : "string"
}
```

## Travaux (read only)
### Annulation de course
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
		"pointArrivee" : "string [A-Z]",
		"pointArrivee" : "string [A-Z]",
		"tempsDebut" : "timestamp",
		"tempsFin" : "timestamp"
	}
]
```
