import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/18
 */
public class MapperHandler {


    public static void main(String[] args) throws IOException {

        String path = "";

        Reader reader = new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;

        String currentMapper;
        String currentId;
        List<String> sqlStack = new ArrayList<>();


        while((line = bufferedReader.readLine()) != null){

            if(line.trim().startsWith("<mapper")){
                String[] split = line.trim().split("namespace=");

                String mapper = split[1];
                String[] split1 = mapper.split("\"");

                currentMapper = split1[1];

            }

            if(line.trim().startsWith("<select") || line.trim().startsWith("<insert") || line.trim().startsWith("<update") || line.trim().startsWith("<delete")){

                sqlStack.clear();

                String[] ids = line.split("id");
                String id = ids[1];

            } else {
                sqlStack.add(line.trim());
            }
        }


    }

}
