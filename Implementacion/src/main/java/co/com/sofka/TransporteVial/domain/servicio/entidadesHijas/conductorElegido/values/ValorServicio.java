package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values;

import co.com.sofka.TransporteVial.domain.generico.values.DireccionDestino;
import co.com.sofka.TransporteVial.domain.generico.values.DireccionInicial;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.Valor;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorServicio implements ValueObject<Double> {

    private final Double tarifaServicio;

    public ValorServicio (DireccionInicial direccionInicial, DireccionDestino direccionDestino){
        this.tarifaServicio = obtenerTarifaServicio(direccionInicial,direccionDestino);
    }

    private Double obtenerTarifaServicio(DireccionInicial direccionInicial,DireccionDestino direccionDestino){

        if(!(direccionInicial.value().municipio().equals("Bogota")) || !(direccionDestino.value().municipio().equals("Bogota"))){
            return 37.000;
        }
        return 27.000;
    }


    @Override
    public Double value() {
        return tarifaServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValorServicio that = (ValorServicio) o;
        return Objects.equals(tarifaServicio, that.tarifaServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tarifaServicio);
    }
}
