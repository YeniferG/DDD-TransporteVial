package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.servicio.Aliado;
import co.com.sofka.TransporteVial.domain.servicio.Cotizacion;
import co.com.sofka.TransporteVial.domain.servicio.enums.Estado;
import co.com.sofka.TransporteVial.domain.servicio.values.Descripcion;
import co.com.sofka.TransporteVial.domain.servicio.values.FechaConHora;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class ServicioCreado extends DomainEvent {

    private final ServicioId entityId;
    private final Descripcion descripcion;
    private final FechaConHora fecha;
    private final Estado estado;

    public ServicioCreado(ServicioId entityId, Descripcion descripcion, FechaConHora fecha, Estado estado) {
        super("sofka.servicio.servicioCreado");

        this.entityId = entityId;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public ServicioId getEntityId() {
        return entityId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public FechaConHora getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }
}
