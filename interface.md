# Interface sender-consumer
## Reservation (read & write)
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

## Maintenance (read)
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
