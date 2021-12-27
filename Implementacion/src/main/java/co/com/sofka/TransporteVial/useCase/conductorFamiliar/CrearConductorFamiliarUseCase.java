package co.com.sofka.TransporteVial.useCase.conductorFamiliar;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.ConductorFamiliar;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands.CrearConductorFamiliar;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearConductorFamiliarUseCase extends UseCase<RequestCommand<CrearConductorFamiliar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearConductorFamiliar> requestCommand) {

        var command = requestCommand.getCommand();

        var conductorFamiliar = new ConductorFamiliar(
                command.getEntityId(),
                command.getValorServicio(),
                command.getTiempo()
        );

        emit().onResponse(new ResponseEvents(conductorFamiliar.getUncommittedChanges()));
    }
}
