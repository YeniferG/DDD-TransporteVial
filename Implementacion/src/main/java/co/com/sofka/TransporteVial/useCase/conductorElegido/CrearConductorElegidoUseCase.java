package co.com.sofka.TransporteVial.useCase.conductorElegido;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.ConductorElegido;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands.CrearConductorElegido;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearConductorElegidoUseCase extends UseCase<RequestCommand<CrearConductorElegido>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearConductorElegido> requestCommand) {

        var command = requestCommand.getCommand();

        var conductorElegido = new ConductorElegido(
                command.getEntityId(),
                command.getValorServicio()
        );

        emit().onResponse(new ResponseEvents(conductorElegido.getUncommittedChanges()));

    }
}
