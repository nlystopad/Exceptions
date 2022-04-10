package Exceptions1;

public class SystemErr {
    /* тут из-за того, что System.out - это буфферный поток, сообщение об ошибке в консоли может как опередить
    сообщение "sout", так и быть после него */
    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }
    /* System.err же выводит сообщение в консоль моментально, как только компилятор видит эту надпись,
     он сразу же выводит в консоль текст, а не сохраняет ее в буффер ради дальнейшего вывода */
}
