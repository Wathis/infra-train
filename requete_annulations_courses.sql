select 
	course.id as idCourse,
    course.id_reservation_transporteur as idReservationInterneTransporteur,
    travaux.date_debut-180*(sillon.position-1) as tempsDebut,
    travaux.date_fin-180*(sillon.position-1) as tempsFin
from
	ligne
    inner join sillon on ligne.id = sillon.ligne_id
    inner join travaux_sillons on sillon.id = travaux_sillons.sillons_id
    inner join travaux on travaux.id = travaux_sillons.travaux_id
    inner join reservation on reservation.sillon_id = sillon.id
    inner join course on course.id = reservation.course_id
where
	reservation.timestamp > travaux.date_debut-180*2
    and reservation.timestamp < travaux.date_fin+180*2