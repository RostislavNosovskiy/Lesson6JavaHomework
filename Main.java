import java.util.*;

public class Main {
    /*
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
 отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
Работу сдать как обычно ссылкой на гит репозиторий
Частые ошибки:
1. Заставляете пользователя вводить все существующие критерии фильтрации
2. Невозможно использовать более одного критерия фильтрации одновременно
3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков
или добавить еще ноутбук, то программа начинает работать некорректно
     */
    public static void main(String[] args) {
        String menu = "Введите цифру, соответствующую необходимому критерию:" + "\n" +
        "1 - ОЗУ" + "\n" +
        "2 - Объем ЖД" + "\n" +
        "3 - Операционная система" + "\n" +
        "4 - Цвет" + "\n" +
        "5 - Показать результат" + "\n";

        NoteBook noteBook1 = new NoteBook(4, 2, "MacOS", "silver");
        NoteBook noteBook2 = new NoteBook(8, 1, "Windows", "white");
        NoteBook noteBook3 = new NoteBook(4, 4, "MacOS", "gold");
        NoteBook noteBook4 = new NoteBook(32, 2, "Linux", "black");
        NoteBook noteBook5 = new NoteBook(16, 1, "Windows", "black");
        NoteBook noteBook6 = new NoteBook(8, 2, "Windows", "silver");
        NoteBook noteBook7 = new NoteBook(8, 2, "Linux", "black");
        NoteBook noteBook8 = new NoteBook(4, 8, "MacOS", "white");
        NoteBook noteBook9 = new NoteBook(16, 4, "Windows", "silver");
        NoteBook noteBook10 = new NoteBook(16, 1, "Windows", "silver");
        List<NoteBook> list = new ArrayList<>();
        list.add(noteBook1);
        list.add(noteBook2);
        list.add(noteBook3);
        list.add(noteBook4);
        list.add(noteBook5);
        list.add(noteBook6);
        list.add(noteBook7);
        list.add(noteBook8);
        list.add(noteBook9);
        list.add(noteBook10);

        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
Boolean work = true;
        while (work) {
            System.out.println(menu);
            String choise = scanner.nextLine();
            switch (choise) {
                case ("1"):
                    System.out.println("Введите минимальное желаемое значение ОЗУ (в ГБ):");
                    String ozuMinVal = scanner.nextLine();
                    map.put("1", ozuMinVal);
                    break;
                case ("2"):
                    System.out.println("Введите минимальное желаемое значение объёма ЖД (в ТБ):");
                    String zhdMinVal = scanner.nextLine();
                    map.put("2", zhdMinVal);
                    break;
                case ("3"):
                    System.out.println("Введите желаемую ОС:");
                    String os = scanner.nextLine();
                    map.put("3", os);
                    break;
                case ("4"):
                    System.out.println("Введите  желаемый цвет:");
                    String color = scanner.nextLine();
                    map.put("4", color);
                    break;
                case ("5"):
                    if (map.isEmpty()) {
                        System.out.println("Вы не указали ни одного критерия, вам будут показаны все ноутбуки");
                        for (NoteBook noteBook : list) {
                            System.out.println(noteBook.toString());
                        }
                        work = false;
                    } else {


                    List<NoteBook> result = new ArrayList<>();
                    Set<String> keys = map.keySet();

                    String firstKey = keys.stream().findFirst().get();
                    if (firstKey.equals("1")) {
                        result = ozuCheck(list, map);
                    } else if (map.containsKey("1")) {
                        result = ozuCheck(result, map);
                    }

                    if (firstKey.equals("2")) {
                        result = zhDCheck(list, map);
                    } else if (map.containsKey("2")) {
                        result = zhDCheck(result, map);
                    }

                    if (firstKey.equals("3")) {
                        result = osCheck(list, map);
                    } else if (map.containsKey("3")) {
                        result = osCheck(result, map);
                    }

                    if (firstKey.equals("4")) {
                        result = colorCheck(list, map);
                    } else if (map.containsKey("4")) {
                        result = colorCheck(result, map);
                    }


                    System.out.println("По заданным вами критериям найдено " + result.size() + " ноутбуков" + "\n");
                    for (NoteBook noteBook : result) {
                        System.out.println(noteBook.toString());

            }
                    work = false;}
            break;

            default:
                System.out.println("Попробуйте выбрать желаемый критерий ещё раз");
        }
            }
        }


    static List<NoteBook> ozuCheck (List<NoteBook> list, Map <String, String> map){
        List<NoteBook> result = new ArrayList<>();
            for (NoteBook noteBook:list ){
                if (noteBook.ozu >= Integer.parseInt(map.get("1"))){
                    result.add(noteBook);
                }
            }
        return  result;
        }


    static List<NoteBook> zhDCheck (List<NoteBook> list, Map <String, String> map) {
        List<NoteBook> result = new ArrayList<>();
            for (NoteBook noteBook : list) {
                if (noteBook.hardDive >= Integer.parseInt(map.get("2"))) {
                    result.add(noteBook);
                }
            }

        return  result;
    }

    static List<NoteBook> osCheck (List<NoteBook> list, Map <String, String> map) {
        List<NoteBook> result = new ArrayList<>();
        for (NoteBook noteBook : list) {
            if (noteBook.opSystem.equalsIgnoreCase(map.get("3"))) {
                result.add(noteBook);
            }
        }

        return  result;
    }

    static List<NoteBook> colorCheck (List<NoteBook> list, Map <String, String> map) {
        List<NoteBook> result = new ArrayList<>();
        for (NoteBook noteBook : list) {
            if (noteBook.color.equalsIgnoreCase(map.get("4"))) {
                result.add(noteBook);
            }
        }

        return  result;
    }




}
