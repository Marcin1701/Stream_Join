package polsl.stream.join.data.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import polsl.stream.join.data.CsvReader;
import polsl.stream.join.data.model.Config;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Component
public class AlgorithmClass {

    private final Logger logger = LoggerFactory.getLogger(AlgorithmClass.class);

    private final CsvReader csvReader;

    private StreamModels firstStreamModel;

    private StreamModels secondStreamModel;

    private Stream<?> returnedData;

    public AlgorithmClass(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    public Stream<?> initializeFlux(Config config) {
        var streamJoin = new StreamJoin(config);
        Flux<StreamModels> firstDataStream = Flux.just(csvReader.readDataFromFile(config.getFirstFile()));
        Flux<StreamModels> secondDataStream = Flux.just(csvReader.readDataFromFile(config.getSecondFile()));
        firstDataStream.subscribe(data -> this.firstStreamModel = data);
        secondDataStream.subscribe(data -> this.secondStreamModel = data);
        logger.info("----- JOIN TYPE: " + config.getJoinType() + " -----");
        logger.info("Joining " + config.getFirstFile() + " with " + config.getSecondFile());
        if (this.firstStreamModel != null && this.secondStreamModel != null) {
            switch (config.getJoinType()) {
                case "INNER" -> returnedData = streamJoin.innerJoin(this.firstStreamModel, this.secondStreamModel).stream();
                case "RIGHT" -> returnedData = streamJoin.rightJoin(this.firstStreamModel, this.secondStreamModel).stream();
                case "LEFT" -> returnedData = streamJoin.leftJoin(this.firstStreamModel, this.secondStreamModel).stream();
                case "RIGHT OUTER" -> returnedData = streamJoin.rightOuterJoin(this.firstStreamModel, this.secondStreamModel).stream();
                case "LEFT OUTER" -> returnedData = streamJoin.leftOuterJoin(this.firstStreamModel, this.secondStreamModel).stream();
                case "THETA" -> returnedData = streamJoin.thetaJoin(this.firstStreamModel, this.secondStreamModel).stream();
                default -> returnedData = null;
            }
        }
        return returnedData;
    }
 }
