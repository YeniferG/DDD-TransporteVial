package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.domain.generic.Identity;

public class ConductorCarroId extends Identity {

    public ConductorCarroId(){}

    private ConductorCarroId(String id){
        super(id);
    }

    public static ConductorCarroId of(String id){
        return new ConductorCarroId(id);
    }

}
