package co.com.sofka.TransporteVial.domain.generico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject<String> {

    private final String nombres;

    public NombreCompleto(String nombres, String apellidos) {

        this.nombres = generarNombreCompleto(nombres, apellidos);
        if(this.nombres.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if(this.nombres.length()<3){
            throw new IllegalArgumentException("El nombre no puede tener menos de cuatro caractéres");
        }
        if(this.nombres.length()>50){
            throw new IllegalArgumentException("El nombre no puede tener más de cincuenta caractéres");
        }
        if(!this.nombres.matches("^[\\p{L} .'-]+$")){
            throw new IllegalArgumentException("El nombre no puede tener caracteres especiales ni números");
        }
    }

    public String generarNombreCompleto(String nombres, String apellidos){
        return nombres + " " + apellidos;
    }

    @Override
    public String value() {
        return nombres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NombreCompleto that = (NombreCompleto) o;
        return Objects.equals(nombres, that.nombres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombres);
    }
}
