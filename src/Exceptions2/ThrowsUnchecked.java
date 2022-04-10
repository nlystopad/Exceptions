package Exceptions2;

public class ThrowsUnchecked {
    // RuntimeException - это unchecked исключение, так что мы не обязаны предупреждать о нем
    public static void main(String[] args) {
        f();
    }
    public static void f() throws RuntimeException {
    }
}
