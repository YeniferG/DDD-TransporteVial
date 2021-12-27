package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
import co.com.sofka.domain.generic.DomainEvent;

public class DatosPersonalesDeConductorMotorizadoActualizados extends DomainEvent {

    private final ConductorMotorizadoId conductorMotorizadoId;
    private final TipoDocumento tipoDocumento;
    private final NombreCompleto nombreCompleto;
    private final Direccion direccion;
    private final Telefono telefono;
    private final LicenciaConduccion licenciaConduccion;

    public DatosPersonalesDeConductorMotorizadoActualizados(ConductorMotorizadoId conductorMotorizadoId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion) {
        super("sofka.mensajeria.datosPersonalesDeConductorMotorizadoActualizados");
        this.conductorMotorizadoId = conductorMotorizadoId;
        this.tipoDocumento = tipoDocumento;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.licenciaConduccion = licenciaConduccion;
    }

    public ConductorMotorizadoId getConductorMotorizadoId() {
        return conductorMotorizadoId;
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
