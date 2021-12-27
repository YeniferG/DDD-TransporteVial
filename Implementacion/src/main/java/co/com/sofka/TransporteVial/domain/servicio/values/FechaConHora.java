package co.com.sofka.TransporteVial.domain.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FechaConHora implements ValueObject<String> {

    private final String fecha;

    public FechaConHora(Integer anio, Integer mes, Integer dia, Integer hora, Integer minutos) {
        this.fecha = generarFechaConHoraToString(anio, mes, dia, hora, minutos);
    }

    public String generarFechaConHoraToString(Integer anio, Integer mes, Integer dia, Integer hora, Integer minutos){
        var fechaConHora = LocalDateTime.of(anio,mes,dia,hora,minutos);
        if (fechaConHora.isBefore(LocalDateTime.now()) || fechaConHora.equals(LocalDateTime.now())){
            throw new IllegalArgumentException("La fecha no puede ser inferior o igual a la fecha actual");
        }
        return LocalDateTime.of(anio,mes,dia,hora,minutos).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String value() {
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaConHora that = (FechaConHora) o;
        return fecha.equals(that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }
}
