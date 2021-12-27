package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.servicio.values.FechaConHora;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaConHora extends Command {

    private final FechaConHora fechaConHora;

    public ActualizarFechaConHora(FechaConHora fechaConHora){
        this.fechaConHora = fechaConHora;
    }

    public FechaConHora getFechaConHora() {
        return fechaConHora;
    }
}
