import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import JsonTool.JSONArray;

/**
 * 網上找到的接Google翻譯API偷吃步
 * 不清楚為什麼這樣可以繞過驗證,反正先拿來用吧
 * 其中client=gtx是Google Toolbox for Accessibility的意思
 * sl是轉換前文件語言,
 * tl是欲轉換成的語言
 * &dt=t&q=
 *
 * Google API傳回來的是JSONARRAY
 *
 * 需特別注意,一次能轉換的字數似乎有上限,超過會exception
 */

public class Translator {
    public String translate(String langFrom, String langTo,
                            String word) throws Exception {

        String url = "https://translate.googleapis.com/translate_a/single?" +
                "client=gtx&" +
                "sl=" + langFrom +
                "&tl=" + langTo +
                "&dt=t&q=" + URLEncoder.encode(word, "UTF-8");

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return parseResult(response.toString());
    }

    private String parseResult(String inputJson) throws Exception {
        /*
         * inputJson for word 'hello' translated to language Hindi from English-
         * [[["नमस्ते","hello",,,1]],,"en"]
         * We have to get 'नमस्ते ' from this json.
         */

        JSONArray jsonArray = new JSONArray(inputJson);
        JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
//        JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);
        String result ="";

        for(var i =0;i < jsonArray2.length();i ++){
            result += ((JSONArray) jsonArray2.get(i)).get(0).toString();
        }

        return result;
    }


}