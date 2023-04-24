import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        // =================== Factory Methods ===================
        
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

        // =================== Pipeline Operations ===================
        
        // Filter: 筛选出长度大于 4 的字符串
        Stream<String> longNames = namesList.stream().filter(name -> name.length() > 4);
        
        IntStream intStream = IntStream.range(1, 10);

        // 使用 boxed() 方法将 IntStream 转换为 Stream<Integer>
        Stream<Integer> boxedStream = intStream.boxed();

        // Map: 将所有名字转换为大写形式
        Stream<String> upperCaseNames = namesList.stream().map(String::toUpperCase);

        // FlatMap: 使用 Optional Monad 创建一个由 "A", "B", "C" 构成的字符串
        Stream<Optional<String>> optionalLetters = Stream.of(
            Optional.of("A"),
            Optional.of("B"),
            Optional.of("C")
        );

        Stream<String> concatenatedLetters = optionalLetters
            .flatMap(optionalLetter -> optionalLetter.map(Stream::of).orElseGet(Stream::empty));

        concatenatedLetters.forEach(System.out::print); // 输出: ABC

        // Sorted: 对流中的元素进行排序
        Stream<String> sortedNames = namesList.stream().sorted();

        // Distinct: 去除流中的重复元素
        Stream<String> distinctNames = namesList.stream().distinct();

        // TakeWhile: 从流中获取满足条件的元素，直到不满足条件的元素出现
        Stream<Integer> numbersUntilFirstEven = IntStream.range(1, 10)
                                                         .boxed()
                                                         .takeWhile(n -> n % 2 != 0);
        
        // =================== Terminal Operations ===================
        
        // Collect: 将流中的元素收集到一个 List 中
        List<String> namesList = Stream.of("Alice", "Bob", "Charlie")
                                       .collect(Collectors.toList());
        
        // Count: 计算流中的元素个数
        long count = namesList.stream().count();

        // AnyMatch: 流中是否存在满足给定条件的元素
        boolean hasLongName = namesList.stream().anyMatch(name -> name.length() > 4);

        // AllMatch: 流中的所有元素是否满足给定条件
        boolean allNamesStartWithA = namesList.stream().allMatch(name -> name.startsWith("A"));

        // NoneMatch: 流中的所有元素是否都不满足给定条件
        boolean noNamesEndWithZ = namesList.stream().noneMatch(name -> name.endsWith("Z"));

        // FindFirst: 查找流中的第一个元素（如果存在）
        Optional<String> firstElement = namesList.stream().findFirst();

        // FindAny: 查找流中的任意一个元素（如果存在）
        Optional<String> anyElement = namesList.stream().findAny();

        // ForEach: 对流中的每个元素执行给定的操作
        namesList.stream().forEach(System.out::println);

        // Min: 获取流中的最小值（如果存在）
        Optional<Integer> minValue = IntStream.range(1, 10).boxed().min(Integer::compare);

        // Max: 获取流中的最大值（如果存在）
        Optional<Integer> maxValue = IntStream.range(1, 10).boxed().max(Integer::compare);

        // Reduce: 将流中的元素按照给定的函数进行累积操作
        Optional<Integer> sum = IntStream.range(1, 10).boxed().reduce((a, b) -> a + b);
    }
}
