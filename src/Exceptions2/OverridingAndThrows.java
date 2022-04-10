package Exceptions2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverridingAndThrows {
    // Наследник не обязан так же как и предок предупреждать об исключениях, оно может их переписать (полиморфизм)
    public static class Parent {
        // предок пугает IOException и InterruptedException
        public void f() throws IOException, InterruptedException {}
    }

    static class Child extends Parent {
        // а потомок пугает только потомком IOException
        @Override
        public void f() throws FileNotFoundException {}
    }

   // однако расширить тип бросаемых исключений мы не можем
    class ChildB extends Parent {
        @Override
        public void f() throws Exception {}
    }
    // Так как мы можем принять объект класса Parent в каком-то методе, который может отлавливать исключения, получить его
    // наследника, который может выбросить проверяемые исключения, и эти исключения будут неконтролированно выбрасываться,
    // хотя по идее не должны, ведь мы их отлавливаем

}
