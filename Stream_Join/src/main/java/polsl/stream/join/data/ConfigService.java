package polsl.stream.join.data;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import polsl.stream.join.data.algorithm.AlgorithmClass;
import polsl.stream.join.data.model.Config;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@Service
public class ConfigService {

    private final AlgorithmClass algorithmClass;

    private final CsvReader csvReader;

    private final List<String> files = Arrays.stream(new String[]
            { "INNER", "RIGHT OUTER", "LEFT OUTER", "LEFT", "RIGHT", "THETA" }).toList();

    public ConfigService(AlgorithmClass algorithmClass, CsvReader csvReader) {
        this.algorithmClass = algorithmClass;
        this.csvReader = csvReader;
    }

    public List<String> getJoinTypes() {
        return this.files;
    }

    public void saveToFile(List<?> returned, Config config) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(
                    config.getFirstFile() + "_" + config.getSecondFile() + "_" + LocalDateTime.now().getNano() + ".data");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(returned);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> startAlgorithm(Config configClass) {
        Stream<?> returned;
        if (configClass.getAutomatic()) {
            int iterator = 0;
            while (true) {
                configClass.setFirstFile(csvReader.getFileNames().get(iterator));
                iterator++;
                configClass.setSecondFile(csvReader.getFileNames().get(iterator));
                iterator++;
                if (iterator >= 5) {
                    iterator = 0;
                }
                configClass.setJoinType(files.get(ThreadLocalRandom.current().nextInt(0, 4)));
                returned = algorithmClass.initializeFlux(configClass);
                if (returned == null) {
                    break;
                } else {
                    this.saveToFile(returned.toList(), configClass);
                }
            }
        } else {
            returned = algorithmClass.initializeFlux(configClass);
            if (returned == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Csv files mismatch");
            }
        }
        assert returned != null;
        return returned.map(Object::toString).toList();
    }
}
