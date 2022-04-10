package Exceptions1;

public class TryCatch {
    // тут выведется в консоль 0 2 3, потому что мы кидаем RuntimeException, а ловим его предка, то есть RuntimeException тоже отлавливается
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
            System.err.print(" 2");
        }
        System.err.println(" 3");
    }
    // тут, так как мы кидаем RuntimeException и поймали RuntimeException, хотя и ловили его предка, выведется "Это RuntimeException на самом деле", потому что поймали именно его
    // если бы тут же кинули другой Exception, то вывелось на экран "В каком смысле не RuntimeException"
    public static void main2(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.print("Это RuntimeException на самом деле!!!");
            } else {
                System.err.print("В каком смысле не RuntimeException???");
            }
        }
    }
    // тут выскочит исключение, что значит, что мы не можем поймать наследника, можем поймать только Exception или его предка (Throwable например)
    public static void main3(String[] args) throws Exception {
        try {
            System.err.print(" 0");
            if (true) {throw new Exception();}
            System.err.print(" 1");
        } catch (RuntimeException e) {
            System.err.print(" 2");
        }
        System.err.print(" 3");
    }
    // тут мы выбрасываем Error, а ловим Exception, хотя они друг друга не наследуют, они оба наследуют Throwable, но друг с другом в контакт не вступают
    // из-за этого мы не перехватим ошибку
    public static void main4(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new Error();}
            System.err.print(" 1");
        } catch (Exception e) {
            System.err.print(" 2");
        }
        System.err.print(" 3");
    }
    // тут мы бросаем RuntimeException, перехватываем, из перехвата бросаем Error и, так как он не перехватывается ничем, вылазит ошибка
    public static void main5(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {throw new Error();} // но бросили Error
        }
        System.err.println(" 3");          // пропускаем - уже летит Error
    }
    // тут мы бросаем исключение, ловим его, бросаем еще раз, но больше не ловим, так что оно у нас вылетает в консоль
    public static void main6(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {throw e;}       // и бросили ВТОРОЙ раз ЕГО ЖЕ
        }
        System.err.println(" 3");      // пропускаем - опять летит RuntimeException
    }
    // тут мы бросаем Error в другом фрейме, поэтому catch на Error, хоть он и есть, не срабатывает
    public static void main7(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {throw new Error();} // и бросили новый Error
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }
    /*
    тут мы кидаем RuntimeException, перехватываем, дальше в блоке catch мы делаем еще один блок try catch, в нем кидаем Error,
    перехватываем Throwable (предок Error), потом перехватываем Error, но мы уже поймали Throwable, так что catch не срабатывает
     */
    public static void main8(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2.1");
            try {
                System.err.print(" 2.2");
                if (true) {throw new Error();} // и бросили новый Error
                System.err.print(" 2.3");
            } catch (Throwable t) {            // перехватили Error
                System.err.print(" 2.4");
            }
            System.err.print(" 2.5");
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }
}
