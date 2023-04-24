/**
这段代码展示了如何使用 Java 中的 Optional 类型的 flatMap 方法将多个操作链接在一起。
Optional 是一个 Monad，它表示一个可能存在或不存在的值。
在这个例子中，我们使用 Optional 类型将两个字符串连接在一起。
*/

/*
 1. Optional.of("A")：我们创建了一个包含字符串 "A" 的 Optional 对象。
 2. .flatMap(a -> ...): 我们使用 flatMap 方法将操作链接在一起。flatMap 方法接受一个函数，该函数以 "A" 为参数，并返回另一个 Optional 对象。在这个例子中，我们返回一个包含字符串 "B" 的新 Optional 对象。
 3. .flatMap(b -> Optional.of(a + b)): 在第二个 flatMap 调用中，我们将操作链接在一起。这个函数以 "B" 为参数，并返回一个新的 Optional 对象，该对象包含 "A" 和 "B" 的连接结果，即 "AB"。
 4. concat.get(): 最后，我们使用 Optional 类型的 get 方法获取连接后的字符串。在这种情况下，concat 包含字符串 "AB"，所以 concat.get() 返回 "AB"。

System.out.println(concat.get()); 将输出 "AB"。
*/
public class MonadExplain {
    public static void main(String[] args) {
        Optional<String> concat = Optional.of("A")
            .flatMap(a -> Optional.of("B")
                     .flatMap(b -> Optional.of(a + b)));
        
        System.out.println(concat.get());
    }
}
