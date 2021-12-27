package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.enums.TipoPersona;
import co.com.sofka.TransporteVial.domain.servicio.values.AliadoId;
import co.com.sofka.TransporteVial.domain.servicio.values.Email;
import co.com.sofka.TransporteVial.domain.servicio.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class ActualizarDatosPersonalesDeAliado extends Command {

    private final AliadoId aliadoId;
    private final TipoDocumento tipoDocumento;
    private final TipoPersona tipoPersona;
    private final Nombre nombre;
    private final Email email;
    private final Direccion direccion;
    private final Telefono telefono;

    public ActualizarDatosPersonalesDeAliado(AliadoId aliadoId, TipoDocumento tipoDocumento, TipoPersona tipoPersona, Nombre nombre, Email email, Direccion direccion, Telefono telefono){
        this.aliadoId = aliadoId;
        this.tipoDocumento = tipoDocumento;
        this.tipoPersona = tipoPersona;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
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
}
