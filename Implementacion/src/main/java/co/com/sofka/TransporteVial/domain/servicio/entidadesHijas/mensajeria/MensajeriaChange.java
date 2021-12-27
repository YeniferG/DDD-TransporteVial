package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.generico.enums.EstadoAsignacionServicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events.*;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
import co.com.sofka.domain.generic.EventChange;

public class MensajeriaChange extends EventChange {

    public MensajeriaChange(Mensajeria mensajeria) {

        apply((MensajeriaCreada event) -> {
            mensajeria.valorServicio = event.getValorServicio();
        });

        apply((ValorServicioActualizado event) -> {
            mensajeria.valorServicio = event.getValorServicio();
        });

        apply((ConductorMotorizadoAsignado event) -> {

            mensajeria.conductor = new ConductorMotorizado(
                    new ConductorMotorizadoId(),
                    event.getTipoDocumento(),
                    event.getNombreCompleto(),
                    event.getDireccion(),
                    event.getTelefono(),
                    Disponibilidad.INACTIVO,
                    event.getLicenciaConduccion(),
                    EstadoAsignacionServicio.EN_VERIFICACION);

        });

        apply((DatosPersonalesDeConductorMotorizadoActualizados event) -> {
            mensajeria.conductor.actualizarDatosPersonales(
                    event.getTipoDocumento(),
                    event.getNombreCompleto(),
                    event.getDireccion(),
                    event.getTelefono(),
                    event.getLicenciaConduccion()
            );
        });

        apply((DisponibilidadDeConductorMotorizadoActualizada event) -> {
            mensajeria.conductor.actualizarDisponibilidad(event.getDisponibilidad());
        });

        apply((EstadoAsignacionServicioDeConductorMotorizadoActualizado event) -> {
            mensajeria.conductor.actualizarEstadoAsignacionServicio();
        });



    }
}
