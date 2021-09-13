package polsl.stream.join.data.algorithm;

import java.util.List;

public interface Join {

    List<String> innerJoin(StreamModels firstStream, StreamModels secondStream);

    List<String> rightJoin(StreamModels firstStream, StreamModels secondStream);

    List<String> leftJoin(StreamModels firstStream, StreamModels secondStream);

    List<String> rightOuterJoin(StreamModels firstStream, StreamModels secondStream);

    List<String> leftOuterJoin(StreamModels firstStream, StreamModels secondStream);

    List<String> thetaJoin(StreamModels firstStream, StreamModels secondStream);
}
