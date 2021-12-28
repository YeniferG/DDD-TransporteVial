package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.generico.enums.EstadoAsignacionServicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events.*;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.domain.generic.EventChange;

public class ConductorElegidoChange extends EventChange {

    public ConductorElegidoChange(ConductorElegido conductorElegido) {

        apply((ConductorElegidoCreado event) -> {
            conductorElegido.valorServicio = event.getValorServicio();
        });

        apply((ValorServicioActualizado event) -> {
            conductorElegido.valorServicio = event.getValorServicio();
        });

        apply((ConductorAsignado event) -> {
            if(conductorElegido.conductores.size() > 0){
                if(conductorElegido.conductores.get(0).tipoConductor().name().equals(event.getTipoConductor().name())){
                    throw  new IllegalArgumentException("El conductor asignado ya existe para este servicio");
                }
            }
            conductorElegido.conductores.add(new Conductor(
                    event.getEntityId(),
                    event.getTipoDocumento(),
                    event.getNombreCompleto(),
                    event.getDireccion(),
                    event.getTelefono(),
                    event.getTipoConductor(),
                    Disponibilidad.INACTIVO,
                    event.getLicenciaConduccion(),
                    EstadoAsignacionServicio.EN_VERIFICACION));

        });

        apply((DatosPersonalesDeConductorActualizados event) -> {
            var funcion = conductorElegido.getConductorById(event.getConductorId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra el conductor"));
            funcion.actualizarDatosPersonales(event.getTipoDocumento(), event.getNombreCompleto(), event.getDireccion(), event.getTelefono(), event.getLicenciaConduccion());
        });

        apply((DisponibilidadDeConductorActualizada event) -> {
            var funcion = conductorElegido.getConductorById(event.getConductorId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra el conductor"));
            funcion.actualizarDisponibilidad(event.getDisponibilidad());
        });

        apply((EstadoAsignacionSevicioDeConductorActualizado event) -> {
            var funcion = conductorElegido.getConductorById(event.getConductorId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra el conductor"));
            funcion.actualizarEstadoAsignacionServicio();
        });



    }
}
