package polsl.stream.join.data.algorithm;

import io.reactivex.rxjava3.core.Observable;
import polsl.stream.join.data.CsvReader;
import polsl.stream.join.data.model.Config;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class AlgorithmClass {

    private final Config config;

    private final CsvReader csvReader;

    private final JoinOperator joinOperator = new JoinOperator();

    private Observable<StreamModels> firstDataStream;

    private Observable<StreamModels> secondDataStream;

    private Stream<?> invokeJoinOperator() {
        this.firstDataStream.subscribe();
        this.secondDataStream.subscribe();
        return joinOperator.join(this.firstDataStream.blockingSingle(), this.secondDataStream.blockingSingle(), config);
    }

    public Stream<?> initializeObservable() {
        Callable<StreamModels> streamModelsCallable = () -> this.csvReader.readDataFromFile(config.getFirstFile());
        firstDataStream = Observable.fromCallable(streamModelsCallable);
        Callable<StreamModels> streamModelsCallableSecond = () -> this.csvReader.readDataFromFile(config.getSecondFile());
        secondDataStream = Observable.fromCallable(streamModelsCallableSecond);
        return this.invokeJoinOperator();
    }

    public AlgorithmClass(Config config, CsvReader csvReader) {
        this.config = config;
        this.csvReader = csvReader;
    }
 }
