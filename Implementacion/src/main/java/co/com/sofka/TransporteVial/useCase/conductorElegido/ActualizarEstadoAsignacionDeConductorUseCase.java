package co.com.sofka.TransporteVial.useCase.conductorElegido;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.ConductorElegido;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events.ConductorAsignado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarEstadoAsignacionDeConductorUseCase extends UseCase<TriggeredEvent<ConductorAsignado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ConductorAsignado> triggeredEvent) {

        var event = triggeredEvent.getDomainEvent();
        var servicioConductorElegido = ConductorElegido.from(event.getServicioId(),retrieveEvents());

        servicioConductorElegido.actualizarEstadoAsignacionDeConductor(event.getServicioId(), event.getEntityId());

        emit().onResponse(new ResponseEvents(servicioConductorElegido.getUncommittedChanges()));

    }

}
