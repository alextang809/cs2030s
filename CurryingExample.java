import java.util.function.Function;

public class CurryingExample {

    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> multiplier = a -> b -> a * b;
        Function<Integer, Function<Integer, Integer>> adder = a -> b -> a + b;

        Function<Integer, Integer> multiplyBy2 = multiplier.apply(2);
        Function<Integer, Integer> add3 = adder.apply(3);

        // 函数组合: 先将输入乘以 2，然后加上 3
        Function<Integer, Integer> multiplyBy2ThenAdd3 = x -> add3.apply(multiplyBy2.apply(x));

        int result = multiplyBy2ThenAdd3.apply(4);
        System.out.println("4 * 2 + 3 = " + result);
    }
}

/*
使用 currying 的好处有以下几点：

    模块化：将多参数函数拆分为一系列单参数函数可以让我们更轻松地重用这些函数。例如，在上面的例子中，我们可以轻松地为任意数创建一个新的 addX 函数。

    参数绑定：Currying 允许我们将部分参数绑定到一个函数，从而产生一个具有较少参数的新函数。这可以使得代码更简洁且易于理解。

    函数组合：Currying 有助于函数组合，通过将一个函数的输出作为另一个函数的输入。这使我们能够构建更复杂的功能，同时保持代码模块化和可重用。
    
在这个例子中，我们首先定义了一个 curried 乘法函数 multiplier 和一个 curried 加法函数 adder。然后，我们分别应用参数 2 和 3，得到新的函数 multiplyBy2 和 add3。
接下来，我们使用这两个函数创建一个新的函数 multiplyBy2ThenAdd3，该函数首先将输入乘以 2，然后将结果加上 3。最后，我们应用这个组合函数到输入值 4，输出结果 11（4 * 2 + 3 = 11）。
这个例子展示了如何使用 currying 将两个独立的函数组合成一个新的函数。通过将函数拆分成小的、可重用的部分，我们可以更轻松地组合它们以实现复杂的功能。同时，使用 currying 让代码更加模块化，易于理解和维护。
*/
