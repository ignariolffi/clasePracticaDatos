package ar.edu.utn.frba.dds.ejercicio_02.converters;

import ar.edu.utn.frba.dds.ejercicio_02.elementos.Arco;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.ElementoDefensor;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.Escudo;
import ar.edu.utn.frba.dds.ejercicio_02.elementos.Espada;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Converter(autoApply = true)
    public class localDateConverter implements AttributeConverter<LocalDate, Date> {
        @Override
        public Date convertToDatabaseColumn(LocalDate elemento) {
            if (elemento!=null) {
                return Date.from(elemento.atStartOfDay(ZoneId.systemDefault()).toInstant());
            }
            return null;
        }

        @Override
        public LocalDate convertToEntityAttribute(Date dbData) {
            if (dbData!=null) {
                return Instant.ofEpochMilli(dbData.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            }
            return null;
        }
    }

