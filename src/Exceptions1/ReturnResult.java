package Exceptions1;

public class ReturnResult {
    // тут все хорошо, ведь мы возвращаем тот тип данных, который указали в сигнатуре
    public double sqrt(double arg) {
        return arg * arg;
    }

    // тут все хорошо, потому что происходит неявное преобразование данных из int в double
    public double sqrt1(double arg) {
        int k = 1;
        return k;
    }

    // а тут вообще преобразование явное, так что тем более нет никаких проблем
    public double sqrt2(double arg) {
        int k = 1;
        return (double) k;
    }

    // тут будет ошибка компиляции, потому что строку в double мы преобразовать не можем никак
    public double sqrt3(double arg) {
        return "Hello";
    }

    // тут вообще нет возврата, а в сигнатуре указан возвращаемый тип, так что тут тоже будет ошибка
    public static double sqrt4(double arg) {
    }

    // тут тоже будет ошибка, потому что возврат может быть, а может его и не быть, а должен быть обязательно
    public double sqrt5(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg;
        }
        // если условие не выполняется, то возврата нет
    }

    // тут случится ошибка из-за отсутствия возвращаемого значения, непонятно, чему должна быть равна переменная
    public static void main(String[] args) {
        double d = sqrt4(4);
        System.out.println(d);
    }

    // этот метод скомпилируется, потому что до возврата тут не дойдет никогда, поэтому его отсутствие не критично
    public double sqrt6(double arg) {
        while (true) ;
    }

    // этот метод тоже скомпилируется, потому что мы либо возвращаем значение, либо не выходим из цикла
    public double sqrt7(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg;
        } else {
            while (true) ;
        }
    }
    // наличие исключения позволяет нам ничего не возвращать
    public static double sqrt8(double arg){
        throw new RuntimeException();
    }
    /* так как выполнение этого мейна прервется выскочившей ошибкой, то и выводить на экран значение переменной нам
     не надо, а значит тут все скомпилируется без ошибок */
    public static void main2(String[] args) {
        double d = sqrt8(5);
        System.out.println(d);
    }
    // нам нужен метод, который вычисляет площадь
    public static int area (int height, int width){
        return height * width; // тут может возникнуть проблема, передаваемые аргументы должны проходить валидацию (быть не меньше 0)
    }
    // лучшим решением в случае не прохождения валидации данных кинуть исключение с текстом, указывающим на ошибку
    public static int area2(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }

}
