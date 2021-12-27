package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.Servicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.events.*;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.*;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class ConductorFamiliar extends Servicio {

    protected Valor valorServicio;
    protected Tiempo tiempo;
    protected ConductorCarro conductor;

    public ConductorFamiliar(ServicioId entityId, Valor valorServicio, Tiempo tiempo) {
        super(entityId);
        appendChange(new ConductorFamiliarCreado(entityId, valorServicio, tiempo)).apply();

    }

    public ConductorFamiliar(ServicioId entityId){
        super(entityId);
        subscribe(new ConductorFamiliarChange(this));
    }

    public static ConductorFamiliar from(ServicioId servicioId, List<DomainEvent> events){
        var conductorFamiliar = new ConductorFamiliar(servicioId);
        events.forEach(conductorFamiliar::applyEvent);
        return conductorFamiliar;
    }

    public void actualizarTiempoServicio(Tiempo tiempo){
        appendChange(new TiempoServicioActualizado(tiempo)).apply();
    }

    public void actualizarValorServicio(Valor valorServicio){
        appendChange(new ValorServicioActualizado(valorServicio)).apply();
    }

    public void asignarConductorCarro(ServicioId servicioId, ConductorCarroId entityId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion){
        appendChange(new ConductorCarroAsignado(servicioId, entityId, tipoDocumento, nombreCompleto, direccion, telefono, licenciaConduccion)).apply();
    }

    public void actualizarDatosPersonalesDeConductorCarro(ConductorCarroId conductorCarroId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion){
        appendChange(new DatosPersonalesDeConductorCarroActualizados(conductorCarroId, tipoDocumento, nombreCompleto, direccion, telefono, licenciaConduccion)).apply();
    }

    public void actualizarDisponibilidadDeConductorCarro(ConductorCarroId conductorCarroId, Disponibilidad disponibilidad){
        appendChange(new DisponibilidadDeConductorCarroActualizada(conductorCarroId, disponibilidad)).apply();
    }

    public void actualizarEstadoAsignacionDeConductorCarro(ServicioId servicioId, ConductorCarroId conductorCarroId){
        appendChange(new EstadoAsignacionSevicioDeConductorCarroActualizado(servicioId,conductorCarroId)).apply();
    }

    public Valor valorServicio() {
        return valorServicio;
    }

    public Tiempo tiempo() {
        return tiempo;
    }

    public ConductorCarro conductor() {
        return conductor;
    }
}
