# Interface sender-consumer
## Reservation
### Requête
```json
{
	"carrierInternalReservationId" : "string",
	"from" : "string [A-Z]",
	"to" : "string [A-Z]",
	"deparatureTime" : "timestamp"
}
```

### Réponse
```json
{
	"rideId" : "integer",
	"carrierInternalReservationId" : "string",
	"from" : "string [A-Z]",
	"to" : "string [A-Z]",
	"departureTime" : "timestamp",
	"error" : "boolean",
	"message" : "string"
}
```

## Travaux (read only)
### Annulation de course
```json
{
	"rideId" : "integer",
	"carrierInternalReservationId" : "string",
	"startTime" : "timestamp",
	"endTime" : "timestamp"
}
```

### Lister les travaux en cours
```json
[
	{
		"from" : "string [A-Z]",
		"to" : "string [A-Z]",
		"startTime" : "timestamp",
		"endTime" : "timestamp"
	}
]
```
