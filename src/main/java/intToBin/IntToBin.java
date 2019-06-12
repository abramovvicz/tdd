package intToBin;

public class IntToBin {
    public static void main(String[] args) {
     howManyZero("00000111000001111100000")  ;
    }

    public String countIntToBin(int a) {
        String result = "";
        if (a < 0) {
            throw new IllegalArgumentException("Nie moża podawać parametrów ujemnych");
        }
        while (a > 0) {
            result = a % 2 + result;
            a = a / 2;
        }

        return result.equals("") ? "0" : result;
        //ładniej byłybo sprawdzać to wyżej jako a

        //napisac  program wktorym edzie wyliczal inta najwieksza liczbę zer miedzy jedynkami
    }


    public static int howManyZero(String a) {
        String str = a.substring(a.indexOf("1"), a.lastIndexOf("1") + 1);
        System.out.println("jakis string : " + str);
        String[] table = str.split("1");
        int result = 0;
        for (String s : table) {
            int i = s.length();
            if (i > result) {
                result = i;
            }
        }
        return result;
    }

}
