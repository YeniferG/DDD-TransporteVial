package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.ConductorCarroId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class AsignarConductorCarro extends Command {

    private final ServicioId servicioId;
    private final ConductorCarroId entityId;
    private final TipoDocumento tipoDocumento;
    private final NombreCompleto nombreCompleto;
    private final Direccion direccion;
    private final Telefono telefono;
    private final LicenciaConduccion licenciaConduccion;

    public AsignarConductorCarro(ServicioId servicioId, ConductorCarroId entityId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion) {
        this.entityId = entityId;
        this.tipoDocumento = Objects.requireNonNull(tipoDocumento);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
        this.direccion = Objects.requireNonNull(direccion);
        this.telefono = Objects.requireNonNull(telefono);
        this.licenciaConduccion = Objects.requireNonNull(licenciaConduccion);
        this.servicioId = servicioId;
    }

    public ServicioId getServicioId(){
        return servicioId;
    }

    public ConductorCarroId getEntityId() {
        return entityId;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public LicenciaConduccion getLicenciaConduccion() {
        return licenciaConduccion;
    }
}
