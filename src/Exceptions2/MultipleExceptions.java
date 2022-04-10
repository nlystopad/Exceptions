package Exceptions2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class MultipleExceptions {
    // мы должны указать все исключения в throws, которые выбрасываем
    public static void main(String[] args) throws EOFException, FileNotFoundException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }

    // или можем предупредить об их предке, если он у них общий
    public static void main2(String[] args) throws IOException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }
    // или даже так (обобщить исключения с общим предком и предупредить о предке, а оставшееся исключение не трогать)
    public static void main3(String[] args) throws InterruptedException, IOException {
        Random r = new Random();
        if (r.nextInt() % 3 == 1) {
            throw new EOFException();
        } else if (r.nextInt() % 3 == 2) {
            throw new FileNotFoundException();
        } else {
            throw new InterruptedException();
        }
    }
}
