package polsl.stream.join.data.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import polsl.stream.join.data.model.Config;

import java.util.stream.Stream;

public class JoinOperator {

    private final Logger logger = LoggerFactory.getLogger(JoinOperator.class);

    public Stream<?> join(StreamModels first, StreamModels second, Config config) {
        logger.info(first.toString());
        return first.getCarDataStream().map(firstStream -> second.getCarDataStream().map(secondStream -> firstStream.toString() + secondStream.toString()));
    }
}
