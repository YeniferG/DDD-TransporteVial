package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.Servicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events.*;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.Valor;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Mensajeria extends Servicio {

    protected Valor valorServicio;
    protected ConductorMotorizado conductor;

    public Mensajeria(ServicioId entityId, Valor valorServicio) {
        super(entityId);
        this.valorServicio = Objects.requireNonNull(valorServicio);
        appendChange(new MensajeriaCreada(entityId, valorServicio)).apply();

    }

    public Mensajeria(ServicioId entityId){
        super(entityId);
        subscribe(new MensajeriaChange(this));
    }

    public static Mensajeria from(ServicioId servicioId, List<DomainEvent> events){
        var mensajeria = new Mensajeria(servicioId);
        events.forEach(mensajeria::applyEvent);
        return mensajeria;
    }

    public void actualizarValorServicio(Valor valorServicio){
        appendChange(new ValorServicioActualizado(valorServicio)).apply();
    }

    public void asignarConductor(ServicioId servicioId, ConductorMotorizadoId entityId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion){
        appendChange(new ConductorMotorizadoAsignado(servicioId, entityId, tipoDocumento, nombreCompleto, direccion, telefono, licenciaConduccion)).apply();
    }

    public void actualizarDatosPersonalesDeConductorMotorizado(ConductorMotorizadoId conductorMotorizadoId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion){
        appendChange(new DatosPersonalesDeConductorMotorizadoActualizados(conductorMotorizadoId, tipoDocumento, nombreCompleto, direccion, telefono, licenciaConduccion)).apply();
    }

    public void actualizarDisponibilidadDeConductorMotorizado(ConductorMotorizadoId conductorMotorizadoId, Disponibilidad disponibilidad){
        appendChange(new DisponibilidadDeConductorMotorizadoActualizada(conductorMotorizadoId, disponibilidad)).apply();
    }

    public void actualizarEstadoAsignacionDeConductorMotorizado(ServicioId servicioId, ConductorMotorizadoId conductorMotorizadoId){
        appendChange(new EstadoAsignacionServicioDeConductorMotorizadoActualizado(servicioId,conductorMotorizadoId)).apply();
    }

    public Valor valorServicio() {
        return valorServicio;
    }

    public ConductorMotorizado conductor() {
        return conductor;
    }
}
