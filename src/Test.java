import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String word="你好嗎";
        System.out.println(URLEncoder.encode(word, "UTF-8"));
    }
}
