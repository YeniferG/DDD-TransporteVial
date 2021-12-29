package co.com.sofka.TransporteVial.useCase.conductorFamiliar;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands.CrearConductorFamiliar;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.events.ConductorFamiliarCreado;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Tiempo;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Valor;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearConductorFamiliarUseCaseTest {

    @Test
    void crearConductorFamiliarUseCaseTest(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        Valor valorServicio = new Valor(10000.00, new Tiempo("horas", 3));
        Tiempo tiempo = new Tiempo("horas", 3);

        var command = new CrearConductorFamiliar(servicioId, valorServicio, tiempo);
        var useCase = new CrearConductorFamiliarUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        ConductorFamiliarCreado event = (ConductorFamiliarCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals(valorServicio.value(), event.getValorServicio().value());
        Assertions.assertEquals(tiempo.value().duracion(), event.getTiempo().value().duracion());


    }

}