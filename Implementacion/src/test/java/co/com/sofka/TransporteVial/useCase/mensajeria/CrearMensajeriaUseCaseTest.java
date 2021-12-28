package co.com.sofka.TransporteVial.useCase.mensajeria;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.commands.CrearMendsajeria;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events.MensajeriaCreada;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.Valor;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearMensajeriaUseCaseTest {

    @Test
    void crearMensajeriaUseCaseTest(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        Valor valorServicio = new Valor(13000.00);

        var command = new CrearMendsajeria(servicioId, valorServicio);
        var useCase = new CrearMensajeriaUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        MensajeriaCreada event = (MensajeriaCreada)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals(valorServicio.value(), event.getValorServicio().value());

    }

}