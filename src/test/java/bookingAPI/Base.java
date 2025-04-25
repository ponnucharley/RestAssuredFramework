package bookingAPI;

import org.example.utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {
    public static  Map<String,Object> dataFromJsonFile;

    static{
        String env = System.getProperty("env")==null?"qa":System.getProperty("env");//if env value is not set/null then it takes qa or else it takes value from System.getProperty
        try {
            dataFromJsonFile = JsonUtils.readFromJsonAsMap(env+"/Bookingdata.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
