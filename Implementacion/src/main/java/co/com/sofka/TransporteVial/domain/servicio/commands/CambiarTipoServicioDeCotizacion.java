package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.servicio.enums.TipoServicio;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.domain.generic.Command;

public class CambiarTipoServicioDeCotizacion extends Command {

    private final CotizacionId cotizacionId;
    private final TipoServicio tipoServicio;

    public CambiarTipoServicioDeCotizacion(CotizacionId cotizacionId, TipoServicio tipoServicio){
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
