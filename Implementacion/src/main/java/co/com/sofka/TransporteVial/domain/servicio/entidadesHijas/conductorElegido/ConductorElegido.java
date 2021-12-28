package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.Servicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.enums.TipoConductor;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events.*;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ConductorElegido extends Servicio {

    protected ValorServicio valorServicio;
    protected List<Conductor> conductores = new ArrayList<>();

    public ConductorElegido(ServicioId entityId, ValorServicio valorServicio) {
        super(entityId);
        this.valorServicio = Objects.requireNonNull(valorServicio);
        appendChange(new ConductorElegidoCreado(entityId, valorServicio)).apply();

    }

    public ConductorElegido(ServicioId entityId){
        super(entityId);
        subscribe(new ConductorElegidoChange(this));
    }

    public static ConductorElegido from(ServicioId servicioId, List<DomainEvent> events){
        var conductorElegido = new ConductorElegido(servicioId);
        events.forEach(conductorElegido::applyEvent);
        return conductorElegido;
    }

    public void actualizarValorServicio(ValorServicio valorServicio){
        appendChange(new ValorServicioActualizado(valorServicio)).apply();
    }

    public void asignarConductor(ServicioId servicioId, ConductorId entityId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, TipoConductor tipoConductor, LicenciaConduccion licenciaConduccion){
        appendChange(new ConductorAsignado(servicioId, entityId, tipoDocumento, nombreCompleto, direccion, telefono, tipoConductor, licenciaConduccion)).apply();
    }

    public void actualizarDatosPersonalesDeConductor(ConductorId conductorId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion){
        appendChange(new DatosPersonalesDeConductorActualizados(conductorId, tipoDocumento, nombreCompleto, direccion, telefono, licenciaConduccion)).apply();
    }

    public void actualizarDisponibilidadDeConductor(ConductorId conductorId, Disponibilidad disponibilidad){
        appendChange(new DisponibilidadDeConductorActualizada(conductorId, disponibilidad)).apply();
    }

    public void actualizarEstadoAsignacionDeConductor(ServicioId servicioId, ConductorId conductorId){
        appendChange(new EstadoAsignacionServicioDeConductorActualizado(servicioId,conductorId)).apply();
    }

    public Optional<Conductor> getConductorById(ConductorId entityId){
        return conductores
                .stream()
                .filter(conductor -> conductor.identity().value().equals(entityId.value()))
                .findFirst();
    }

    public ValorServicio valorServicio() {
        return valorServicio;
    }

    public List<Conductor> conductores() {
        return conductores;
    }
}
