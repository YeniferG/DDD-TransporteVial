package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {

    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
        if(this.descripcion.isBlank()){
            throw new IllegalArgumentException("La descripcion no puede estar vacía");
        }
        if(this.descripcion.length()>300){
            throw new IllegalArgumentException("La descripcion no puede tener más de trecientos caracteres");
        }
    }

    @Override
    public String value() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion that = (Descripcion) o;
        return descripcion.equals(that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion);
    }
}
