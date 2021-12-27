package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorServicio extends Command {

    private final ValorServicio valorServicio;

    public ActualizarValorServicio(ValorServicio valorServicio){
        this.valorServicio = valorServicio;
    }

    public ValorServicio getValorServicio() {
        return valorServicio;
    }
}
