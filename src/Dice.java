import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;


public class Dice extends JFrame {

    public String nDm(int n,int m){
        StringBuilder ndm= new StringBuilder();
        for(int i=0;i<n;i++){
            int a = (int)(Math.random()*100%(m))+1;
            System.out.println(a);
            ndm.append(a).append(" ");
        }
        return ndm.toString();
    }

    private final JTextField textField;
    private final JTextField textField1;
    private final JLabel Answer;

    public Dice() {
        setTitle("DICE");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        JButton button = new JButton("Click me!");
        JLabel label = new JLabel("请输入你想要的骰子数目");
        JLabel label1 = new JLabel("请输入你想要的骰子，如D6，就输入6");
        Answer = new JLabel("");

        textField = new JTextField(10);
        textField1 = new JTextField(10);

        button.addActionListener(e -> {
            String text = textField.getText();
            System.out.println(text);
            int a = Integer.parseInt(text);

            String text1 = textField1.getText();
            int b = Integer.parseInt(text1);
            System.out.println(text1);

            String t = nDm(a,b);
            Answer.setText(t);

        });


        this.setLayout(new GridLayout(4,1));
        panel.add(button);

        panel2.add(textField);
        panel2.add(label);

        panel3.add(textField1);
        panel3.add(label1);

        panel4.add(Answer);

        add(panel);
        add(panel2);
        add(panel3);
        add(panel4);
    }

    public static void main(String[] args) {
        Dice ui = new Dice();
        ui.setVisible(true);
    }

}
