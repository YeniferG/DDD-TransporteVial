package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Tiempo;
import co.com.sofka.domain.generic.Command;

public class ActualizarTiempoServicio extends Command {

    private final Tiempo tiempo;

    public ActualizarTiempoServicio(Tiempo tiempo) {
        this.tiempo = tiempo;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }
}
