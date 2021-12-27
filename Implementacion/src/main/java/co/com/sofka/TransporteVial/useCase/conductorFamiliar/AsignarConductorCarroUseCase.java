package co.com.sofka.TransporteVial.useCase.conductorFamiliar;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.ConductorFamiliar;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands.AsignarConductorCarro;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AsignarConductorCarroUseCase extends UseCase<RequestCommand<AsignarConductorCarro>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarConductorCarro> requestCommand) {

        var command = requestCommand.getCommand();

        var servicioConductorFamiliar = ConductorFamiliar.from(command.getServicioId(), retrieveEvents());

        if(servicioConductorFamiliar.conductor() != null){
            throw new BusinessException(command.getEntityId().value(), "No puede asignar mas de un conductor");
        }

        servicioConductorFamiliar.asignarConductorCarro(
                command.getServicioId(),
                command.getEntityId(),
                command.getTipoDocumento(),
                command.getNombreCompleto(),
                command.getDireccion(),
                command.getTelefono(),
                command.getLicenciaConduccion()
        );

        emit().onResponse(new ResponseEvents(servicioConductorFamiliar.getUncommittedChanges()));
    }
}
