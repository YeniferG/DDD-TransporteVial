package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.enums.TipoConductor;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class ConductorMotorizadoAsignado extends DomainEvent {

    private final ServicioId servicioId;
    private final ConductorMotorizadoId entityId;
    private final TipoDocumento tipoDocumento;
    private final NombreCompleto nombreCompleto;
    private final Direccion direccion;
    private final Telefono telefono;
    private final LicenciaConduccion licenciaConduccion;

    public ConductorMotorizadoAsignado(ServicioId servicioId, ConductorMotorizadoId entityId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion) {
        super("sofka.mensajeria.conductorMotorizadoAsignado");
        this.servicioId = servicioId;
        this.entityId = entityId;
        this.tipoDocumento = tipoDocumento;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.licenciaConduccion = licenciaConduccion;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ConductorMotorizadoId getEntityId() {
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
