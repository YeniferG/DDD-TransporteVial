package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.generico.enums.EstadoAsignacionServicio;
import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.enums.TipoConductor;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

import java.util.Objects;

public class AsignarConductor extends Command {

    private final ServicioId servicioId;
    private final ConductorId entityId;
    private final TipoDocumento tipoDocumento;
    private final NombreCompleto nombreCompleto;
    private final Direccion direccion;
    private final Telefono telefono;
    private final TipoConductor tipoConductor;
    private final LicenciaConduccion licenciaConduccion;

    public AsignarConductor(ServicioId servicioId, ConductorId entityId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, TipoConductor tipoConductor, LicenciaConduccion licenciaConduccion) {
        this.entityId = entityId;
        this.tipoDocumento = Objects.requireNonNull(tipoDocumento);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
        this.direccion = Objects.requireNonNull(direccion);
        this.telefono = Objects.requireNonNull(telefono);
        this.tipoConductor = tipoConductor;
        this.licenciaConduccion = Objects.requireNonNull(licenciaConduccion);
        this.servicioId = servicioId;
    }

    public ServicioId getServicioId(){
        return servicioId;
    }

    public ConductorId getEntityId() {
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

    public TipoConductor getTipoConductor() {
        return tipoConductor;
    }

    public LicenciaConduccion getLicenciaConduccion() {
        return licenciaConduccion;
    }
}
