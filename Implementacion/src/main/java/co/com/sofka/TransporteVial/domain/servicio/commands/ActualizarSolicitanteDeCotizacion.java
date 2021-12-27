package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.TransporteVial.domain.servicio.values.Solicitante;
import co.com.sofka.domain.generic.Command;

public class ActualizarSolicitanteDeCotizacion extends Command {

    private final CotizacionId cotizacionId;
    private final Solicitante solicitante;

    public ActualizarSolicitanteDeCotizacion(CotizacionId cotizacionId, Solicitante solicitante){
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
