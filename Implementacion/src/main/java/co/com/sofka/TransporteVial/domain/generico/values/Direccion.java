package co.com.sofka.TransporteVial.domain.generico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {

    private final String direccion;

    public Direccion(String direccion) {
        this.direccion = Objects.requireNonNull(direccion);
        if(this.direccion.isBlank()){
            throw new IllegalArgumentException("La direccion no puede estar vacía");
        }
        if(this.direccion.length()<3){
            throw new IllegalArgumentException("La direccion no puede tener menos de cuatro caractéres");
        }
        if(this.direccion.length()>100){
            throw new IllegalArgumentException("La direccion no puede tener más de cien caractéres");
        }
    }

    @Override
    public String value() {
        return direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion1 = (Direccion) o;
        return Objects.equals(direccion, direccion1.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion);
    }
}
