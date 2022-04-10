package Exceptions1;

public class TryCatchFinally {
    // тут нет ошибки, catch не срабатывает, выводится 0 1 3 4
    public static void main(String[] args) {
        try {
            System.err.print(" 0");

            System.err.print(" 1");
        } catch (Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
    // тут есть ошибка, try не дорабатывает, выводится 0 2 3 4
    public static void main2(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new Error();}
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }
    // тут есть исключение, но нет подходящего catch, поэтому выполнение прерывается исключением, выводится 0 3 (потому что finally срабатывает)
    public static void main3(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch(Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");
    }


}
