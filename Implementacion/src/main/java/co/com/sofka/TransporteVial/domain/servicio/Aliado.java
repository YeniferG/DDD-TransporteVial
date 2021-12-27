package co.com.sofka.TransporteVial.domain.servicio;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.enums.TipoPersona;
import co.com.sofka.TransporteVial.domain.servicio.values.AliadoId;
import co.com.sofka.TransporteVial.domain.servicio.values.Email;
import co.com.sofka.TransporteVial.domain.servicio.values.Nombre;
import co.com.sofka.TransporteVial.domain.servicio.values.Vehiculo;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Aliado extends Entity<AliadoId> {

    protected TipoDocumento tipoDocumento;
    protected TipoPersona tipoPersona;
    protected Nombre nombre;
    protected Email email;
    protected Direccion direccion;
    protected Telefono telefono;
    protected Vehiculo datosVehiculo;

    public Aliado(AliadoId entityId, TipoDocumento tipoDocumento, TipoPersona tipoPersona, Nombre nombre, Email email, Direccion direccion, Telefono telefono, Vehiculo datosVehiculo) {
        super(entityId);
        this.tipoDocumento = Objects.requireNonNull(tipoDocumento);
        this.tipoPersona = Objects.requireNonNull(tipoPersona);
        this.nombre = Objects.requireNonNull(nombre);
        this.email = Objects.requireNonNull(email);
        this.direccion = Objects.requireNonNull(direccion);
        this.telefono = Objects.requireNonNull(telefono);
        this.datosVehiculo = Objects.requireNonNull(datosVehiculo);
    }

    public void actualizarDatosPersonales(TipoDocumento tipoDocumento, TipoPersona tipoPersona, Nombre nombre, Email email, Direccion direccion, Telefono telefono){

        this.tipoDocumento = Objects.requireNonNull(tipoDocumento);
        this.tipoPersona = Objects.requireNonNull(tipoPersona);
        this.nombre = Objects.requireNonNull(nombre);
        this.email = Objects.requireNonNull(email);
        this.direccion = Objects.requireNonNull(direccion);
        this.telefono = Objects.requireNonNull(telefono);

    }

    public void actualizarDatosVehiculo(Vehiculo datosVehiculo){
        this.datosVehiculo = datosVehiculo;
    }

    public TipoDocumento tipoDocumento() {
        return tipoDocumento;
    }

    public TipoPersona tipoPersona() {
        return tipoPersona;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Email email() {
        return email;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Telefono telefono() {
        return telefono;
    }

    public Vehiculo datosVehiculo() {
        return datosVehiculo;
    }
}
