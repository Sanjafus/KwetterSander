/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Batch;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author Sander
 */
@Dependent
@Named
public class TweetReader extends AbstractItemReader {

    private JsonReader reader;
    private Gson gson;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                this.getClass().getClassLoader().getResourceAsStream("kwetterinput.json")));

       reader = new JsonReader(in);
       reader.beginObject();
       reader.nextName();
       reader.beginArray();
       gson = new Gson();
    }

    @Override
    public Object readItem() throws Exception {
        if (reader.hasNext()) {
            return gson.fromJson(reader, RawTweet.class);
        }
        return null;
    }
}
