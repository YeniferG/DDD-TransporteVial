package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.servicio.values.AliadoId;
import co.com.sofka.TransporteVial.domain.servicio.values.Vehiculo;
import co.com.sofka.domain.generic.Command;

public class ActualizarDatosVehiculoDeAliado extends Command {

    private final AliadoId aliadoId;
    private final Vehiculo datosVerhiculo;

    public ActualizarDatosVehiculoDeAliado(AliadoId aliadoId, Vehiculo datosVerhiculo){
        this.aliadoId = aliadoId;
        this.datosVerhiculo = datosVerhiculo;
    }

    public AliadoId getAliadoId() {
        return aliadoId;
    }

    public Vehiculo getDatosVerhiculo() {
        return datosVerhiculo;
    }
}
