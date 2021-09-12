package polsl.stream.join.data.algorithm.join;

import java.util.function.BiPredicate;

@SuppressWarnings("unchecked")
public class MatchPredicate {
    static final BiPredicate<Object, Object> EQUALS = Object::equals;

    public static <KL, KR> BiPredicate<KL, KR> equals() {

        return (BiPredicate<KL, KR>)EQUALS;
    }
}
