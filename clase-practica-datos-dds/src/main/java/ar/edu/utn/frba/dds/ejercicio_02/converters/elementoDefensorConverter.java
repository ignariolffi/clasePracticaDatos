package ar.edu.utn.frba.dds.ejercicio_02.converters;

import ar.edu.utn.frba.dds.ejercicio_02.elementos.Arco;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.ElementoDefensor;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.Escudo;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.Espada;
import ar.edu.utn.frba.dds.ejercicio_02.personajes.Ladron;
import ar.edu.utn.frba.dds.ejercicio_02.personajes.Mago;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class elementoDefensorConverter implements AttributeConverter<ElementoDefensor, String> {
    @Override
    public String convertToDatabaseColumn(ElementoDefensor elemento) {
        if (elemento instanceof Arco) {
            return "arco";
        } else if (elemento instanceof Espada) {
            return "espada";
        } else if (elemento instanceof Escudo) {
            return "escudo";
        }
        return null;
    }

    @Override
    public ElementoDefensor convertToEntityAttribute(String dbData) {
        if ("arco".equals(dbData)) {
            return new Arco();
        } else if ("escudo".equals(dbData)) {
            return new Escudo();
        } else if ("espada".equals(dbData)) {
            return new Espada();
        }
        return null;
    }
}
