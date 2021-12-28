package co.com.sofka.TransporteVial.useCase.conductorElegido;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.ConductorElegido;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands.ActualizarDisponibilidadDeConductor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarDisponibilidadDeConductorUseCase extends UseCase<RequestCommand<ActualizarDisponibilidadDeConductor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarDisponibilidadDeConductor> requestCommand) {

        var command = requestCommand.getCommand();
        var servicioConductorElegido = ConductorElegido.from(command.getServicioId(), retrieveEvents());

        servicioConductorElegido.actualizarDisponibilidadDeConductor(command.getConductorId(), command.getDisponibilidad());

        emit().onResponse(new ResponseEvents(servicioConductorElegido.getUncommittedChanges()));
    }
}
