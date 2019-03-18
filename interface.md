# Interface sender-consumer
## Reservation
### Request
```json
{
	"carrierInternalReservationId" : "string",
	"from" : "string [A-Z]",
	"to" : "string [A-Z]",
	"deparatureTime" : "timestamp"
}
```

### Response
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

## Maintenance (read only)
### Ride cancellation
```json
{
	"rideId" : "integer",
	"carrierInternalReservationId" : "string",
	"startTime" : "timestamp",
	"endTime" : "timestamp"
}
```

### List ongoing maintenance operations
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
