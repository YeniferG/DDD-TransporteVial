package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDatosPersonalesDeConductorMotorizado extends Command {

    private ConductorMotorizadoId conductorMotorizadoId;
    private TipoDocumento tipoDocumento;
    private NombreCompleto nombreCompleto;
    private Direccion direccion;
    private Telefono telefono;
    private LicenciaConduccion licenciaConduccion;

    public ActualizarDatosPersonalesDeConductorMotorizado(ConductorMotorizadoId conductorMotorizadoId, TipoDocumento tipoDocumento, NombreCompleto nombreCompleto, Direccion direccion, Telefono telefono, LicenciaConduccion licenciaConduccion){
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
