package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.domain.generic.DomainEvent;

public class DireccionInicialDeCotizacionActualizada extends DomainEvent {

    private final CotizacionId cotizacionId;
    private final DireccionInicial direccionInicial;

    public DireccionInicialDeCotizacionActualizada(CotizacionId cotizacionId, DireccionInicial direccionInicial) {
        super("sofka.servicio.DeCotizacionActualizada");
        this.cotizacionId = cotizacionId;
        this.direccionInicial = direccionInicial;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public DireccionInicial getDireccionInicial() {
        return direccionInicial;
    }
}
