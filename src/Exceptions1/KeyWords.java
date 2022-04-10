package Exceptions1;

public class KeyWords {
    // тут все хорошо
    public static void main(String[] args) throws Throwable {

    }
    // тут будет ошибка компиляции, потому что бросить мы можем только объект класса Throwable
    public static void main1(String[] args) throws String {

    }
    // тут все норм
    public static void main2(String[] args) {
        try {

        } catch (Throwable e) {
        }
    }
    // тут тоже ошибка компиляции, потому что поймать мы можем только Throwable или наследника
    public static void main3(String[] args) {
        try {
        } catch (String s){

        }
    }
    // тут все норм
    public static void main4(String[] args) {
        throw new Error();
    }
    // ошибка компиляции, кинуть можно только Throwable или наследника
    public static void main5(String[] args) {
        throw new String("hi")
    }
    // ошибка компиляции, null кинуть нельзя
    public static void main6(String[] args) {
        throw null;
    }
    // ошибка, нельзя кинуть ошибку в разрыве от ее инициализации, эти операции должны идти вместе
    public static void main7(String[] args) {
        Error er = new Error();
        throw er;
    }

    public static void main8(String[] args) {
        f(null);
    }
    /* Данный фрагмент кода отлавливает исключение, которое возникает, когда переменная равна null, дальше,
     если это другое исключение, то просто его выбрасывает, а если это исключение типа NullPointerException,
     рекурсивно вызывает себя, передавая себе эту же ошибку. В итоге мы бесконечно передаем в метод ошибку, у нас
     переполняется стек и выскакивает StackOverflowError*/
    public static void f(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe){
            f(npe);
        }
    }
}
