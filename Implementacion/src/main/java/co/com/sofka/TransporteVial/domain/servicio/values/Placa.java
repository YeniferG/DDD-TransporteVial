package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Placa implements ValueObject<String> {

    private final String placa;

    public Placa(String placa) {
        this.placa = Objects.requireNonNull(placa);
        if(this.placa.isBlank()){
            throw new IllegalArgumentException("La placa no puede estar vacía");
        }
        if(this.placa.length() > 6 || this.placa.length() < 6){
            throw new IllegalArgumentException("La placa no puede tener mas de 6 caracteres ni menos de 6");
        }
    }

    @Override
    public String value() {
        return placa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Placa placa1 = (Placa) o;
        return Objects.equals(placa, placa1.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }
}
