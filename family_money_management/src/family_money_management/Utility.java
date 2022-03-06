package family_money_management;
import java.util.Scanner;
/**
 Utility¹¤¾ßÀà£º
 ½«²»Í¬µÄ¹¦ÄÜ·â×°Îª·½·¨£¬¾ÍÊÇ¿ÉÒÔÖ±½ÓÍ¨¹ýµ÷ÓÃ·½·¨Ê¹ÓÃËüµÄ¹¦ÄÜ£¬¶øÎÞÐè¿¼ÂÇ¾ßÌåµÄ¹¦ÄÜÊµÏÖÏ¸½Ú¡£
 */
public class Utility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     ÓÃÓÚ½çÃæ²Ëµ¥µÄÑ¡Ôñ¡£¸Ã·½·¨¶ÁÈ¡¼üÅÌ£¬Èç¹ûÓÃ»§¼üÈë¡¯1¡¯-¡¯4¡¯ÖÐµÄÈÎÒâ×Ö·û£¬Ôò·½·¨·µ»Ø¡£·µ»ØÖµÎªÓÃ»§¼üÈë×Ö·û¡£
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.println("input wrong,input again");
            } else break;
        }
        return c;
    }
    /**
     ÓÃÓÚÊÕÈëºÍÖ§³ö½ð¶îµÄÊäÈë¡£¸Ã·½·¨´Ó¼üÅÌ¶ÁÈ¡Ò»¸ö²»³¬¹ý4Î»³¤¶ÈµÄÕûÊý£¬²¢½«Æä×÷Îª·½·¨µÄ·µ»ØÖµ¡£
     */
    public static int readNumber() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(4);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("money input wrong");
            }
        }
        return n;
    }
    /**
     ÓÃÓÚÊÕÈëºÍÖ§³öËµÃ÷µÄÊäÈë¡£¸Ã·½·¨´Ó¼üÅÌ¶ÁÈ¡Ò»¸ö²»³¬¹ý8Î»³¤¶ÈµÄ×Ö·û´®£¬²¢½«Æä×÷Îª·½·¨µÄ·µ»ØÖµ¡£
     */
    public static String readString() {
        String str = readKeyBoard(8);
        return str;
    }

    /**
     ÓÃÓÚÈ·ÈÏÑ¡ÔñµÄÊäÈë¡£¸Ã·½·¨´Ó¼üÅÌ¶ÁÈ¡¡®Y¡¯»ò¡¯N¡¯£¬²¢½«Æä×÷Îª·½·¨µÄ·µ»ØÖµ¡£
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("chose worng");
            }
        }
        return c;
    }


    private static String readKeyBoard(int limit) {
        String line = "";

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("\tinput string too long,input again:");
                continue;
            }
            break;
        }

        return line;
    }
}
