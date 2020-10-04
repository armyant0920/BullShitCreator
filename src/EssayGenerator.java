


import java.util.Arrays;
import java.util.List;

    public final class EssayGenerator {

    /*    public static void main(String[] args) {
            String theme = "球鞋";
            String res = essayGenerator(theme );
            System.out.println(res.length());
            System.out.println(res);
        }*/

        public static String essayGenerator(String theme) {
            return essayGenerator(theme,6000);
        }
        public static String essayGenerator(String theme, int sum) {
            StringBuffer res = new StringBuffer(sum);
            while(res.length()<sum){
                int num = (int) (Math.random() * 100);
                if (num < 5){
                    //5%概率换个行
                    res.append("\r\n");
                }else if (num < 30){
                    //25%概率说个名言
                    res.append(randomChoice(famous)
                            .replace("a",randomChoice(before))
                            .replace("b",randomChoice(after))
                    );
                    if((int) (Math.random() * 100)<50){
                        //写完名言后50%概率换个行
                        res.append("\r\n");
                    }
                }else{
                    //70%概率说着车轱辘话，为了不能跑题啊，哈哈哈
                    res.append(randomChoice(remark)
                            .replace("x",theme)
                    );
                }
            }

            return res.toString();
        }
        public static <T> T randomChoice(List<T> data) {
            //随机取一个工具函数，不理解泛型的，把T换成String
            int num = (int) (Math.random() * data.size());
            return data.get(num);
        }
        private EssayGenerator() {
        }
        static List<String> famous = Arrays.asList(
                "愛迪生a，天才是百分之一的勤奮加百分之九十九的汗水。b",
                "查爾斯·史a，一個人幾乎可以在任何他懷有無限熱忱的事情上成功。b",
                "培根說過，深窺自己的心，而後發覺一切的奇蹟在你自己。b",
                "歌德曾經a，流水在碰到底處時才會釋放活力。b",
                "莎士比亞a，那腦袋裡的智慧，就像打火石裡的火花一樣，不去打它是不肯出來的。b",
                "戴爾·卡耐基a，多數人都擁有自己不了解的能力和機會，都有可能做到未曾夢想的事情。b",
                "白哲特a，堅強的信念能贏得強者的心，並使他們變得更堅強。b",
                "伏爾泰a, 不經巨大的困難，不會有偉大的事業。b",
                "富勒曾經a, 苦難磨煉一些人，也毀滅另一些人。b",
                "文森特·皮爾a, 改變你的想法，你就改變了自己的世界。b",
                "拿破崙·希爾a, 不要等待，時機永遠不會恰到好處。b",
                "塞涅卡a, 生命如同寓言，其價值不在與長短，而在與內容。b",
                "奧普拉·溫弗瑞a, 你相信什麼，你就成為什麼樣的人。b",
                "呂凱特a, 生命不可能有兩次，但許多人連一次也不善於度過。b",
                "莎士比亞a, 人的一生是短的，但如果卑劣地過這一生，就太長了。b",
                "笛卡兒a, 我的努力求學沒有得到別的好處，只不過是愈來愈發覺自己的無知。b",
                "左拉a, 生活的道路一旦選定，就要勇敢地走到底，決不回頭。b",
                "米歇潘a, 生命是一條艱險的峽谷，只有勇敢的人才能通過。b",
                "吉姆·羅恩a, 要么你主宰生活，要么你被生活主宰。b",
                "日本諺語a, 不幸可能成為通向幸福的橋樑。b",
                "海貝爾a, 人生就是學校。在那裡，與其說好的教師是幸福，不如說好的教師是不幸。b",
                "杰納勒爾·喬治·S·巴頓a, 接受挑戰，就可以享受勝利的喜悅。b",
                "德謨克利特a, 節制使快樂增加並使享受加強。b",
                "裴斯泰洛齊a, 今天應做的事沒有做，明天再早也是耽誤了。b",
                "歌德a, 決定一個人的一生，以及整個命運的，只是一瞬之間。b",
                "卡耐基a, 一個不注意小事情的人，永遠不會成就大事業。b",
                "盧梭a, 浪費時間是一樁大罪過。b",
                "康德a, 既然我已經踏上這條道路，那麼，任何東西都不應妨礙我沿著這條路走下去。b",
                "克勞斯·莫瑟爵士a, 教育需要花費錢，而無知也是一樣。b",
                "伏爾泰a, 堅持意志偉大的事業需要始終不渝的精神。b",
                "亞伯拉罕·林肯a, 你活了多少歲不算什麼，重要的是你是如何度過這些歲月的。b",
                "韓非a, 內外相應，言行相稱。b",
                "富蘭克林a, 你熱愛生命嗎？那麼別浪費時間，因為時間是組成生命的材料。b",
                "馬爾頓a, 堅強的信心，能使平凡的人做出驚人的事業。b",
                "笛卡兒a, 讀一切好書，就是和許多高尚的人談話。b",
                "塞涅卡a, 真正的人生，只有在經過艱難卓絕的鬥爭之後才能實現。b",
                "易卜生a, 偉大的事業，需要決心，能力，組織和責任感。b",
                "歌德a, 沒有人事先了解自己到底有多大的力量，直到他試過以後才知道。b",
                "達爾文a, 敢於浪費哪怕一個鐘頭時間的人，說明他還不懂得珍惜生命的全部價值。b",
                "佚名a, 感激每一個新的挑戰，因為它會鍛造你的意志和品格。b",
                "奧斯特洛夫斯基a, 共同的事業，共同的鬥爭，可以使人們產生忍受一切的力量。 b",
                "蘇軾a, 古之立大事者，不惟有超世之才，亦必有堅忍不拔之志。b",
                "王陽明a, 故立志者，為學之心也；為學者，立誌之事也。b",
                "歌德a, 讀一本好書，就如同和一個高尚的人在交談。b",
                "烏申斯基a, 學習是勞動，是充滿思想的勞動。b",
                "別林斯基a, 好的書籍是最貴重的珍寶。b",
                "富蘭克林a, 讀書是易事，思索是難事，但兩者缺一，便全無用處。b",
                "魯巴金a, 讀書是在別人思想的幫助下，建立起自己的思想。b",
                "培根a, 合理安排時間，就等於節約時間。b",
                "屠格涅夫a, 你想成為幸福的人嗎？但願你首先學會吃得起苦。b",
                "莎士比亞a, 拋棄時間的人，時間也拋棄他。b",
                "叔本華a, 普通人只想到如何度過時間，有才能的人設法利用時間。b",
                "博a, 一次失敗，只是證明我們成功的決心還夠堅強。 維b",
                "拉羅什夫科a, 取得成就時堅持不懈，要比遭到失敗時頑強不屈更重要。b",
                "莎士比亞a, 人的一生是短的，但如果卑劣地過這一生，就太長了。b",
                "俾斯麥a, 失敗是堅忍的最後考驗。b",
                "池田大作a, 不要迴避苦惱和困難，挺起身來向它挑戰，進而克服它。b",
                "莎士比亞a, 那腦袋裡的智慧，就像打火石裡的火花一樣，不去打它是不肯出來的。b",
                "希臘a, 最困難的事情就是認識自己。b",
                "黑塞a, 有勇氣承擔命運這才是英雄好漢。b",
                "非洲a, 最靈繁的人也看不見自己的背脊。b",
                "培根a, 閱讀使人充實，會談使人敏捷，寫作使人精確。b",
                "斯賓諾莎a, 最大的驕傲於最大的自卑都表示心靈的最軟弱無力。b",
                "西班牙a, 自知之明是最難得的知識。b",
                "塞內加a, 勇氣通往天堂，怯懦通往地獄。b",
                "赫爾普斯a, 有時候讀書是一種巧妙地避開思考的方法。b",
                "笛卡兒a, 閱讀一切好書如同和過去最傑出的人談話。b",
                "鄧拓a, 越是沒有本領的就越加自命不凡。b",
                "愛爾蘭a, 越是無能的人，越喜歡挑剔別人的錯兒。b",
                "老子a, 知人者智，自知者明。勝人者有力，自勝者強。b",
                "歌德a, 意志堅強的人能把世界放在手中像泥塊一樣任意揉捏。b",
                "邁克爾·F·斯特利a, 最具挑戰性的挑戰莫過於提升自我。b",
                "愛迪生a, 失敗也是我需要的，它和成功對我一樣有價值。b",
                "羅素·貝克a, 一個人即使已登上頂峰，也仍要自強不息。b",
                "馬雲a, 最大的挑戰和突破在於用人，而用人最大的突破在於信任人。b",
                "雷鋒a, 自己活著，就是為了使別人過得更美好。b",
                "布爾沃a, 要掌握書，莫被書掌握；要為生而讀，莫為讀而生。b",
                "培根a, 要知道對好事的稱頌過於誇大，也會招來人們的反感輕蔑和嫉妒。b",
                "莫扎特a, 誰和我一樣用功，誰就會和我一樣成功。b",
                "馬克思a, 一切節省，歸根到底都歸結為時間的節省。b",
                "莎士比亞a, 意志命運往往背道而馳，決心到最後會全部推倒。b",
                "卡萊爾a, 過去一切時代的精華盡在書中。b",
                "培根a, 深窺自己的心，而後發覺一切的奇蹟在你自己。b",
                "羅曼·羅蘭a, 只有把抱怨環境的心情，化為上進的力量，才是成功的保證。b",
                "孔子a, 知之者不如好之者，好之者不如樂之者。b",
                "達·芬奇a, 大膽和堅定的決心能夠抵得上武器的精良。b",
                "叔本華a, 意志是一個強壯的盲人，倚靠在明眼的跛子肩上。b",
                "黑格爾a, 只有永遠躺在泥坑里的人，才不會再掉進坑里。b",
                "普列姆昌德a, 希望的燈一旦熄滅，生活剎那間變成了一片黑暗。b",
                "維龍a, 要成功不需要什麼特別的才能，只要把你能做的小事做得好就行了。b",
                "郭沫若a, 形成天才的決定因素應該是勤奮。b",
                "洛克a, 學到很多東西的訣竅，就是一下子不要學很多。b",
                "西班牙a, 自己的鞋子，自己知道緊在哪裡。b",
                "拉羅什福科a, 我們唯一不會改正的缺點是軟弱。b",
                "亞伯拉罕·林肯a, 我這個人走得很慢，但是我從不後退。b",
                "美華納a, 勿問成功的秘訣為何，且盡全力做你應該做的事吧。b",
                "俾斯麥a, 對於不屈不撓的人來說，沒有失敗這回事。b",
                "阿卜·日·法拉茲a, 學問是異常珍貴的東西，從任何源泉吸收都不可恥。b",
                "白哲特a, 堅強的信念能贏得強者的心，並使他們變得更堅強。 b",
                "查爾斯·史考伯a, 一個人幾乎可以在任何他懷有無限熱忱的事情上成功。 b",
                "貝多芬a, 卓越的人一大優點是：在不利與艱難的遭遇裡百折不饒。b",
                "莎士比亞a, 本來無望的事，大膽嘗試，往往能成功。b",
                "卡耐基a, 我們若已接受最壞的，就再沒有什麼損失。b",
                "德國a, 只有在人群中間，才能認識自己。b",
                "史美爾斯a, 書籍把我們引入最美好的社會，使我們認識各個時代的偉大智者。b",
                "馮學峰a, 當一個人用工作去迎接光明，光明很快就會來照耀著他。b",
                "吉格·金克拉a, 如果你能做夢，你就能實現它。b"

        );

        static List<String> remark = Arrays.asList(
                "現在, 解決x的問題, 是非常非常重要的. 所以, ",
                "我們不得不面對一個非常尷尬的事實, 那就是, ",
                "x的發生, 到底需要如何做到, 不x的發生, 又會如何產生. ",
                "而這些並不是完全重要, 更加重要的問題是, ",
                "x, 到底應該如何實現. ",
                "帶著這些問題, 我們來審視一下x. ",
                "所謂x, 關鍵是x需要如何寫. ",
                "我們一般認為, 抓住了問題的關鍵, 其他一切則會迎刃而解.",
                "問題的關鍵究竟為何? ",
                "x因何而發生?",
                "每個人都不得不面對這些問題. 在面對這種問題時, ",
                "一般來講, 我們都必須務必慎重的考慮考慮. ",
                "要想清楚, x, 到底是一種怎麼樣的存在. ",
                "了解清楚x到底是一種怎麼樣的存在, 是解決一切問題的關鍵.",
                "就我個人來說, x對我的意義, 不能不說非常重大. ",
                "本人也是經過了深思熟慮,在每個日日夜夜思考這個問題. ",
                "x, 發生了會如何, 不發生又會如何. ",
                "在這種困難的抉擇下, 本人思來想去, 寢食難安.",
                "生活中, 若x出現了, 我們就不得不考慮它出現了的事實. ",
                "這種事實對本人來說意義重大, 相信對這個世界也是有一定意義的.",
                "我們都知道, 只要有意義, 那麼就必須慎重考慮.",
                "既然如此, ",
                "那麼, ",
                "我認為, ",
                "一般來說, ",
                "總結的來說, ",
                "既然如何, ",
                "經過上述討論, ",
                "這樣看來, ",
                "從這個角度來看, ",
                "我們不妨可以這樣來想: ",
                "這是不可避免的. ",
                "可是，即使是這樣，x的出現仍然代表了一定的意義. ",
                "x似乎是一種巧合，但如果我們從一個更大的角度看待問題，這似乎是一種不可避免的事實. ",
                "在這種不可避免的衝突下，我們必須解決這個問題. ",
                "對我個人而言，x不僅僅是一個重大的事件，還可能會改變我的人生. "
        );

        static List<String> before = Arrays.asList(
                "曾經說過",
                "在不經意間這樣說過",
                "說過一句著名的話",
                "曾經提到過",
                "說過一句富有哲理的話"

        );
        static List<String> after = Arrays.asList(
                "這不禁令我深思. ",
                "帶著這句話, 我們還要更加慎重的審視這個問題: ",
                "這啟發了我. ",
                "我希望諸位也能好好地體會這句話. ",
                "這句話語雖然很短, 但令我浮想聯翩. ",
                "這句話看似簡單，但其中的陰鬱不禁讓人深思. ",
                "這句話把我們帶到了一個新的維度去思考這個問題: ",
                "這似乎解答了我的疑惑. "

        );
    }

