package JUnitTests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {
    static Stream<Arguments> streamOfArg(){
        return Stream.of(arguments("carrot",3.4),arguments("cherry",1.0));
    }
}
