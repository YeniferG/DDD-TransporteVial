package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.servicio.enums.Estado;
import co.com.sofka.TransporteVial.domain.servicio.values.Descripcion;
import co.com.sofka.TransporteVial.domain.servicio.values.FechaConHora;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class CrearServicio extends Command {

    private final ServicioId servicioId;
    private final Descripcion descripcion;
    private final FechaConHora fecha;
    private final Estado estado;

    public CrearServicio(ServicioId servicioId, Descripcion descripcion, FechaConHora fecha, Estado estado) {
        this.servicioId = servicioId;
        this.descripcion = Objects.requireNonNull(descripcion);
        this.fecha = Objects.requireNonNull(fecha);
        this.estado = Objects.requireNonNull(estado);
    }

    public ServicioId getServicioId() {
        return servicioId;
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
