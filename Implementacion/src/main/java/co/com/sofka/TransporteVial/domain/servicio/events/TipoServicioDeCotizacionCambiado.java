package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.servicio.enums.TipoServicio;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoServicioDeCotizacionCambiado extends DomainEvent {

    private final CotizacionId cotizacionId;
    private final TipoServicio tipoServicio;

    public TipoServicioDeCotizacionCambiado(CotizacionId cotizacionId, TipoServicio tipoServicio) {
        super("sofka.servicio.tipoServicioDeCotizacionCambiado");
        this.cotizacionId = cotizacionId;
        this.tipoServicio = tipoServicio;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }
}
