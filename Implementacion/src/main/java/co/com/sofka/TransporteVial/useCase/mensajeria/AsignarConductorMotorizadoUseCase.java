package co.com.sofka.TransporteVial.useCase.mensajeria;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.ConductorMotorizado;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.Mensajeria;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.commands.AsignarConductorMotorizado;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsignarConductorMotorizadoUseCase extends UseCase<RequestCommand<AsignarConductorMotorizado>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarConductorMotorizado> requestCommand) {

        var command = requestCommand.getCommand();

        var servicioMensajeria = Mensajeria.from(command.getServicioId(), retrieveEvents());

        if(servicioMensajeria.conductor() != null){
            throw new BusinessException(command.getConductorMotorizadoId().value(), "No puede asignar mas de un conductor");
        }

        servicioMensajeria.asignarConductorMotorizado(
                command.getServicioId(),
                command.getConductorMotorizadoId(),
                command.getTipoDocumento(),
                command.getNombreCompleto(),
                command.getDireccion(),
                command.getTelefono(),
                command.getLicenciaConduccion()
        );

        emit().onResponse(new ResponseEvents(servicioMensajeria.getUncommittedChanges()));
    }
}
