package polsl.stream.join.data.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import polsl.stream.join.data.CsvReader;
import polsl.stream.join.data.model.Config;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Component
public class AlgorithmClass {

    private final Logger logger = LoggerFactory.getLogger(AlgorithmClass.class);

    private final CsvReader csvReader;

    private final JoinOperator joinOperator;

    private StreamModels firstStreamModel;

    private StreamModels secondStreamModel;

    private Stream<?> returnedData;

    public AlgorithmClass(CsvReader csvReader, JoinOperator joinOperator) {
        this.csvReader = csvReader;
        this.joinOperator = joinOperator;
    }

    public Stream<?> initializeFlux(Config config) {
        Flux<StreamModels> firstDataStream = Flux.just(csvReader.readDataFromFile(config.getFirstFile()));
        Flux<StreamModels> secondDataStream = Flux.just(csvReader.readDataFromFile(config.getSecondFile()));
        firstDataStream.subscribe(data -> {
            this.firstStreamModel = data;
            logger.info("First stream model initiailized");
            logger.info(data.toString());
        });
        secondDataStream.timeout(Duration.ofMillis(config.getDataLifespan())).subscribe(data -> {
            this.secondStreamModel = data;
            logger.info(config.getDataLifespan() + " has passed!");
            logger.info("Second stream model initialized - Starting " + config.getJoinType() + " on " + config.getJoinColumn());
            returnedData = this.joinOperator.join(firstStreamModel, secondStreamModel, config);
        });
        return returnedData;
    }
 }
