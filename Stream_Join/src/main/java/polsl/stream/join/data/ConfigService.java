package polsl.stream.join.data;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import polsl.stream.join.data.algorithm.AlgorithmClass;
import polsl.stream.join.data.model.Config;

import java.util.Arrays;
import java.util.List;

@Service
public class ConfigService {

    private final AlgorithmClass algorithmClass;

    private final List<String> files = Arrays.stream(new String[]
            { "INNER", "RIGHT OUTER", "LEFT OUTER", "LEFT", "RIGHT", "THETA" }).toList();

    public ConfigService(AlgorithmClass algorithmClass) {
        this.algorithmClass = algorithmClass;
    }

    public List<String> getJoinTypes() {
        return this.files;
    }

    public List<String> startAlgorithm(Config configClass) {
        var returned = algorithmClass.initializeFlux(configClass);
        if (returned == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Csv files mismatch");
        }
       return returned.map(Object::toString).toList();
    }
}
