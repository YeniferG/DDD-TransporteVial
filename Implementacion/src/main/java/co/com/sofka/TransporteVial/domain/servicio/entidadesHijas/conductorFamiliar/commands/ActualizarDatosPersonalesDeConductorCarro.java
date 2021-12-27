package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.ConductorCarroId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDatosPersonalesDeConductorCarro extends Command {

    private ConductorCarroId conductorCarroId;
    private TipoDocumento tipoDocumento;
    private NombreCompleto nombreCompleto;
    private Direccion direccion;
    private Telefono telefono;
    private LicenciaConduccion licenciaConduccion;

    public ActualizarDatosPersonalesDeConductorCarro(ConductorCarroId conductorCarroId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion){
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
