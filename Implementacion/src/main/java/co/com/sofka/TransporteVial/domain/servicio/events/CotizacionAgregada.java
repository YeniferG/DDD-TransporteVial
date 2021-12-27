package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class CotizacionAgregada extends DomainEvent {


    private final ServicioId servicioId;
    private final CotizacionId cotizacionId;
    private final DireccionInicial direccionInicial;
    private final DireccionDestino direccionDestino;

    public CotizacionAgregada(ServicioId servicioId, CotizacionId cotizacionId, DireccionInicial direccionInicial, DireccionDestino direccionDestino) {
        super("sofka.servicio.cotizacionAgregada");
        this.servicioId = servicioId;
        this.cotizacionId = cotizacionId;
        this.direccionInicial = direccionInicial;
        this.direccionDestino = direccionDestino;
    }

    public ServicioId getServicioId(){
        return servicioId;
    }
    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public DireccionInicial getDireccionInicial() {
        return direccionInicial;
    }

    public DireccionDestino getDireccionDestino() {
        return direccionDestino;
    }
}
