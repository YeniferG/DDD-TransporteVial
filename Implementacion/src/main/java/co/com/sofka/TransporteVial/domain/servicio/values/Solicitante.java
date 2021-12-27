package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Solicitante implements ValueObject<String> {

    private final String solicitante;

    public Solicitante(String solicitante) {
        this.solicitante = Objects.requireNonNull(solicitante);
        if(this.solicitante.isBlank()){
            throw new IllegalArgumentException("El solicitante no puede estar vacío");
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
        Solicitante that = (Solicitante) o;
        return Objects.equals(solicitante, that.solicitante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solicitante);
    }
}
