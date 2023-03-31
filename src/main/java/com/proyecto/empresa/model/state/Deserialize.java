package com.proyecto.empresa.model.state;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.proyecto.empresa.enums.EState;

import java.io.IOException;

public class Deserialize extends JsonDeserializer<EState> {
    @Override
    public EState deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        int intValue = p.getValueAsInt();
        return EState.fromInt(intValue);
    }


}
