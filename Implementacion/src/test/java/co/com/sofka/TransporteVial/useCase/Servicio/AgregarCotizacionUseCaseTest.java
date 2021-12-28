package co.com.sofka.TransporteVial.useCase.Servicio;

import co.com.sofka.TransporteVial.domain.generico.values.*;
import co.com.sofka.TransporteVial.domain.servicio.commands.AgregarCotizacion;
import co.com.sofka.TransporteVial.domain.servicio.enums.Estado;
import co.com.sofka.TransporteVial.domain.servicio.events.CotizacionAgregada;
import co.com.sofka.TransporteVial.domain.servicio.events.ServicioCreado;
import co.com.sofka.TransporteVial.domain.servicio.values.CotizacionId;
import co.com.sofka.TransporteVial.domain.servicio.values.Descripcion;
import co.com.sofka.TransporteVial.domain.servicio.values.FechaConHora;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarCotizacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarCotizacionUseCaseTest(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        CotizacionId cotizacionId = CotizacionId.of("yyyy");
        DireccionInicial direccionInicial = new DireccionInicial(new Municipio("Bogota"), "Calle 107 # 56-65");
        DireccionDestino direccionDestino = new DireccionDestino(new Municipio("Bogota"), "Carrera 6 # 25-87");

        var command = new AgregarCotizacion(servicioId, cotizacionId, direccionInicial, direccionDestino);
        var useCase = new AgregarCotizacionUseCase();

        //act

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        CotizacionAgregada event = (CotizacionAgregada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getCotizacionId().value());
        Assertions.assertEquals(direccionInicial.value().municipio().value(), event.getDireccionInicial().value().municipio().value());
        Assertions.assertEquals(direccionDestino.value().direccion(), event.getDireccionDestino().value().direccion());
        Mockito.verify(repository).getEventsBy("xxxx");

    }

    private List<DomainEvent> eventList(){
        return List.of(new ServicioCreado(
                        ServicioId.of("xxxx"),
                        new Descripcion("xxxxxxx"),
                        new FechaConHora(2021, 12, 28, 8, 30),
                        Estado.EN_DESPLAZAMIENTO
                )
        );
    }

}