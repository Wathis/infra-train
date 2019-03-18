# Reservation 

```
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

```
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

```
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