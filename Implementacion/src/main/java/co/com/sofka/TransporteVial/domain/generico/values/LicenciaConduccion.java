package co.com.sofka.TransporteVial.domain.generico.values;

import co.com.sofka.TransporteVial.domain.generico.enums.CategoriaAutorizada;
import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LicenciaConduccion implements ValueObject<Boolean> {

    private List<CategoriaAutorizada> categoriasAutorizadas = new ArrayList<>();
    private final boolean licenciaConduccion;

    public LicenciaConduccion(LocalDate fechaVigencia, CategoriaAutorizada categoriasAutorizadas) {
        this.categoriasAutorizadas = Objects.requireNonNull(agregarCategoriaAutorizada(categoriasAutorizadas));
        this.licenciaConduccion = Objects.requireNonNull(vigenciaLicenciaConduccion(fechaVigencia));
    }

    public Boolean vigenciaLicenciaConduccion(LocalDate fechaVigencia){
        return fechaVigencia.isAfter(LocalDate.now());
    }

    public List<CategoriaAutorizada> agregarCategoriaAutorizada(CategoriaAutorizada categoriaAutorizada){
        this.categoriasAutorizadas.add(categoriaAutorizada);
        return this.categoriasAutorizadas;
    }

    @Override
    public Boolean value() {
        return licenciaConduccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenciaConduccion that = (LicenciaConduccion) o;
        return licenciaConduccion == that.licenciaConduccion && Objects.equals(categoriasAutorizadas, that.categoriasAutorizadas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoriasAutorizadas, licenciaConduccion);
    }
}
