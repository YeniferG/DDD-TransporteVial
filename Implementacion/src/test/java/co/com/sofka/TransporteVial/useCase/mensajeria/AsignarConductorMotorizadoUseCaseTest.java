package co.com.sofka.TransporteVial.useCase.mensajeria;

import co.com.sofka.TransporteVial.domain.generico.enums.CategoriaAutorizada;
import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.commands.AsignarConductorMotorizado;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events.ConductorMotorizadoAsignado;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
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
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsignarConductorMotorizadoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void asignarConductorMotorizadoUseCaseTest(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        ConductorMotorizadoId conductorMotorizadoId = ConductorMotorizadoId.of("yyyy");
        TipoDocumento tipoDocumento = TipoDocumento.NIT;
        NombreCompleto nombreCompleto = new NombreCompleto("Juan Pablo", "Lopez Estrada");
        Direccion direccion = new Direccion("Calle 2 # 93d-30");
        Telefono telefono = new Telefono("6427527");
        LicenciaConduccion licenciaConduccion = new LicenciaConduccion(LocalDate.of(2022, Month.APRIL, 15), CategoriaAutorizada.C1);

        var command = new AsignarConductorMotorizado(servicioId, conductorMotorizadoId, tipoDocumento, nombreCompleto, direccion, telefono, licenciaConduccion);
        var useCase = new AsignarConductorMotorizadoUseCase();

        //act

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        ConductorMotorizadoAsignado event = (ConductorMotorizadoAsignado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getEntityId().value());
        Assertions.assertEquals(tipoDocumento.name(), event.getTipoDocumento().name());
        Assertions.assertEquals(nombreCompleto.value(), event.getNombreCompleto().value());
        Assertions.assertEquals(direccion.value(), event.getDireccion().value());
        Assertions.assertEquals(telefono.value(), event.getTelefono().value());
        Assertions.assertEquals(licenciaConduccion.value(), event.getLicenciaConduccion().value());
        Mockito.verify(repository).getEventsBy("xxxx");

    }

    private List<DomainEvent> eventList(){
        return List.of(new ServicioCreado(
                        ServicioId.of("xxxx"),
                        new Descripcion("xxxxxxx"),
                        new FechaConHora(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().plusDays(1).getDayOfMonth(), LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()),
                        Estado.EN_DESPLAZAMIENTO
                )
        );
    }

}