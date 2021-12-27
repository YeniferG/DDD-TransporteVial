package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Valor;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorServicio extends Command {

    private final Valor valorServicio;

    public ActualizarValorServicio(Valor valorServicio){
        this.valorServicio = valorServicio;
    }

    public Valor getValorServicio() {
        return valorServicio;
    }
}
