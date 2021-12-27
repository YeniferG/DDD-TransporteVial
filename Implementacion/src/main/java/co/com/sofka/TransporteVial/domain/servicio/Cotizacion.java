package co.com.sofka.TransporteVial.domain.servicio;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cotizacion extends Entity<CotizacionId> {

    protected DireccionInicial direccionInicial;
    protected DireccionDestino direccionDestino;

    public Cotizacion(CotizacionId entityId, DireccionInicial direccionInicial, DireccionDestino direccionDestino       ) {
        super(entityId);
        this.direccionInicial = Objects.requireNonNull(direccionInicial);
        this.direccionDestino = Objects.requireNonNull(direccionDestino);
    }

    public void actualizarDireccionInicial(DireccionInicial direccionInicial){
        this.direccionInicial = direccionInicial;
    }

    public void actualizarDireccionDestino(DireccionDestino direccionDestino){
        this.direccionDestino = direccionDestino;
    }


    public DireccionInicial direccionInicial() {
        return direccionInicial;
    }

    public DireccionDestino direccionDestino() {
        return direccionDestino;
    }

}
