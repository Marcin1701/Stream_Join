package polsl.stream.join.data.algorithm;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import polsl.stream.join.data.CsvReader;
import polsl.stream.join.data.model.Config;

import java.util.List;
import java.util.concurrent.Callable;

public class AlgorithmClass {

    private final Config config;

    private final CsvReader csvReader;

    private final Logger logger = LoggerFactory.getLogger(AlgorithmClass.class);

    private JoinOperator joinOperator = new JoinOperator();

    private Observable<StreamModels> firstDataStream;

    private Observable<StreamModels> secondDataStream;

    private void allJoinsAreActive() {
        logger.info("All joins are active");
    }

    private void invokeJoinOperator() {
       this.firstDataStream.subscribe(firstSubscribeStream -> {
            this.secondDataStream.subscribe(secondSubscribeDataStream -> {
                logger.info("First: " + firstSubscribeStream.toString());
                logger.info("Second: " + secondSubscribeDataStream.toString());
               // joinOperator.join(firstSubscribeStream, secondSubscribeDataStream, config).forEach(value -> logger.info(value.toString()));
            });
        });
    }

    private void initializeObservable() {
       if (firstDataStream == null) {
           logger.info("First observable is null!");
           Callable<StreamModels> streamModelsCallable = () -> {
               return this.csvReader.readDataFromFile(config.getFirstFile());
           };
           firstDataStream = Observable.fromCallable(streamModelsCallable);
       }
       //else if (secondDataStream == null) {
           logger.info("Second observable is null!");
           Callable<StreamModels> streamModelsCallable = () -> {
               return this.csvReader.readDataFromFile(config.getSecondFile());
           };
           secondDataStream = Observable.fromCallable(streamModelsCallable);
           this.invokeJoinOperator();
       //}
    }

    public AlgorithmClass(Config config, CsvReader csvReader) {
        this.config = config;
        this.csvReader = csvReader;
        this.initializeObservable();
    }

    public void loadData(List<?> data) {

    }
 }
