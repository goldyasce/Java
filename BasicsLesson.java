package ru.rzn.sbt.javaschool.basics;

import ru.rzn.sbt.javaschool.basics.utils.Logger;
import ru.rzn.sbt.javaschool.basics.utils.StringSupplier;

public class BasicsLesson {

    /**
     * Времена года.<br/>
     * <br/>
     * Получив месяц в формате "ЯНВАРЬ", "ФЕВРАЛЬ" и т.д., выведите время года, к которому он принадлежит
     * ("ЗИМА", "ВЕСНА", "ЛЕТО", "ОСЕНЬ"). Если время года определить не удаётся, верните строку "НЕТ ДАННЫХ"<br/>
     * Используйте switch, не создавайте новых переменных.<br/>
     * После прохождения тестов позовите преподавателя.
     */
    public String getSeason(String month) {
        String result = null;
        switch (month){
            case "ЯНВАРЬ":
                result = "ЗИМА";
                break;
            case "ФЕВРАЛЬ":
                result = "ЗИМА";
                break;
            case "ДЕКАБРЬ":
                result = "ЗИМА";
                break;
            case "МАРТ":
                result = "ВЕСНА";
                break;
            case "АПРЕЛЬ":
                result = "ВЕСНА";
                break;
            case "МАЙ":
                result = "ВЕСНА";
                break;
            case "ИЮНЬ":
                result = "ЛЕТО";
                break;
            case "ИЮЛЬ":
                result = "ЛЕТО";
                break;
            case "АВГУСТ":
                result = "ЛЕТО";
                break;
            case "СЕНТЯБРЬ":
                result = "ОСЕНЬ";
                break;
            case "ОКТЯБРЬ":
                result = "ОСЕНЬ";
                break;
            case "НОЯБРЬ":
                result = "ОСЕНЬ";
                break;
            default:
                result = "НЕТ ДАННЫХ";
        }

        return result;
    }

    /**
     * X негритят.<br/>
     * <br/>
     * Получив количество негритят {@code x}, выведите в лог {@code log} обратный отсчёт:<br/>
     * <ul>
     * <li>10 little indians</li>
     * <li>9 little indians</li>
     * <li>...</li>
     * <li>2 little indians</li>
     * <li>1 little indian</li>
     * </ul>
     */
    public void xLittleIndians(int x, Logger log) {
        String message;
        for(int i = x; i > 0; i--){
            if (i == 1){
                message = 1 + " little indian";
            }
            else {
                message = i + " little indians";
            }
            log.log(message);
        }
    }

    /**
     * Всё в лог.<br/>
     * <br/>
     * Сервис {@link StringSupplier} предоставляет строки в ответ на вызов метода {@link StringSupplier#next()}.
     * Если у него есть ещё строка, то он отвечает {@code true} на вызов метода {@link StringSupplier#hasNext()},
     * если строки кончились - ответит {@code false}.<br/>
     * Получите от сервиса все строки и отправьте их в лог.
     */
    public void logEverything(StringSupplier supplier, Logger log) {
        while (supplier.hasNext()){
            log.log(supplier.next());
        }
    }

    /**
     * Устами младенца.<br/>
     * <br/>
     * Малыши "не выговаливают" букву Р. Сделайте для робота малыша метод, который получив слово, заменит в нём все
     * буквы Р на Л.
     */
    public String littleKid(String word) {
        String result = null;
        result = word.replace("Р", "Л");
        return result;
    }

    /**
     * Первый раз в первый класс.<br/>
     * <br/>
     * Создайте в этом пакете ({@link ru.rzn.sbt.javaschool.basics}) новый класс с именем LethalWeapon.<br/>
     * Класс должен содержать:
     * <ul>
     *     <li>публичное строковое поле color</li>
     *     <li>приватное поле {@code roundsLeft} типа {@code int} без методов чтения и записи</li>
     *     <li>приватное поле {@code power типа} {@code Double} с методами чтения и записи</li>
     *     <li>публичный void-метод {@code reload}, принимающий {@code int} - количество зарядов и увеличивающий
     *     {@code roundsLeft} на эту величину</li>
     *     <li>публичный void-метод pewPew без параметров, уменьшающий значение {@code roundsLeft} на 2</li>
     *     <li>публичный конструктор без параметров</li>
     *     <li>публичный конструктор, принимающий параметры для всех полей в алфавитном порядке их имён</li>
     * </ul>
     * Создайте объект нового класса, проинициализировав все его поля и верните его из метода {@link #newClass()}.<br/>
     */
    public Object newClass() {
        LethalWeapon pistol = new LethalWeapon("Red", 2.0, 20);
        //pistol.setPower("3");
        return pistol;
    }

    /**
     * Добавьте в класс LethalWeapon серийные номера.<br />
     * <br />
     * Создайте приватное статическое целочисленное ({@code long}) поле nextSerial = 0.<br />
     * Создайте приватное финальное целочисленное ({@code long}) поле serial с методом чтения.<br />
     * В конструкторах обеспечьте корректное проставление серийных номеров.<br />
     */
    public void serial() {

    }

    /**
     * Реализуйте метод equals() у класса LethalWeapon. Сравните цвет, мощность и заряд. Серийный номер роли не играет.
     */
    public void equalsContract() {

    }

    /**
     * Получив некоторую строку, получите из нее подстроку со 2-го символа по символ "S",
     * приведите все символы в верхний регистр и верните результат.
     * @param input
     * @return
     */
    public String stringExercise1(String input) {
        String str = input.substring(2, input.indexOf("S") + 1);
        String strUp = str.toUpperCase();
        return strUp;
    }

    /**
     * Получив некоторую строку, найдите длину строки, количество запятых, количество дефисов,
     * индекс первого символа "R", индекс последнего символа "L" и количество пробелолв между словами.
     * Верните результат перемножения всех полученных чисел.
     * @param input
     * @return
     */
    public int stringExercise2(String input) {
        String newInput = input.trim();
        int numZ = 0;
        int numD = 0;
        int tabs = 0;

        for(int i = 0; i < newInput.length(); i++){
            char a = newInput.charAt(i);
            if(a == ','){ numZ++; }
            if(a == '-'){ numD++; }
            if(a == ' '){ tabs++; }
        }

        int sum = input.length() * numZ * numD * input.indexOf("R") * input.lastIndexOf("L") * tabs;
        return sum;
    }

    /**
     * Получив некоторую строку выполните следующее:<br />
     * 1. если в строке 3 слова и есть слово "Hello", верните новую строку, содержащую первое и последнее слова (без лишних пробелов).<br />
     * 2. если в строке 2 слова и есть слово "Hello", инвертируйте порядок символов в ней и верните результат.<br />
     * 3. если в строке 3 слова и есть слово "Goodbye", верните новую строку, содержащую первое и последнее слова (без лишних пробелов),
     * если в конце есть восклицательный знак - уберите его, если нет - добавьте.<br />
     * 4. если в строке 2 слова и есть слово "Goodbye", поменяйте слова местами (между словами в новой строке тоже должен быть пробел, лишних пробелов быть не должно),
     * сделайте все буквы в нижнем регистре и верните результат.
     * @param input
     * @return
     */
    public String stringExercise3(String input) {
        int count = 0;
        String newInput = input.trim();
        String result = "";

        if(newInput.length() != 0){
            count++;
            for (int i = 0; i < newInput.length(); i++) {
                if(newInput.charAt(i) == ' '){ count++; }
            }

            if(count == 3 && newInput.contains("Hello")){
                String sub = newInput.substring(newInput.indexOf(' '), newInput.lastIndexOf(' '));
                result = newInput.replace(sub, "");
            }

            if(count == 2 && newInput.contains("Hello")){
                result = new StringBuilder(newInput).reverse().toString();
            }

            if(count == 3 && newInput.contains("Goodbye")){

                String sub = newInput.substring(newInput.indexOf(' '), newInput.lastIndexOf(' ') + 1);
                String result2 = newInput.replace(sub, " ");
                String result1 = "";
                if (result2.charAt(result2.length() - 1) == '!') {
                    result1 = result2.replace(result2.substring(result2.indexOf('!')), "");
                }
                else{
                    result1 = result2 + '!';
                }

                result = result1;
            }

            if(count == 2 && input.contains("Goodbye")){
                String word1 = newInput.substring(0, newInput.indexOf(" "));
                String word2 = newInput.substring(newInput.indexOf(" ") + 1);
                String res = word2 + " " + word1;
                result = res.toLowerCase();
            }
        }
        return result;
    }
}
