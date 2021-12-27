package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Vehiculo implements ValueObject<String> {

    private final String caracteristicaVehiculo;

    public Vehiculo(Caracteristica caracteristica) {
        this.caracteristicaVehiculo = Objects.requireNonNull(caracteristica.toString());
        if(this.caracteristicaVehiculo.isBlank()){
            throw new IllegalArgumentException("La caracteristica del vehiculo no puede estar vacía");
        }
    }

    @Override
    public String value() {
        return caracteristicaVehiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(caracteristicaVehiculo, vehiculo.caracteristicaVehiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caracteristicaVehiculo);
    }
}
