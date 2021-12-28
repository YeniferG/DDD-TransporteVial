package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values;

import co.com.sofka.domain.generic.Identity;

public class ConductorMotorizadoId extends Identity {

    public ConductorMotorizadoId(){}

    private ConductorMotorizadoId(String id){
        super(id);
    }

    public static ConductorMotorizadoId of(String id){
        return new ConductorMotorizadoId(id);
    }

}
