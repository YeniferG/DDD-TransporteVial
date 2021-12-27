package co.com.sofka.TransporteVial.useCase;

import co.com.sofka.TransporteVial.domain.servicio.Servicio;
import co.com.sofka.TransporteVial.domain.servicio.commands.CrearServicio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearServicioUseCase extends UseCase<RequestCommand<CrearServicio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearServicio> requestCommand) {

        var command = requestCommand.getCommand();

        var servicio = new Servicio(
            command.getServicioId(),
            command.getDescripcion(),
            command.getFecha(),
            command.getEstado()
        );

        emit().onResponse(new  ResponseEvents(servicio.getUncommittedChanges()));

    }


}
