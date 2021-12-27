package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.servicio.enums.TipoServicio;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.TransporteVial.domain.servicio.values.Solicitante;
import co.com.sofka.domain.generic.Command;

public class AgregarCotizacion extends Command {

    private final CotizacionId cotizacionId;
    private final Solicitante solicitante;
    private final DireccionInicial direccionInicial;
    private final DireccionDestino direccionDestino;
    private final TipoServicio tipoServicio;

    public AgregarCotizacion(CotizacionId cotizacionId, Solicitante solicitante, DireccionInicial direccionInicial, DireccionDestino direccionDestino, TipoServicio tipoServicio){
        this.cotizacionId = cotizacionId;
        this.solicitante = solicitante;
        this.direccionInicial = direccionInicial;
        this.direccionDestino = direccionDestino;
        this.tipoServicio = tipoServicio;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public DireccionInicial getDireccionInicial() {
        return direccionInicial;
    }

    public DireccionDestino getDireccionDestino() {
        return direccionDestino;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }
}