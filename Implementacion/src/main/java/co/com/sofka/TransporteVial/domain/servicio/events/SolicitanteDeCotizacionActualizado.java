package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.TransporteVial.domain.servicio.values.Solicitante;
import co.com.sofka.domain.generic.DomainEvent;

public class SolicitanteDeCotizacionActualizado extends DomainEvent {

    private final CotizacionId cotizacionId;
    private final Solicitante solicitante;

    public SolicitanteDeCotizacionActualizado(CotizacionId cotizacionId, Solicitante solicitante) {
        super("sofka.servicio.solicitanteDeCotizacionActualizado");
        this.cotizacionId = cotizacionId;
        this.solicitante = solicitante;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }
}
