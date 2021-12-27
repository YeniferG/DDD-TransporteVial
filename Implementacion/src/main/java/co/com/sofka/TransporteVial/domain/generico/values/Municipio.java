package co.com.sofka.TransporteVial.domain.generico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Municipio implements ValueObject<String> {

    private final String municipio;

    public Municipio(String municipio) {
        this.municipio = Objects.requireNonNull(municipio);
        if(this.municipio.isBlank()){
            throw new IllegalArgumentException("El municipio no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return municipio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipio municipio1 = (Municipio) o;
        return Objects.equals(municipio, municipio1.municipio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(municipio);
    }
}
