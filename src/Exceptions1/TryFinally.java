package Exceptions1;

public class TryFinally {
    // finally начинается после того, как try успешно заканчивается
    public static void main(String[] args) {
        try {
            System.err.println("try");
        } finally {
            System.err.println("finally");
        }
    }
    // хотя даже если try закончился исключением, finally все равно приступит к исполнению
    public static void main2(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }
    // и даже если в блоке try происходит выход из метода, finally все равно случится
    public static void main3(String[] args) {
        try {
            return;
        } finally {
            System.err.println("finally");
        }
    }
    // если происходит радикальный выход из программы с выключением JVM, то тогда блоку finally не суждено случиться
    // сюда же относятся такие выходы из программы как Runtime.getRuntime().exit(42) и  Runtime.getRuntime().halt(42)
    public static void main4(String[] args) {
        try {
            System.exit(42);
        } finally {
            System.err.println("finally");
        }
    }
    // если try заканчивается исключением, то finally все равно случается, но исключение все равно не обрабатывается
    public static void main5(String[] args) {
        try {
            System.err.println("try");
            if (true) {throw new RuntimeException();}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
    // если try заканчивается выходом из метода, то finally тоже случится, но все, что за ним - нет
    public static void main6(String[] args) {
        try {
            System.err.println("try");
            if (true) {return;}
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }

    /* однако finally перебьет return в try и в данном случае вернется 1, это же верно и для исключений, как в блоке
     try (если в try исключение, а в finally - return, сработает return), так и в блоке finally (если в try return,
      а в finally - исключение, сработает исключение)
     */
    public static void main7(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }

}
