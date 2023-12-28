import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
public class String_Test {
    public static void main(String[] args) {
        String str = "Hi";

        String s = new String("Hi");

        System.out.println("사용되는 기본 캐릭터셋 : " + Charset.defaultCharset().name());
        byte[] byte_arr = {72, 101, 108, 108, 111}; // 스트링 생성
        String str_Test = new String(byte_arr);
        System.out.println("생성된 스트링 : " + str_Test); // Hello

        byte[] byte_arr1 = {72, 101, 108, 108, 111};
        String str_Test1 = new String(byte_arr1, Charset.forName("UTF-8"));
        System.out.println("생성된 스트링 : " + str_Test1);

        byte[] byte_arr3 = {72, 101, 108, 108, 111}; // Hello
        String str_Test3 = new String(byte_arr3, StandardCharsets.UTF_8);
        System.out.println("생성된 스트링 : " + str_Test3); // ell

        byte[] byte_arr4 = {72, 101, 108, 108, 111}; // Hello
        String str_Test4 = new String(byte_arr4, 1, 3);
        System.out.println("생성된 스트링 : " + str_Test4); // ell

        byte[] byte_arr5 = {72, 101, 108, 108, 111}; // Hello
        String str_Test5 = new String(byte_arr5, 1, 3, Charset.forName("UTF-8"));
        System.out.println("생성된 스트링 : " + str_Test5); // ell

        byte[] byte_arr6 = {72, 101, 108, 108, 111}; // Hello
        String str_Test6 = new String(byte_arr6, 1, 3, StandardCharsets.UTF_8);
        System.out.println("생성된 스트링 : " + str_Test6); // ell

        char char_arr7[] = {'H', 'e', 'l', 'l', 'o'};
        String str_Test7 = new String(char_arr7);
        System.out.println("생성된 스트링 : " + str_Test7); // Hello

        char char_arr8[] = {'H', 'e', 'l', 'l', 'o'};
        String str_Test8 = new String(char_arr8,1,3);
        System.out.println("생성된 스트링 : " + str_Test8); // Hello

        StringBuffer s_buffer9 = new StringBuffer("Hello");
        String str_Test9 = new String(s_buffer9);
        System.out.println("생성된 스트링 : " + str_Test9); // Hello

        StringBuilder s_builder10 = new StringBuilder("Hello");
        String str_Test10 = new String(s_builder10);
        System.out.println("생성된 스트링 : " + str_Test10); // Hello

        // CharAt(int index)
        String str_Temp = "910624-1388995";
        char c_sex = str_Temp.charAt(7); // 1
        System.out.println("c_sex"); // 성별확인 == 1

        // equals
        String strVar1 = new String("정준상");
        String strVar2 = "정준상";

        // 주소 번지를 비교
        if(strVar1 == strVar2){
            System.out.println("같은 String 객체를 참조");
        }else{
            System.out.println("다른 String 객체를 참조");
        }

        // 문자열을 비교
        if(strVar1.equals(strVar2)){
            System.out.println("같은 문자열을 가짐");
        }else{
            System.out.println("다른 문자열을 가짐");
        }

        System.out.println("========================================");
        String str1 = "안녕하세요";
        byte[] bytes1 = str1.getBytes();
        System.out.println("bytes1.length : " + bytes1.length);
        String str2 = new String(bytes1);
        System.out.println("bytes1->String: " + str2);

        System.out.println("==========IndexOf============");
        String str_temp1 = "팀노바 과제는 즐거워";
        int index1 = str_temp1.indexOf("과제는");
        int index2 = str_temp1.indexOf("팀노바");
        int index3 = str_temp1.indexOf("과즐");

        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);

        System.out.println("===========length===========");
        String strTeamNova = "팀노바 과제는 힘들지만 즐겁다";
        int strLength = strTeamNova.length();
        System.out.println("문자열의 수는 : " + strLength);

        System.out.println("===========replace==========");
        String oldStr = "팀노바 과제는 힘들다";
        String newStr = oldStr.replace("힘들다", "즐겁다");
        System.out.println("힘들다 -> 즐겁다 =>" + newStr);

        System.out.println("===========substring==========");
        String oldStr2 = "팀노바 과제는 정말 즐겁다";
        String newStr2 = oldStr2.substring(8,10);
        String newStr3 = oldStr2.substring(2);
        System.out.println("8자리 부터 10자리 까지 추출 : " + newStr2);
        System.out.println("2부터 끝까지 추출 : " + newStr3);

        System.out.println("==============toLowerCase================");
        String strTeamNova1 = "ENJOY YOUR TEAM NOVA LIFE";
        String smallStr = strTeamNova1.toLowerCase();
        System.out.println(smallStr);

        System.out.println("==============toUpperCase================");
        String strTeamNova2 = "enjoy your team nova life";
        String BigStr = strTeamNova2.toUpperCase();
        System.out.println(BigStr);

        System.out.println("==================trim===================");
        String strTrim1 = " 팀노바 ";
        String strTrim2 = "    하면서 ";
        String strTrim3 = " 즐겁게      ";
        String strTrim4 = "  살아남기";
        String TeamNovaTrim = strTrim1.trim() + strTrim2.trim() + strTrim3.trim() + strTrim4.trim();
        System.out.println(TeamNovaTrim);


        System.out.println("==================valueOf===================");
        String strTest1 = String.valueOf(true); // boolean
        String strTest2 = String.valueOf('N');  // char
        String strTest3 = String.valueOf(660);  // int
        String strTest4 = String.valueOf(2000); // long
        String strTest5 = String.valueOf(3.14); //double
        String strTest6 = String.valueOf(3.1567F); //float

        System.out.println(strTest1);
        System.out.println(strTest2);
        System.out.println(strTest3);
        System.out.println(strTest4);
        System.out.println(strTest5);
        System.out.println(strTest6);




    }

}
