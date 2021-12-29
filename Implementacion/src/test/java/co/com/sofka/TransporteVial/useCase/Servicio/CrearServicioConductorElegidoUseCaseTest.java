package co.com.sofka.TransporteVial.useCase.Servicio;

import co.com.sofka.TransporteVial.domain.generico.values.*;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events.ConductorElegidoCreado;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.events.CotizacionAgregada;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CrearServicioConductorElegidoUseCaseTest {

    @Test
    void crearServicioConductorElegidoUseCaseTest(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        CotizacionId cotizacionId = CotizacionId.of("yyyy");
        DireccionInicial direccionInicial = new DireccionInicial(new Municipio("Bogota"), "Calle 45 # 56-12");
        DireccionDestino direccionDestino = new DireccionDestino(new Municipio("Bogota"), "Calle 193 # 100-65");

        var eventCotizacionAgregada = new CotizacionAgregada(servicioId,cotizacionId,direccionInicial,direccionDestino);
        var useCase = new CrearServicioConductorElegidoUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new TriggeredEvent<>(eventCotizacionAgregada))
                .orElseThrow();

        //asserts

        ConductorElegidoCreado event = (ConductorElegidoCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.getServicioId().value());
        Assertions.assertEquals(new ValorServicio(direccionInicial, direccionDestino).value(), event.getValorServicio().value());

    }

}