package Sample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class frame extends JFrame {


    public static void main(String[] args) {
        frame frame = new frame();
        frame.setVisible(true);
    }

    private JPanel contentPane;
    private JButton BT;

    public frame() {   //init frame
        setTitle("Test");
        setBounds(100, 100, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));


        BT = new JButton("call dialog");        //set a button
        contentPane.add(BT);

        //button listener
        BT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mydialog ID = new Mydialog();       //創建自己定義的Dialog
                ID.setModal(true);        //這個無敵重要 一定要有  意義為  彈出Dialog程序會                                                                       暫停在此 各位可以試試有此行與無此行所取得的                                                                        值有何變化
                ID.setBounds(100, 100, 200, 400);
                testclass tc = ID.getValue();                //呼叫自己創建的Dialog中的一個自訂義function
                System.out.println(tc.getS());
            }
        });
    }

}


class Mydialog extends JDialog {                     //自訂義的Dialog中我只放入兩個東西 按鈕跟TextField想要放入更多東西可以自己設定
    private JButton ok = new JButton("OK");
    private JTextField TF = new JTextField("    ");
    testclass tc;

    public Mydialog() {
        JPanel JP = new JPanel();
        add(JP);
        JP.add(ok);
        JP.add(TF);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);                                //點了這個按鈕之後就讓Dialog隱藏
                tc = new testclass(TF.getText());
                dispose();                                          //讓Dialog 關閉
            }
        });
    }

    public testclass getValue() {
        setVisible(true);                     //呼叫此Function之後 讓Dialog顯示
        return tc;
    }
}

class testclass {                                     //一個隨便定義的Class  表示 Dialog也可以回傳給Frame 自訂義Class{
    String s;

    public testclass(String ins) {
        s = ins;
    }

    public String getS() {
        return s;
    }
}