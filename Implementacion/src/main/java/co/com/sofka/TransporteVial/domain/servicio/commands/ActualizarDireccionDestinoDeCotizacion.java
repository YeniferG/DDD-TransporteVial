package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDireccionDestinoDeCotizacion extends Command {

    private final CotizacionId cotizacionId;
    private final DireccionDestino direccionDestino;

    public ActualizarDireccionDestinoDeCotizacion(CotizacionId cotizacionId, DireccionDestino direccionDestino){
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
