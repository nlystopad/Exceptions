package Exceptions2;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class CatchThrow {
    // не надо предупреждать о том, что перехватывается. Если перехватывается предок предупреждать тоже не надо
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
        }
    }
    // если же перехватывается потомок - то предупреждать надо, а иначе - ошибка компиляции.
    public static void main2(String[] args) {
        try {
            throw new Throwable();
        } catch (Exception e) {
        }
    }
    // Такая же логика работает и если перехватывается другой наследник Throwable, но не потомок и не предок данного исключения
    public static void main3(String[] args) throws FileNotFoundException {
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        } catch (EOFException e) {
            // ...
        }
    }
}
