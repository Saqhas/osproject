import  java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

class Minios extends JFrame implements ActionListener
{
    /*Jframe is a java class to create a frame for a destop app.
    * Jmenubar is a method to createa menu bar in the frame.
     * Jmenu is used to create a menu in it.
     * Jmenu item is used to define items in the menu.
     * Jbuttons is used to create buttons in the Frame
     * Jlabel is used to dispaly a single line read only text.*/
    JFrame f; JMenuBar jb; JMenu m,s; JMenuItem i1,i2,i3,i4,i5,s1,s2; JButton b1,b2,b3,b4,b5; JLabel t1,t2,t3,t4,t5;
    
     Minios()
    {
        f=new JFrame("Mini OS"); /*Here the main window of the application is created.*/
         f.getContentPane().setBackground(Color.yellow);
        jb=new JMenuBar(); /*Here the menu bar is created.*/
       m=new JMenu("start"); /*The menu is created.*/
       m.setIcon(new ImageIcon("start.png"));
       s=new JMenu("Settings");/*Another menu is created.*/
       s.setIcon(new ImageIcon("start.png"));
       m.setMnemonic(KeyEvent.VK_S);
       s.setMnemonic(KeyEvent.VK_R);
       s1=new JMenuItem("Shutdown");/*Here a menu item is created.*/
       s2=new JMenuItem("Restart");/*Another menu item is created.*/
       s.add(s1);
       s.add(s2);
       s1.addActionListener(this); /*The ActionListener is used to trigger a particular event when item is clicked.*/
       s2.addActionListener(this);
       i1=new JMenuItem("Gedit", new ImageIcon("notepad.png"));
       //i1.setIcon(new ImageIcon("start.jpg"));
       i2=new JMenuItem("Calculator", new ImageIcon("calc.png"));
       i3=new JMenuItem("Microsoft Word",new ImageIcon("word.png"));
       i4=new JMenuItem("Microsoft Power Point", new ImageIcon("ppt.png"));
       i5=new JMenuItem("Internet Explorer",new ImageIcon("net.png"));
       i1.setMnemonic(KeyEvent.VK_N);
       i2.setMnemonic(KeyEvent.VK_C);
       i3.setMnemonic(KeyEvent.VK_W);
       i4.setMnemonic(KeyEvent.VK_P);
       i5.setMnemonic(KeyEvent.VK_E);
       i1.addActionListener(this);
       i2.addActionListener(this);
       i3.addActionListener(this);
       i4.addActionListener(this);
       i5.addActionListener(this);
       jb.add(m); /* The menu m is added to the menu bar.*/
       m.add(i1);
       m.add(i2);
       m.add(i3);
       m.add(i4);
       m.add(i5);
       jb.add(s);/*The menu s is added to the menu bar.*/
       //m.addSeparator();
       f.setJMenuBar(jb);/*jb is set as the frame menu bar.*/
       b1=new JButton(new ImageIcon("notepad.png"));/*A button is created */
       b1.addActionListener(this);
       b1.setBounds(10,10,50,50);
       f.add(b1);
       t1=new JLabel("Gedit");
       t1.setBounds(10,60,50,20);
       f.add(t1);
       b2=new JButton(new ImageIcon("calc.png"));
       b2.addActionListener(this);
       b2.setBounds(10,90,50,50);
       f.add(b2);
       t2=new JLabel("Calculator");
       t2.setBounds(10,140,50,20);
       f.add(t2);
       b3=new JButton(new ImageIcon("word.png"));
       b3.addActionListener(this);
       b3.setBounds(10,170,50,50);
       f.add(b3);
       t3=new JLabel("MSWord");
       t3.setBounds(10,220,50,20);
       f.add(t3);
       b4=new JButton(new ImageIcon("ppt.png"));
       b4.addActionListener(this);
       b4.setBounds(10,260,50,50);
       f.add(b4);
       t4=new JLabel("PowerPt");
       t4.setBounds(10,310,50,20);
       f.add(t4);
       b5=new JButton(new ImageIcon("net.png"));
       b5.addActionListener(this);
       b5.setBounds(10,350,50,50);
       f.add(b5);
       t5=new JLabel("Google");
       t5.setBounds(10,400,50,20);
       f.add(t5);
       f.setSize(700,700);
       f.setLayout(null);
       f.setVisible(true);
       f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) /*This function is to catch ActionListeners*/
  {
      Runtime rt=Runtime.getRuntime();
      if(e.getSource()==s1)
      {
        try{
           Process p=rt.exec("shutdown -h now");
         }
         catch(IOException er)
         {
           System.out.println(er);
         }
      }
      if(e.getSource()==s2)
      {
           try{
           Process p=rt.exec("restart -h now");
         }
         catch(IOException er)
         {
            System.out.println(er);
         }
      }
      if(e.getSource()==i1||e.getSource()==b1)
      {

           try
           {
                 Process p=rt.exec("gedit");
                 System.out.println("waiting for gedit to exit...");
                 p.waitFor();
                 if(p.exitValue()==0)
                 {
                    System.out.println("process exited successfully");

                  }
                  else {
                    System.out.println("error in exit in from the process");
                  }
           }
           catch(Exception er)
           {
                System.out.println(er);
           }
       }
       if(e.getSource()==i2||e.getSource()==b2)
      {

           try
           {

                   Process p=rt.exec("gnome-calculator");
                 
           }
           catch(Exception er)
           {
                System.out.println(er);
           }
       }
       if(e.getSource()==i3|| e.getSource()==b3)
      {

           try
           {

                  JFileChooser ch=new JFileChooser();
                  int result = ch.showOpenDialog(this);
                  if (result == JFileChooser.APPROVE_OPTION)
                 {

                          File selectedFile =ch.getSelectedFile();
                          Desktop.getDesktop().open(selectedFile);
                          //System.out.println("Selected file: " + selectedFile.getAbsolutePath());

                 }
            }
          catch(Exception er)
          {
              System.out.println(er);
          }
       }
        if(e.getSource()==i4||e.getSource()==b4)
       {

           try
           {

                  JFileChooser ch=new JFileChooser();
                  int result = ch.showOpenDialog(this);
                  if (result == JFileChooser.APPROVE_OPTION)
                 {
                          File selectedFile =ch.getSelectedFile();
                          System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                 }
          }
          catch(Exception er)
          {
              System.out.println(er);
          }
       }
        if(e.getSource()==i5||e.getSource()==b5)
        {
             try
             {
                  URI uri=new URI("http://www.google.com");
                  Desktop dk=null;
                  if(Desktop.isDesktopSupported())
                  {
                        dk=Desktop.getDesktop();
                  }
                   if(dk!=null)
                       dk.browse(uri);
              }
              catch(Exception er)
              {
                     System.out.println(er);
               }
        }
   }

   public static void main(String s[])
   {
        new Minios();
   }
}
