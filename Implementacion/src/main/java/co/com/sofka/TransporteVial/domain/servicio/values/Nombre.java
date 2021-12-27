package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String nombre;

    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if(this.nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    @Override
    public String value() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre1 = (Nombre) o;
        return Objects.equals(nombre, nombre1.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
