package com.imt.spring.infra.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Reservation {

    private int id;
    private LocalDateTime date;

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Reservation(int id, LocalDateTime date) {
        this.id = id;
        this.date = date;
    }

    public static SimpleModule getSerializerModule(){

        class ReservationSerializer extends JsonSerializer<Reservation> {
            @Override
            public void serialize(Reservation reservation, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeNumberField("id", reservation.getId());
                jsonGenerator.writeStringField("date", reservation.getDate().format(dateTimeFormatter));
                jsonGenerator.writeEndObject();
            }
        }

        SimpleModule module = new SimpleModule("ReservationDeserializer");
        module.addSerializer(Reservation.class, new ReservationSerializer());
        return module;
    }

    public static SimpleModule getDeserializerModule(){

        class ReservationDeserializer extends JsonDeserializer<Reservation> {

            @Override
            public Reservation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                ObjectCodec oc = jsonParser.getCodec();
                JsonNode node = oc.readTree(jsonParser);

                return new Reservation(node.get("id").intValue(), LocalDateTime.parse(node.get("date").asText(), dateTimeFormatter));
            }
        }

        SimpleModule module = new SimpleModule("ReservationDeserializer");
        module.addDeserializer(Reservation.class, new ReservationDeserializer());
        return module;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
