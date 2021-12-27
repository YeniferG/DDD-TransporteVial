package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDireccionInicialDeCotizacion extends Command {

    private final CotizacionId cotizacionId;
    private final DireccionInicial direccionInicial;

    public ActualizarDireccionInicialDeCotizacion(CotizacionId cotizacionId, DireccionInicial direccionInicial){
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
