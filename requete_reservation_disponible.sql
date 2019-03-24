select 
	count(*) = 0 as sillon_disponible 
from
	reservation res 
    join sillon sil on res.sillon_id = sil.id 
    join travaux_sillons on travaux_sillons.sillons_id = sil.id
    join travaux on travaux.id = travaux_sillons.travaux_id
where 
	(res.timestamp < 1553285719 + 180*2 and res.timestamp > 1553285719 - 180*2 and sil.id = 10)
    or (travaux.date_debut < 1553285719 + 180*2 and travaux.date_fin > 1553285719 - 180*2 and sil.id = 10)
