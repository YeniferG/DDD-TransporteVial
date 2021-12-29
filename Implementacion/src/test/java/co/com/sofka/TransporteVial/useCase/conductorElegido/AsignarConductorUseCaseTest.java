package co.com.sofka.TransporteVial.useCase.conductorElegido;

import co.com.sofka.TransporteVial.domain.generico.enums.CategoriaAutorizada;
import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.LicenciaConduccion;
import co.com.sofka.TransporteVial.domain.generico.values.NombreCompleto;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands.AsignarConductor;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.enums.TipoConductor;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events.ConductorAsignado;
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
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsignarConductorUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void asignarConductorElegido(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        ConductorId conductorId = ConductorId.of("yyyy");
        TipoDocumento tipoDocumento = TipoDocumento.CEDULA_DE_CIUDADANIA;
        NombreCompleto nombreCompleto = new NombreCompleto("Juan Pablo", "Lopez Estrada");
        Direccion direccion = new Direccion("Calle 2 # 93d-30");
        Telefono telefono = new Telefono("6427527");
        TipoConductor tipoConductor = TipoConductor.CARRO;
        LicenciaConduccion licenciaConduccion = new LicenciaConduccion(LocalDate.of(2022, Month.APRIL, 15), CategoriaAutorizada.C1);

        var command = new AsignarConductor(servicioId,conductorId,tipoDocumento,nombreCompleto,direccion,telefono,tipoConductor,licenciaConduccion);
        var useCase = new AsignarConductorUseCase();

        //act

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        ConductorAsignado event = (ConductorAsignado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getEntityId().value());
        Assertions.assertEquals(tipoDocumento.name(), event.getTipoDocumento().name());
        Assertions.assertEquals(nombreCompleto.value(), event.getNombreCompleto().value());
        Assertions.assertEquals(direccion.value(), event.getDireccion().value());
        Assertions.assertEquals(telefono.value(), event.getTelefono().value());
        Assertions.assertEquals(tipoConductor.name(), event.getTipoConductor().name());
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