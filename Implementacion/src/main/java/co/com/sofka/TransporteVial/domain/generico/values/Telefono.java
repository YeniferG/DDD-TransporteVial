package co.com.sofka.TransporteVial.domain.generico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String telefono;

    public Telefono(String telefono){
        this.telefono = Objects.requireNonNull(telefono);
        if(this.telefono.isBlank()){
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if(this.telefono.length()<7){
            throw new IllegalArgumentException("El teléfono no puede tener menos de siete caracteres");
        }
        if(this.telefono.length()>10){
            throw new IllegalArgumentException("El teléfono no puede tener más de diez caracteres");
        }
        if (!this.telefono.matches("[0-9]*")){
            throw new IllegalArgumentException("El teléfono sólo puede incluir números");
        }
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono1 = (Telefono) o;
        return Objects.equals(telefono, telefono1.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono);
    }
}
