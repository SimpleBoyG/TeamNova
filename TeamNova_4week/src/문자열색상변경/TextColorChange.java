package 문자열색상변경;

public class TextColorChange {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";


    public void RedText(String str){
        System.out.println(RED + str + RESET);
    }

    public void CyanText(String str){
        System.out.println(CYAN + str + RESET);
    }

    public void YellowText(String str){
        System.out.println(YELLOW + str + RESET);
    }

    public void BlueText(String str){
        System.out.println(BLUE + str + RESET);
    }
    public void GreenText(String str){
        System.out.println(GREEN + str + RESET);
    }
    public void PurpleText(String str){
        System.out.println(PURPLE + str + RESET);
    }
}
