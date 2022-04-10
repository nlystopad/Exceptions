package Exceptions2;

import java.io.IOException;

public class Throws {
    // нельзя бросить проверяемое исключение не предупредив о нем
    public static void main(String[] args) {
        throw new Exception(); // тут ошибка компиляции
    }
    // мы не можем бросить исключение, предупредив о его наследнике
    public static void main2(String[] args) throws IOException {
        throw new Exception(); // тут ошибка компиляции
    }
    // а вот бросить то, о чем предупреждаем, мы можем
    public static void main3(String[] args) throws Exception { // предупреждаем о Exception
        throw new Exception(); // и кидаем Exception
    }
    // так же мы можем предупредить о предке и бросить потомка
    public static void main4(String[] args) throws Throwable { // предупреждаем "целом" Throwable
        throw new Exception(); // а кидаем только Exception
    }
    // или даже предупредить, но не бросить ничего
    public static void main5(String[] args) throws Exception {
    }
    // в мейне мы тоже должны предупреждать о возможном исключении, ведь его может выкинуть f()
    public static void main6(String[] args) {
        f(); // тут ошибка компиляции
    }
    public static void f() throws Exception {
    }
    // так же мы можем предупредить о большем (предке), чем предупреждает метод, который вызывается в мейне
    public static void main7(String[] args) throws Throwable {
        f();
    }


}
