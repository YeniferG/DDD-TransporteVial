package co.com.sofka.TransporteVial.useCase.Servicio;

import co.com.sofka.TransporteVial.domain.servicio.commands.CrearServicio;
import co.com.sofka.TransporteVial.domain.servicio.enums.Estado;
import co.com.sofka.TransporteVial.domain.servicio.events.ServicioCreado;
import co.com.sofka.TransporteVial.domain.servicio.values.Descripcion;
import co.com.sofka.TransporteVial.domain.servicio.values.FechaConHora;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CrearServicioUseCaseTest {

    @Test
    void crearServicioUseCaseTest(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        Descripcion descripcion = new Descripcion("xxxxxxx");
        FechaConHora fechaConHora = new FechaConHora(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().plusDays(1).getDayOfMonth(), LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
        Estado estado = Estado.EN_DESPLAZAMIENTO;

        var command = new CrearServicio(servicioId, descripcion, fechaConHora, estado);
        var useCase = new CrearServicioUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        ServicioCreado event = (ServicioCreado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("xxxxxxx", event.getDescripcion().value());
        Assertions.assertEquals(fechaConHora.value(), event.getFecha().value());
        Assertions.assertEquals(estado, event.getEstado());

    }

}