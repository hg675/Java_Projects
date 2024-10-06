import java.awt.*;
import javax.swing.*;

public class MyTextEditor extends JFrame {
        private final JTextPane harshit = new JTextPane();
        private final JComboBox<String> jComboBox1 = new JComboBox<>();
        private final JComboBox<String> fontSizeBox = new JComboBox<>();

        public MyTextEditor() {
                String[] allFonts = { "Arial", "Calibri", "Cambria", "Courier New", "Comic Sans MS", "Dialog",
                                "Georgia",
                                "Helevetica", "Lucida Sans", "Monospaced", "SignPainter", "Tahoma", "Times New Roman",
                                "Verdana" };
                String[] sizes = { "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70",
                                "75",
                                "80", "85", "90" };

                for (String font : allFonts) {
                        jComboBox1.addItem(font);
                }

                for (String size : sizes) {
                        fontSizeBox.addItem(size);
                }

                harshit.setFont(new Font("Cambria", Font.PLAIN, 20));

                JMenuBar men = createMenuBar();
                JPanel lpanel = createMainPanel();

                setLayout(new BorderLayout());
                add(men, BorderLayout.NORTH);
                add(lpanel, BorderLayout.CENTER);

                setTitle("Text Editor");
                setSize(800, 600);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                setSize(screenSize.width, screenSize.height);
                setLocationRelativeTo(null);
        }

        private JMenuBar createMenuBar() {
                JMenuBar men = new JMenuBar();

                JMenu file = new JMenu("File");
                JMenu edit = new JMenu("Edit");
                JMenu review = new JMenu("Review");
                JMenu help = new JMenu("Help");

                JMenuItem newfile = new JMenuItem("New");
                JMenuItem opens = new JMenuItem("Open");
                JMenuItem sve = new JMenuItem("Save");
                JMenuItem sveas = new JMenuItem("Save as...");
                JMenuItem ext = new JMenuItem("Exit");
                file.add(newfile);
                file.add(opens);
                file.addSeparator();
                file.add(sve);
                file.add(sveas);
                file.addSeparator();
                file.add(ext);

                JMenuItem _cut = new JMenuItem("Cut");
                JMenuItem _copy = new JMenuItem("Copy");
                JMenuItem _paste = new JMenuItem("Paste");
                edit.add(_cut);
                edit.add(_copy);
                edit.add(_paste);

                JMenuItem _find = new JMenuItem("Find");
                JMenuItem _find_and_replace = new JMenuItem("Find and Replace");
                JMenuItem _count = new JMenuItem("Word Count");
                review.add(_find);
                review.add(_find_and_replace);
                review.addSeparator();
                review.add(_count);

                JMenuItem _about_us = new JMenuItem("About Us");
                help.add(_about_us);

                men.add(file);
                men.add(edit);
                men.add(review);
                men.add(help);

                return men;
        }

        private JPanel createMainPanel() {
                JPanel mainpanel = new JPanel();
                mainpanel.setLayout(new BorderLayout());

                JPanel mainpanel1 = new JPanel();
                mainpanel1.setLayout(new BorderLayout());
                mainpanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                JPanel mainpanel2 = new JPanel();
                mainpanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                JPanel sketchpanel = new JPanel(new BorderLayout());
                JPanel sketchPanel1 = new JPanel();
                sketchPanel1.setLayout(new BoxLayout(sketchPanel1, BoxLayout.X_AXIS));

                JPanel sketchpanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JLabel sketchlabel = new JLabel("SketchPad");
                sketchpanel2.add(sketchlabel);

                JPanel sketchpanel3 = new JPanel(new BorderLayout());

                JButton b1 = new JButton("Rectangle");
                JButton b2 = new JButton("Oval");
                JButton b3 = new JButton("Line");
                JButton b4 = new JButton("Triangle");
                JButton b5 = new JButton("Pentagon");
                JButton clearbutton = new JButton("Clear");

                sketchPanel1.add(b1);
                sketchPanel1.add(b2);
                sketchPanel1.add(b3);
                sketchPanel1.add(b4);
                sketchPanel1.add(b5);
                sketchPanel1.add(Box.createRigidArea(new Dimension(5, 0)));
                sketchPanel1.add(clearbutton);
                
                sketchpanel3.add(sketchPanel1, BorderLayout.NORTH);
                sketchpanel3.add(new PaintBox(), BorderLayout.SOUTH);
                sketchpanel.add(sketchpanel2, BorderLayout.NORTH);
                sketchpanel.add(sketchpanel3);
                mainpanel2.add(sketchpanel);

                JPanel spanel = new JPanel();
                spanel.setLayout(new BorderLayout());

                JPanel spanel1 = new JPanel();
                spanel1.setLayout(new BoxLayout(spanel1, BoxLayout.PAGE_AXIS));

                // Find panel
                JPanel findPanel = new JPanel();
                findPanel.setLayout(new GridLayout(2, 1));
                JLabel jLabel1 = new JLabel("Find");
                JTextField findText = new JTextField(20);
                findText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                findPanel.add(jLabel1);
                findPanel.add(findText);

                // Replace panel
                JPanel replacePanel = new JPanel();
                replacePanel.setLayout(new GridLayout(2, 1));
                JLabel jLabel2 = new JLabel("Replace");
                JTextField replaceWithText = new JTextField(20);
                replaceWithText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                replacePanel.add(jLabel2);
                replacePanel.add(replaceWithText);

                JPanel otherFindpanel = new JPanel();
                otherFindpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                JButton m1 = new JButton("Find All");
                JButton m3 = new JButton("Find Next");
                JButton m2 = new JButton("Replace All");
                JButton m4 = new JButton("Replace");
                otherFindpanel.add(m1);
                otherFindpanel.add(m3);
                otherFindpanel.add(m2);
                otherFindpanel.add(m4);

                spanel1.add(findPanel);
                spanel1.add(replacePanel);
                spanel1.add(otherFindpanel);

                harshit.setPreferredSize(new Dimension(800, 450));
                JPanel tpanel = new JPanel();
                tpanel.setLayout(new BorderLayout());
                tpanel.add(harshit, BorderLayout.CENTER);

                spanel.add(spanel1, BorderLayout.NORTH);
                spanel.add(tpanel, BorderLayout.SOUTH);

                JPanel wpanel = new JPanel();
                wpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel wordcnt = new JLabel("Word Count: ");
                JLabel wordCount = new JLabel("");
                JLabel charcnt = new JLabel("Character Count: ");
                JLabel characterCount = new JLabel("");
                JLabel informationDisplay = new JLabel("");
                wpanel.add(wordcnt);
                wpanel.add(wordCount);
                wpanel.add(charcnt);
                wpanel.add(characterCount);
                wpanel.add(informationDisplay);
                wpanel.setBackground(Color.LIGHT_GRAY);

                JPanel fpanel = new JPanel();
                fpanel.setLayout(new BoxLayout(fpanel, BoxLayout.X_AXIS));
                Dimension buttonSize = new Dimension(20, 20);

                ImageIcon boldIcon = new ImageIcon(
                                new ImageIcon("bold.png").getImage().getScaledInstance(buttonSize.width,
                                                buttonSize.height, Image.SCALE_DEFAULT));
                ImageIcon italicIcon = new ImageIcon(
                                new ImageIcon("Italic.png").getImage().getScaledInstance(buttonSize.width,
                                                buttonSize.height, Image.SCALE_DEFAULT));
                ImageIcon underlineIcon = new ImageIcon(new ImageIcon("underline.png").getImage()
                                .getScaledInstance(buttonSize.width, buttonSize.height, Image.SCALE_DEFAULT));
                ImageIcon strikethroughIcon = new ImageIcon(new ImageIcon("strikethrough.png").getImage()
                                .getScaledInstance(buttonSize.width, buttonSize.height, Image.SCALE_DEFAULT));
                ImageIcon lAlignIcon = new ImageIcon(
                                new ImageIcon("lalign.png").getImage().getScaledInstance(buttonSize.width,
                                                buttonSize.height, Image.SCALE_DEFAULT));
                ImageIcon cAlignIcon = new ImageIcon(
                                new ImageIcon("calign.png").getImage().getScaledInstance(buttonSize.width,
                                                buttonSize.height, Image.SCALE_DEFAULT));
                ImageIcon rAlignIcon = new ImageIcon(
                                new ImageIcon("ralign.png").getImage().getScaledInstance(buttonSize.width,
                                                buttonSize.height, Image.SCALE_DEFAULT));
                ImageIcon justifyIcon = new ImageIcon(new ImageIcon("justify.png").getImage()
                                .getScaledInstance(buttonSize.width, buttonSize.height, Image.SCALE_DEFAULT));

                JButton jBold = new JButton(boldIcon);
                JButton jItalics = new JButton(italicIcon);
                JButton jUnderline = new JButton(underlineIcon);
                JButton jStrikethrough = new JButton(strikethroughIcon);

                fpanel.add(jBold);
                fpanel.add(jItalics);
                fpanel.add(jUnderline);
                fpanel.add(jStrikethrough);

                fpanel.add(Box.createRigidArea(new Dimension(5, 0)));

                JButton jLeftalign = new JButton(lAlignIcon);
                JButton jCenteralign = new JButton(cAlignIcon);
                JButton jRightalign = new JButton(rAlignIcon);
                JButton jJustify = new JButton(justifyIcon);

                fpanel.add(jLeftalign);
                fpanel.add(jCenteralign);
                fpanel.add(jRightalign);
                fpanel.add(jJustify);

                jComboBox1.setMaximumSize(new Dimension(250, 25));
                fontSizeBox.setMaximumSize(new Dimension(150, 25));

                fpanel.add(Box.createRigidArea(new Dimension(5, 0)));

                fpanel.add(jComboBox1);
                fpanel.add(fontSizeBox);

                mainpanel1.add(spanel, BorderLayout.CENTER);
                mainpanel1.add(fpanel, BorderLayout.NORTH);

                mainpanel.add(mainpanel1, BorderLayout.WEST);
                mainpanel.add(mainpanel2, BorderLayout.CENTER);
                mainpanel.add(wpanel, BorderLayout.SOUTH);

                return mainpanel;
        }

        public class PaintBox extends JPanel {
                public PaintBox() {
                        setPreferredSize(new Dimension(400, 580));
                        setBackground(Color.GRAY);
                }
        }

        

        public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> {
                        new MyTextEditor().setVisible(true);
                });
        }
}
