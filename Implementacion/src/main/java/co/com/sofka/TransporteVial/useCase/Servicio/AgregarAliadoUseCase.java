package co.com.sofka.TransporteVial.useCase.Servicio;

import co.com.sofka.TransporteVial.domain.servicio.Servicio;
import co.com.sofka.TransporteVial.domain.servicio.commands.AgregarAliado;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarAliadoUseCase extends UseCase<RequestCommand<AgregarAliado>, ResponseEvents> {
    
    
    @Override
    public void executeUseCase(RequestCommand<AgregarAliado> requestCommand) {

        var command = requestCommand.getCommand();

        var servicio = Servicio.from(ServicioId.of(command.getServicioId().value()),retrieveEvents());

        if(servicio.aliado() != null){
            throw new BusinessException(command.getAliadoId().value(), "No puede agregar más de un aliado");
        }

        servicio.agregarAliado(
            command.getServicioId(),
            command.getAliadoId(),
            command.getTipoDocumento(),
            command.getTipoPersona(),
            command.getNombre(),
            command.getEmail(),
            command.getDireccion(),
            command.getTelefono(),
            command.getDatosVehiculo()
        );

        emit().onResponse(new ResponseEvents(servicio.getUncommittedChanges()));

    }
}
