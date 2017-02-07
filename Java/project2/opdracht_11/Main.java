package opdracht_11;



public class Main {
    public static void main( String [ ] args ) {
        System.out.println("## heyho\n");
        KlokHuis tijd = new KlokHuis(03,45);
        KlokHuis tijd1 = new KlokHuis(12,7);
        KlokHuis tijd2 = new KlokHuis(17,15);
        KlokHuis tijd3 = new KlokHuis(0,15);
        KlokHuis tijd4 = new KlokHuis(15,39);
        KlokHuis tijd5 = new KlokHuis(23,33);
        System.out.print("03:45   ");
        System.out.println(tijd);
        System.out.print("12:07   ");
        System.out.println(tijd1);
        System.out.print("17:15   ");
        System.out.println(tijd2);
        System.out.print("00:15   ");
        System.out.println(tijd3);
        System.out.print("15:39   ");
        System.out.println(tijd4);
        System.out.print("23:33   ");
        System.out.println(tijd5);
    }
}