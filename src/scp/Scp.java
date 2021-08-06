/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scp;
///*a simple program for scp foundation only for learning purpose now support traditional chinese and English version
//all content is response to scp-wiki.net
//any other illegal uses which are illegal is not included in the developer responsibilities

//免責聲明 一切下載及使用軟件時均被視為已經仔細閱讀並完全同意以下條款：
//軟件僅供個人學習與交流使用，嚴禁用於商業以及不良用途。 如有發現任何商業行為以及不良用途，
//軟件作者有權撤銷使用權。 使用本軟件所存在的風險將完全由其本人承擔，軟件作者不承擔任何責任。 
//此程式由 http://www.scp-wiki.net/ 使用權利所擁有 所有內容出於 scp-wiki.net
//軟件註明之服務條款外，其它因不當使用本軟件而導致的任何意外、疏忽、合約毀壞、誹謗、版權或其他知識產權侵犯及其所造成的任何損失，
//本軟件作者概不負責，亦不承擔任何法律責任。 對於因不可抗力或因黑客攻擊、通訊線路中斷等不能控制的原因造成的服務中斷或其他缺陷，
//導致用戶不能正常使用，軟件作者不承擔任何責任，但將盡力減少因此給用戶造成的損失或影響。 本聲明未涉及的問題請參見國家有關法律法規，
//當本聲明與國家有關法律法規衝突時，以國家法律法規為準。 本軟件相關聲明版權及其修改權、更新權和最終解釋權均屬軟件作者所有。
//
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import com.spreada.utils.chinese.ZHConverter;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.speech.Central;
import javax.speech.Engine;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.apache.commons.io.IOUtils;
import javax.swing.JTextField;

/**
 *
 * @author Jason
 */
public class Scp extends Applet
        implements MouseListener, ActionListener, WindowListener, KeyListener {

    /**
     * @param args the command line arguments
     */
    private JTextField textfield;
    private BufferedImage img;
    private JPanel panel;
    // JLabel picture;
    private JFrame frame;
    private JTextArea text;
    private JComboBox<String> box;
    private ArrayList<String> url;
    private ArrayList<String> content;
    private JPanel toppanel;
    private JPanel toptoppanel;
    private JLabel label;

    private JLabel information;
    private Content con;
    private JCheckBox chinese;
    private JCheckBox english;

    private boolean isenglish = false;

    private JMenu menu;
    private JMenuBar menubar;
    private JMenuItem m1, m2;

    private boolean storymode = false;
    private JButton voice;
    private JButton ranScp;
    private JPanel buttonplace;

    Scp() throws MalformedURLException, IOException {
        this.buttonplace = new JPanel();
        this.buttonplace.setLayout(null);
        this.buttonplace.setVisible(true);
        this.buttonplace.setSize(200, 400);
        this.buttonplace.setLocation(800, 150);
        //  this.buttonplace.setBackground(Color.red);

        voice = new JButton("Speak(English only)");
        voice.setSize(180, 50);
        voice.setVisible(true);
        voice.setLayout(null);
        voice.setLocation(0, 0);
        this.buttonplace.add(voice);

        ranScp = new JButton("Ran Scp");
        ranScp.setSize(180, 50);
        ranScp.setVisible(true);
        ranScp.setLayout(null);
        ranScp.setLocation(0, 60);
        this.buttonplace.add(ranScp);

        m1 = new JMenuItem("documentmode");

        m2 = new JMenuItem("storymode");

        menu = new JMenu("menu");
        menu.setVisible(true);
        menu.add(m1);
        menu.add(m2);
        //   menu.setMnemonic(KeyEvent.VK_A);
        //  menu.setSize(100, 30);
        //menu.setLocation(0, 0);
        this.menubar = new JMenuBar();
        menubar.add(menu);
        this.menubar.setVisible(true);
        this.menubar.setLocation(0, 0);
        this.menubar.setSize(200, 30);

        this.chinese = new JCheckBox("Chinese");
        // this.chinese.setVisible(true);
        this.chinese.setLocation(0, 40);
        this.chinese.setSize(100, 40);
        this.chinese.setLayout(null);
        this.english = new JCheckBox("English");
        //this.english.setVisible(true);
        this.english.setLocation(200, 40);
        this.english.setSize(100, 40);
        this.english.setLayout(null);

        this.chinese.setSelected(true);
        this.chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                english.setSelected(false);
                isenglish = false;
            }
        });
        this.english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chinese.setSelected(false);
                isenglish = true;
            }
        });

        this.information = new JLabel();
        this.information.setVisible(true);
        this.information.setLayout(null);
        this.information.setSize(100, 20);
        this.information.setLocation(700, 10);
        this.information.setText("Enter 001 to 5999");
        this.information.repaint();

        this.content = new ArrayList<>();
        this.box = new JComboBox();
        con = new Content();
        textfield = new JTextField(20);
        //  textfield.setSize(100,40);
        this.textfield.setBounds(0, 0, 300, 30);
        this.textfield.setVisible(true);
        this.setLocation(0, 0);

        this.label = new JLabel();
        label.setSize(300, 30);
        label.setVisible(true);
        label.setLocation(400, 0);
        label.setLayout(null);
        label.add(this.textfield);
        //  this.label.add(this.english);

        this.toptoppanel = new JPanel();
        this.toptoppanel.setVisible(true);
        this.toptoppanel.setSize(1000, 100);
        this.toptoppanel.setLocation(0, 0);
        //  this.toptoppanel.setLayout(null);
        this.toptoppanel.add(this.chinese);
        this.toptoppanel.add(this.english);

        //    this.toptoppanel.add(this.menubar);
        this.toptoppanel.setLayout(null);
        this.toptoppanel.add(label);
        this.toptoppanel.add(this.information);
        if (url != null) {
            createbox(url.size() - 1);
        } else {
            createbox(0);
        }
        toppanel = new JPanel();
        toppanel.setSize(1000, 50);
        this.toppanel.setVisible(true);
        // this.toppanel.setBackground(Color.red);
        this.toppanel.setLocation(0, 100);
        //  toppanel.add(this.textfield);
        toppanel.add(box);

//        img = ImageIO.read(new URL("http://scp-wiki.wdfiles.com/local--files/scp-002/800px-SCP002.jpg"));
        panel = new JPanel();
        panel.setSize(800, 600);
        panel.setVisible(true);
        //  panel.setLayout(null);
        //  panel.setLocation(100, 100);
        panel.setLocation(0, 150);
        //   panel.setLayout(new GridLayout(2, 2));
        //     panel.setBackground(Color.BLACK);

        text = new JTextArea(30, 70);
        text.setSize(300, 200);
        text.setVisible(true);

        JScrollPane scroll = new JScrollPane(text);
        scroll.setSize(300, 200);
        scroll.setVisible(true);

        //  picture.setIcon(new ImageIcon(img));
        //   this.picture.add(scroll);
        frame = new JFrame("SCP");
        frame.setLayout(null);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        // frame.add(text);
        frame.add(this.toptoppanel);
        frame.add(this.toppanel);
        frame.add(panel);
        frame.add(this.buttonplace);

        this.frame.setJMenuBar(menubar);
        //panel.add(picture);
        this.frame.addWindowListener(this);
        this.textfield.addKeyListener(this);
        // panel.add(box);
        panel.add(scroll);
        //  panel.add(this.voice);

        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = "";
                    // System.out.println(box.toString());
                    String checking = String.valueOf(box.getSelectedItem());
                    // System.out.println(checking);

                    if (content.indexOf(checking) >= 0) {
                        String format = url.get(content.indexOf(checking));
                        int urltop = format.indexOf("\"");
                        int urlbottom = format.indexOf("\"", urltop + 1);
                        format = format.subSequence(urltop + 1, urlbottom).toString();
                        System.out.println("the picture is in " + format);
                        input = format;
                    }

                    if (input != "") {
                        Picture a = new Picture(input);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Scp.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storymode = false;
                ScpDocument doc = new ScpDocument();
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storymode = true;
                //    System.out.println("it work!!! option 2");
            }
        });
        voice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean speaking = false;
                if (speaking == false) {
                    try {
                        if (con.out().isEmpty() == false) {
                            con.sound(con.out());
                        } else {
                            //    System.out.println("nothing");
                        }
                    } catch (Exception ex) {

                    }
                }
            }

        });
        this.ranScp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int rannum = con.ranScp();
                //   System.out.println(rannum);
                String ran = "scp-0";
                if (rannum < 100 && rannum > 10) {
                    ran = ran + Integer.toString(rannum);
                } else if (rannum < 10) {
                    ran = ran + "0" + Integer.toString(rannum);
                } else {
                    ran = "scp-" + Integer.toString(rannum);
                }
                if (isenglish == false) {
                    con.search(ran);
                    String out = ZHConverter.convert(con.out(), ZHConverter.TRADITIONAL);
                    text.setText("");
                    text.setText(out);

                    if (con.imageList() != null) {
                        url = con.imageList();
                        content = con.imagediscribe();
                    }
                    if (url != null) {
                        // System.out.println("hi");
                        createbox(url.size() - 1);

                        //list = null;
                        frame.revalidate();
                        frame.repaint();
                        box.revalidate();
                        box.repaint();
                        toppanel.revalidate();
                        toppanel.repaint();
                        frame.revalidate();
                        frame.repaint();
                    }
                } else {
                    con.searchenglish(ran);
                    String out = con.out();
                    text.setText("");
                    text.setText(out);

                    if (con.imageList() != null) {
                        url = con.imageList();
                        content = con.imagediscribe();
                    }
                    if (url != null) {
                        // System.out.println("hi");
                        createbox(url.size() - 1);

                        //list = null;
                        frame.revalidate();
                        frame.repaint();
                        box.revalidate();
                        box.repaint();
                        toppanel.revalidate();
                        toppanel.repaint();
                        frame.revalidate();
                        frame.repaint();
                    }
                }
                text.setCaretPosition(0);
            }
            //   System.gc();
        });

        //     picture.add(box);
        //   panel.repaint();
        //  this.toppanel.repaint();
        //  JWebBrowser a1 = null;
        // a1.executeJavascript("<iframe src=\"/scp-049/html/8e52f60fe1f51880be5cf6c40ae5adc7c409c633-4188595161646598502\" allowtransparency=\"true\" frameborder=\"0\" class=\"html-block-iframe\" style=\"height: 54px;\"></iframe>");
        //  this.frame. setLocationRelativeTo ( null );
    }

    public void createbox(int num) {
        //  this.box = null;

        box.removeAllItems();
        //   box.addItem("nothing");
        //  System.out.println(num);
        if (num == 0) {
            box.addItem("no picture");
        } else if (num >= 1) {
            box.addItem("drag down do have picture");
        } else {
            box.addItem("no picture");
        }
        if (this.url != null) {
            for (int i = 0; i <= num; i++) {
                box.addItem(this.content.get(i));
            }
        }
        //   box.addItem("none");
        //    box.setSelectedIndex(0);
        //     box.get
        //  box.setLocation(, 100);
        // box.setSize(10, 60);   
        box.setSelectedIndex(0);
        box.setVisible(true);
        this.box.setSize(30, 30);

    }

    public static void main(String[] args) throws IOException {

        Scp a = new Scp();
        // Content con = new Content();
        // con.search_other_version("4999");

    }

    public void settext(String in) {
        text.append(in);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        // System.out.println(keyCode);
        System.gc();
        if (keyCode == 10) {
            if (this.isenglish == false) {
                this.con.search(this.textfield.getText());
                String out = ZHConverter.convert(this.con.out(), ZHConverter.TRADITIONAL);
                this.text.setText("");
                this.text.setText(out);

                if (con.imageList() != null) {
                    url = con.imageList();
                    this.content = con.imagediscribe();
                }
                if (this.url != null) {
                    // System.out.println("hi");
                    this.createbox(url.size() - 1);

                    //list = null;
                    this.frame.revalidate();
                    this.frame.repaint();
                    this.box.revalidate();
                    this.box.repaint();
                    this.toppanel.revalidate();
                    this.toppanel.repaint();
                    this.frame.revalidate();
                    this.frame.repaint();
                }
            } else {
                this.con.searchenglish(this.textfield.getText());
                String out = this.con.out();
                this.text.setText("");
                this.text.setText(out);

                if (con.imageList() != null) {
                    url = con.imageList();
                    this.content = con.imagediscribe();
                }
                if (this.url != null) {
                    // System.out.println("hi");
                    this.createbox(url.size() - 1);

                    //list = null;
                    this.frame.revalidate();
                    this.frame.repaint();
                    this.box.revalidate();
                    this.box.repaint();
                    this.toppanel.revalidate();
                    this.toppanel.repaint();
                    this.frame.revalidate();
                    this.frame.repaint();
                }
            }

        }
        text.setCaretPosition(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

class Content {

    private String result;
    private ArrayList<String> imageurl;
    private ArrayList<String> imagediscribe;
    public List<String> serielnumber;
    private Thread soundthread;
    private boolean speaking = false;
    private Synthesizer synthesizer;
    private int i = 0;
    private int jsp_input;

    Content() {
        result = "";
        this.imagediscribe = new ArrayList();
    }

    public void sound(String input) {
        final Lock lock = new ReentrantLock();
        if (input.isEmpty()) {
            try {
                throw new Exception("no input");
            } catch (Exception ex) {

            }
        }
        if (speaking == false) {
            // speaking = true;
            //    System.out.println(speaking);
            if (i == 0) {
                soundthread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            if (i == 0) {
                                i++;
                                System.setProperty("freetts.voices",
                                        "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

                                // Register Engine 
                                Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");

                                // Create a Synthesizer 
                                synthesizer
                                        = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));

                                // Allocate synthesizer 
                                synthesizer.allocate();

                                // Resume Synthesizer 
                                synthesizer.resume();

                                // speaks the given text until queue is empty. 
                                synthesizer.speak(input, null);
                                synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                                //      synthesizer.deallocate();
                                // Deallocate the Synthesizer. 
                                System.out.println("reach speak end");
                                i = 0;
                                //    synthesizer.cancelAll();
                                // Thread.currentThread().wait();
                                //    Thread.currentThread().interrupt();;
                                System.gc();
                                //Thread.currentThread()=null;
                            } else if (i == 4) {
                                // synthesizer.cancel();
                                //  synthesizer.wait();

                                synthesizer.pause();
                                //   synthesizer.cancel();
                                //  synthesizer.deallocate();
                                synthesizer = null;
                                System.gc();
// synthesizer.wait();
                                //synthesizer.cancel();
                                //  i = 0;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //Thread Implmentation code here

                };
                soundthread.start();
            }

            if (i != 0) {
                //    lock.lock();
                i = 0;
                try {

                    //      synthesizer.pause();
                    //this.synthesizer.waitEngineState(Engine.DEALLOCATING_RESOURCES);
                    this.synthesizer.pause();
                    //this.synthesizer.waitEngineState(Engine.DEALLOCATED);

                    // this.soundthread.wait();
                    this.soundthread = null;
                    synthesizer = null;
                    System.gc();
                    // this.soundthread.interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            speaking = false;
            System.out.print(speaking);
            try {
                //   synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
                synthesizer.waitEngineState(Synthesizer.QUEUE_NOT_EMPTY);
                this.synthesizer.wait();
                if (this.synthesizer == null) {
                    //         System.out.println("null");
                }
                synthesizer.deallocate();

                //  this.synthesizer.resume();
                //   this.synthesizer=null;
                this.soundthread.wait();

                if (soundthread.isAlive()) {
                    System.out.println(soundthread.isAlive());
                    //   this.soundthread.interrupt();
                }
                //  this.soundthread=null;
//                this.synthesizer.cancel();;
                // this.synthesizer.cancelAll();
                //   this.soundthread.interrupt();

            } catch (IllegalMonitorStateException e) {
                System.out.println(e.toString());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            this.soundthread = null;
        }

// set property as Kevin Dictionary 
    }

    public void stopthread() {
        if (this.soundthread != null) {
            System.out.println("not null");
            if (this.soundthread.isAlive() == true) {
                this.soundthread.interrupt();
                System.out.println("interupt");
            }
        }
    }

    public ArrayList<String> imageList() {
        return this.imageurl;
    }

    public ArrayList<String> imagediscribe() {
        return this.imagediscribe;
    }

    public String out() {
        return result;
    }

    public void search(String in) {
        boolean ch_3125 = false;
        if (in.contains("3125") == true) {
            ch_3125 = true;

        }
        result = "";
        // System.out.print(001>999);
        try {

            if (in.contains("scp-") == false) {
                in = "scp-" + in;
            }
            String check = in.replaceAll("scp-", "");
            int check_num = Integer.parseInt(check);

            try {

                String name = "";
                if (check_num < 1000) {
                    name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series"), "utf-8");
                } else if (check_num >= 1000 && check_num < 2000) {
                    name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-2"), "utf-8");
                } else if (check_num >= 2000 && check_num < 3000) {
                    name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-3"), "utf-8");
                } else if (check_num >= 3000 && check_num < 4000) {
                    name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-4"), "utf-8");
                } else if (check_num >= 4000 && check_num < 5000) {
                    name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-5"), "utf-8");
                } else if (check_num >= 5000 && check_num < 6000) {
                    name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-6"), "utf-8");
                } else if (check_num >= 6000 && check_num < 7000) {
                    name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-7"), "utf-8");
                }

                int ckname = name.indexOf(in);
                int ck_middle = name.indexOf("</a>", ckname);
                int ck_bottom = name.indexOf("</li>", ck_middle);
                name = name.subSequence(ck_middle, ck_bottom).toString();
                name = name.replaceAll("</a>", "");
                name = name.replaceAll("-", "");
                name = name.replaceAll(" ", "");
                name = name.replaceAll("<strong>", "");
                name = name.replaceAll("</strong>", "");
                name = ZHConverter.convert(name, ZHConverter.TRADITIONAL);
                String content = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/" + in), "utf-8");

                String firstresult = "";
                int top = content.indexOf("<div id=\"page-title\">");
                int bottom = content.indexOf("<div id=\"wad-scp-wiki-cn-below-content\" class=\"wd-adunit wd-ad-np wd-adunit-below_content\">");//special bottom for cn web
                firstresult = content.subSequence(top, bottom).toString();//content create

                imageurl = new ArrayList<String>();

                int imagetop = firstresult.indexOf("<img src");
                int imagebottom = firstresult.indexOf(">", imagetop);

                this.imagediscribe = null;
                this.imagediscribe = new ArrayList();
                //   System.out.println(imagetop);
                while (imagetop > 0 && imagebottom > 0) {

                    String get = firstresult.subSequence(imagetop, imagebottom + 1).toString();
                    int imagecontop = firstresult.indexOf("<p>", imagebottom);
                    int imageconbottom = firstresult.indexOf("</p>", imagecontop);
                    // System.out.println(123);
                    if (imagecontop > 0) {

                        String imagecontent = firstresult.subSequence(imagecontop + 3, imageconbottom).toString();
                        imagecontent = ZHConverter.convert(imagecontent, ZHConverter.TRADITIONAL);
                        this.imagediscribe.add(imagecontent);
                        // System.out.println(imagecontent);
                        //  System.out.println(imagecontent .equals("SCP-"+in.subSequence(4, in.length())));
                        if (imagecontent.equals(in) == false && imagecontent.equals("SCP-" + in.subSequence(4, in.length())) == false) {
                            // System.out.println(imagecontent);
                            firstresult = firstresult.replaceAll(imagecontent, " ");
                        }
                    }
                    //   System.out.println(this.imagediscribe.get(0));
                    imageurl.add(get);
                    firstresult = firstresult.replaceAll(get, " ");
                    firstresult = firstresult.replace(get, " ");
                    //  System.out.println(get);

                    imagetop = firstresult.indexOf("<img src");
                    imagebottom = firstresult.indexOf(">", imagetop);
                }

                int informtop = firstresult.indexOf("<div class=\"info-container\">");
                int informbottom = firstresult.indexOf("<strong>", informtop);
                if (informtop > 0) {
                    String deleting = firstresult.subSequence(informtop, informbottom).toString();
                    firstresult = firstresult.replaceAll(deleting, " ");
                    firstresult = firstresult.replace(deleting, " ");
                }
                firstresult = firstresult.replaceAll(" ", "");
                firstresult = firstresult.replaceAll("\n\n", "");
                firstresult = firstresult.replaceAll("<p>", "");
                firstresult = firstresult.replaceAll("<strong>", "");
                firstresult = firstresult.replaceAll("</strong>", "");
                firstresult = firstresult.replaceAll("<br/>", "");
                firstresult = firstresult.replaceAll("</p>", "");
                firstresult = firstresult.replaceAll("&nbsp;", "");

                firstresult = firstresult.replaceAll("，", "，\n");
                firstresult = firstresult.replaceAll("。", "。\n");
                firstresult = firstresult.replaceAll("", "");
                firstresult = firstresult.replaceAll("</blockquote>", "");
                firstresult = firstresult.replaceAll("</em>", "");
                firstresult = firstresult.replaceAll("</a>", "");
                firstresult = firstresult.replaceAll("<blockquote>", "");
                firstresult = firstresult.replaceAll("<em>", "");
                firstresult = firstresult.replaceAll("<a>", "");
                firstresult = firstresult.replaceAll("</div>", "");
                firstresult = firstresult.replaceAll("<tr>", "");
                firstresult = firstresult.replaceAll("</tr>", "");
                firstresult = firstresult.replaceAll("<li>", "");
                firstresult = firstresult.replaceAll("</li>", "");
                firstresult = firstresult.replaceAll("<ul>", "");
                firstresult = firstresult.replaceAll("</ul>", "");

                firstresult = firstresult.replaceAll("<sub>", "");
                firstresult = firstresult.replaceAll("</sub>", "");
                firstresult = firstresult.replaceAll("<td>", "");
                firstresult = firstresult.replaceAll("</td>", "");
                firstresult = firstresult.replaceAll("</table>", "");
                firstresult = firstresult.replaceAll("</sup>", "");
                firstresult = firstresult.replaceAll("<divid=\"page-content\">", "");
                firstresult = firstresult.replaceAll("<divid=\"page-title\">", "");
                firstresult = firstresult.replaceAll("</span>", " ");
                firstresult = firstresult.replaceAll("<!--wikidot_bottom_300x250-->", "");
                firstresult = firstresult.replaceAll("<hr/>", "");
                firstresult = firstresult.replaceAll("</h1>", "");
                firstresult = firstresult.replaceAll("</iframe>", "");

                int spantop = firstresult.indexOf("<span");
                int spanbottom = firstresult.indexOf("\">", spantop);
                while (spantop > 0) {

                    String delete = firstresult.subSequence(spantop, spanbottom + 2).toString();

                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    spantop = firstresult.indexOf("<span");
                    spanbottom = firstresult.indexOf("\">", spantop);
                    if (spanbottom == -1) {
                        spantop = -1;
                    }
                }

                int atop = firstresult.indexOf("<a");
                int abottom = firstresult.indexOf("\">", atop);
                while (atop > 0) {

                    String delete = firstresult.subSequence(atop, abottom + 2).toString();

                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    atop = firstresult.indexOf("<a");
                    abottom = firstresult.indexOf("\">", atop);
                    if (abottom == -1) {
                        atop = -1;
                    }
                }

                int divtop = firstresult.indexOf("<div");
                int divbottom = firstresult.indexOf(">", divtop);
                while (divtop > 0) {
                    String delete = firstresult.subSequence(divtop, divbottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");

                    divtop = firstresult.indexOf("<div");
                    divbottom = firstresult.indexOf(">", divtop);
                    if (divbottom == -1) {
                        divtop = -1;
                    }
                }

                int tabletop = firstresult.indexOf("<table");
                int tablebottom = firstresult.indexOf(">", tabletop);
                while (tabletop > 0) {
                    String delete = firstresult.subSequence(tabletop, tablebottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    tabletop = firstresult.indexOf("<table");
                    tablebottom = firstresult.indexOf(">", tabletop);
                    if (tablebottom == -1) {
                        tabletop = -1;
                    }
                }
                int suptop = firstresult.indexOf("<sup");
                int supbottom = firstresult.indexOf(">", suptop);

                while (suptop > 0 && supbottom > 0) {
                    String delete = firstresult.subSequence(suptop, supbottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    //     System.out.println(delete);
                    suptop = firstresult.indexOf("<sup");
                    supbottom = firstresult.indexOf(">", suptop);
                    if (supbottom == -1) {
                        suptop = -1;
                    }
                }

                int iframetop = firstresult.indexOf("<iframe");
                int iframebottom = firstresult.indexOf(">", iframetop);
                //   System.out.println(iframebottom);
                while (iframetop > 0 && iframebottom > 0) {
                    String delete = firstresult.subSequence(iframetop, iframebottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    //     System.out.println(delete);
                    iframetop = firstresult.indexOf("<iframe");
                    iframebottom = firstresult.indexOf(">", iframetop);
                    if (iframebottom == -1) {
                        iframetop = -1;
                    }
                }

                int htop = firstresult.indexOf("<h");
                int hbottom = firstresult.indexOf(">", htop);
                while (htop > 0 && hbottom > 0) {
                    String delete = firstresult.subSequence(htop, hbottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    //     System.out.println(delete);
                    htop = firstresult.indexOf("<h");
                    hbottom = firstresult.indexOf(">", htop);
                    if (hbottom == -1) {
                        htop = -1;
                    }
                }

                result += name + "\n" + firstresult;
                //if things wont work
                if (result.length() < 100) {

                    int num = content.indexOf("项目编号");
                    if (num < 0) {
                        num = content.indexOf("項目編號");
                    }
                    // System.out.println(num);
                    if (num > 0) {
                        int num_bottom = content.indexOf("</p>", num);
                        String done = content.subSequence(num, num_bottom).toString();
                        done = done.replaceAll("</strong>", "");
                        result += done + " " + name + "\n";
                    }
                    int level = content.indexOf("项目等级", num);
                    if (level < 0) {
                        level = content.indexOf("項目等級", num);
                    }
                    int level_bottom = content.indexOf("</p>", level);
                    result += content.subSequence(level, level_bottom).toString().replaceAll("</strong>", "") + "\n\n";

                    int contain = content.indexOf("特殊收容措施", level);
                    int describe = content.indexOf("描述", contain);
                    //   System.out.println(contain );
                    if (contain > 0 && describe > 0) {
                        //System.out.println("con");
                        String con = content.subSequence(contain, describe).toString().replaceAll("</strong>", "");
                        con = con.replaceAll("特殊收容措施", "特殊收容措施：\n\n");
                        con = con.replaceAll("<p>", "");
                        con = con.replaceAll("<strong>", "");
                        con = con.replaceAll("</p>", "");
                        con = con.replaceAll("，", "，\n");
                        con = con.replaceAll("。", "。\n");
                        con = con.replaceAll("", "");
                        con = con.replaceAll("</blockquote>", "");
                        con = con.replaceAll("</em>", "");
                        con = con.replaceAll("</a>", "");
                        con = con.replaceAll("<blockquote>", "");
                        con = con.replaceAll("<em>", "");
                        con = con.replaceAll("<a>", "");
                        con = con.replaceAll("</div>", "");
                        con = con.replaceAll("<tr>", "");
                        con = con.replaceAll("</tr>", "");
                        con = con.replaceAll("<td>", "");
                        con = con.replaceAll("</td>", "");
                        con = con.replaceAll("</table>", "");
                        con = con.replaceAll("</sup>", "");
                        con = con.replaceAll("</span>", " ");

                        spantop = con.indexOf("<span");
                        spanbottom = con.indexOf("\">", spantop);
                        while (spantop > 0) {

                            String delete = con.subSequence(spantop, spanbottom + 2).toString();

                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");
                            spantop = con.indexOf("<span");
                            spanbottom = con.indexOf("\">", spantop);
                            if (spanbottom == -1) {
                                spantop = -1;
                            }
                        }

                        atop = con.indexOf("<a");
                        abottom = con.indexOf("\">", atop);
                        while (atop > 0) {

                            String delete = con.subSequence(atop, abottom + 2).toString();

                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");
                            atop = con.indexOf("<a");
                            abottom = con.indexOf("\">", atop);
                            if (abottom == -1) {
                                atop = -1;
                            }
                        }

                        divtop = con.indexOf("<div");
                        divbottom = con.indexOf("\">", divtop);
                        while (divtop > 0) {
                            String delete = con.subSequence(divtop, divbottom + 2).toString();
                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");

                            divtop = con.indexOf("<div");
                            divbottom = con.indexOf("\">", divtop);
                            if (divbottom == -1) {
                                divtop = -1;
                            }
                        }

                        tabletop = con.indexOf("<table");
                        tablebottom = con.indexOf(">", tabletop);
                        while (tabletop > 0) {
                            String delete = con.subSequence(tabletop, tablebottom + 1).toString();
                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");
                            tabletop = con.indexOf("<table");
                            tablebottom = con.indexOf(">", tabletop);
                            if (tablebottom == -1) {
                                tabletop = -1;
                            }
                        }
                        suptop = con.indexOf("<sup");
                        supbottom = con.indexOf(">", suptop);

                        while (suptop > 0 && supbottom > 0) {
                            String delete = con.subSequence(suptop, supbottom + 1).toString();
                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");
                            //     System.out.println(delete);
                            suptop = con.indexOf("<sup");
                            supbottom = con.indexOf(">", suptop);
                            if (supbottom == -1) {
                                suptop = -1;
                            }
                        }

                        result += con + "\n";
                    }

                    int describe_bottom = content.indexOf("<div class=\"footer-wikiwalk-nav\">", describe);
                    //  System.out.println(describe_bottom);
                    //
                    if (describe_bottom < 0) {
                        describe_bottom = content.indexOf("<div class=\"footnotes-footer\">", describe);
                    }
                    if (describe_bottom < 0) {
                        describe_bottom = content.indexOf("<div id=\"wad-scp-wiki-cn-below-content\" class=\"wd-adunit wd-ad-np wd-adunit-below_content\">");
                    }//special
                    if (describe_bottom > 0 && describe > 0) {
                        String de = content.subSequence(describe, describe_bottom).toString();
                        de = de.replaceAll("描述", "描述：\n\n");
                        de = de.replaceAll("</strong>", "");
                        de = de.replaceAll("<p>", "");
                        de = de.replaceAll("</p>", "");
                        de = de.replaceAll("，", "，\n");
                        de = de.replaceAll("。", "。\n");
                        de = de.replaceAll("<hr />", "");
                        de = de.replaceAll("<blockquote>", "");
                        de = de.replaceAll("</span>", "");
                        de = de.replaceAll("<br />", "");
                        de = de.replaceAll("</blockquote>", "");
                        de = de.replaceAll("<strong>", "");
                        de = de.replaceAll("</a>", "");
                        de = de.replaceAll("<em>", "");
                        de = de.replaceAll("</em>", "");
                        de = de.replaceAll("</sup>", "");
                        de = de.replaceAll("<tt>", "");
                        de = de.replaceAll("</tt>", "");
                        de = de.replaceAll("</h1>", "");
                        de = de.replaceAll("</div>", "");

                        spantop = de.indexOf("<span");
                        spanbottom = de.indexOf(">", spantop);
                        //   System.out.println("con");
                        while (spantop > 0) {
                            String delete = de.subSequence(spantop, spanbottom + 1).toString();
                            //  System.out.println(delete);
                            de = de.replaceAll(delete, " ");
                            de = de.replace(delete, " ");
                            spantop = de.indexOf("<span");
                            spanbottom = de.indexOf(">", spantop);
                            if (spanbottom == -1) {
                                spantop = -1;
                            }
                        }
                        atop = de.indexOf("<a");
                        abottom = de.indexOf(">", atop);
                        // System.out.println("con");
                        while (atop > 0) {
                            // System.out.println("con");
                            String delete = de.subSequence(atop, abottom + 1).toString();
                            //  System.out.println(delete);
                            de = de.replaceAll(delete, " ");
                            de = de.replaceFirst(delete, " ");
                            de = de.replace(delete, " ");
                            // System.out.println(de.contains(delete));
                            atop = de.indexOf("<a");
                            abottom = de.indexOf(">", atop);
                            if (abottom == -1) {
                                //  System.out.println(1);
                                atop = -1;
                            }
                        }
                        divtop = de.indexOf("<div");
                        divbottom = de.indexOf(">", divtop);
                        while (divtop > 0) {
                            String delete = de.subSequence(divtop, divbottom + 1).toString();
                            de = de.replaceAll(delete, " ");
                            de = de.replace(delete, " ");
                            //   System.out.println(delete);
                            divtop = de.indexOf("<div");
                            divbottom = de.indexOf(">", divtop);
                            if (divbottom == -1) {
                                divtop = -1;
                            }
                        }

                        int hltop = de.indexOf("<h1");
                        int hlbottom = de.indexOf(">", hltop);
                        while (hltop > 0 && hlbottom > 0) {
                            String delete = de.subSequence(hltop, hlbottom + 1).toString();
                            de = de.replaceAll(delete, " ");
                            de = de.replace(delete, " ");
                            //   System.out.println(delete);
                            hltop = de.indexOf("<h1");
                            hlbottom = de.indexOf(">", hltop);
                            if (hlbottom == -1) {
                                hltop = -1;
                            }
                        }

                        suptop = de.indexOf("<sup");
                        supbottom = de.indexOf(">", suptop);

                        while (suptop > 0 && supbottom > 0) {
                            String delete = de.subSequence(suptop, supbottom + 1).toString();
                            de = de.replaceAll(delete, " ");
                            de = de.replace(delete, " ");
                            //     System.out.println(delete);
                            suptop = de.indexOf("<sup");
                            supbottom = de.indexOf(">", suptop);
                            if (supbottom == -1) {
                                suptop = -1;
                            }
                        }

                        result += de + "\n";
                    }

                    if (describe_bottom > 0) {
                        //  System.out.println("reach the top");
                    }
                }

                if (ch_3125 == true) {
                    //  result = "";
                    content = "";
                    //個人非常喜歡 這個scp 特別拉出來做一個 由於其特殊性質必須額外處理 背後所用jsp 原理也是特別拉出來做
                    //https://scp-wiki-cn.wikidot.com/scp-3125/scp-3125/html/ceca1e7e0d750efe8e8661433a15fb67b60e2d48-13561805281471004873
                    content = IOUtils.toString(new URL("https://scp-wiki-cn.wdfiles.com/local--html/scp-3125/ceca1e7e0d750efe8e8661433a15fb67b60e2d48-13561805281471004873/scp-wiki-cn.wikidot.com/"), "utf-8");
                    int top_3125 = content.indexOf("特殊收容措施");
                    int bottom_3125 = content.indexOf("文件结束");
                    String temp = content.subSequence(top_3125, bottom_3125 + 4).toString();
                    temp = temp.replaceAll("</p>", "");
                    temp = temp.replaceAll("<p>", "");
                    temp = temp.replaceAll("特殊收容措施:", "特殊收容措施:\n");
                    temp = temp.replaceAll("，", "，\n");
                    temp = temp.replaceAll("<b>", "");
                    temp = temp.replaceAll("</b>", "");
                    result += temp;
                    URL url = getClass().getResource("scp3125.html");
                    File htmlFile = new File(url.getPath());
                    Desktop.getDesktop().browse(htmlFile.toURI());
                    result += "\n" + "認證訪問許可_你並不孤單" + "\n\n";
                    top_3125 = content.indexOf("项目编号", bottom_3125);
                    bottom_3125 = content.indexOf("5", top_3125);
                    temp = content.subSequence(top_3125, bottom_3125 + 1).toString();
                    temp = temp.replaceAll("</p>", "");
                    temp = temp.replaceAll("<p>", "");
                    temp = temp.replaceAll("特殊收容措施:", "特殊收容措施:\n");
                    temp = temp.replaceAll("，", "，\n");
                    temp = temp.replaceAll("<b>", "");
                    temp = temp.replaceAll("</b>", "");
                    result += temp + "\n";
                    top_3125 = content.indexOf("项目等级", bottom_3125);
                    bottom_3125 = content.indexOf("r", top_3125);
                    temp = content.subSequence(top_3125, bottom_3125 + 1).toString();
                    temp = temp.replaceAll("</p>", "");
                    temp = temp.replaceAll("<p>", "");
                    temp = temp.replaceAll("特殊收容措施:", "特殊收容措施:\n");
                    temp = temp.replaceAll("，", "，\n");
                    temp = temp.replaceAll("<b>", "");
                    temp = temp.replaceAll("</b>", "");
                    result += temp + "\n";
                    top_3125 = content.indexOf("特殊收容措施", bottom_3125);
                    bottom_3125 = content.indexOf("描述", top_3125);
                    bottom_3125 = content.indexOf("。", bottom_3125);
                    temp = content.subSequence(top_3125, bottom_3125 + 1).toString();
                    temp = temp.replaceAll("</p>", "");
                    temp = temp.replaceAll("<p>", "");
                    temp = temp.replaceAll("特殊收容措施:", "特殊收容措施:\n");
                    temp = temp.replaceAll("，", "，\n");
                    temp = temp.replaceAll("<b>", "");
                    temp = temp.replaceAll("</b>", "");
                    result += temp + "\n\n\n";
                    top_3125 = content.indexOf("描述", bottom_3125);
                    bottom_3125 = content.indexOf("文件结束", top_3125);
                    temp = content.subSequence(top_3125, bottom_3125 + 4).toString();
                    temp = temp.replaceAll("</p>", "");
                    temp = temp.replaceAll("<p>", "");
                    temp = temp.replaceAll("特殊收容措施:", "特殊收容措施:\n");
                    temp = temp.replaceAll("，", "，\n");
                    temp = temp.replaceAll("<b>", "");
                    temp = temp.replaceAll("</b>", "");
                    temp = temp.replaceAll("<br/>", "");
                    temp = temp.replaceAll("<br>", "");
                    temp = temp.replaceAll("<i>", "");
                    temp = temp.replaceAll("</i>", "");
                    temp = temp.replaceAll("<ol>", "");
                    temp = temp.replaceAll("</ol>", "");
                    temp = temp.replaceAll("<li>", "");
                    temp = temp.replaceAll("</li>", "");
                    temp = temp.replaceAll("</a>", "");
                    temp = temp.replaceAll("</div>", "");
                    temp = temp.replaceAll("<blockquote>", "");
                    temp = temp.replaceAll("</blockquote>", "");

                    top_3125 = temp.indexOf("<div");
                    bottom_3125 = temp.indexOf(">", top_3125);
                    while (top_3125 > 0) {

                        String delete = temp.subSequence(top_3125, bottom_3125 + 2).toString();
                        System.out.println(delete);
                        temp = temp.replaceAll(delete, " ");
                        temp = temp.replace(delete, " ");
                        top_3125 = temp.indexOf("<div");
                        bottom_3125 = temp.indexOf(">", top_3125);
                        if (bottom_3125 == -1) {
                            top_3125 = -1;
                        }
                    }

                    top_3125 = temp.indexOf("<a");
                    bottom_3125 = temp.indexOf("\">", top_3125);
                    while (top_3125 > 0) {

                        String delete = temp.subSequence(top_3125, bottom_3125 + 2).toString();
                        System.out.println(delete);
                        temp = temp.replaceAll(delete, " ");
                        temp = temp.replace(delete, " ");
                        top_3125 = temp.indexOf("<a");
                        bottom_3125 = temp.indexOf("\">", top_3125);
                        if (bottom_3125 == -1) {
                            top_3125 = -1;
                        }
                    }

                    result += temp + "\n\n\n";

                    //    System.out.println(content);
                }

                //int test = content.indexOf("");
                // System.out.println(content.subSequence(test, test+100));
            } catch (IOException ex) {
                this.result = ex.toString() + "\n Access denied";

            }
        } catch (Exception e) {
            // this.result = e.toString() + "\n Access denied";
            try {
                search_other_version(in);
            } catch (Exception ex) {
                this.result = ex.toString() + "\n Access denied";
            }
        }
    }

    protected void search_other_version(String in) {
        String number = in;
        if (in.contains("scp-") == false) {
            in = "scp-" + in;
        }
        String check = in.replaceAll("scp-", "");
        int check_num = Integer.parseInt(check);
        try {
            String name = "";
            if (check_num < 1000) {
                name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series"), "utf-8");
            } else if (check_num >= 1000 && check_num < 2000) {
                name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-2"), "utf-8");
            } else if (check_num >= 2000 && check_num < 3000) {
                name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-3"), "utf-8");
            } else if (check_num >= 3000 && check_num < 4000) {
                name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-4"), "utf-8");
            } else if (check_num >= 4000 && check_num < 5000) {
                name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-5"), "utf-8");
            } else if (check_num >= 5000 && check_num < 6000) {
                name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-6"), "utf-8");
            } else if (check_num >= 6000 && check_num < 7000) {
                name = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-7"), "utf-8");
            }

            int ckname = name.indexOf(in);
            int ck_middle = name.indexOf("</a>", ckname);
            int ck_bottom = name.indexOf("</li>", ck_middle);
            name = name.subSequence(ck_middle, ck_bottom).toString();
            name = name.replaceAll("</a>", "");
            name = name.replaceAll("-", "");
            name = name.replaceAll(" ", "");
            name = name.replaceAll("<strong>", "");
            name = name.replaceAll("</strong>", "");
            name = ZHConverter.convert(name, ZHConverter.TRADITIONAL);
            String content = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/" + in), "utf-8");
            int scp_name_top = content.indexOf("<div class=\"credit first\">");
            int scp_name_bottom = content.indexOf("<strong>SCP-" + number + "：</strong>");
            int scp_name_bottom_bottom = content.indexOf("</strong>", scp_name_bottom);
            int scp_name_bottom_bottom_bottom = content.indexOf("<strong>", scp_name_bottom_bottom);
            String con = "";
            con = content.subSequence(scp_name_bottom_bottom + 9, scp_name_bottom_bottom_bottom).toString();
            con = con.replaceAll("<br />", "");
            this.result = result + "\n\n" + in + " " + con + "\n";

            int scp_cont_top = content.indexOf("<div class=\"credit-back\"");
            int scp_cont_tbottom = content.indexOf("<div", scp_cont_top + 7);
            int scp_cont_tbottom_class = content.indexOf("<div", scp_cont_tbottom + 7);
            int scp_cont_tbottom_class_top = content.indexOf("<div", scp_cont_tbottom_class + 7);
            // int scp_cont_tbottom_class_bottom=content.indexOf("<div",scp_cont_tbottom_class_top+7);
            int scp_cont_bottom_bottom = content.indexOf("<div class=\"footer-wikiwalk-n", scp_cont_tbottom);
            con = content.subSequence(scp_cont_tbottom, scp_cont_tbottom_class).toString();
            con = con.replaceAll("<div class=\"", "");
            con = con.replaceAll("\">", "");
            this.result = result + con + "\n";

            int cont_top = content.indexOf("<strong>特殊收容措施：</strong>", scp_cont_tbottom);
            con = content.subSequence(cont_top, scp_cont_bottom_bottom).toString();
            this.result = result + con + "\n";
            result = result.replaceAll("<br />", "");
            result = result.replaceAll("<strong>", "");
            result = result.replaceAll("</strong>", "");
            result = result.replaceAll("<p>", "");
            result = result.replaceAll("<ul>", "");
            result = result.replaceAll("<li>", "");
            result = result.replaceAll("</li>", "");
            result = result.replaceAll("</ul>", "");
            result = result.replaceAll("</p>", "");
            result = this.delete_html(result);

            //System.out.println(result);
        } catch (IOException ex) {
            this.result = ex.toString() + "\n Access denied";

        }

    }

    public void searchenglish(String in) {
        boolean ch_3125 = false;
        if (in.contains("3125") == true) {
            ch_3125 = true;

        }

        result = "";
        // System.out.print(001>999);
        try {
            if (in.contains("scp-") == false) {
                in = "scp-" + in;
            }
            String check = in.replaceAll("scp-", "");
            int check_num = Integer.parseInt(check);
            try {
                String name = "";
                if (check_num < 1000) {
                    name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series"), "utf-8");
                } else if (check_num >= 1000 && check_num < 2000) {
                    name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-2"), "utf-8");
                } else if (check_num >= 2000 && check_num < 3000) {
                    name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-3"), "utf-8");
                } else if (check_num >= 3000 && check_num < 4000) {
                    name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-4"), "utf-8");
                } else if (check_num >= 4000 && check_num < 5000) {
                    name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-5"), "utf-8");
                } else if (check_num >= 5000 && check_num < 6000) {
                    name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-6"), "utf-8");
                } else if (check_num >= 6000 && check_num < 7000) {
                    name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-7"), "utf-8");
                }
                //    System.out.println("reach scp checking model");
                int ckname = name.indexOf(in);
                int ck_middle = name.indexOf("</a>", ckname);
                int ck_bottom = name.indexOf("</li>", ck_middle);
                name = name.subSequence(ck_middle, ck_bottom).toString();
                name = name.replaceAll("</a>", "");
                name = name.replaceAll("-", "");
                name = name.replaceAll(" ", "");
                name = name.replaceAll("<strong>", "");
                name = name.replaceAll("</strong>", "");
                name = name.replaceAll("&quot", "");
                //   System.out.println("reach after scp checked model");
                String content = IOUtils.toString(new URL("http://www.scp-wiki.net/" + in), "utf-8");

                String firstresult = "";
                int top = content.indexOf("<div id=\"page-title\">");
                int bottom = content.indexOf("<!-- wikidot_bottom_300x250 -->");//special bottom for cn web
                firstresult = content.subSequence(top, bottom).toString();//content create
                //    System.out.println(firstresult);
                // System.out.println("reach after scp checked model");
                imageurl = new ArrayList<String>();

                int imagetop = firstresult.indexOf("<img src");
                int imagebottom = firstresult.indexOf(">", imagetop);

                this.imagediscribe = null;
                this.imagediscribe = new ArrayList();
                //   System.out.println(imagetop);
                while (imagetop > 0 && imagebottom > 0) {

                    String get = firstresult.subSequence(imagetop, imagebottom + 1).toString();
                    int imagecontop = firstresult.indexOf("<p>", imagebottom);
                    int imageconbottom = firstresult.indexOf("</p>", imagecontop);
                    // System.out.println(123);
                    if (imagecontop > 0) {

                        String imagecontent = firstresult.subSequence(imagecontop + 3, imageconbottom).toString();
                        this.imagediscribe.add(imagecontent);
                        // System.out.println(imagecontent);
                        //  System.out.println(imagecontent .equals("SCP-"+in.subSequence(4, in.length())));
                        if (imagecontent.equals(in) == false && imagecontent.equals("SCP-" + in.subSequence(4, in.length())) == false) {
                            // System.out.println(imagecontent);
                            firstresult = firstresult.replaceAll(imagecontent, " ");
                        }
                    }
                    //System.out.println("hi");
                    //   System.out.println(this.imagediscribe.get(0));
                    imageurl.add(get);
                    firstresult = firstresult.replaceAll(get, " ");
                    firstresult = firstresult.replace(get, " ");
                    //  System.out.println(get);

                    imagetop = firstresult.indexOf("<img src");
                    imagebottom = firstresult.indexOf(">", imagetop);
                }
//work well
                int informtop = firstresult.indexOf("<div class=\"info-container\">");
                int informbottom = firstresult.indexOf("<strong>", informtop);
                if (informtop > 0) {
                    String deleting = firstresult.subSequence(informtop, informbottom).toString();
                    firstresult = firstresult.replaceAll(deleting, " ");
                    firstresult = firstresult.replace(deleting, " ");
                }
                // firstresult = firstresult.replaceAll(" ", "");
                firstresult = firstresult.replaceAll("\n\n", "");
                firstresult = firstresult.replaceAll("<p>", "");
                firstresult = firstresult.replaceAll("<strong>", "");
                firstresult = firstresult.replaceAll("</strong>", "");
                firstresult = firstresult.replaceAll("<br/>", "");
                firstresult = firstresult.replaceAll("</p>", "");
                firstresult = firstresult.replaceAll("&nbsp;", "");

                firstresult = firstresult.replaceAll(",", ",\n");
                firstresult = firstresult.replaceAll(";", ";\n");
                firstresult = firstresult.replace(".", ".\n");

                firstresult = firstresult.replaceAll("", "");
                firstresult = firstresult.replaceAll("</blockquote>", "");
                firstresult = firstresult.replaceAll("</em>", "");
                firstresult = firstresult.replaceAll("</a>", "");
                firstresult = firstresult.replaceAll("<blockquote>", "");
                firstresult = firstresult.replaceAll("<em>", "");
                firstresult = firstresult.replaceAll("<a>", "");
                firstresult = firstresult.replaceAll("</div>", "");
                firstresult = firstresult.replaceAll("<tr>", "");
                firstresult = firstresult.replaceAll("</tr>", "");
                firstresult = firstresult.replaceAll("<li>", "");
                firstresult = firstresult.replaceAll("</li>", "");
                firstresult = firstresult.replaceAll("<ul>", "");
                firstresult = firstresult.replaceAll("</ul>", "");
                firstresult = firstresult.replaceAll("<br />", "");
                firstresult = firstresult.replaceAll("&quot", "");
                //  firstresult = firstresult.replaceAll("<br />", "");

                firstresult = firstresult.replaceAll("<sub>", "");
                firstresult = firstresult.replaceAll("</sub>", "");
                firstresult = firstresult.replaceAll("<td>", "");
                firstresult = firstresult.replaceAll("</td>", "");
                firstresult = firstresult.replaceAll("</table>", "");
                firstresult = firstresult.replaceAll("</sup>", "");
                firstresult = firstresult.replaceAll("<divid=\"page-content\">", "");
                firstresult = firstresult.replaceAll("<divid=\"page-title\">", "");
                firstresult = firstresult.replaceAll("</span>", " ");
                firstresult = firstresult.replaceAll("<!--wikidot_bottom_300x250-->", "");
                firstresult = firstresult.replaceAll("<hr/>", "");
                firstresult = firstresult.replaceAll("</h1>", "");
                firstresult = firstresult.replaceAll("</iframe>", "");
// System.out.println(firstresult); work well
                int spantop = firstresult.indexOf("<span");
                int spanbottom = firstresult.indexOf("\">", spantop);

                while (spantop >= 0) {

                    String delete = firstresult.subSequence(spantop, spanbottom + 2).toString();

                    //  firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    spantop = firstresult.indexOf("<span");
                    spanbottom = firstresult.indexOf("\">", spantop);
                    if (spanbottom == -1) {
                        spantop = -1;
                    }
                }
//System.out.println(firstresult);// erroe top func
                int atop = firstresult.indexOf("<a");
                int abottom = firstresult.indexOf("\">", atop);
                while (atop >= 0) {

                    String delete = firstresult.subSequence(atop, abottom + 2).toString();

                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    atop = firstresult.indexOf("<a");
                    abottom = firstresult.indexOf("\">", atop);
                    if (abottom == -1) {
                        atop = -1;
                    }
                }

                int divtop = firstresult.indexOf("<div");
                int divbottom = firstresult.indexOf(">", divtop);
                //  System.out.println(divtop);
                //  System.out.println(divbottom);
                while (divtop >= 0) {
                    String delete = firstresult.subSequence(divtop, divbottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    //   System.out.println(delete);

                    divtop = firstresult.indexOf("<div");
                    divbottom = firstresult.indexOf(">", divtop);
                    if (divbottom == -1) {
                        divtop = -1;
                    }
                }

                int tabletop = firstresult.indexOf("<table");
                int tablebottom = firstresult.indexOf(">", tabletop);
                while (tabletop >= 0) {
                    String delete = firstresult.subSequence(tabletop, tablebottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    tabletop = firstresult.indexOf("<table");
                    tablebottom = firstresult.indexOf(">", tabletop);
                    if (tablebottom == -1) {
                        tabletop = -1;
                    }
                }
                int suptop = firstresult.indexOf("<sup");
                int supbottom = firstresult.indexOf(">", suptop);

                while (suptop >= 0 && supbottom >= 0) {
                    String delete = firstresult.subSequence(suptop, supbottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    //     System.out.println(delete);
                    suptop = firstresult.indexOf("<sup");
                    supbottom = firstresult.indexOf(">", suptop);
                    if (supbottom == -1) {
                        suptop = -1;
                    }
                }

                int iframetop = firstresult.indexOf("<iframe");
                int iframebottom = firstresult.indexOf(">", iframetop);
                //   System.out.println(iframebottom);
                while (iframetop >= 0 && iframebottom >= 0) {
                    String delete = firstresult.subSequence(iframetop, iframebottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    //     System.out.println(delete);
                    iframetop = firstresult.indexOf("<iframe");
                    iframebottom = firstresult.indexOf(">", iframetop);
                    if (iframebottom == -1) {
                        iframetop = -1;
                    }
                }

                int htop = firstresult.indexOf("<h");
                int hbottom = firstresult.indexOf(">", htop);
                while (htop >= 0 && hbottom >= 0) {
                    String delete = firstresult.subSequence(htop, hbottom + 1).toString();
                    firstresult = firstresult.replaceAll(delete, " ");
                    firstresult = firstresult.replace(delete, " ");
                    //     System.out.println(delete);
                    htop = firstresult.indexOf("<h");
                    hbottom = firstresult.indexOf(">", htop);
                    if (hbottom == -1) {
                        htop = -1;
                    }
                }

                result += name + "\n" + firstresult;
                //if things wont work
                if (result.length() < 100) {

                    int num = content.indexOf("项目编号");
                    if (num < 0) {
                        num = content.indexOf("項目編號");
                    }
                    // System.out.println(num);
                    if (num > 0) {
                        int num_bottom = content.indexOf("</p>", num);
                        String done = content.subSequence(num, num_bottom).toString();
                        done = done.replaceAll("</strong>", "");
                        result += done + " " + name + "\n";
                    }
                    int level = content.indexOf("项目等级", num);
                    if (level < 0) {
                        level = content.indexOf("項目等級", num);
                    }
                    int level_bottom = content.indexOf("</p>", level);
                    result += content.subSequence(level, level_bottom).toString().replaceAll("</strong>", "") + "\n\n";

                    int contain = content.indexOf("特殊收容措施", level);
                    int describe = content.indexOf("描述", contain);
                    //   System.out.println(contain );
                    if (contain > 0 && describe > 0) {
                        //System.out.println("con");
                        String con = content.subSequence(contain, describe).toString().replaceAll("</strong>", "");
                        con = con.replaceAll("特殊收容措施", "特殊收容措施：\n\n");
                        con = con.replaceAll("<p>", "");
                        con = con.replaceAll("<strong>", "");
                        con = con.replaceAll("</p>", "");
                        con = con.replaceAll("，", "，\n");
                        con = con.replaceAll("。", "。\n");
                        con = con.replaceAll("", "");
                        con = con.replaceAll("</blockquote>", "");
                        con = con.replaceAll("</em>", "");
                        con = con.replaceAll("</a>", "");
                        con = con.replaceAll("<blockquote>", "");
                        con = con.replaceAll("<em>", "");
                        con = con.replaceAll("<a>", "");
                        con = con.replaceAll("</div>", "");
                        con = con.replaceAll("<tr>", "");
                        con = con.replaceAll("</tr>", "");
                        con = con.replaceAll("<td>", "");
                        con = con.replaceAll("</td>", "");
                        con = con.replaceAll("</table>", "");
                        con = con.replaceAll("</sup>", "");
                        con = con.replaceAll("</span>", " ");

                        spantop = con.indexOf("<span");
                        spanbottom = con.indexOf("\">", spantop);
                        while (spantop > 0) {

                            String delete = con.subSequence(spantop, spanbottom + 2).toString();

                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");
                            spantop = con.indexOf("<span");
                            spanbottom = con.indexOf("\">", spantop);
                            if (spanbottom == -1) {
                                spantop = -1;
                            }
                        }

                        atop = con.indexOf("<a");
                        abottom = con.indexOf("\">", atop);
                        while (atop > 0) {

                            String delete = con.subSequence(atop, abottom + 2).toString();

                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");
                            atop = con.indexOf("<a");
                            abottom = con.indexOf("\">", atop);
                            if (abottom == -1) {
                                atop = -1;
                            }
                        }

                        divtop = con.indexOf("<div");
                        divbottom = con.indexOf("\">", divtop);
                        while (divtop > 0) {
                            String delete = con.subSequence(divtop, divbottom + 2).toString();
                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");

                            divtop = con.indexOf("<div");
                            divbottom = con.indexOf("\">", divtop);
                            if (divbottom == -1) {
                                divtop = -1;
                            }
                        }

                        tabletop = con.indexOf("<table");
                        tablebottom = con.indexOf(">", tabletop);
                        while (tabletop > 0) {
                            String delete = con.subSequence(tabletop, tablebottom + 1).toString();
                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");
                            tabletop = con.indexOf("<table");
                            tablebottom = con.indexOf(">", tabletop);
                            if (tablebottom == -1) {
                                tabletop = -1;
                            }
                        }
                        suptop = con.indexOf("<sup");
                        supbottom = con.indexOf(">", suptop);

                        while (suptop > 0 && supbottom > 0) {
                            String delete = con.subSequence(suptop, supbottom + 1).toString();
                            con = con.replaceAll(delete, " ");
                            con = con.replace(delete, " ");
                            //     System.out.println(delete);
                            suptop = con.indexOf("<sup");
                            supbottom = con.indexOf(">", suptop);
                            if (supbottom == -1) {
                                suptop = -1;
                            }
                        }

                        result += con + "\n";
                    }

                    int describe_bottom = content.indexOf("<div class=\"footer-wikiwalk-nav\">", describe);
                    //  System.out.println(describe_bottom);
                    //
                    if (describe_bottom < 0) {
                        describe_bottom = content.indexOf("<div class=\"footnotes-footer\">", describe);
                    }
                    if (describe_bottom < 0) {
                        describe_bottom = content.indexOf("<div id=\"wad-scp-wiki-cn-below-content\" class=\"wd-adunit wd-ad-np wd-adunit-below_content\">");
                    }//special
                    if (describe_bottom > 0 && describe > 0) {
                        String de = content.subSequence(describe, describe_bottom).toString();
                        de = de.replaceAll("描述", "描述：\n\n");
                        de = de.replaceAll("</strong>", "");
                        de = de.replaceAll("<p>", "");
                        de = de.replaceAll("</p>", "");
                        de = de.replaceAll("，", "，\n");
                        de = de.replaceAll("。", "。\n");
                        de = de.replaceAll("<hr />", "");
                        de = de.replaceAll("<blockquote>", "");
                        de = de.replaceAll("</span>", "");
                        de = de.replaceAll("<br />", "");
                        de = de.replaceAll("</blockquote>", "");
                        de = de.replaceAll("<strong>", "");
                        de = de.replaceAll("</a>", "");
                        de = de.replaceAll("<em>", "");
                        de = de.replaceAll("</em>", "");
                        de = de.replaceAll("</sup>", "");
                        de = de.replaceAll("<tt>", "");
                        de = de.replaceAll("</tt>", "");
                        de = de.replaceAll("</h1>", "");
                        de = de.replaceAll("</div>", "");

                        spantop = de.indexOf("<span");
                        spanbottom = de.indexOf(">", spantop);
                        //   System.out.println("con");
                        while (spantop > 0) {
                            String delete = de.subSequence(spantop, spanbottom + 1).toString();
                            //  System.out.println(delete);
                            de = de.replaceAll(delete, " ");
                            de = de.replace(delete, " ");
                            spantop = de.indexOf("<span");
                            spanbottom = de.indexOf(">", spantop);
                            if (spanbottom == -1) {
                                spantop = -1;
                            }
                        }
                        atop = de.indexOf("<a");
                        abottom = de.indexOf(">", atop);
                        // System.out.println("con");
                        while (atop > 0) {
                            // System.out.println("con");
                            String delete = de.subSequence(atop, abottom + 1).toString();
                            //  System.out.println(delete);
                            de = de.replaceAll(delete, " ");
                            de = de.replaceFirst(delete, " ");
                            de = de.replace(delete, " ");
                            // System.out.println(de.contains(delete));
                            atop = de.indexOf("<a");
                            abottom = de.indexOf(">", atop);
                            if (abottom == -1) {
                                //  System.out.println(1);
                                atop = -1;
                            }
                        }
                        divtop = de.indexOf("<div");
                        divbottom = de.indexOf(">", divtop);
                        while (divtop > 0) {
                            String delete = de.subSequence(divtop, divbottom + 1).toString();
                            de = de.replaceAll(delete, " ");
                            de = de.replace(delete, " ");
                            //   System.out.println(delete);
                            divtop = de.indexOf("<div");
                            divbottom = de.indexOf(">", divtop);
                            if (divbottom == -1) {
                                divtop = -1;
                            }
                        }

                        int hltop = de.indexOf("<h1");
                        int hlbottom = de.indexOf(">", hltop);
                        while (hltop > 0 && hlbottom > 0) {
                            String delete = de.subSequence(hltop, hlbottom + 1).toString();
                            de = de.replaceAll(delete, " ");
                            de = de.replace(delete, " ");
                            //   System.out.println(delete);
                            hltop = de.indexOf("<h1");
                            hlbottom = de.indexOf(">", hltop);
                            if (hlbottom == -1) {
                                hltop = -1;
                            }
                        }

                        suptop = de.indexOf("<sup");
                        supbottom = de.indexOf(">", suptop);

                        while (suptop > 0 && supbottom > 0) {
                            String delete = de.subSequence(suptop, supbottom + 1).toString();
                            de = de.replaceAll(delete, " ");
                            de = de.replace(delete, " ");
                            //     System.out.println(delete);
                            suptop = de.indexOf("<sup");
                            supbottom = de.indexOf(">", suptop);
                            if (supbottom == -1) {
                                suptop = -1;
                            }
                        }

                        result += de + "\n";
                    }
                    /*    int reference = content.indexOf("参考资料");
            int reference_bottom = content.indexOf("<div class=\"footer-wikiwalk-nav\">", reference);
            if (reference > 0) {
                String ref = content.subSequence(reference, reference_bottom).toString();
                ref = ref.replaceAll("参考资料", "参考资料：\n\n");
                ref = ref.replaceAll("，", "，\n");
                ref = ref.replaceAll("。", "。\n");
                ref = ref.replaceAll("</strong>", "");
                ref = ref.replaceAll("<blockquote>", "");
                ref = ref.replaceAll("<p>", "");
                ref = ref.replaceAll("</p>", "");
                ref = ref.replaceAll("<br />", "");
                ref = ref.replaceAll("</blockquote>", "");
                result += ref + "\n";

            }*/

                    if (describe_bottom > 0) {
                        //    System.out.println("reach the top");
                    }

                }
                if (ch_3125 == true) {
                    //scp-3125
                    //http://scp-wiki.wdfiles.com/local--html/scp-3125-unencrypted/19a551ea86bc6d2bd95b6e4cc40758497b7a00e0-11702915221798099076/www.scpwiki.com/
                    content = "";
                    result += "\n\n";
                    content = IOUtils.toString(new URL("http://scp-wiki.wdfiles.com/local--html/scp-3125-unencrypted/19a551ea86bc6d2bd95b6e4cc40758497b7a00e0-11702915221798099076/www.scpwiki.com/"), "utf-8");
                    int top_3125 = content.indexOf("Item");
                    int bottom_3125 = content.indexOf("</p>", top_3125);
                    String temp = content.subSequence(top_3125, bottom_3125).toString();
                    temp = temp.replaceAll("</p>", "");
                    temp = temp.replaceAll("<p>", "");
                    temp = temp.replaceAll(",", ",\n");
                    temp = temp.replaceAll("<b>", "");
                    temp = temp.replaceAll("</b>", "");
                    result += temp + "\n\n";

                    top_3125 = content.indexOf("Object Class");
                    bottom_3125 = content.indexOf("</p>", top_3125);
                    temp = content.subSequence(top_3125, bottom_3125).toString();
                    temp = temp.replaceAll("</p>", "");
                    temp = temp.replaceAll("<p>", "");
                    temp = temp.replaceAll(",", ",\n");
                    temp = temp.replaceAll("<b>", "");
                    temp = temp.replaceAll("</b>", "");
                    result += temp + "\n\n";

                    top_3125 = content.indexOf("Special Containment");
                    bottom_3125 = content.indexOf("END OF FILE</b>");
                    bottom_3125 = content.indexOf("</b>", bottom_3125);

                    temp = content.subSequence(top_3125, bottom_3125).toString();
                    temp = temp.replaceAll("</p>", "");
                    temp = temp.replaceAll("<p>", "");
                    temp = temp.replaceAll("Special Containment Procedures", "Special Containment Procedures:\n\n");
                    //  temp = temp.replaceAll(".", ".\n");
                    temp = temp.replaceAll(",", ",\n");
                    temp = temp.replaceAll("<b>", "");
                    temp = temp.replaceAll("</b>", "");
                    result += temp + "\n";
                    URL url = getClass().getResource("3125_eng.html");
                    File htmlFile = new File(url.getPath());
                    Desktop.getDesktop().browse(htmlFile.toURI());

                    top_3125 = content.indexOf("Special Containment Procedures", bottom_3125);
                    bottom_3125 = content.indexOf("END OF FILE</b>", top_3125);
                    bottom_3125 = content.indexOf("</b>", bottom_3125);
                    temp = content.subSequence(top_3125, bottom_3125).toString();
                    temp = temp.replaceAll("</p>", "");
                    temp = temp.replaceAll("<p>", "");
                    temp = temp.replaceAll("Special Containment Procedures", "Special Containment Procedures:\n\n");
                    //  temp = temp.replaceAll(".", ".\n");
                    temp = temp.replaceAll(",", ",\n");
                    temp = temp.replaceAll("<b>", "");
                    temp = temp.replaceAll("</b>", "");

                    temp = temp.replaceAll("<li>", "");
                    temp = temp.replaceAll("</li>", "");
                    temp = temp.replaceAll("</a>", "");
                    temp = temp.replaceAll("</div>", "");
                    temp = temp.replaceAll("<blockquote>", "");
                    temp = temp.replaceAll("</blockquote>", "");
                    temp = temp.replaceAll("<br/>", "");
                    temp = temp.replaceAll("<br>", "");
                    temp = temp.replaceAll("<i>", "");
                    temp = temp.replaceAll("</i>", "");
                    temp = temp.replaceAll("<ol>", "");
                    temp = temp.replaceAll("</ol>", "");

                    top_3125 = temp.indexOf("<div");
                    bottom_3125 = temp.indexOf(">", top_3125);
                    while (top_3125 > 0) {

                        String delete = temp.subSequence(top_3125, bottom_3125 + 2).toString();
                        System.out.println(delete);
                        temp = temp.replaceAll(delete, " ");
                        temp = temp.replace(delete, " ");
                        top_3125 = temp.indexOf("<div");
                        bottom_3125 = temp.indexOf(">", top_3125);
                        if (bottom_3125 == -1) {
                            top_3125 = -1;
                        }
                    }

                    top_3125 = temp.indexOf("<a");
                    bottom_3125 = temp.indexOf("\">", top_3125);
                    while (top_3125 > 0) {

                        String delete = temp.subSequence(top_3125, bottom_3125 + 2).toString();
                        System.out.println(delete);
                        temp = temp.replaceAll(delete, " ");
                        temp = temp.replace(delete, " ");
                        top_3125 = temp.indexOf("<a");
                        bottom_3125 = temp.indexOf("\">", top_3125);
                        if (bottom_3125 == -1) {
                            top_3125 = -1;
                        }
                    }

                    result += temp + "\n";
                }
            } catch (IOException ex) {
                this.result = ex.toString() + "\n Access denied";
            }
        } catch (Exception e) {
            //  System.out.println("error");
            this.result = e.toString() + "\n Access denied";
            try {
                search_other_version_eng(in);
            } catch (Exception ex) {
                this.result = ex.toString() + "\n Access denied";
            }
        }
    }

    protected void search_other_version_eng(String in) {
        String number = in;
        if (in.contains("scp-") == false) {
            in = "scp-" + in;
        }
        String check = in.replaceAll("scp-", "");
        int check_num = Integer.parseInt(check);
        try {
            String name = "";
            if (check_num < 1000) {
                name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series"), "utf-8");
            } else if (check_num >= 1000 && check_num < 2000) {
                name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-2"), "utf-8");
            } else if (check_num >= 2000 && check_num < 3000) {
                name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-3"), "utf-8");
            } else if (check_num >= 3000 && check_num < 4000) {
                name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-4"), "utf-8");
            } else if (check_num >= 4000 && check_num < 5000) {
                name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-5"), "utf-8");
            } else if (check_num >= 5000 && check_num < 6000) {
                name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-6"), "utf-8");
            } else if (check_num >= 6000 && check_num < 7000) {
                name = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-7"), "utf-8");
            }

            int ckname = name.indexOf(in);
            int ck_middle = name.indexOf("</a>", ckname);
            int ck_bottom = name.indexOf("</li>", ck_middle);
            name = name.subSequence(ck_middle, ck_bottom).toString();
            name = name.replaceAll("</a>", "");
            name = name.replaceAll("-", "");
            name = name.replaceAll(" ", "");
            name = name.replaceAll("<strong>", "");
            name = name.replaceAll("</strong>", "");
            // name = ZHConverter.convert(name, ZHConverter.TRADITIONAL);
            String content = IOUtils.toString(new URL("http://www.scpwiki.com/" + in), "utf-8");
            int scp_name_top = content.indexOf("<div class=\"credit first\">");
            int scp_name_bottom = content.indexOf("<strong>SCP-" + number + "：</strong>");
            int scp_name_bottom_bottom = content.indexOf("</strong>", scp_name_bottom);
            int scp_name_bottom_bottom_bottom = content.indexOf("<strong>", scp_name_bottom_bottom);
            String con = "";
            con = content.subSequence(scp_name_bottom_bottom + 9, scp_name_bottom_bottom_bottom).toString();
            con = con.replaceAll("<br />", "");
            this.result = result + "\n\n" + in + " " + con + "\n";

            int scp_cont_top = content.indexOf("<div class=\"credit-back\"");
            int scp_cont_tbottom = content.indexOf("<div", scp_cont_top + 7);
            int scp_cont_tbottom_class = content.indexOf("<div", scp_cont_tbottom + 7);
            int scp_cont_tbottom_class_top = content.indexOf("<div", scp_cont_tbottom_class + 7);
            // int scp_cont_tbottom_class_bottom=content.indexOf("<div",scp_cont_tbottom_class_top+7);
            int scp_cont_bottom_bottom = content.indexOf("<div class=\"footer-wikiwalk-n", scp_cont_tbottom);
            con = content.subSequence(scp_cont_tbottom, scp_cont_tbottom_class).toString();
            con = con.replaceAll("<div class=\"", "");
            con = con.replaceAll("\">", "");
            this.result = result + con + "\n";

            int cont_top = content.indexOf("Special Containment Procedures", scp_cont_tbottom);
            con = content.subSequence(cont_top, scp_cont_bottom_bottom).toString();
            this.result = result + con + "\n";
            result = result.replaceAll("<br />", "");
            result = result.replaceAll("<strong>", "");
            result = result.replaceAll("</strong>", "");
            result = result.replaceAll("<p>", "");
            result = result.replaceAll("<ul>", "");
            result = result.replaceAll("<li>", "");
            result = result.replaceAll("</li>", "");
            result = result.replaceAll("</ul>", "");
            result = result.replaceAll("</p>", "");
            result = result.replaceAll(",", ",\n");
            //result = result.replaceAll(".", "\n");
            int divtop = 0;
            int divbottom = 0;

            divtop = result.indexOf("<div");
            divbottom = result.indexOf("\">", divtop);
            while (divtop > 0) {
                String delete = result.subSequence(divtop, divbottom + 1).toString();
                // result = result.replaceAll(delete, " ");
                result = result.replace(delete, "");

                divtop = result.indexOf("<div");
                divbottom = result.indexOf("\">", divtop);
                if (divbottom == -1) {
                    divtop = -1;
                }
            }
            divtop = result.indexOf("<a");
            divbottom = result.indexOf("</a>", divtop);
            divbottom = result.indexOf(">", divbottom);
            while (divtop > 0) {
                String delete = result.subSequence(divtop, divbottom + 1).toString();
                // result = result.replaceAll(delete, " ");
                result = result.replace(delete, "");

                divtop = result.indexOf("<a");
                divbottom = result.indexOf("</a>", divtop);
                divbottom = result.indexOf(">", divbottom);
                if (divbottom == -1) {
                    divtop = -1;
                }
            }
            divtop = result.indexOf("<span");
            divbottom = result.indexOf("</span>", divtop);
            divbottom = result.indexOf(">", divbottom);
            while (divtop > 0) {
                String delete = result.subSequence(divtop, divbottom + 1).toString();
                // result = result.replaceAll(delete, " ");
                result = result.replace(delete, "");

                divtop = result.indexOf("<span");
                divbottom = result.indexOf("</span>", divtop);
                divbottom = result.indexOf(">", divbottom);
                if (divbottom == -1) {
                    divtop = -1;
                }
            }

            divtop = result.indexOf("<th");
            divbottom = result.indexOf("\">", divtop);
            while (divtop > 0) {
                String delete = result.subSequence(divtop, divbottom + 1).toString();
                // result = result.replaceAll(delete, " ");
                result = result.replace(delete, "");

                divtop = result.indexOf("<th");
                divbottom = result.indexOf("\">", divtop);
                if (divbottom == -1) {
                    divtop = -1;
                }
            }
            result = result.replace("</div>", "");
            result = result.replace("</table>", "");
            result = result.replace("</tr>", "");
            result = result.replace("</th>", "");
            result = result.replace("<tr>", "");
            divtop = result.indexOf("<table");
            divbottom = result.indexOf("\">", divtop);
            while (divtop > 0) {
                String delete = result.subSequence(divtop, divbottom + 1).toString();
                // result = result.replaceAll(delete, " ");
                result = result.replace(delete, "");

                divtop = result.indexOf("<table");
                divbottom = result.indexOf("\">", divtop);
                if (divbottom == -1) {
                    divtop = -1;
                }
            }
            result = delete_html(result);
            result = result.replaceAll("\n\n\n", "");

        } catch (IOException ex) {
            this.result = ex.toString() + "\n Access denied";

        }

    }

    public boolean isChinese(String con) {

        for (int i = 0; i < con.length(); i = i + 1) {
            if (!Pattern.compile("[\u4e00-\u9fa5]").matcher(
                    String.valueOf(con.charAt(i))).find()) {
                return false;
            }
        }

        return true;
    }

    public boolean conValidate(String con) {
        if (null != con && !"".equals(con)) {
            if ((this.isChinese(con) || con.matches("^[A-Za-z]+$"))
                    && con.length() <= 10) {
                return true;
            }
        }
        return false;
    }

    public void searchdocumentserial(String in) {
        // String urlseries1 = "http://scp-wiki-cn.wikidot.com/scp-series-1-tales-edition";
        serielnumber = new ArrayList();

        try {
            String menu = "";
            //System.out.println(Integer.parseInt(in));
            if (Integer.parseInt(in) < 1000) {
                menu = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-1-tales-edition"), "utf-8");
            } else if (Integer.parseInt(in) >= 1000 && Integer.parseInt(in) <= 1999) {
                menu = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-2-tales-edition"), "utf-8");
            } else if (Integer.parseInt(in) >= 2000 && Integer.parseInt(in) <= 2999) {
                menu = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-3-tales-edition"), "utf-8");
            } else if (Integer.parseInt(in) >= 3000 && Integer.parseInt(in) <= 3999) {
                menu = IOUtils.toString(new URL("http://www.scp-wiki.net/scp-series-4-tales-edition"), "utf-8");
            }
            String SCP = "SCP-" + in;
            if (SCP.contains("001")) {

                int start001 = menu.indexOf("toc1");
                int start001adddedumm2 = menu.indexOf("toc1", start001);
                int ul = menu.indexOf("h1 id=\"toc1\"", start001);
                int uldone = menu.indexOf("<p>", ul);
                int nextbottom = menu.indexOf("toc2", ul);
                // System.out.println(menu.subSequence(ul, uldone));
                //   System.out.println(uldone);
                // int stop = uldone;
                boolean check = true;
                int tempstart = ul;
                while (check) {
                    if (tempstart >= uldone) {
                        check = false;
                    }
                    if (tempstart < uldone) {
                        tempstart = menu.indexOf("<li><a href=\"", tempstart);
                        int tempstop = menu.indexOf("\">", tempstart);

                        if (tempstart >= 0 && tempstop >= 0 && tempstart < nextbottom) {
                            serielnumber.add(menu.subSequence(tempstart + 14, tempstop).toString());
                        }
                        tempstart = tempstop;
                    }

                }

                //  System.out.println(menu);
                Iterator<String> iterator = this.serielnumber.iterator();

                while (iterator.hasNext()) {
                    String checkingstr = iterator.next();
                    if (checkingstr.contains(".com") == true) {
                        iterator.remove();
                    }
                }
                for (String t : this.serielnumber) {
                    System.out.println(t);

                }
            } else {
                int start_ontop = menu.indexOf("toc2");
                // String done=menu.substring(start_ontop, start_ontop+200);
                // System.out.println(done);
                int start = menu.indexOf(SCP, start_ontop);
                int href_top = menu.indexOf("<a href=\"", start);

                int propose = menu.indexOf("/", href_top);
                //    System.out.println(propose);
                int propose_bottom = menu.indexOf("\"", propose);
                String done = menu.substring(propose + 1, propose_bottom);
                int allend = menu.indexOf("footnotes-footer", propose);
                // System.out.println(done);
                boolean loop = true;
                while (loop) {
                    String temp = "";
                    href_top = menu.indexOf("<a href=\"", propose_bottom);

                    propose = menu.indexOf("/", href_top);
                    //    System.out.println(propose);
                    propose_bottom = menu.indexOf("\"", propose);
                    temp = menu.substring(propose + 1, propose_bottom);
                    if (temp.contains("scp")) {
                        loop = false;
                    } else if (propose > allend) {
                        loop = false;
                    } else if (temp.contains("scp") == false) {
                        done = done + "\n" + temp;
                        this.serielnumber.add(temp);
                    }
                }
                for (String out : this.serielnumber) {
                    //    System.out.println(out);
                }

            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Content.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(Content.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchdocument(String doc) {
        // String doc = (String) menu.subSequence(start + 14, stop);
        String menu2;
        try {
            menu2 = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/" + doc), "utf-8");

            int docstart = menu2.indexOf("page-title");
            int docstop = menu2.indexOf("wikidot_bottom");
            String docbottom = menu2.subSequence(docstart, docstop).toString();
            //  System.out.println(docbottom);

            String firstresult = docbottom;
            firstresult = firstresult.replaceAll(" ", "");
            firstresult = firstresult.replaceAll("\n\n", "");
            firstresult = firstresult.replaceAll("<p>", "");
            firstresult = firstresult.replaceAll("<strong>", "");
            firstresult = firstresult.replaceAll("</strong>", "");
            firstresult = firstresult.replaceAll("<br/>", "");
            firstresult = firstresult.replaceAll("</p>", "");
            firstresult = firstresult.replaceAll("&nbsp;", "");

            firstresult = firstresult.replaceAll("，", "，\n");
            firstresult = firstresult.replaceAll("。", "。\n");
            firstresult = firstresult.replaceAll("", "");
            firstresult = firstresult.replaceAll("</blockquote>", "");
            firstresult = firstresult.replaceAll("</em>", "");
            firstresult = firstresult.replaceAll("</a>", "");
            firstresult = firstresult.replaceAll("<blockquote>", "");
            firstresult = firstresult.replaceAll("<em>", "");
            firstresult = firstresult.replaceAll("<a>", "");
            firstresult = firstresult.replaceAll("</div>", "");
            firstresult = firstresult.replaceAll("<tr>", "");
            firstresult = firstresult.replaceAll("</tr>", "");
            firstresult = firstresult.replaceAll("<li>", "");
            firstresult = firstresult.replaceAll("</li>", "");
            firstresult = firstresult.replaceAll("<ul>", "");
            firstresult = firstresult.replaceAll("</ul>", "");

            firstresult = firstresult.replaceAll("<sub>", "");
            firstresult = firstresult.replaceAll("</sub>", "");
            firstresult = firstresult.replaceAll("<td>", "");
            firstresult = firstresult.replaceAll("</td>", "");
            firstresult = firstresult.replaceAll("</table>", "");
            firstresult = firstresult.replaceAll("</sup>", "");
            firstresult = firstresult.replaceAll("<divid=\"page-content\">", "");
            firstresult = firstresult.replaceAll("<divid=\"page-title\">", "");
            firstresult = firstresult.replaceAll("</span>", " ");
            firstresult = firstresult.replaceAll("<!--wikidot_bottom_300x250-->", "");
            firstresult = firstresult.replaceAll("<hr/>", "");
            firstresult = firstresult.replaceAll("</h1>", "");
            firstresult = firstresult.replaceAll("&quot;", "");
            firstresult = firstresult.replaceAll("</iframe>", "");
            firstresult = firstresult.replaceAll("project-palisade", "");
            firstresult = firstresult.replaceAll("page-title\">", "");

            int spantop = firstresult.indexOf("<span");
            int spanbottom = firstresult.indexOf("\">", spantop);
            while (spantop > 0) {

                String delete = firstresult.subSequence(spantop, spanbottom + 2).toString();

                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                spantop = firstresult.indexOf("<span");
                spanbottom = firstresult.indexOf("\">", spantop);
                if (spanbottom == -1) {
                    spantop = -1;
                }
            }

            int atop = firstresult.indexOf("<a");
            int abottom = firstresult.indexOf("\">", atop);
            while (atop > 0) {

                String delete = firstresult.subSequence(atop, abottom + 2).toString();

                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                atop = firstresult.indexOf("<a");
                abottom = firstresult.indexOf("\">", atop);
                if (abottom == -1) {
                    atop = -1;
                }
            }

            int divtop = firstresult.indexOf("<div");
            int divbottom = firstresult.indexOf(">", divtop);
            while (divtop > 0) {
                String delete = firstresult.subSequence(divtop, divbottom + 1).toString();
                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");

                divtop = firstresult.indexOf("<div");
                divbottom = firstresult.indexOf(">", divtop);
                if (divbottom == -1) {
                    divtop = -1;
                }
            }

            int tabletop = firstresult.indexOf("<table");
            int tablebottom = firstresult.indexOf(">", tabletop);
            while (tabletop > 0) {
                String delete = firstresult.subSequence(tabletop, tablebottom + 1).toString();
                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                tabletop = firstresult.indexOf("<table");
                tablebottom = firstresult.indexOf(">", tabletop);
                if (tablebottom == -1) {
                    tabletop = -1;
                }
            }
            int suptop = firstresult.indexOf("<sup");
            int supbottom = firstresult.indexOf(">", suptop);

            while (suptop > 0 && supbottom > 0) {
                String delete = firstresult.subSequence(suptop, supbottom + 1).toString();
                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                //     System.out.println(delete);
                suptop = firstresult.indexOf("<sup");
                supbottom = firstresult.indexOf(">", suptop);
                if (supbottom == -1) {
                    suptop = -1;
                }
            }

            int iframetop = firstresult.indexOf("<iframe");
            int iframebottom = firstresult.indexOf(">", iframetop);
            //   System.out.println(iframebottom);
            while (iframetop > 0 && iframebottom > 0) {
                String delete = firstresult.subSequence(iframetop, iframebottom + 1).toString();
                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                //     System.out.println(delete);
                iframetop = firstresult.indexOf("<iframe");
                iframebottom = firstresult.indexOf(">", iframetop);
                if (iframebottom == -1) {
                    iframetop = -1;
                }
            }

            int htop = firstresult.indexOf("<h");
            int hbottom = firstresult.indexOf(">", htop);
            while (htop > 0 && hbottom > 0) {
                String delete = firstresult.subSequence(htop, hbottom + 1).toString();
                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                //     System.out.println(delete);
                htop = firstresult.indexOf("<h");
                hbottom = firstresult.indexOf(">", htop);
                if (hbottom == -1) {
                    htop = -1;
                }
            }
            int imagetop = firstresult.indexOf("<imgclass");
            int imagebottom = firstresult.indexOf("/>", imagetop);
            while (imagetop > 0 && imagebottom > 0) {
                String delete = firstresult.subSequence(imagetop, imagebottom + 1).toString();
                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                //     System.out.println(delete);
                imagetop = firstresult.indexOf("<imgclass");
                imagebottom = firstresult.indexOf("/>", imagetop);
                if (imagebottom == -1) {
                    imagetop = -1;
                }
            }
            int ultop = firstresult.indexOf("<ul");
            int ulbottom = firstresult.indexOf(">", ultop);
            while (ultop > 0 && ulbottom > 0) {
                //  System.out.println(ulbottom);
                String delete = firstresult.subSequence(ultop, ulbottom + 1).toString();
                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                //     System.out.println(delete);
                ultop = firstresult.indexOf("<ul");
                ulbottom = firstresult.indexOf(">", ultop);

                if (ulbottom <= -1) {
                    ultop = -1;
                }
            }

            int litop = firstresult.indexOf("<li");
            int libottom = firstresult.indexOf(">", litop);
            while (litop > 0 && libottom > 0) {
                //  System.out.println(ulbottom);
                String delete = firstresult.subSequence(litop, libottom + 1).toString();
                firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                //     System.out.println(delete);
                litop = firstresult.indexOf("<li");
                libottom = firstresult.indexOf(">", litop);

                if (libottom <= -1) {
                    litop = -1;
                }
            }

            int scripttop = firstresult.indexOf("<scripttype=");
            int scriptbottom = firstresult.indexOf("</script>", scripttop);

            while (scripttop >= 0 && scriptbottom >= 0) {
                // System.out.println(scripttop);  
                //  System.out.println(scriptbottom);  
                String delete = firstresult.subSequence(scripttop, scriptbottom + 9).toString();

                //   firstresult = firstresult.replaceAll(delete, " ");
                firstresult = firstresult.replace(delete, " ");
                //     System.out.println(delete);
                scripttop = firstresult.indexOf("<scripttype");
                scriptbottom = firstresult.indexOf("</script>", scripttop);
                if (scriptbottom == -1) {
                    scripttop = -1;
                }
            }
            firstresult = firstresult.replaceAll("<!--", "");
            result += firstresult;
            // System.out.println(result);

        } catch (Exception ex) {
            Logger.getLogger(Content.class
                    .getName()).log(Level.SEVERE, null, ex);

        }

    }

    public int ranScp() {
        Random ran = new Random();
        int ran_num = ran.nextInt(6001);

        //System.out.println(ran_num);
        return ran_num;
    }

    public void cpy_str(String in) {
        String myString = in;
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public static String delete_html(String in) {
        String out = in;
        //5282
        int top_3125 = out.indexOf("<a");
        int bottom_3125 = out.indexOf("\">", top_3125);
        while (top_3125 > 0) {

            String delete = out.subSequence(top_3125, bottom_3125 + 2).toString();
            //  System.out.println(delete);
            out = out.replaceAll(delete, " ");
            out = out.replace(delete, " ");
            top_3125 = out.indexOf("<a");
            bottom_3125 = out.indexOf("\">", top_3125);
            if (bottom_3125 == -1) {
                top_3125 = -1;
            }
        }
        top_3125 = out.indexOf("<td");
        bottom_3125 = out.indexOf("\">", top_3125);
        while (top_3125 > 0) {

            String delete = out.subSequence(top_3125, bottom_3125 + 2).toString();
            //  System.out.println(delete);
            out = out.replaceAll(delete, " ");
            out = out.replace(delete, " ");
            top_3125 = out.indexOf("<td");
            bottom_3125 = out.indexOf("\">", top_3125);
            if (bottom_3125 == -1) {
                top_3125 = -1;
            }
        }
        out = out.replace("</td>", "");
        out = out.replace("<em>", "");
        out = out.replace("</em>", "");
        out = out.replace("</span>", "");
        return out;
    }
}

class Picture extends Applet
        implements WindowListener {

    //
    JFrame frame;
    private BufferedImage img;
    JLabel label;

    Picture(String input) throws MalformedURLException, IOException {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000, 800);
        frame.setVisible(true);

        img = ImageIO.read(new URL(input));

        img = getScaledImage(img, 800, 600);

        label = new JLabel();
        label.setSize(800, 800);
        label.setVisible(true);
        label.setLayout(null);
        label.setIcon(new ImageIcon(img));
        frame.add(this.label);
        label.repaint();
        frame.repaint();
        //frame.setIconImage(img);
        this.frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(false);
                frame.dispose();
                frame = null;
                System.gc();
                //  System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

        });
    }

    private BufferedImage getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}

class ScpDocument extends Applet
        implements WindowListener {

    JFrame frame = new JFrame("SCP DoCument");
    JPanel panellefttop = new JPanel();
    JRadioButton op1 = new JRadioButton("series1");
    JRadioButton op2 = new JRadioButton("series2");
    JRadioButton op3 = new JRadioButton("series3");
    JRadioButton op4 = new JRadioButton("series4");
    JRadioButton op5 = new JRadioButton("series5");
    ButtonGroup Group = new ButtonGroup();

    JPanel paneltext = new JPanel();
    JTextArea area = new JTextArea();

    JPanel panelbox = new JPanel();

    private String taleshttp = "http://scp-wiki-cn.wikidot.com/scp-series-1-tales-edition";

    private JComboBox<String> box;

    ScpDocument() {
        this.box = new JComboBox();
        createbox1();

        this.panelbox.setLayout(null);
        this.panelbox.setVisible(true);
        this.panelbox.setLocation(200, 0);
        this.panelbox.setSize(800, 600);
        this.panelbox.add(box);
        //   this.panelbox.setBackground(Color.red);
        //   this.paneltext.add(scroll);

        //createbox1();
        this.area.setLayout(null);
        this.area.setSize(800, 500);
        this.area.setVisible(true);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setSize(800, 500);
        scroll.setVisible(true);
        scroll.setLocation(50, 0);

        this.paneltext.setLayout(null);
        this.paneltext.setVisible(true);
        this.paneltext.setLocation(0, 200);
        this.paneltext.setSize(1000, 600);
        this.paneltext.add(scroll);

        this.panellefttop.setSize(150, 200);
        this.panellefttop.setLayout(null);
        this.panellefttop.setVisible(true);
        this.panellefttop.setLocation(0, 0);

        this.op1.setVisible(true);
        this.op2.setVisible(true);
        this.op3.setVisible(true);
        this.op4.setVisible(true);
        this.op5.setVisible(true);
        this.op1.setLayout(null);
        this.op2.setLayout(null);
        this.op3.setLayout(null);
        this.op4.setLayout(null);
        this.op5.setLayout(null);
        this.op1.setSize(120, 40);
        this.op2.setSize(120, 40);
        this.op3.setSize(120, 40);
        this.op4.setSize(120, 40);
        this.op5.setSize(120, 40);
        this.op1.setLocation(0, 0);
        this.op2.setLocation(0, 40);
        this.op3.setLocation(0, 80);
        this.op4.setLocation(0, 120);
        this.op5.setLocation(0, 160);

        this.op1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                taleshttp = "http://scp-wiki-cn.wikidot.com/scp-series-1-tales-edition";
                try {
                    String content = IOUtils.toString(new URL("http://scp-wiki-cn.wikidot.com/scp-series-1-tales-edition"), "utf-8");
                    int zero_1 = content.indexOf("001提案");
                    int end = content.indexOf("footnotes-footer", zero_1);
                    String result = content.substring(zero_1, end);
                    result = Content.delete_html(result);
                    //System.out.println(result);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ScpDocument.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ScpDocument.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        this.op2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                taleshttp = "http://scp-wiki-cn.wikidot.com/scp-series-2-tales-edition";
            }

        });
        this.op3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                taleshttp = "http://scp-wiki-cn.wikidot.com/scp-series-3-tales-edition";
            }

        });
        this.op4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                taleshttp = "http://scp-wiki-cn.wikidot.com/scp-series-4-tales-edition";
            }

        });
        this.op5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                taleshttp = "http://scp-wiki-cn.wikidot.com/scp-series-5-tales-edition";
            }

        });

        Group.add(op1);
        Group.add(op2);
        Group.add(op3);
        Group.add(op4);
        Group.add(op5);

        this.panellefttop.add(op1);
        this.panellefttop.add(op2);
        this.panellefttop.add(op3);
        this.panellefttop.add(op4);
        this.panellefttop.add(op5);

        frame.setLayout(null);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.add(this.panellefttop);
        frame.add(this.paneltext);
        this.frame.add(this.panelbox);
        this.frame.addWindowListener(this);
    }

    private void createbox1() {
        box.addItem("dragdown");
        //box.addItem("");
        box.setSelectedIndex(0);
        box.setVisible(true);
        this.box.setSize(200, 30);
        this.box.setLayout(null);
        box.setLocation(0, 0);
        // box.showPopup();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.setVisible(false);
        frame.dispose();
        frame = null;
        System.gc();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        ///   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
