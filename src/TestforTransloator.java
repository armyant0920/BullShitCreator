public class TestforTransloator {

    public static void main(String[] args) throws Exception {
       String s= "how are you?\nI'm fine\nreally?\nwhen people say they are fine,they're not really...";
        System.out.println(s);
       Translator t=new Translator();
        System.out.println(t.translate("en","zh-TW",s));


    }
}
