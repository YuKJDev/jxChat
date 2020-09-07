import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class XChatForm extends JFrame implements ActionListener, KeyListener {
    private JPanel panel1;
    private JPanel bottomdPane;
    private JTextArea textArOut;
    private JTextArea textFldIn;
    private JButton sendBtn;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane1In;

    public XChatForm() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUIComponents();
        setTitle("xChat");

    }

    private void doExecute() {
        sendBtn.setActionCommand(textFldIn.getText());
        sendBtn.addActionListener(this);
        textFldIn.addKeyListener(this);

    }

    private void componentConfigurations() {
        setPreferredSize(new Dimension(600, 500));
        setResizable(true);
        panel1.setLayout(new BorderLayout());
        panel1.setMinimumSize(new Dimension(300, 400));
        textArOut.setDisabledTextColor(new Color(-4665371));
        textArOut.setEditable(false); // Путь пока будет нередактируемым
        textArOut.setLineWrap(true); // переносим на след строку если закончилось место
        textFldIn.setLineWrap(true);
        textFldIn.setMargin(new Insets(2, 2, 2, 2));
        bottomdPane.setVisible(true);
        sendBtn.setSize(50, 20);
        sendBtn.setVisible(true);
        textFldIn.setWrapStyleWord(true);
        textFldIn.setAutoscrolls(true);
        textArOut.setAutoscrolls(true);
        sendBtn.setText(">>");
        sendBtn.setOpaque(true);
        bottomdPane.add(sendBtn, BorderLayout.EAST);
        panel1.add(bottomdPane, BorderLayout.SOUTH);
        scrollPane1In.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setPreferredSize(new Dimension(598, 300));
        scrollPane1In.setPreferredSize(new Dimension(598, 50));
        scrollPane1.setViewportView(textArOut);
        scrollPane1In.setViewportView(textFldIn);
        panel1.add(scrollPane1, BorderLayout.NORTH);
        panel1.add(scrollPane1In, BorderLayout.CENTER);
        scrollPane1.setVisible(true);
        scrollPane1In.setVisible(true);
        

        setContentPane(panel1);
        pack();
        doExecute();

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        panel1 = new JPanel();
        textArOut = new JTextArea();
        textFldIn = new JTextArea(2, 2);
        scrollPane1 = new JScrollPane(textArOut);
        scrollPane1In = new JScrollPane(textFldIn);
        bottomdPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        sendBtn = new JButton("Отправить");
        componentConfigurations();


    }

    void doAction() {
        textArOut.append(textFldIn.getText());
        textFldIn.setText("");

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        doAction();

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            doAction();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
