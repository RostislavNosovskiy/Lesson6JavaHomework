public class NoteBook {
    Integer ozu;
    Integer hardDive;
    String opSystem;
    String color;
    public String toString(){
        return "ОЗУ:"+ ozu + ", Объём ЖД:" + hardDive + ", Операционная система:" + opSystem + ", Цвет:" + color;
    }
    public NoteBook(Integer ozu, Integer  hardDive, String opSystem,  String color) {
        this.ozu = ozu;
        this.hardDive = hardDive;
        this.opSystem = opSystem;
        this.color = color;
    }


}
