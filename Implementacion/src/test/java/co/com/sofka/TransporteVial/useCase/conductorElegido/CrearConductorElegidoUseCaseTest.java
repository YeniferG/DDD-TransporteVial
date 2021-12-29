package co.com.sofka.TransporteVial.useCase.conductorElegido;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.generico.values.Municipio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands.CrearConductorElegido;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events.ConductorElegidoCreado;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearConductorElegidoUseCaseTest {

    @Test
    void crearConductorElegidoUseCaseTest(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");

        ValorServicio valorServicio = new ValorServicio(new DireccionInicial(new Municipio("Bogota"), "Calle 51 # 14-60"), new DireccionDestino(new Municipio("Bogota"), "Calle 2 # 93d-30"));
        var command = new CrearConductorElegido(servicioId, valorServicio);
        var useCase = new CrearConductorElegidoUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        ConductorElegidoCreado event = (ConductorElegidoCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals(valorServicio.value(), event.getValorServicio().value());

    }

}