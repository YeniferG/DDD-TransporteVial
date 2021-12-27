package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valor implements ValueObject<Double> {

    private final Double valor;

    public Valor(Double valor) {
        this.valor = Objects.requireNonNull(valor);
        if(this.valor < 0){
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
    }

    @Override
    public Double value() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valor valor1 = (Valor) o;
        return Objects.equals(valor, valor1.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
