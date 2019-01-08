package ru.rzn.sbt.javaschool.exceptions;

import ru.rzn.sbt.javaschool.exceptions.utils.*;

import java.io.IOException;

/**
 * Исключения.
 */
public class ExceptionsLesson {

    /**
     * Упражнение 1. Catch me if you can.<br />
     * <br />
     * Вызовите у сервиса {@code service} метод {@link SomeService#doSomething()}<br />
     * В случае возникновения исключения {@link java.io.IOException}
     * запишите в лог сообщение ( {@link Throwable#getMessage()} )
     * методом {@link Logger#log(String)}.
     */
    public void logException(SomeService service, Logger log) {
        try{
            service.doSomething();
        }catch (IOException e){
            log.log(e.getMessage());
        }
    }

    /**
     * Упражнение 2. Whatever happens.<br />
     * <br />
     * Вызовите у сервиса {@code service} метод {@link SomeService#doSomething()}<br />
     * В случае возникновения исключения {@link java.io.IOException}
     * запишите в лог сообщение ( {@link Throwable#getMessage()} )
     * методом {@link Logger#log(String)}.<br />
     * При любом результате выполнения после вызова метода закройте соединение с сервисом
     * методом {@link SomeService#closeConnection()}
     */
    public void closeConnection(SomeService service, Logger log) {
        try{
            service.doSomething();
        }catch (IOException e){
            log.log(e.getMessage());
        }finally {
            service.closeConnection();
        }
    }

    /**
     * Упражнение 3. Inception.<br />
     * <br />
     * Вызовите метод {@link #getStackTraceDeeper}<br />
     * В случае возникновения любого исключения отправьте стек вызовов
     * в лог методом {@link Logger#log(String)}.<br />
     * Изучите распечатаный стек вызовов в логе вывода тестов.
     */
    public void getStackTrace(SomeService service, Logger log) {
        try{
            getStackTraceDeeper(service);
        }catch (Exception e){
            StackTraceElement[] elements = e.getStackTrace();
            String str = "";
            for(StackTraceElement element : elements){
                str += element;
            }
            log.log(str);
        }

    }
    private void getStackTraceDeeper(SomeService service) throws IOException {
        getStackTraceEvenDeeper(service);
    }
    private void getStackTraceEvenDeeper(SomeService service) throws IOException {
        getStackTraceWeNeedToGoDeeper(service);
    }
    private void getStackTraceWeNeedToGoDeeper(SomeService service) throws IOException {
        service.doSomething();
    }

    /**
     * Упражнение 4. Мальчики-направо, девочки-налево.<br />
     * <br />
     * Вызовите у сервиса {@code service} метод {@link SomeService#showMeTheWay()} и обработайте исключения:<br />
     * <br />
     * 1. В случае, если пол определить не удаётся ( {@link ru.rzn.sbt.javaschool.exceptions.utils.ChildException} )
     *      отправьте в лог сообщение {@link #UNKNOWN}<br />
     * 2. При возникновении {@link ru.rzn.sbt.javaschool.exceptions.utils.BoyException}
     *      отправьте в лог сообщение {@link #RIGHT}<br />
     * 3. При возникновении {@link ru.rzn.sbt.javaschool.exceptions.utils.GirlException}
     *      отправьте в лог сообщение {@link #LEFT}<br />
     * 4. Другие исключения не обрабатывайте.<br />
     * <br />
     * Внимание! Это упражнение только для изучения синтаксиса языка. Можно включить его в раздел "вредные советы" -
     * исключения не предназначены для описания стандартного поведения программы!
     */
    public void showMeTheWay(SomeService service, Logger log) {
        try {
            service.showMeTheWay();
        } catch (BoyException be) {
            log.log(RIGHT);
        } catch (GirlException ge) {
            log.log(LEFT);
        } catch (ChildException ce) {
            log.log(UNKNOWN);
        }
    }

    public static final String LEFT = "Налево";
    public static final String RIGHT = "Направо";
    public static final String UNKNOWN = "Kill it with fire!!111";

    /**
     * Упражнение 5. Just do it!<br />
     * <br />
     * Хватит ловить исключения! Пора их бросать!<br />
     * В классе {@link Thrower} напишите метод doIt так, чтобы он получал целочисленный ({@code int}) параметр,
     * и в случае, если десятичная запись полученного числа заканчивается на ноль,
     * метод выбрасывал исключение типа {@link Exception} с сообщением {@link #ENDS_WITH_ZERO}
     */
    public static class Thrower {
        public Thrower(){

        }

        public void doIt(int num) throws Exception{
            if(num % 10 == 0){
                throw new Exception(ENDS_WITH_ZERO);
            }
        }
    }

    public static final String ENDS_WITH_ZERO = "ААААА!! Ноль на конце!";

    /**
     * Упражнение 6. HelloWorldException<br />
     * <br />
     * А теперь пора сделать своё собственное исключение.<br />
     * <br />
     * Определите вместо строки {@code //Тут должно быть ваше исключение} новое проверяемое исключение:<br />
     * 1. с именем {@code HelloWorldException}<br />
     * 2. c дополнительным целочисленным ({@code int}) свойством {@code ErrorCode}<br />
     * 3. с единственным публичным конструктором, принимающим сообщение и код ошибки
     *     (два параметра в указанном порядке)<br />
     * <br />
     * В методе {@link #helloWorldException} выбросьте получившееся исключение
     * с кодом ошибки {@link #THROW_THE_WORLD_CODE} и с сообщением {@link #THROW_THE_WORLD_MSG}
     */
    public void helloWorldException() throws HelloWorldException{
        throw new HelloWorldException(THROW_THE_WORLD_MSG, THROW_THE_WORLD_CODE);
    }

    public class HelloWorldException extends Exception{
        private int ErrorCode;

        public HelloWorldException(String message, int errorCode){
            super(message);
            this.ErrorCode = errorCode;
        }

        public int getErrorCode(){return this.ErrorCode;}
    }

    public static final int THROW_THE_WORLD_CODE = 777;
    public static final String THROW_THE_WORLD_MSG = "Pew! Pew!";

    /**
     * Упражнение 7. Call me maybe.<br />
     * <br />
     * Верните из метода {@link #callMe()} название метода, из которого он будет вызван.
     */
    public String callMe() {
        String caller = null;
        try{
            throw new Exception();
        }catch (Exception e){
            caller = e.getStackTrace()[1].getMethodName();
            return caller;
        }
    }

    /**
     * Упражнение 8. Уходя гасите свет.<br />
     * <br />
     * 1. Получив {@link OldConnection} в качестве параметра, создайте сессию методом
     * {@link OldConnection#createSession()}, получите данные методом {@link OldSession#getData()} и верните их
     * из метода {@link #closeResource(OldConnection, Logger)}.<br />
     * 2. Перед возвратом из метода закройте сессию.<br />
     * 3. Не забудьте обработать возможные ошибки - метод {@link #closeResource(OldConnection, Logger)}
     * не должен выбрасывать проверяемых исключений. Если при запросе возникла ошибка ({@link IOException}),
     * верните {@code null}, а сообщение об ошибке запишите в лог.
     */
    public String closeResource(OldConnection c, Logger log) {
        String data = null;
        OldSession s = null;
        try{
            s = c.createSession();
            data = s.getData();
        }catch (IOException e){
            log.log(e.getMessage());
        }finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e1) {
                log.log(e1.getMessage());
            }
        }

        return data;
    }

    /**
     * Упражнение 9. Уходя пусть гаснет сам.<br />
     * <br />
     * Сделайте всё то же самое, что и в предыдущем упражнении, но с использованием классов, реализующих интерфейс
     * {@link AutoCloseable}. ({@link Connection} и {@link Session})<br />
     * Оцените более лаконичную и легче читаемую запись.
     */
    public String autocloseResource(Connection c, Logger log) {
        String data = null;

        try(Session s = c.createSession()){
            data = s.getData();
        }catch (IOException e){
            log.log(e.getMessage());
        }

        return data;
    }

    /**
     * Упражнение 10. Больше ада.<br />
     * <br />
     * 1. Получив {@link OldConnectionFactory} в качестве параметра, создайте соединение методом
     * {@link OldConnectionFactory#createConnection()}, затем сессию методом {@link OldConnection#createSession()},
     * получите данные методом {@link OldSession#getData()} и верните их из метода
     * {@link #closeEverything(OldConnectionFactory, Logger)}.<br />
     * 2. Перед возвратом из метода закройте сессию и соединение.<br />
     * 3. Не забудьте обработать возможные ошибки - метод {@link #closeEverything(OldConnectionFactory, Logger)}
     * не должен выбрасывать проверяемых исключений. Если при запросе возникла ошибка ({@link IOException}),
     * верните {@code null}, а сообщение об ошибке запишите в лог.
     */
    public String closeEverything(OldConnectionFactory cf, Logger log) {
        String data = null;
        OldConnection c = null;
        OldSession s = null;

        try {
            c = cf.createConnection();
            s = c.createSession();
            data = s.getData();
        } catch (IOException e) {
            log.log(e.getMessage());
        } finally {
            try {
                if (s != null) {
                    try {
                        s.close();
                    }catch (IOException e){
                        log.log(e.getMessage());
                    }
                }

                if (c != null) {
                    c.close();
                }
            } catch (IOException e1) {
                log.log(e1.getMessage());
            }

        }

        return data;
    }

    /**
     * Упражнение 11. Feel the difference.<br />
     * <br />
     * Сделайте всё то же самое, что и в предыдущем упражнении, но с использованием классов, реализующих интерфейс
     * {@link AutoCloseable}. ({@link ConnectionFactory}, {@link Connection}, {@link Session})<br />
     * Почувствуйте разницу :)
     */
    public String autocloseEverything(ConnectionFactory cf, Logger log) {
        String data = null;

        try(
                Connection c = cf.createConnection();
                Session s = c.createSession();
                ){
            data = s.getData();
        }catch (IOException e){
            log.log(e.getMessage());
        }

        return data;
    }

    /**
     * Упражнение 12. Hello Barbara.<br />
     * <br />
     * Создайте в этом пакете ({@link ru.rzn.sbt.javaschool.exceptions}) класс {@code SubClass} - потомок класса
     * {@link SuperClass}. Переопределите метод {@link SuperClass#callService(SomeService)} так, чтобы
     * он вызывал метод {@link SomeService#doSomething()} у полученного в качестве аргумента сервиса
     * {@link SomeService} и в случае успешного выполнения возвращал строку "DONE".<br />
     * <br />
     * Если метод {@link SomeService#doSomething()} выбросит исключение, пробросьте его из метода {@code callService},
     * а если это невозможно, то выбросьте непроверяемое исключение с тем же сообщением, указав исходное исключение
     * в качестве причины.
     */
    public void helloBarbara() {
    }
}
