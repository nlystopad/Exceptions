package Exceptions1;

public class TryCatchCatch {
    // тут будет ошибка, нельзя ставить потомка после предка
    public static void main(String[] args) {
        try {
        } catch (Exception e) {
        } catch (RuntimeException e) {
        }
    }
    // тут все норм, RuntimeException - наследник Exception, а они с Error - разные наследники Throwable
    public static void main2(String[] args) {
        try {
        } catch (Error e) {
        } catch (RuntimeException e) {
        }
    }
    // тут выведется "catch Exception", а не "catch RuntimeException", потому что кидаем мы Exception, а не выведется "catch Throwable",
    // потому что после того, как мы поймали то, что нам нужно или предка, вниз по кетчам мы не идем
    public static void main3(String[] args) {
        try {
            throw new Exception();
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }
    /*
    тут выведется "catch Exception", потому что инициализируем мы объект класса Exception, хотя ссылка на него и типа Throwable,
    но в данном случае важно не тип ссылки на объект, а тип объекта
     */
    public static void main4(String[] args) {
        try {
            Throwable t = new Exception(); // ссылка типа Throwable указывает на объект типа Exception
            throw t;
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }
}
