package polsl.stream.join.data;

import org.springframework.stereotype.Service;
import polsl.stream.join.data.algorithm.AlgorithmClass;
import polsl.stream.join.data.model.Config;

import java.util.Arrays;
import java.util.List;

@Service
public class ConfigService {

    private final CsvReader csvReader;

    private final List<String> files = Arrays.stream(new String[]
            { "INNER" }).toList();

    public ConfigService(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    public List<String> getJoinTypes() {
        return this.files;
    }

    public void startAlgorithm(Config configClass) {
        var algorithmClass = new AlgorithmClass(configClass, csvReader);
    }
}
