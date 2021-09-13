package polsl.stream.join.data.algorithm;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

public interface Join {

    List<String> innerJoin(StreamModels firstStream, StreamModels secondStream);

    List<String> rightJoin(StreamModels firstStream, StreamModels secondStream);

    List<String> leftJoin(StreamModels firstStream, StreamModels secondStream);

    Stream<?> thetaJoin(StreamModels firstStream, StreamModels secondStream);
}
