package co.com.sofka.TransporteVial.useCase.mensajeria;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.Mensajeria;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.commands.CrearMendsajeria;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearMensajeriaUseCase extends UseCase<RequestCommand<CrearMendsajeria>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearMendsajeria> requestCommand) {

        var command = requestCommand.getCommand();

        var mensajeria = new Mensajeria(
                command.getEntityId(),
                command.getValorServicio()
        );

        emit().onResponse(new ResponseEvents(mensajeria.getUncommittedChanges()));
    }
}
