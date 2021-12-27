package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valor implements ValueObject<Double> {

    private final Double valorServicio;

    public Valor(Double base, Tiempo tiempo) {
        if(tiempo.value().duracion() > 6 || tiempo.value().duracion() < 3){
            throw new IllegalArgumentException("La duracion del servicio no puede ser menor a 3 ni mayor a 6");
        }
        this.valorServicio = Objects.requireNonNull(calcularValorServicio(base, tiempo));
    }

    public Double calcularValorServicio(Double base, Tiempo tiempo){
        return base * tiempo.value().duracion();
    }

    @Override
    public Double value() {
        return valorServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valor valor = (Valor) o;
        return Objects.equals(valorServicio, valor.valorServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valorServicio);
    }
}
