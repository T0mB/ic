package opdracht_11;

@SuppressWarnings("unused")
public class KlokHuis {
     
    private int Kuren;
    private int Kminuten;
    private String uur;
    private String minuut;
    private String zonofmaan;
     
    public KlokHuis(int uren, int minuten) {
        Kuren = uren;
        Kminuten = minuten;
     
     
    if (uren >= 0 && uren < 24 && minuten >= 0 && minuten <= 59) {
        switch(uren){
        case 0:
            uur = "twaalf";
            zonofmaan = "'s nachts";
            break;
        case 1:
            uur = "een";
            zonofmaan = "'s nachts";
            break;
        case 2:
            uur = "twee";
            zonofmaan = "'s nachts";
            break;
        case 3:
            uur = "drie";
            zonofmaan = "'s nachts";
            break;
        case 4:
            uur = "vier";
            zonofmaan = "'s nachts";
            break;
        case 5:
            uur = "vijf";
            zonofmaan = "'s nachts";
            break;
        case 6:
            uur = "zes";
            zonofmaan = "'s ochtends";
            break;
        case 7:
            uur = "zeven";
            zonofmaan = "'s ochtends";
            break;
        case 8:
            uur = "acht";
            zonofmaan = "'s ochtends";
            break;
        case 9:
            uur = "negen";
            zonofmaan = "'s ochtends";
            break;
        case 10:
            uur = "tien";
            zonofmaan = "'s ochtends";
            break;
        case 11:
            uur = "elf";
            zonofmaan = "'s ochtends";
            break;
        case 12:
            uur = "twaalf";
            zonofmaan = "'s middags";
            break;
        case 13:
            uur = "een";
            zonofmaan = "'s middags";
            break;
        case 14:
            uur = "twee";
            zonofmaan = "'s middags";
            break;
        case 15:
            uur = "drie";
            zonofmaan = "'s middags";
            break;
        case 16:
            uur = "vier";
            zonofmaan = "'s middags";
            break;
        case 17:
            uur = "vijf";
            zonofmaan = "'s middags";
            break;
        case 18:
            uur = "zes";
            zonofmaan = "'s avond";
            break;
        case 19:
            uur = "zeven";
            zonofmaan = "'s avond";
            break;
        case 20:
            uur = "acht";
            zonofmaan = "'s avond";
            break;
        case 21:
            uur = "negen";
            zonofmaan = "'s avond";
            break;
        case 22:
            uur = "tien";
            zonofmaan = "'s avond";
            break;
        case 23:
            uur = "elf";
            zonofmaan = "'s avond";
            break;
 
        }
        if(minuten >= 0 && minuten <= 7){
            minuut = " uur";
             
        }
         
        else if(minuten >=8 && minuten <= 22){
            minuut = "kwart over ";
        }
         
        else if(minuten >=24 && minuten <= 37){
            minuut = "half ";
        }
         
        else if(minuten >= 38 && minuten <= 52){
            minuut = "kwart voor ";
        }
    }
    }
     
     
     
    @Override
    public String toString() {
        if(minuut.equals("half ")){
            return ""+minuut+uur+" "+zonofmaan;
        }
        else if(minuut.equals(" uur")){
            return ""+uur+minuut+" "+zonofmaan;
        }
        else if(minuut.equals("kwart over ")){
            return ""+minuut+uur+" "+zonofmaan;
        }
        else if(minuut.equals("kwart voor ")){
            return ""+minuut+uur+" "+zonofmaan; 
        }
        else {
            return "ain't nobody got time for that";
        }
     
}
 
 
}