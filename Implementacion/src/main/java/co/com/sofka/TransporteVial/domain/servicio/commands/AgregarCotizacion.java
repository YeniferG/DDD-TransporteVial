package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class AgregarCotizacion extends Command {

    private final ServicioId servicioId;
    private final CotizacionId cotizacionId;
    private final DireccionInicial direccionInicial;
    private final DireccionDestino direccionDestino;

    public AgregarCotizacion(ServicioId servicioId, CotizacionId cotizacionId, DireccionInicial direccionInicial, DireccionDestino direccionDestino){
        this.servicioId = servicioId;
        this.cotizacionId = cotizacionId;
        this.direccionInicial = direccionInicial;
        this.direccionDestino = direccionDestino;
    }


    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public DireccionInicial getDireccionInicial() {
        return direccionInicial;
    }

    public DireccionDestino getDireccionDestino() {
        return direccionDestino;
    }

}
