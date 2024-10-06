import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UniversityInterface extends JFrame {
    public UniversityInterface() {
        setTitle("Shiv Nadar University");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());


        // Blue Box
        JPanel blueBox = new JPanel(new BorderLayout());
        Color blueColor = new Color(0, 81, 151);
        blueBox.setBackground(blueColor);
        blueBox.setPreferredSize(new Dimension(getWidth(), 100));



        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0,81,151));
        leftPanel.setPreferredSize(new Dimension((int) (blueBox.getPreferredSize().width / 3.0), blueBox.getPreferredSize().height));
        ImageIcon leftPanelIcon = new ImageIcon(getClass().getResource("logo.png"));
        JLabel leftPanelLabel = new JLabel(leftPanelIcon);
        leftPanelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(leftPanelLabel, BorderLayout.CENTER);
        blueBox.add(leftPanel, BorderLayout.WEST);



        // Search Panel
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(blueColor);
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon searchIcon = new ImageIcon(getClass().getResource("search.png"));
        JLabel searchIconLabel = new JLabel(searchIcon);
        int searchPanelHeight = 30;
        searchIconLabel.setPreferredSize(new Dimension(searchPanelHeight, searchPanelHeight));
        searchPanel.add(searchIconLabel);
        JTextField searchBox = new JTextField("Search");
        searchBox.setPreferredSize(new Dimension(150, 30));
        searchBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        searchBox.setHorizontalAlignment(JTextField.LEFT);
        searchPanel.add(searchBox);
        searchPanel.setPreferredSize(new Dimension(180, searchPanelHeight));
        blueBox.add(searchPanel, BorderLayout.CENTER);



        // right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(0,81,151));
        rightPanel.setPreferredSize(new Dimension((int) (blueBox.getPreferredSize().width / 3.0), blueBox.getPreferredSize().height));
        blueBox.add(rightPanel, BorderLayout.EAST);

        JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        middlePanel.setBackground(new Color(0,81,151));
        middlePanel.setPreferredSize(new Dimension(200,30));

        JLabel greetingLabel = new JLabel("Hi, Harshit Gangwar");
        greetingLabel.setForeground(Color.white);
        middlePanel.add(greetingLabel);

        ImageIcon originalIcon = new ImageIcon("drop.png"); 
        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton menuButton = new JButton();
        menuButton.setIcon(scaledIcon);
        menuButton.setBorder(new LineBorder(new Color(0, 81, 151)));
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("LogOut"));
        popupMenu.add(new JMenuItem("Forgot password"));
        popupMenu.add(new JMenuItem("Change/Reset password"));
        popupMenu.addSeparator();
        popupMenu.add(new JMenuItem("IT Helpdesk"));
        popupMenu.add(new JMenuItem("How To Login"));
        
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(menuButton, 0, menuButton.getHeight());
            }
        });
        menuButton.setPreferredSize(new Dimension(20,20));
        middlePanel.add(menuButton);
        menuButton.setBackground(new Color(0,81,151));
        rightPanel.add(middlePanel, BorderLayout.CENTER);




        // Black box
        JPanel blackBox = new JPanel();
        blackBox.setBackground(new Color(23,20,31,255));
        blackBox.setPreferredSize(new Dimension(getWidth(), 200));

        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(new Color(23, 20, 31, 255));
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        String[] arr = {"Student Policy", "Student Handbook", "Academic Research", "University Library", "Mess Menu", "NetID Help"};
        String[] arr2 = {"SP", "SH", "AR", "UL", "MM", "NH"};

        for (int i = 0; i < 6; i++) {
            JLabel cursorLabel = new JLabel(arr[i], JLabel.CENTER);
            cursorLabel.setPreferredSize(new Dimension(200, 50));
            cursorLabel.setBackground(new Color(23, 20, 31, 255));
            cursorLabel.setForeground(Color.WHITE);

            ImageIcon originalIcon1 = new ImageIcon(arr2[i] + ".png");
            Image originalImage = originalIcon1.getImage();
            Image resizedImage = originalImage.getScaledInstance(-1, cursorLabel.getPreferredSize().height, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(resizedImage);

            cursorLabel.setBorder(BorderFactory.createLineBorder(new Color(23, 20, 31, 255)));
            Font originalFont = cursorLabel.getFont();
            Font newFont = new Font(originalFont.getName(), Font.PLAIN, originalFont.getSize());
            cursorLabel.setFont(newFont);
            cursorLabel.setIcon(icon);

            upperPanel.add(cursorLabel);
        }
        blackBox.add(upperPanel,BorderLayout.CENTER);


        JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label1 = new JLabel("2023 - Shiv Nadar(Institution of Eminence Deemed to be University)");
        label1.setForeground(Color.WHITE);
        lowerPanel.setBackground(new Color(23, 20, 31, 255));
        Font labelFont = label1.getFont();
        label1.setFont(new Font(labelFont.getName(), Font.PLAIN, 16));
        lowerPanel.add(label1,BorderLayout.SOUTH);
        blackBox.add(lowerPanel, BorderLayout.SOUTH);



        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 6, 10, 10));

        panel2.add(createButton("University ERP", "1.png"));
        panel2.add(createButton("Assistanceship/ Awardship", "2.png"));
        panel2.add(createButton("BlackBoard", "3.png"));
        panel2.add(createButton("CCT", "4.png"));
        panel2.add(createButton("Certificate Insurance", "5.png"));
        panel2.add(createButton("Course Evaluation Survey", "6.png"));
        panel2.add(createButton("Doctoral Portal", "7.png"));
        panel2.add(createButton("Fastrack", "8.png"));
        panel2.add(createButton("Hostel Management", "9.png"));
        panel2.add(createButton("ID-Card Management", "10.png"));
        panel2.add(createButton("Mobile-App CMS", "11.png"));
        panel2.add(createButton("On-Campus Job", "12.png"));
        panel2.add(createButton("Student Outbound Mobility", "13.png"));
        panel2.add(createButton("Student Attendance Recording", "14.png"));
        panel2.add(createButton("Student Attendance Management", "15.png"));
        panel2.add(createButton("Student Clearance", "16.png"));
        panel2.add(createButton("Student Payment Center", "17.png"));

        JPanel panel3 = new JPanel();
        panel3.add(panel2, BorderLayout.CENTER);

        panel1.add(blackBox, BorderLayout.SOUTH);
        panel1.add(blueBox, BorderLayout.NORTH);
        panel1.add(panel3, BorderLayout.CENTER);

        add(panel1);
        setVisible(true);
    }

    private JButton createButton(String text, String imagePath) {
        JButton button;
        Font normalFont = new Font("SansSerif", Font.PLAIN, 12);
        if (text.equals("University ERP")) {
            button = new JButton(
                    "<html><div style='text-align: left;'>" + text.replaceAll(" ", "<br>") + "</div></html>");
            button.setBackground(new Color(1, 103, 189));
            button.setForeground(Color.WHITE);
            button.setFont(normalFont);
        } else {
            button = new JButton(
                    "<html><div style='text-align: left;'>" + text.replaceAll(" ", "<br>") + "</div></html>");
            button.setBackground(Color.WHITE);
            button.setFont(normalFont);
        }


        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image image = icon.getImage();

        int buttonHeight = 50; 
        int imageHeight = buttonHeight - button.getInsets().top - button.getInsets().bottom;
        Image scaledImage = image.getScaledInstance(-1, imageHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(scaledIcon);
        button.setLayout(new BorderLayout());
        button.add(Box.createHorizontalGlue());
        button.add(label, BorderLayout.WEST);
        button.add(Box.createHorizontalStrut(2)); 

        button.setBorder(new LineBorder(Color.BLUE, 1));
        button.setPreferredSize(new Dimension(170, buttonHeight)); 

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UniversityInterface());
    }
}
