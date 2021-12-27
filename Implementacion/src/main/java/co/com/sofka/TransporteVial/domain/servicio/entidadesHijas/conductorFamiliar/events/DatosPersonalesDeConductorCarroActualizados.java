package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.events;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.ConductorCarroId;
import co.com.sofka.domain.generic.DomainEvent;

public class DatosPersonalesDeConductorCarroActualizados extends DomainEvent {

    private final ConductorCarroId conductorCarroId;
    private final TipoDocumento tipoDocumento;
    private final NombreCompleto nombreCompleto;
    private final Direccion direccion;
    private final Telefono telefono;
    private final LicenciaConduccion licenciaConduccion;

    public DatosPersonalesDeConductorCarroActualizados(ConductorCarroId conductorCarroId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion) {
        super("sofka.conductorFamiliar.datosPersonalesDeConductorCarroActualizados");
        this.conductorCarroId = conductorCarroId;
        this.tipoDocumento = tipoDocumento;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.licenciaConduccion = licenciaConduccion;
    }

    public ConductorCarroId getConductorCarroId() {
        return conductorCarroId;
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
