package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.generico.enums.EstadoAsignacionServicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.*;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.events.*;
import co.com.sofka.domain.generic.EventChange;

public class ConductorFamiliarChange extends EventChange {

    public ConductorFamiliarChange(ConductorFamiliar conductorFamiliar) {

        apply((ConductorFamiliarCreado event) -> {
            conductorFamiliar.valorServicio = event.getValorServicio();
            conductorFamiliar.tiempo = event.getTiempo();
        });

        apply((TiempoServicioActualizado event) -> {
            conductorFamiliar.tiempo = event.getTiempo();
        });

        apply((ValorServicioActualizado event) -> {
            conductorFamiliar.valorServicio = event.getValorServicio();
        });

        apply((ConductorCarroAsignado event) -> {
            conductorFamiliar.conductor = new ConductorCarro(
                    new ConductorCarroId(),
                    event.getTipoDocumento(),
                    event.getNombreCompleto(),
                    event.getDireccion(),
                    event.getTelefono(),
                    Disponibilidad.INACTIVO,
                    event.getLicenciaConduccion(),
                    EstadoAsignacionServicio.EN_VERIFICACION);
        });

        apply((DatosPersonalesDeConductorCarroActualizados event) -> {
            conductorFamiliar.conductor.actualizarDatosPersonales(
                    event.getTipoDocumento(),
                    event.getNombreCompleto(),
                    event.getDireccion(),
                    event.getTelefono(),
                    event.getLicenciaConduccion());
        });

        apply((DisponibilidadDeConductorCarroActualizada event) -> {
            conductorFamiliar.conductor.actualizarDisponibilidad(event.getDisponibilidad());
        });

        apply((EstadoAsignacionSevicioDeConductorCarroActualizado event) -> {
            conductorFamiliar.conductor.actualizarEstadoAsignacionServicio();
        });



    }
}
