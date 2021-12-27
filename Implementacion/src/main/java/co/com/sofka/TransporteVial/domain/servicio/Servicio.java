package co.com.sofka.TransporteVial.domain.servicio;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.enums.Estado;
import co.com.sofka.TransporteVial.domain.servicio.enums.TipoPersona;
import co.com.sofka.TransporteVial.domain.servicio.events.*;
import co.com.sofka.TransporteVial.domain.servicio.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Servicio extends AggregateEvent<ServicioId> {

    protected Descripcion descripcion;
    protected FechaConHora fecha;
    protected Estado estado;
    protected Aliado aliado;
    protected Cotizacion cotizacion;

    public Servicio(ServicioId entityId, Descripcion descripcion, FechaConHora fecha, Estado estado) {
        super(entityId);
        this.descripcion = Objects.requireNonNull(descripcion);
        this.fecha = Objects.requireNonNull(fecha);
        this.estado = Objects.requireNonNull(estado);
        appendChange(new ServicioCreado(entityId,descripcion,fecha,estado)).apply();
    }

    public Servicio(ServicioId entityId){
        super(entityId);
        subscribe(new ServicioChange(this));
    }

    public static Servicio from(ServicioId servicioId, List<DomainEvent> events){
        var servicio = new Servicio(servicioId);
        events.forEach(servicio::applyEvent);
        return servicio;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionActualizada(descripcion)).apply();
    }
    
    public void actualizarFechaConHora(FechaConHora fecha){
        Objects.requireNonNull(fecha);
        appendChange(new FechaConHoraActualizada(fecha)).apply();
    }
    
    public void actualizarEstado(Estado estado){
        Objects.requireNonNull(estado);
        appendChange(new EstadoActualizado(estado)).apply();
    }

    public void agregarAliado(ServicioId servicioId, AliadoId aliadoId, TipoDocumento tipoDocumento, TipoPersona tipoPersona, Nombre nombre, Email email, Direccion direccion, Telefono telefono, Vehiculo datosVehiculo){
        Objects.requireNonNull(aliadoId);
        Objects.requireNonNull(tipoDocumento);
        Objects.requireNonNull(tipoPersona);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(email);
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(telefono);
        Objects.requireNonNull(datosVehiculo);
        appendChange(new AliadoAgregado(servicioId, aliadoId, tipoDocumento, tipoPersona, nombre, email, direccion, telefono, datosVehiculo)).apply();
    }

    public void actualizarDatosPersonalesDeAliado(AliadoId aliadoId, TipoDocumento tipoDocumento, TipoPersona tipoPersona, Nombre nombre, Email email, Direccion direccion, Telefono telefono){
        appendChange(new DatosPersonalesDeAfiliadoActualizados(aliadoId, tipoDocumento, tipoPersona, nombre, email, direccion, telefono)).apply();
    }

    public void actualizarDatosVehiculoDeAliado(AliadoId aliadoId, Vehiculo datosVehiculo){
        appendChange(new DatosVehiculoDeAliadoActualizados(aliadoId, datosVehiculo)).apply();
    }

    public void agregarCotizacion(ServicioId servicioId, CotizacionId cotizacionId, DireccionInicial direccionInicial, DireccionDestino direccionDestino){
        appendChange(new CotizacionAgregada(servicioId, cotizacionId, direccionInicial, direccionDestino)).apply();
    }

    public void actualizarDireccionInicialDeCotizacion(CotizacionId cotizacionId, DireccionInicial direccionInicial){
        appendChange(new DireccionInicialDeCotizacionActualizada(cotizacionId, direccionInicial)).apply();
    }

    public void actualizarDireccionDestinoDeCotizacion(CotizacionId cotizacionId, DireccionDestino direccionDestino){
        appendChange(new DireccionDestinoDeCotizacionActualizada(cotizacionId, direccionDestino)).apply();
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public FechaConHora fecha() {
        return fecha;
    }

    public Estado estado() {
        return estado;
    }

    public Aliado aliado() {
        return aliado;
    }

    public Cotizacion cotizacion() {
        return cotizacion;
    }
}
