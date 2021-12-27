package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String email;

    public Email(String email) {
        this.email = Objects.requireNonNull(email);
        if(this.email.isBlank()){
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if(this.email.length()<5){
            throw new IllegalArgumentException("El email no puede tener menos de cinco caracteres");
        }
        if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            throw new IllegalArgumentException("El email no es válido");
        }
    }

    @Override
    public String value() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return email.equals(email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
