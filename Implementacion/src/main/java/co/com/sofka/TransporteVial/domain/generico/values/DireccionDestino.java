package co.com.sofka.TransporteVial.domain.generico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DireccionDestino implements ValueObject<DireccionDestino.Properties> {

    private final Municipio municipio;
    private final String direccion;

    public DireccionDestino(Municipio municipio, String direccion) {
        this.municipio = Objects.requireNonNull(municipio);
        this.direccion = Objects.requireNonNull(direccion);
        if(this.municipio.value().isBlank() && this.direccion.isBlank()){
            throw new IllegalArgumentException("El municipio y la direccion no pueden estar vacios");
        }
    }

    @Override
    public Properties value(){
        return new Properties() {
            @Override
            public Municipio municipio() {
                return municipio;
            }

            @Override
            public String direccion() {
                return direccion;
            }
        };
    }

    public interface Properties{
        Municipio municipio();
        String direccion();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DireccionDestino that = (DireccionDestino) o;
        return Objects.equals(municipio, that.municipio) && Objects.equals(direccion, that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(municipio, direccion);
    }
}
