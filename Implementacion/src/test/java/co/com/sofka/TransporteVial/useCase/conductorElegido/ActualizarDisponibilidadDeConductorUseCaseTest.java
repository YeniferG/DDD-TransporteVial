package co.com.sofka.TransporteVial.useCase.conductorElegido;

import co.com.sofka.TransporteVial.domain.generico.enums.CategoriaAutorizada;
import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands.ActualizarDisponibilidadDeConductor;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.enums.TipoConductor;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events.ConductorAsignado;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events.DisponibilidadDeConductorActualizada;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.enums.Estado;
import co.com.sofka.TransporteVial.domain.servicio.events.ServicioCreado;
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

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarDisponibilidadDeConductorUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarDisponibilidadDeConductorUseCaseTest(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        ConductorId conductorId = ConductorId.of("yyyy");
        Disponibilidad disponibilidad = Disponibilidad.INACTIVO;

        var command = new ActualizarDisponibilidadDeConductor(servicioId, conductorId, disponibilidad);
        var useCase = new ActualizarDisponibilidadDeConductorUseCase();

        //act

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        DisponibilidadDeConductorActualizada event = (DisponibilidadDeConductorActualizada) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getConductorId().value());
        Assertions.assertEquals(disponibilidad.name(), event.getDisponibilidad().name());
        Mockito.verify(repository).getEventsBy("xxxx");

    }

    private List<DomainEvent> eventList(){
        return List.of(new ServicioCreado(
                        ServicioId.of("xxxx"),
                        new Descripcion("xxxxxxx"),
                        new FechaConHora(2021, 12, 28, 8, 30),
                        Estado.EN_DESPLAZAMIENTO
                        ),
                        new ConductorAsignado(
                        ServicioId.of("xxxx"),
                        ConductorId.of("yyyy"),
                        TipoDocumento.CEDULA_DE_CIUDADANIA,
                        new NombreCompleto("Juan Pablo", "Lopez Estrada"),
                        new Direccion("Calle 2 # 93d-30"),
                        new Telefono("6427527"),
                        TipoConductor.CARRO,
                        new LicenciaConduccion(LocalDate.of(2022, Month.APRIL, 15), CategoriaAutorizada.C1))
        );
    }

}