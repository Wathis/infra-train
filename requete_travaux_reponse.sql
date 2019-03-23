select 
	desserte1.nom as pointDepart,
    desserte2.nom as pointArrivee,
    travaux.date_debut-180*(sillon.position-1) as tempsDebut,
    travaux.date_fin-180*(sillon.position-1) as tempsFin
from
	desserte as desserte1
    inner join ligne on ligne.depart_id = desserte1.id
    inner join desserte as desserte2 on ligne.arrivee_id = desserte2.id
    inner join sillon on ligne.id = sillon.ligne_id
    inner join travaux_sillons on sillon.id = travaux_sillons.sillons_id
    inner join travaux on travaux.id = travaux_sillons.travaux_id
