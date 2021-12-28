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
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AsignarConductorUseCaseTest {

    @Test
    void asignarConductorElegido(){

        //arrange

        ServicioId servicioId = ServicioId.of("xxxx");
        ConductorId conductorId = ConductorId.of("yyyy");
        TipoDocumento tipoDocumento = TipoDocumento.NIT;
        NombreCompleto nombreCompleto = new NombreCompleto("Juan Pablo", "Lopez Estrada");
        Direccion direccion = new Direccion("Calle 2 # 93d-30");
        Telefono telefono = new Telefono("6427527");
        TipoConductor tipoConductor = TipoConductor.CARRO;
        LicenciaConduccion licenciaConduccion = new LicenciaConduccion(LocalDate.of(2022, Month.APRIL, 15), CategoriaAutorizada.C1);

        var command = new AsignarConductor(servicioId,conductorId,tipoDocumento,nombreCompleto,direccion,telefono,tipoConductor,licenciaConduccion);
        var useCase = new AsignarConductorUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts

        ConductorAsignado event = (ConductorAsignado)events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getEntityId());
        Assertions.assertEquals(tipoDocumento.name(), event.getTipoDocumento().name());
        Assertions.assertEquals(nombreCompleto.value(), event.getNombreCompleto().value());
        Assertions.assertEquals(direccion.value(), event.getDireccion().value());
        Assertions.assertEquals(telefono.value(), event.getTelefono().value());
        Assertions.assertEquals(tipoConductor.name(), event.getTipoConductor().name());
        Assertions.assertEquals(licenciaConduccion.value(), event.getLicenciaConduccion().value());

    }

}