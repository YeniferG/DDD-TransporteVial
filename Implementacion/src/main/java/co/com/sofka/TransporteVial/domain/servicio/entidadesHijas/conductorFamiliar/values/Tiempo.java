package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values;

import co.com.sofka.domain.generic.ValueObject;

public class Tiempo implements ValueObject<Tiempo.Properties> {

    private final String tiempo;
    private final Integer duracion;

    public Tiempo(String tiempo, Integer duracion) {
        this.tiempo = tiempo;
        this.duracion = duracion;
    }


    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String tiempo() {
                return tiempo;
            }

            @Override
            public Integer duracion() {
                return duracion;
            }
        };
    }

    public interface Properties {
        String tiempo();
        Integer duracion();
    }

}
