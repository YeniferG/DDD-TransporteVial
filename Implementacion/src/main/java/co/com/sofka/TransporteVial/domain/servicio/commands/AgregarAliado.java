package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.enums.TipoPersona;
import co.com.sofka.TransporteVial.domain.servicio.values.AliadoId;
import co.com.sofka.TransporteVial.domain.servicio.values.Email;
import co.com.sofka.TransporteVial.domain.servicio.values.Nombre;
import co.com.sofka.TransporteVial.domain.servicio.values.Vehiculo;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class AgregarAliado extends Command {

    private final AliadoId aliadoId;
    private final TipoDocumento tipoDocumento;
    private final TipoPersona tipoPersona;
    private final Nombre nombre;
    private final Email email;
    private final Direccion direccion;
    private final Telefono telefono;
    private final Vehiculo datosVehiculo;

    public AgregarAliado(AliadoId aliadoId, TipoDocumento tipoDocumento, TipoPersona tipoPersona, Nombre nombre, Email email, Direccion direccion, Telefono telefono, Vehiculo datosVehiculo) {
        this.aliadoId = Objects.requireNonNull(aliadoId);
        this.tipoDocumento = Objects.requireNonNull(tipoDocumento);
        this.tipoPersona = Objects.requireNonNull(tipoPersona);
        this.nombre = Objects.requireNonNull(nombre);
        this.email = Objects.requireNonNull(email);
        this.direccion = Objects.requireNonNull(direccion);
        this.telefono = Objects.requireNonNull(telefono);
        this.datosVehiculo = Objects.requireNonNull(datosVehiculo);
    }

    public AliadoId getAliadoId() {
        return aliadoId;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Vehiculo getDatosVehiculo() {
        return datosVehiculo;
    }
}
