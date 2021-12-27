package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Marca implements ValueObject<String> {

    private final String marca;

    public Marca(String marca) {
        this.marca = Objects.requireNonNull(marca);
        if(this.marca.isBlank()){
            throw new IllegalArgumentException("La marca no puede estar vacío");
        }
    }

    @Override
    public String value() {
        return marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca1 = (Marca) o;
        return marca.equals(marca1.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca);
    }
}
