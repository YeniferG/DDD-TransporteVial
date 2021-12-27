package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.Identity;

public class AliadoId extends Identity {

    public AliadoId(){}

    private AliadoId(String id){
        super(id);
    }

    public static AliadoId of(String id){
        return new AliadoId();
    }

}
