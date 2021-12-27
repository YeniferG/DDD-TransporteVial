package co.com.sofka.TransporteVial.useCase;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.ConductorElegido;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.events.CotizacionAgregada;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class CrearServicioConductorElegidoUseCase extends UseCase<TriggeredEvent<CotizacionAgregada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CotizacionAgregada> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();

        if(event.getDireccionInicial().value().isBlank() || event.getDireccionDestino().value().isBlank()){
            throw new BusinessException(event.getServicioId().value(), "Las direcciones no pueden estar vacias para generar el servicio");
        }

        var serivicioConductorElegido = new ConductorElegido(
                event.getServicioId(),
                new ValorServicio(event.getDireccionInicial(), event.getDireccionDestino())
        );

        emit().onResponse(new ResponseEvents(serivicioConductorElegido.getUncommittedChanges()));

    }

}
