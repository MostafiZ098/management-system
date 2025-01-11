import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
	private JButton button1;
	private JButton button2;

    MyFrame() {
        ImageIcon image = new ImageIcon("E:/image/AIUB.png");
        this.setIconImage(image.getImage());
        this.setTitle("University Management System.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(600, 800);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Container c = this.getContentPane();
        c.setBackground(Color.WHITE);

        Label();
    }

    private void Label() {
        ImageIcon image = new ImageIcon("E:/image/AIUB.png");
        Font a = new Font("Ariel", Font.BOLD, 20);

        JLabel label1 = new JLabel("Welcome to AIUB");
        label1.setFont(a);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBounds(0, 20, 600, 30);

        JLabel label2 = new JLabel();
        label2.setIcon(image);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.BOTTOM);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setBounds(0, 100, 600, 230);

        JLabel label3 = new JLabel("American International University-Bangladesh (AIUB)");
        label3.setFont(a);
        label3.setForeground(Color.BLUE);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setBounds(0, 420, 600, 30);

        button1 = new JButton("Log In ... ");
        button1.setBounds(100, 550, 200, 30);
        button1.addActionListener(this);

        button2 = new JButton("Create Account...");
        button2.setBounds(300, 550, 200, 30);
        button2.addActionListener(this);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(button1);
        this.add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            new Login();
        } else if (e.getSource() == button2) {
            new CreateAccount();
        }
    }
}


class Login extends JFrame {
    JLabel label1;
    JComboBox<String> categoryComboBox;
    JTextField idField;
    JPasswordField passwordField;
    JButton submitButton;

    Login() {
        ImageIcon image = new ImageIcon("E:/image/AIUB.png");
        this.setIconImage(image.getImage());
        this.setTitle("Login.....");
        this.setSize(600, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        label1 = new JLabel("Select Category:");
        label1.setBounds(50, 50, 200, 30);
        String[] categories = {"Admin", "Faculty", "Student"};
        categoryComboBox = new JComboBox<>(categories);
        categoryComboBox.setBounds(200, 50, 200, 30);

        JLabel label2 = new JLabel("ID:");
        label2.setBounds(50, 100, 200, 30);
        idField = new JTextField();
        idField.setBounds(200, 100, 200, 30);

        JLabel label3 = new JLabel("Password:");
        label3.setBounds(50, 150, 200, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(200, 150, 200, 30);

        submitButton = new JButton("Submit");
        submitButton.setBounds(200, 200, 200, 30);
        submitButton.addActionListener(e -> idAndPassCheck());

        this.add(label1);
        this.add(categoryComboBox);
        this.add(label2);
        this.add(idField);
        this.add(label3);
        this.add(passwordField);
        this.add(submitButton);

        this.setVisible(true);
    }

    private void idAndPassCheck() {
        String id = idField.getText();
        String category = (String) categoryComboBox.getSelectedItem();
        String password = new String(passwordField.getPassword());
        
            if (id.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
            } else if (id.length() != 5 || !id.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Invalid ID. Please enter a 5-digit number.");
            } else if (password.length() < 6 || password.length() > 10 || !password.matches("[a-zA-Z0-9]+")) {
                JOptionPane.showMessageDialog(this, "Password must be 6 to 10 characters long and contain only a-z, A-Z, and 0-9.");
            } else {
                JOptionPane.showMessageDialog(this, "Logged in as " + category);
            }
        
    }
}

class CreateAccount extends JFrame {
    CreateAccount() {
        ImageIcon image = new ImageIcon("E:/image/AIUB.png");
        this.setIconImage(image.getImage());
        this.setTitle("Create Account...");
        this.setSize(600, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}

class Main {
    public static void main(String[] args) {
        new MyFrame();
    }
}
