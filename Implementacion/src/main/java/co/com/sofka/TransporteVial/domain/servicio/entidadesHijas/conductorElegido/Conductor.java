package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.generico.enums.EstadoAsignacionServicio;
import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.enums.TipoConductor;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Conductor extends Entity<ConductorId> {

    protected TipoDocumento tipoDocumento;
    protected NombreCompleto nombreCompleto;
    protected Direccion direccion;
    protected Telefono telefono;
    protected TipoConductor tipoConductor;
    protected Disponibilidad disponibilidad;
    protected LicenciaConduccion licenciaConduccion;
    protected EstadoAsignacionServicio estadoAsignacionServicio;

    public Conductor(ConductorId entityId,
                     TipoDocumento tipoDocumento,
                     NombreCompleto nombreCompleto,
                     Direccion direccion,
                     Telefono telefono,
                     TipoConductor tipoConductor,
                     Disponibilidad disponibilidad,
                     LicenciaConduccion licenciaConduccion,
                     EstadoAsignacionServicio estadoAsignacionServicio
    ) {
        super(entityId);
        this.tipoDocumento = Objects.requireNonNull(tipoDocumento);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
        this.direccion = Objects.requireNonNull(direccion);
        this.telefono = Objects.requireNonNull(telefono);
        this.tipoConductor = tipoConductor;
        this.disponibilidad = Objects.requireNonNull(disponibilidad);
        this.licenciaConduccion = Objects.requireNonNull(licenciaConduccion);
        this.estadoAsignacionServicio = Objects.requireNonNull(estadoAsignacionServicio);
    }

    public void actualizarDatosPersonales(TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion){
        this.tipoDocumento = Objects.requireNonNull(tipoDocumento);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
        this.direccion = Objects.requireNonNull(direccion);
        this.telefono = Objects.requireNonNull(telefono);
        this.licenciaConduccion = Objects.requireNonNull(licenciaConduccion);
    }

    public void actualizarDisponibilidad(Disponibilidad disponibilidad){
        this.disponibilidad = Objects.requireNonNull(disponibilidad);
    }

    public void actualizarEstadoAsignacionServicio(){
        if(this.licenciaConduccion.value()){
            this.estadoAsignacionServicio = EstadoAsignacionServicio.ASIGNADO;
        }else{
            this.estadoAsignacionServicio  = EstadoAsignacionServicio.RECHAZADO;
        }
    }

    public TipoDocumento tipoDocumento() {
        return tipoDocumento;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Telefono telefono() {
        return telefono;
    }

    public TipoConductor tipoConductor() {
        return tipoConductor;
    }

    public Disponibilidad disponibilidad() {
        return disponibilidad;
    }

    public LicenciaConduccion licenciaConduccion() {
        return licenciaConduccion;
    }

    public EstadoAsignacionServicio estadoAsignacionServicio() {
        return estadoAsignacionServicio;
    }
}
