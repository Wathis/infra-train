# Réservation
## Requête
```json
{
	"carrierId" : "string",
	"carrierReservationId" : "string",
	"from" : "string [A-Z]",
	"to" : "string [A-Z]",
	"deparatureTime" : "timestamp",
	"delta" : "integer"
}
```

## Réponse
```json
{
	"rideId" : "integer",
	"carrierId" : "string",
	"carrierReservationId" : "string",
	"from" : "string [A-Z]",
	"to" : "string [A-Z]",
	"departureTime" : "timestamp",
	"error" : "boolean",
	"message" : "string"
}
```


# Travaux 
```json
{
	"rideId" : "integer",
    	"carrierId" : "string",
	"carrierReservationId" : "string",
	"workBeginTime" : "timestamp",
	"workEndTime" : "timestamp"
}
```
