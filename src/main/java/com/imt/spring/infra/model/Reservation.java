package com.imt.spring.infra.model;

import javax.persistence.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    public int id;

    @Column
    public long timestamp;

    @ManyToOne
    public Sillon sillon;

    @ManyToOne(fetch = FetchType.LAZY)
    public Course course;

//
//    public static SimpleModule getSerializerModule(){
//
//        class ReservationSerializer extends JsonSerializer<Reservation> {
//            @Override
//            public void serialize(Reservation reservation, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
//                jsonGenerator.writeStartObject();
//                jsonGenerator.writeNumberField("id", reservation.getId());
//                jsonGenerator.writeEndObject();
//            }
//        }
//
//        SimpleModule module = new SimpleModule("ReservationDeserializer");
//        module.addSerializer(Reservation.class, new ReservationSerializer());
//        return module;
//    }
//
//    public static SimpleModule getDeserializerModule(){
//
//        class ReservationDeserializer extends JsonDeserializer<Reservation> {
//
//            @Override
//            public Reservation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//                ObjectCodec oc = jsonParser.getCodec();
//                JsonNode node = oc.readTree(jsonParser);
//
//                return new Reservation(node.get("id").intValue());
//            }
//        }
//
//        SimpleModule module = new SimpleModule("ReservationDeserializer");
//        module.addDeserializer(Reservation.class, new ReservationDeserializer());
//        return module;
//    }
//
//    @Override
//    public String toString() {
//        return "Reservation{" +
//                "id=" + id +
//                '}';
//    }
}
