package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.domain.generic.DomainEvent;

public class DireccionDestinoDeCotizacionActualizada extends DomainEvent {


    private final CotizacionId cotizacionId;
    private final DireccionDestino direccionDestino;

    public DireccionDestinoDeCotizacionActualizada(CotizacionId cotizacionId, DireccionDestino direccionDestino) {
        super("sofka.servicio.direccionDestinoDeCotizacionActualizada");
        this.cotizacionId = cotizacionId;
        this.direccionDestino = direccionDestino;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public DireccionDestino getDireccionDestino() {
        return direccionDestino;
    }
}
