package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;


public class Caracteristica implements ValueObject<String> {

    private final String caracteristica;

    public Caracteristica(String caracteristica, Placa placa, Marca marca, Referencia referencia) {
        this.caracteristica = Objects.requireNonNull(generarCaracteristicaGeneral(placa, marca, referencia));
        if(this.caracteristica.isBlank()){
            throw new IllegalArgumentException("La caracteristica no puede estar vacía");
        }
    }

    public String generarCaracteristicaGeneral(Placa placa, Marca marca, Referencia referencia){
        return placa + "\n" + marca + "\n" + referencia + "\n";
    }

    @Override
    public String value() {
        return caracteristica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caracteristica that = (Caracteristica) o;
        return caracteristica.equals(that.caracteristica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caracteristica);
    }
}
