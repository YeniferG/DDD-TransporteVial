package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.servicio.values.AliadoId;
import co.com.sofka.TransporteVial.domain.servicio.values.Vehiculo;
import co.com.sofka.domain.generic.DomainEvent;

public class DatosVehiculoDeAliadoActualizados extends DomainEvent {

    private final AliadoId aliadoId;
    private final Vehiculo datosVehiculo;

    public DatosVehiculoDeAliadoActualizados(AliadoId aliadoId, Vehiculo datosVehiculo) {
        super("sofka.servicio.datsoVehiculoDeAliadoActualizados");
        this.aliadoId = aliadoId;
        this.datosVehiculo = datosVehiculo;
    }

    public AliadoId getAliadoId() {
        return aliadoId;
    }

    public Vehiculo getDatosVehiculo() {
        return datosVehiculo;
    }
}
