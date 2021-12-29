package co.com.sofka.TransporteVial.useCase.Servicio;

import co.com.sofka.TransporteVial.domain.generico.enums.TipoDocumento;
import co.com.sofka.TransporteVial.domain.generico.values.Direccion;
import co.com.sofka.TransporteVial.domain.generico.values.Telefono;
import co.com.sofka.TransporteVial.domain.servicio.commands.AgregarAliado;
import co.com.sofka.TransporteVial.domain.servicio.enums.Estado;
import co.com.sofka.TransporteVial.domain.servicio.enums.TipoPersona;
import co.com.sofka.TransporteVial.domain.servicio.events.AliadoAgregado;
import co.com.sofka.TransporteVial.domain.servicio.events.ServicioCreado;
import co.com.sofka.TransporteVial.domain.servicio.values.*;
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

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarAliadoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarAliadoUseCaseTest(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        AliadoId aliadoId = AliadoId.of("yyyy");
        TipoDocumento tipoDocumento = TipoDocumento.NIT;
        TipoPersona tipoPersona = TipoPersona.JURIDICA;
        Nombre nombre = new Nombre("Bolivar");
        Email email = new Email("bolivarcomstructora98@gmail.com");
        Direccion direccion = new Direccion("Calle 87 # 14-65");
        Telefono telefono = new Telefono("8756431");
        Vehiculo datosVehiculo = new Vehiculo(new Caracteristica(new Placa("SDR654"), new  Marca("Renauld"), new Referencia("Sandero")));

        var command = new AgregarAliado(servicioId, aliadoId, tipoDocumento, tipoPersona, nombre, email, direccion, telefono, datosVehiculo);
        var useCase = new AgregarAliadoUseCase();

        //act

        when(repository.getEventsBy("xxxx")).thenReturn(eventList());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        AliadoAgregado event = (AliadoAgregado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getAliadoId().value());
        Assertions.assertEquals(tipoDocumento.name(), event.getTipoDocumento().name());
        Assertions.assertEquals(tipoPersona.name(), event.getTipoPersona().name());
        Assertions.assertEquals(nombre.value(), event.getNombre().value());
        Assertions.assertEquals(email.value(), event.getEmail().value());
        Assertions.assertEquals(direccion.value(), event.getDireccion().value());
        Assertions.assertEquals(telefono.value(), event.getTelefono().value());
        Assertions.assertEquals(datosVehiculo.value(), event.getDatosVehiculo().value());
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