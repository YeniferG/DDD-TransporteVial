package co.com.sofka.TransporteVial.domain.servicio;

import co.com.sofka.TransporteVial.domain.servicio.events.*;
import co.com.sofka.TransporteVial.domain.servicio.values.AliadoId;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.domain.generic.EventChange;

public class ServicioChange extends EventChange {

    public ServicioChange(Servicio servicio) {

        apply((ServicioCreado event) -> {
            servicio.descripcion = event.getDescripcion();
            servicio.fecha = event.getFecha();
            servicio.estado = event.getEstado();
        });

        apply((DescripcionActualizada event) -> {
            servicio.descripcion = event.getDescripcion();
        });
        
        apply((FechaConHoraActualizada event) -> {
            servicio.fecha = event.getFecha();
        });
        
        apply((EstadoActualizado event) -> {
            servicio.estado = event.getEstado();
        });

        apply((AfiliadoAgregado event) -> {
            servicio.aliado = new Aliado(
                    new AliadoId(),
                    event.getTipoDocumento(),
                    event.getTipoPersona(),
                    event.getNombre(),
                    event.getEmail(),
                    event.getDireccion(),
                    event.getTelefono(),
                    event.getDatosVehiculo());
        });

        apply((DatosPersonalesDeAfiliadoActualizados event) -> {
            servicio.aliado.actualizarDatosPersonales(
                    event.getTipoDocumento(),
                    event.getTipoPersona(),
                    event.getNombre(),
                    event.getEmail(),
                    event.getDireccion(),
                    event.getTelefono());
        });

        apply((DatosVehiculoDeAliadoActualizados event) -> {
            servicio.aliado.actualizarDatosVehiculo(event.getDatosVehiculo());
        });

        apply((CotizacionAgregada event) -> {
            servicio.cotizacion = new Cotizacion(
                    new CotizacionId(),
                    event.getSolicitante(),
                    event.getDireccionInicial(),
                    event.getDireccionDestino(),
                    event.getTipoServicio());
        });

        apply((DireccionInicialDeCotizacionActualizada event) -> {
            servicio.cotizacion.actualizarDireccionInicial(event.getDireccionInicial());
        });

        apply((DireccionDestinoDeCotizacionActualizada event) -> {
            servicio.cotizacion.actualizarDireccionDestino(event.getDireccionDestino());
        });

        apply((SolicitanteDeCotizacionActualizado event) -> {
            servicio.cotizacion.actualizarSolicitante(event.getSolicitante());
        });

        apply((TipoServicioDeCotizacionCambiado event) -> {
            servicio.cotizacion.cambiarTipoServicio(event.getTipoServicio());
        });

    }
}
