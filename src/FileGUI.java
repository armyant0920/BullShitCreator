
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.JOptionPane.*;

class FileGUI {

    private JFrame frame;// 定義窗體
    private JMenuBar bar;// 定義選單欄
    private TextArea textOutput;
    private JMenu fileMenu, editMenu;// 定義"檔案"和"子選單"選單
    private JMenuItem newItem, openItem, saveItem, saveOtherItem, closeItem;// 定義條目"退出"和"子條目"選單項
    private JMenuItem languageItem;
    private FileDialog openDia, saveDia;// 定義"開啟 儲存"對話方塊
    private File file;//定義檔案
    private JPanel panel;
    private String current;

    private TextField keyWord;

    FileGUI() {
        init();
    }

    //圖形使用者介面組建初始化
    public void init() {
        frame = new JFrame("廢文生成器");//建立窗體物件


        frame.setVisible(true); //設定窗體可見
        bar = new JMenuBar();// 建立選單欄

        textOutput = new TextArea();// 建立文字域
        keyWord = new TextField();

        fileMenu = new JMenu("檔案");// 建立"檔案"選單
        newItem = new JMenuItem("建立新檔");//建立新檔案

        openItem = new JMenuItem("開啟");//建立"開啟"選單項
        saveItem = new JMenuItem("儲存");//建立"儲存"選單項
        saveOtherItem = new JMenuItem("另存");
        closeItem = new JMenuItem("退出");//建立“退出"選單項
        fileMenu.add(newItem);//將 開新檔 新增到檔案選單上
        fileMenu.add(openItem);//將 開啟 選單項新增到 檔案 選單上
        fileMenu.add(saveItem);//將 儲存 選單項新增到 檔案 選單上
        fileMenu.add(closeItem);//將 退出 選單項新增到 檔案 選單上

        bar.add(fileMenu);//將檔案新增到選單欄上
        editMenu = new JMenu("編輯");
        languageItem = new JMenuItem("語言轉換");
        editMenu.add(languageItem);
        bar.add(editMenu);


        frame.setJMenuBar(bar);//將此窗體的選單欄設定為指定的選單欄.
        openDia = new FileDialog(frame, "Open", FileDialog.LOAD);
        saveDia = new FileDialog(frame, "Save", FileDialog.SAVE);
        frame.add(textOutput);// 將文字域新增到窗體內
        textOutput.requestFocus();//Kevin:focus後文字才有正常顯示,調查中
        textOutput.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                current = textOutput.getText();
                System.out.println(current);
                if (current.length() == 0)
                    current = null;
            }
        });

        myEvent();//載入事件處理

        frame.pack();
        frame.setBounds(300, 100, 600, 500);//設定窗體位置和大小

    }

    private void myEvent() {
        //開新檔案處理
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (file != null || current != null) {
                    int result = showConfirmDialog(frame, "即將另開新檔,請確認目前檔案已儲存", "建立新檔",
                            YES_NO_OPTION, WARNING_MESSAGE);
                    if (result == YES_OPTION) {
                        createArticle();

                    }


                } else {
                    createArticle();
                }

            }
        });


        //開啟選單項監聽
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDia.setVisible(true); //顯得開啟檔案對話方塊
                String dirpath = openDia.getDirectory();//獲取開啟檔案路徑並且儲存
                String fileName = openDia.getFile();//獲取檔名並且儲存

                if (dirpath == null || fileName == null) //判斷路徑和檔案是否為空
                    return;
                else
                    textOutput.setText(null); //檔案不為空 清除原來檔案內容
                file = new File(dirpath, fileName); //建立新的路徑和名稱
                try {
                    BufferedReader bufr = new BufferedReader(new FileReader(file));//嘗試從檔案中讀東西
                    String line = null; //變數字串初始化為空
                    while ((line = bufr.readLine()) != null) {
                        textOutput.append(line + "\r\n");
                    } //顯示每一行內容
                    System.out.println(textOutput.getText());
                    bufr.close();//關閉檔案

                } catch (FileNotFoundException e1) {
                    showMessageDialog(null, e1.getClass(), "系統找不到指定的檔案。", ERROR_MESSAGE);
                    System.out.println("系統找不到指定的檔案。");
                    e1.printStackTrace(); // 丟擲檔案路徑找不到異常

                } catch (IOException e2) {
                    e2.printStackTrace();// 丟擲IO異常
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (file == null) {
                    saveDia.setVisible(true);//顯示儲存檔案對話方塊
                    String dirpath = saveDia.getDirectory();//獲取儲存檔案路徑並儲存到字串中。
                    String fileName = saveDia.getFile() + ".txt";////獲取打儲存檔名稱並儲存到字串中

                    if (dirpath == null || fileName == null)//判斷路徑和檔案是否為空
                        return;//空操作
                    else
                        file = new File(dirpath, fileName);//檔案不為空，新建一個路徑和名稱
                }
                try {
                    BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
                    String text = textOutput.getText();//獲取文字內容
                    bufw.write(text);//將獲取文字內容寫入到字元輸出流
                    bufw.close();//關閉檔案
                } catch (IOException e1) {
                    e1.printStackTrace();//丟擲IO異常
                }
            }
        });

        saveOtherItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                saveDia.setVisible(true);//顯示儲存檔案對話方塊
                String dirpath = saveDia.getDirectory();//獲取儲存檔案路徑並儲存到字串中。
                String fileName = saveDia.getFile() + ".txt";////獲取打儲存檔名稱並儲存到字串中

                if (dirpath == null || fileName == null)//判斷路徑和檔案是否為空
                    return;//空操作
                else
                    file = new File(dirpath, fileName);//檔案不為空，新建一個路徑和名稱

                try {
                    BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
                    String text = textOutput.getText();//獲取文字內容
                    bufw.write(text);//將獲取文字內容寫入到字元輸出流
                    bufw.close();//關閉檔案
                } catch (IOException e1) {
                    e1.printStackTrace();//丟擲IO異常
                }
            }
        });

        languageItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChoiseLanguage dialog = new ChoiseLanguage();

//                dialog.setModal(true);
                String[] chooice = dialog.getResult();
                for (String s : chooice) {
                    System.out.println(s);
                }

                Translator t = new Translator();
                try {
                    current = t.translate(chooice[0], chooice[1], current);
                    textOutput.setText(current);
                    showMessageDialog(null,chooice[0]+"->"+chooice[1]+"翻譯完成","翻譯完成", INFORMATION_MESSAGE);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    showMessageDialog(null,chooice[0]+"->"+chooice[1]+"翻譯失敗","翻譯失敗", ERROR_MESSAGE);
                    System.err.println("出現異常,請注意如果字數太多會出現403網頁異常");
                }
            }
        });


        //窗體關閉監聽
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //退出選單項監聽
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createArticle() {

        file = null;
        current = null;
        textOutput.setText("");
        String inputValue = showInputDialog("請輸入關鍵字");

        ArrayList<String> options = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            String s = i * 1000 + "字";
            options.add(s);
        }

        if (inputValue != null) {
//            Object[] possibleValues = {"1000字", "2000字", "3000字", "4000字", "5000字", "6000字"};
            Object[] possibleValues = options.toArray();
            Object selectedValue = showInputDialog(null, "請選擇產生文章長度", "輸出文章長度",
                    INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
            if (selectedValue == null) {
                showMessageDialog(null, "未輸入文章長度,使用預設值", "文章長度", INFORMATION_MESSAGE);
                selectedValue = 6000;
            }
            String s = (String) selectedValue;
            s = s.substring(0, s.indexOf("字"));

            current = EssayGenerator.essayGenerator(inputValue, Integer.parseInt(s));
            textOutput.setText(current);
        } else {
            showMessageDialog(null, "無關鍵字,開啟空白新檔", "提醒", INFORMATION_MESSAGE);


        }
    }



    public static void main(String[] args) {
        new FileGUI();
    }



}