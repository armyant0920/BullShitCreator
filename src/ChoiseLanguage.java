import javax.swing.*;
import java.awt.event.*;

public class ChoiseLanguage extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private String pickLanguage[];


    private static String language[] = {"zh-TW", "zh-CN","en",  "ja", "ko", "th"};

    public ChoiseLanguage() {
        pickLanguage = new String[2];
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    onOK();
                } catch (FieldException fieldException) {
                    fieldException.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
//        createUIComponents();

        pack();
        setLocationRelativeTo(null);

    }

    private void onOK() throws FieldException {//按下OK後應該取得兩邊語言


            pickLanguage[0] = (String) comboBox1.getSelectedItem();
            pickLanguage[1] = (String) comboBox2.getSelectedItem();
            if(pickLanguage[0].equals(pickLanguage[1])){
                throw new FieldException("欄位值異常");
            }

//         pickLanguage[]={(String)comboBox1.getSelectedItem(),(String)comboBox2.getSelectedItem()};


            setVisible(false);
            dispose();
     /*   } catch (FieldException e1){
            e1.printStackTrace();
        }catch (Exception e2) {
            e2.printStackTrace();
        }*/

    }

    public String[] getResult() {
        setVisible(true);
        return pickLanguage;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

/*
    public static void main(String[] args) {
        ChoiseLanguage dialog = new ChoiseLanguage();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
*/

    private void createUIComponents() {
        // TODO: place custom component creation code here
        comboBox1 = new JComboBox(language);
        comboBox2 = new JComboBox(language);

        ItemListener itemListener = new

                ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (ItemEvent.SELECTED == e.getStateChange()) {

                            String selectedItem = e.getItem().toString();
                            System.out.printf("new selected item : %s%n", selectedItem);
                            System.out.println(e.getSource());
                        }
                        if (ItemEvent.DESELECTED == e.getStateChange()) {
                            String selectedItem = e.getItem().toString();
                            System.out.printf("deselected item : %s%n", selectedItem);
                        }

                    }
                };
        comboBox1.addItemListener(itemListener);
        comboBox2.addItemListener(itemListener);

    }
    class httpException extends Exception{
        public httpException(){
            super();

        }
        public httpException(String s){
            super(s);

        }

    }
    class FieldException extends  Exception{
        public FieldException(String msg){
            super(msg);

        }
    }
}
