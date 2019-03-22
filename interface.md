
# Reservation 

```
RESERVATION
=======
# Interface sender-consumer
## Réservation
### Requête
```json
>>>>>>> d75beeb7d55302d40a1b14ad6a7af88dda20bdf1
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
	"idCourse" : "integer",
	"idReservationInterneTransporteur" : "string",
	"pointDepart" : "string [A-Z]",
	"pointArrivee" : "string [A-Z]",
	"tempsDepart" : "timestamp",
	"erreur" : "boolean",
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
