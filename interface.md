# Reservation 

```json
Reservation
{
    "idTransporteur" : "",
    "idResa" : "",
    "from" : A-Z,
    "to" : A-Z,
    "deparatureTime" : timestamp,
    "delta" : int // minutes
}
```

```json
Course
{
	"idCourse" : "",
	"idResa" : "",
	"departureTime" : timestamp,
	"from" : A-Z,
	"to" : A-Z,
	"response" : "validé" | "refusé : déjà reservé"
}
```


# Travaux 

```json
travaux
{
	"idCourse" : "",
	"idResa" : "",
	"departureTime" : timestamp,
	"from" : A-Z,
	"to" : A-Z,
	"workBeginTime" : timestamp,
	"workEndTime" : timestamp
}
```
