package co.com.sofka.TransporteVial.useCase.Servicio;

import co.com.sofka.TransporteVial.domain.servicio.Servicio;
import co.com.sofka.TransporteVial.domain.servicio.commands.AgregarCotizacion;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarCotizacionUseCase extends UseCase<RequestCommand<AgregarCotizacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCotizacion> requestCommand) {
        var command = requestCommand.getCommand();

        if((command.getDireccionInicial().value().municipio().value().isBlank() || command.getDireccionDestino().value().municipio().value().isBlank())
            && (command.getDireccionInicial().value().direccion().isBlank() || command.getDireccionDestino().value().direccion().isBlank())){
            throw new BusinessException(command.getServicioId().value(), "Las direcciones no pueden estar vacias para generar la cotizacion");
        }

        var servicio = Servicio.from(ServicioId.of(command.getServicioId().value()),retrieveEvents());

        servicio.agregarCotizacion(
                command.getServicioId(),
                command.getCotizacionId(),
                command.getDireccionInicial(),
                command.getDireccionDestino()
        );

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));

    }

}
