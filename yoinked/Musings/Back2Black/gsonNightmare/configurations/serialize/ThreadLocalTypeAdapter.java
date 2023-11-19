package com.cbfacademy.apiassessment.serialize;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class ThreadLocalTypeAdapter extends TypeAdapter<ThreadLocal<?>> {

    
    /** 
     * @param out
     * @param value
     * @throws IOException
     */
    @Override
    public void write(JsonWriter out, ThreadLocal<?> value) throws IOException {
        return ;
    }

    @Override
    public ThreadLocal<?> read(JsonReader in) throws IOException {

        return null ;
    }
    
}
