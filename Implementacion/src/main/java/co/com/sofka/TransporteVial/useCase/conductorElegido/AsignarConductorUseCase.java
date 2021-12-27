package co.com.sofka.TransporteVial.useCase.conductorElegido;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.ConductorElegido;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands.AsignarConductor;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsignarConductorUseCase extends UseCase<RequestCommand<AsignarConductor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarConductor> requestCommand){
        var command = requestCommand.getCommand();

        var servicioConductorElegido = ConductorElegido.from(command.getServicioId(),retrieveEvents());

        if(servicioConductorElegido.conductores().size() > 2){
            throw new BusinessException(command.getEntityId().value(), "No puede asignar mas de dos conductores");
        }

        servicioConductorElegido.asignarConductor(
                command.getServicioId(),
                command.getEntityId(),
                command.getTipoDocumento(),
                command.getNombreCompleto(),
                command.getDireccion(),
                command.getTelefono(),
                command.getTipoConductor(),
                command.getLicenciaConduccion()
        );

        emit().onResponse(new ResponseEvents(servicioConductorElegido.getUncommittedChanges()));

    }

}
