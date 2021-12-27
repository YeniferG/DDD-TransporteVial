package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Referencia implements ValueObject<String> {

    private final String referencia;

    public Referencia(String referencia) {
        this.referencia = Objects.requireNonNull(referencia);
        if(this.referencia.isBlank()){
            throw new IllegalArgumentException("La referencia no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return referencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Referencia that = (Referencia) o;
        return Objects.equals(referencia, that.referencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referencia);
    }
}
