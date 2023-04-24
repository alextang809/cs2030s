import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        // 1. 通过提供的元素创建一个有限的流
        Stream<String> names = Stream.of("Alice", "Bob", "Charlie");
        
        // 2. 创建一个空的流
        Stream<String> emptyStream = Stream.empty();
        
        // 3. 通过一个无限的生成函数创建一个无限流（使用 limit() 限制元素数量）
        Stream<Double> randomNumbers = Stream.generate(Math::random).limit(10);
        
        // 4. 通过一个初始值和一个生成函数创建一个无限流（使用 limit() 限制元素数量）
        Stream<Integer> naturalNumbers = Stream.iterate(1, n -> n + 1).limit(10);
        
        // 5. 创建一个有限的整数流，包含一个范围内的值
        IntStream numbers = IntStream.range(1, 10); // 1, 2, 3, ..., 9
        
        // 6. 创建一个有限的整数流，包含一个范围内的值，包括结束值
        IntStream numbersClosed = IntStream.rangeClosed(1, 10); // 1, 2, 3, ..., 10
        
        // 7. 从集合（Collection）类创建流
        List<String> namesList = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> namesStream = namesList.stream();
    }
}
