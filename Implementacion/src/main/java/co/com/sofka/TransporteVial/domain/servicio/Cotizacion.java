package co.com.sofka.TransporteVial.domain.servicio;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.servicio.enums.TipoServicio;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.TransporteVial.domain.servicio.values.Solicitante;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Cotizacion extends Entity<CotizacionId> {

    protected Solicitante solicitante;
    protected DireccionInicial direccionInicial;
    protected DireccionDestino direccionDestino;
    protected TipoServicio tipoServicio;

    public Cotizacion(CotizacionId entityId, Solicitante solicitante, DireccionInicial direccionInicial, DireccionDestino direccionDestino, TipoServicio tipoServicio) {
        super(entityId);
        this.solicitante = Objects.requireNonNull(solicitante);
        this.direccionInicial = Objects.requireNonNull(direccionInicial);
        this.direccionDestino = Objects.requireNonNull(direccionDestino);
        this.tipoServicio = Objects.requireNonNull(tipoServicio);
    }

    public void actualizarDireccionInicial(DireccionInicial direccionInicial){
        this.direccionInicial = direccionInicial;
    }

    public void actualizarDireccionDestino(DireccionDestino direccionDestino){
        this.direccionDestino = direccionDestino;
    }

    public void actualizarSolicitante(Solicitante solicitante){
        this.solicitante = solicitante;
    }

    public void cambiarTipoServicio(TipoServicio tipoServicio){
        this.tipoServicio = tipoServicio;
    }

    public Solicitante solicitante() {
        return solicitante;
    }

    public DireccionInicial direccionInicial() {
        return direccionInicial;
    }

    public DireccionDestino direccionDestino() {
        return direccionDestino;
    }

    public TipoServicio tipoServicio() {
        return tipoServicio;
    }
}
