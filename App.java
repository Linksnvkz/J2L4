import javax.swing.*;
import java.awt.*;
import java.util.Date;

class App extends JFrame {

    private JTextArea textArea;
    private JTextField textMessage;

    App() {
        setTitle("Chat");
        setBounds(800, 300, 300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jp1 = new JPanel();
        add(jp1, BorderLayout.CENTER);
        jp1.setBackground(Color.gray);
        jp1.setLayout(new BorderLayout());

        JPanel jp2 = new JPanel();
        add(jp2, BorderLayout.SOUTH);
        jp2.setBackground(Color.darkGray);
        jp2.setPreferredSize(new Dimension(1, 40));
        jp2.setLayout(new BorderLayout());


        JButton jb2 = new JButton("Отправить ->");
        jp2.add(jb2, BorderLayout.EAST);

        textArea = new JTextArea();
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        jp1.add(textAreaScroll, BorderLayout.CENTER);
        textArea.setEditable(false);

        textMessage = new JTextField();
        jp2.add(textMessage, BorderLayout.CENTER);

        jb2.addActionListener(e -> sendMessage());

        textMessage.addActionListener(e -> sendMessage());

        setVisible(true);
    }
    private void sendMessage() {
        Date date = new Date(System.currentTimeMillis());
        textArea.append(textMessage.getText() + "  " + date.getHours() + ":" + date.getMinutes()
                        + ":" + date.getSeconds() + "\n");
        textMessage.setText("");
    }
}