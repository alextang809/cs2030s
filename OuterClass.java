public class OuterClass {

    // 静态内部类
    public static class StaticInnerClass {
        public void nonStaticMethod() {
            System.out.println("Non-static method in static inner class");
        }

        public static void staticMethod() {
            System.out.println("Static method in static inner class");
        }
    }

    // 静态方法
    public static void staticMethod() {
        System.out.println("Static method in outer class");
    }

    // 非静态方法
    public void nonStaticMethod() {
        System.out.println("Non-static method in outer class");
    }

    public static void main(String[] args) {
        // 调用外部类的静态方法
        OuterClass.staticMethod();

        // 创建外部类的实例，以调用非静态方法
        OuterClass outerInstance = new OuterClass();
        outerInstance.nonStaticMethod();

        // 调用静态内部类的静态方法
        OuterClass.StaticInnerClass.staticMethod();

        // 创建静态内部类的实例，以调用非静态方法
        OuterClass.StaticInnerClass innerInstance = new OuterClass.StaticInnerClass();
        innerInstance.nonStaticMethod();
    }
}
