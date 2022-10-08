package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import model.Library;

import java.io.File;
import java.io.IOException;

public class LibSerializer {
    private static final JsonMapper jsonMapper = new JsonMapper();
    private static final File file = new File("src/main/resources/library.json");
    private static Library lib = new Library();
    private ObjectMapper mapper;


    public LibSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public LibSerializer() {

    }

    public Library getLib(){
        try {
            file.createNewFile();
           return  mapper.readValue(file, Library.class);
        } catch (IOException e) {
            return new Library();
        }
    }

    public void saveLib(Library library){
        try {
            mapper.writeValue(file, library);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
