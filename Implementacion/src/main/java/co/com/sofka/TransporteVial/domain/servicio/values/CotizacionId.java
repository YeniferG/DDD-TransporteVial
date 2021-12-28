package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.Identity;

public class CotizacionId extends Identity {

    public CotizacionId(){}

    private CotizacionId(String id){
        super(id);
    }

    public static CotizacionId of(String id){
        return new CotizacionId(id);
    }

}
