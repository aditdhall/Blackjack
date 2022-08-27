import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.net.*;
import javax.sound.sampled.*;
/*
 * This class is the main class and has many inner classes
 * in it with specific roles and tasks to create this game.
 * @authors Adit Dhall, Jaiveer Kapadia, Saif Bin Meshar and Yameen Khan.
 * @version 2/3/2019.
 */
public class Dealer
{
   private ArrayList<String> cardName=new ArrayList<String>();
   private ArrayList<BufferedImage> card=new ArrayList<BufferedImage>();
   private ArrayList<String> finalName=new ArrayList<String>();
   private player1 player1;
   private player2 player2;
   private int counter=51;
   private deck deck=new deck();
   private int ph1=170;
   private int ph2=1245;
   private boolean r1=true;
   private boolean r2=true;
   /*
    * This method calls the constructor of the inner class 
    * 'GameFrontScreen' and also calls lots of methods.
    */
   public void deal()
   {
      new GameFrontScreen();
      addCard();
      ReadImage(); 
      player1=new player1();
      player2=new player2();
      player1.deal(card.get(counter),card.get(counter-1));
      player1.setTotal(returnCardName(counter));
      player1.setTotal(returnCardName(counter-1));
      counter--;
      counter--;
      player2.deal(card.get(counter),card.get(counter-1));
      player2.setTotal(returnCardName(counter));
      player2.setTotal(returnCardName(counter-1));
      counter--;
      counter--;
      while(r1==true||r2==true)
      {
         System.out.print("");
      }
      winner();
   }
   /*
    * This method adds the names of the cards to an arraylist.
    */
   public void addCard()
   {
      cardName.add("2C.png");
      cardName.add("2D.png");
      cardName.add("2H.png");
      cardName.add("2S.png");
      cardName.add("3C.png");
      cardName.add("3D.png");
      cardName.add("3H.png");
      cardName.add("3S.png");
      cardName.add("4C.png");
      cardName.add("4D.png");
      cardName.add("4H.png");
      cardName.add("4S.png");
      cardName.add("5C.png");
      cardName.add("5D.png");
      cardName.add("5H.png");
      cardName.add("5S.png");
      cardName.add("6C.png");
      cardName.add("6D.png");
      cardName.add("6H.png");
      cardName.add("6S.png");
      cardName.add("7C.png");
      cardName.add("7D.png");
      cardName.add("7H.png");
      cardName.add("7S.png");
      cardName.add("8C.png");
      cardName.add("8D.png");
      cardName.add("8H.png");
      cardName.add("8S.png");
      cardName.add("9C.png");
      cardName.add("9D.png");
      cardName.add("9H.png");
      cardName.add("9S.png");
      cardName.add("10C.png");
      cardName.add("10D.png");
      cardName.add("10H.png");
      cardName.add("10S.png");
      cardName.add("AC.png");
      cardName.add("AD.png");
      cardName.add("AH.png");
      cardName.add("AS.png");
      cardName.add("JC.png");
      cardName.add("JD.png");
      cardName.add("JH.png");
      cardName.add("JS.png");
      cardName.add("KC.png"); 
      cardName.add("KD.png");
      cardName.add("KH.png");
      cardName.add("KS.png");
      cardName.add("QC.png");
      cardName.add("QD.png");
      cardName.add("QH.png");
      cardName.add("QS.png");
   }
   /*
    * This method shuffles the names of the cards from an arraylist 
    * and adds it to another arraylist. It also reads the shuffled 
    * images of cards and adds them to another arraylist.
    */
   public void ReadImage()
   {  
      BufferedImage temp = null;
      Collections.shuffle(cardName);
      try
      {
         for( String item : cardName )
         {
            temp = ImageIO.read( new File( item ) );
            finalName.add(item);
            card.add( temp );
         }
      }
      catch( IOException e )
      {
         System.err.println( e.getMessage() );
      }
   }
   /*
    * This method makes the JFrame visible for the 
    * inner classes 'player1' and 'player2'.
    */
   public void visible()
   {
      player1.setVisible(true);
      player2.setVisible(true);
   }
   /*
    * This method determines the result based on the criterias.
    */
   public void winner()
   {
      int tp1;
      int tp2;
      tp1= Integer.parseInt(player1.getTotal());
      tp2= Integer.parseInt(player2.getTotal());
      if(tp1>tp2&&tp1<=21)
      {
         JOptionPane.showMessageDialog( null,"p1 wins");   
      }
      else if(tp1==tp2)
      {
         JOptionPane.showMessageDialog( null,"draw");
      }
      else if(tp2>tp1&&tp2<=21)
      {
         JOptionPane.showMessageDialog( null,"p2 wins"); 
      }
      else if(tp1>21&&tp2<=21)
      {
         JOptionPane.showMessageDialog( null,"p2 wins");
      }
      else if(tp2>21&&tp1<=21)
      {
         JOptionPane.showMessageDialog( null,"p1 wins");
      }   
      else
      {
         JOptionPane.showMessageDialog( null,"both lose");
      }
   }
   /*
    * This method gets the name of the specific card from
    * an arraylist of shuffled names of cards. 
    */ 
   public String returnCardName(int i)
   {
      return finalName.get(i);
   }
   /*
    * This method gets the counter.
    */
   public int getCounter()
   {
      return counter;
   }
   /*
    * This method calls the method 'setCard1' from an inner class 'deck' 
    * with a specific argument which depends on the criteria.
    */
   public void deckCard1(boolean a)
   {
      if(a==true)
      {
         deck.setCard1(card.get(51));
      }
      else
      {
         deck.setCard1(card.get(50));
      }
   }
   /*
    * This method calls the method 'setCard2' from an inner class 'deck' 
    * with a specific argument which depends on the criteria.
    */
   public void deckCard2(boolean a)
   {
      if(a==true)
      {
         deck.setCard2(card.get(49));
      }
      else
      {
         deck.setCard2(card.get(48));
      }
   }
   /*
    * This inner class creates a JFrame which shows the card that 
    * both player one and player two want to show to each other.
    */
   public class deck extends JFrame
   {
      private JButton d;
      private JButton c1;
      private JButton c2;
      /*
       * This constructor creates a JFrame and adds or sets 
       * or both add and sets the components related to it.
       */
      public deck()
      {
         setTitle("table");
         setSize(470,370);
         setLocation(550,20);
         setLayout(new BorderLayout());
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         d=new JButton("");
         c1=new JButton("");
         c2=new JButton("");
         d.setBorder(null);
         c1.setBorder(null);
         c2.setBorder(null);
         JPanel dp=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
         JPanel cards=new JPanel(new FlowLayout(FlowLayout.CENTER,80,8));
         JPanel label=new JPanel(new FlowLayout(FlowLayout.CENTER,180,5));
         dp.setBackground(new Color(0,95,0));
         cards.setBackground(new Color(0,95,0));
         label.setBackground(new Color(0,95,0));
         dp.add(d);
         add(dp,BorderLayout.NORTH);
         cards.add(c1);
         cards.add(c2);
         add(cards,BorderLayout.CENTER);
         label.add(new JLabel("Player 1"));
         label.add(new JLabel("Player 2"));
         try
         {
            BufferedImage temp;
            temp=ImageIO.read(new File("Bgp1.jpg"));
            d.setIcon(new ImageIcon(temp));
         }
         catch(Exception e)
         {
            System.out.println(e.getMessage());
         }
         add(label,BorderLayout.SOUTH);
         setVisible(false);
      }
      /*
       * This method sets the buttons icon to an image 
       * of a card that the player chose to show.   
       */
      public void setCard1(BufferedImage a)
      {
         c1.setIcon(new ImageIcon(a));
         setVisible(true);
      }
      /*
       * This method sets the buttons icon to an image 
       * of a card that the player chose to show.   
       */  
      public void setCard2(BufferedImage a)
      {
         c2.setIcon(new ImageIcon(a));
         setVisible(true);
      }
   }
   /*
    * This class creates a JFrame for player one with its 
    * components and also handles the buttons events
    */
   public class player1 extends JFrame implements ActionListener
   {
      private JButton c1;
      private JButton c2;
      private JRadioButton o1;
      private JRadioButton o2;
      private JButton show;
      private JButton raise;
      private JButton hold;
      private BufferedImage i1;
      private BufferedImage i2;
      private int total=0;
      private File f;
      private AudioInputStream ais;
      private Clip c;
      private boolean option=true;
      /*
       * This constructor creates a JFrame and adds or sets 
       * or both add and sets the components related to it.
       */
      public player1() 
      {
         setTitle("p1");
         setSize(470,360);
         setLocation(320,450);
         setLayout(new BorderLayout());
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JPanel ta=new JPanel(new FlowLayout(FlowLayout.CENTER,50,20));
         ta.setBackground(new Color(0,102,0));
         JPanel center=new JPanel(new GridLayout(0,1));
         center.setBackground(new Color(0,102,0));
         JPanel rb=new JPanel(new FlowLayout(FlowLayout.CENTER,145,10));
         JPanel b1=new JPanel(new FlowLayout(FlowLayout.CENTER,10,8));
         JPanel b2=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
         rb.setBackground(new Color(0,102,0));
         b1.setBackground(new Color(0,102,0));
         b2.setBackground(new Color(0,102,0));
         c1=new JButton("");
         c2=new JButton("");
         ta.add(c1);
         ta.add(c2);
         add(ta,BorderLayout.NORTH);
         o1=new JRadioButton("1st card",true);
         o2=new JRadioButton("2nd card",false);
         ButtonGroup group=new ButtonGroup();
         group.add(o1);
         group.add(o2);
         rb.add(o1);
         rb.add(o2);
         center.add(rb);
         show=new JButton("show");
         b1.add(show);
         center.add(b1);
         add(center,BorderLayout.CENTER);
         raise=new JButton("raise");
         hold=new JButton("hold");
         raise.setEnabled(false);
         hold.setEnabled(false);
         c1.setBackground(new Color(0,102,0));
         c2.setBackground(new Color(0,102,0));
         b2.add(raise);
         b2.add(hold);
         add(b2,BorderLayout.SOUTH);
         show.addActionListener(this);
         raise.addActionListener(this);
         hold.addActionListener(this);
         c1.setBorder(null);
         c2.setBorder(null);
         setVisible(false);
      }
      /*
       * This method handles the button events case by case
       * by using switch.
       */
      public void actionPerformed(ActionEvent e)
      {
         String str;
         str=String.valueOf(e.getActionCommand());
         char ch=str.charAt(0);
         switch(ch)
         {
            case('s'):
               {
                  deckCard1(getOption());
                  o1.setEnabled(false);
                  o2.setEnabled(false);
                  show.setEnabled(false);
                  raise.setEnabled(true);
                  hold.setEnabled(true);
               }
               break;
            case('r'):
               {
                  try
                  {
                     f=new File("p1r.wav");
                     ais=AudioSystem.getAudioInputStream(f);
                     c=AudioSystem.getClip();
                     c.open(ais);
                     c.start();
                  }      
                  catch(UnsupportedAudioFileException uafe)
                  {
                     uafe.printStackTrace();
                  }
                  catch(IOException ioe)
                  {
                     ioe.printStackTrace();
                  }
                  catch(Exception ie)
                  {
                     ie.printStackTrace();
                  }
                  JFrame f1=new JFrame();
                  f1.setSize(70,200);
                  f1.setLocation(ph1,450);
                  f1.setTitle("player 1 new card");
                  JButton jb1=new JButton("");
                  jb1.setBackground(new Color(0,102,0));
                  jb1.setBorder(null);
                  f1.add(jb1);
                  jb1.setIcon(new ImageIcon(card.get(counter)));
                  player1.setTotal(returnCardName(counter));
                  counter--;
                  ph1-=148;
                  if(r2!=false)
                  {
                     player2.buttonEnabled();
                     raise.setEnabled(false);
                     hold.setEnabled(false);
                  }
                  f1.setVisible(true);
               }
               break;
            case('h'):
               {
                  try
                  {
                     f=new File("p1h.wav");
                     ais=AudioSystem.getAudioInputStream(f);
                     c=AudioSystem.getClip();
                     c.open(ais);
                     c.start();
                  }      
                  catch(UnsupportedAudioFileException uafe)
                  {
                     uafe.printStackTrace();
                  }
                  catch(IOException ioe)
                  {
                     ioe.printStackTrace();
                  }
                  catch(Exception ie)
                  {
                     ie.printStackTrace();
                  }
                  r1=false;
                  if(r2!=false)
                  {
                     player2.buttonEnabled();
                  }
                  raise.setEnabled(false);
                  hold.setEnabled(false);
               }
               break;
         }
      }
      /*
       * This method sets the buttons icons to images 
       * of cards that are shown to player one.   
       */
      public void deal(BufferedImage a,BufferedImage b)
      {
         i1=a;
         i2=b;
         c1.setIcon(new ImageIcon(a));
         c2.setIcon(new ImageIcon(b));
      }
      /*
       * This method enables the 'raise' and 'hold' buttons.
       */
      public void buttonEnabled()
      {
         raise.setEnabled(true);
         hold.setEnabled(true);
      }
      /*
       * This method sets the total for player one based on the criterias.
       */
      public void setTotal(String a)
      {
         if (a.equals("2C.png")||a.equals("2D.png")||a.equals("2H.png")||a.equals("2S.png"))
         {
            total+=2;
         }
         else if(a.equals("3C.png")||a.equals("3D.png")||a.equals("3H.png")||a.equals("3S.png"))
         {
            total+=3;
         }
         else if(a.equals("4C.png")||a.equals("4D.png")||a.equals("4H.png")||a.equals("4S.png"))
         {
            total+=4;
         }
         else if(a.equals("5C.png")||a.equals("5D.png")||a.equals("5H.png")||a.equals("5S.png"))
         {
            total+=5;
         }
         else if(a.equals("6C.png")||a.equals("6D.png")||a.equals("6H.png")||a.equals("6S.png"))
         {
            total+=6;
         }
         else if(a.equals("7C.png")||a.equals("7D.png")||a.equals("7H.png")||a.equals("7S.png"))
         {
            total+=7;
         }
         else if(a.equals("8C.png")||a.equals("8D.png")||a.equals("8H.png")||a.equals("8S.png"))
         {
            total+=8;
         }
         else if(a.equals("9C.png")||a.equals("9D.png")||a.equals("9H.png")||a.equals("9S.png"))
         {
            total+=9;
         }
         else if(a.equals("10C.png")||a.equals("10D.png")||a.equals("10H.png")||a.equals("10S.png")||a.equals("JC.png")||a.equals("JD.png")||a.equals("JH.png")||a.equals("JS.png")||a.equals("KC.png")||a.equals("KD.png")||a.equals("KH.png")||a.equals("KS.png")||a.equals("QC.png")||a.equals("QD.png")||a.equals("QH.png")||a.equals("QS.png"))
         {
            total+=10;
         }
         else if(a.equals("AC.png")||a.equals("AD.png")||a.equals("AH.png")||a.equals("AS.png"))
         {
            total+=1;
         }
      }
      /*
       * This method returns a boolean based on the conditions.
       */
      public boolean getOption()
      {
         if(o1.isSelected())
         {
            option=true;
         }
         else
         {
            option=false;
         }
         return option;
      }
      /* 
       * This method gets the total for player one.
       */
      public String getTotal()
      {
         return total+"";
      }
   }
   /*
    * This class creates a JFrame for player two with its 
    * components and also handles the buttons events
    */
   public class player2 extends JFrame implements ActionListener
   {
      private JButton c1;
      private JButton c2;
      private JRadioButton o1;
      private JRadioButton o2;
      private JButton show;
      private JButton raise;
      private JButton hold;
      private BufferedImage i1;
      private BufferedImage i2;
      private int total=0;
      private File f;
      private AudioInputStream ais;
      private Clip c;
      private boolean option=true;
      /*
       * This constructor creates a JFrame and adds or sets 
       * or both add and sets the components related to it.
       */
      public player2() 
      {
         setTitle("p2");
         setSize(470,360);
         setLocation(790,450);
         setLayout(new BorderLayout());
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JPanel ta=new JPanel(new FlowLayout(FlowLayout.CENTER,50,20));
         JPanel center=new JPanel(new GridLayout(0,1));
         JPanel rb=new JPanel(new FlowLayout(FlowLayout.CENTER,145,10));
         JPanel b1=new JPanel(new FlowLayout(FlowLayout.CENTER,10,8));
         JPanel b2=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
         ta.setBackground(new Color(0,102,0));
         center.setBackground(new Color(0,102,0));
         rb.setBackground(new Color(0,102,0));
         b1.setBackground(new Color(0,102,0));
         b2.setBackground(new Color(0,102,0));
         c1=new JButton("");
         c2=new JButton("");
         ta.add(c1);
         ta.add(c2);
         add(ta,BorderLayout.NORTH);
         o1=new JRadioButton("1st card",true);
         o2=new JRadioButton("2nd card",false);
         ButtonGroup group=new ButtonGroup();
         group.add(o1);
         group.add(o2);
         rb.add(o1);
         rb.add(o2);
         center.add(rb);
         show=new JButton("show");
         b1.add(show);
         center.add(b1);
         add(center,BorderLayout.CENTER);
         raise=new JButton("raise");
         hold=new JButton("hold");
         raise.setEnabled(false);
         hold.setEnabled(false);
         b2.add(raise);
         b2.add(hold);
         add(b2,BorderLayout.SOUTH);
         show.addActionListener(this);
         raise.addActionListener(this);
         hold.addActionListener(this);
         c1.setBackground(new Color(0,102,0));
         c2.setBackground(new Color(0,102,0));
         c1.setBorder(null);
         c2.setBorder(null);
         setVisible(false);
      }
      /*
       * This method handles the button events case by case
       * by using switch.
       */
      public void actionPerformed(ActionEvent e)
      {
         String str;
         str=String.valueOf(e.getActionCommand());
         char ch=str.charAt(0);
         switch(ch)
         {
            case('s'):
               {
                  deckCard2(getOption());
                  o1.setEnabled(false);
                  o2.setEnabled(false);
                  show.setEnabled(false);
               }
               break;
            case('r'):
               {
                  try
                  {
                     f=new File("p2r.wav");
                     ais=AudioSystem.getAudioInputStream(f);
                     c=AudioSystem.getClip();
                     c.open(ais);
                     c.start();
                  }      
                  catch(UnsupportedAudioFileException uafe)
                  {
                     uafe.printStackTrace();
                  }
                  catch(IOException ioe)
                  {
                     ioe.printStackTrace();
                  }
                  catch(Exception ie)
                  {
                     ie.printStackTrace();
                  }
                  JFrame f1=new JFrame();
                  f1.setSize(70,200);
                  f1.setLocation(ph2,450);
                  f1.setTitle("player 2 new card");
                  JButton jb1=new JButton("");
                  jb1.setBackground(new Color(0,102,0));
                  jb1.setBorder(null);
                  f1.add(jb1);
                  jb1.setIcon(new ImageIcon(card.get(counter)));
                  player2.setTotal(returnCardName(counter));
                  counter--;
                  ph2+=148;
                  if(r1!=false)
                  {
                     player1.buttonEnabled();
                     raise.setEnabled(false);
                     hold.setEnabled(false);
                  }
                  f1.setVisible(true);
               }
               break;
            case('h'):
               {
                  try
                  {
                     f=new File("p2h.wav");
                     ais=AudioSystem.getAudioInputStream(f);
                     c=AudioSystem.getClip();
                     c.open(ais);
                     c.start();
                  }      
                  catch(UnsupportedAudioFileException uafe)
                  {
                     uafe.printStackTrace();
                  }
                  catch(IOException ioe)
                  {
                     ioe.printStackTrace();
                  }
                  catch(Exception ie)
                  {
                     ie.printStackTrace();
                  }
                  r2=false;
                  if(r1!=false)
                  {
                     player1.buttonEnabled();
                  }
                  raise.setEnabled(false);
                  hold.setEnabled(false);
               }
               break;
         }
      }
      /*
       * This method sets the buttons icons to images 
       * of cards that are shown to player two.   
       */
      public void deal(BufferedImage a,BufferedImage b)
      {
         Dealer d1=new Dealer();
         i1=a;
         i2=b;
         c1.setIcon(new ImageIcon(a));
         c2.setIcon(new ImageIcon(b));
      }
      /*
       * This method enables the 'raise' and 'hold' buttons. 
       */
      public void buttonEnabled()
      {
         raise.setEnabled(true);
         hold.setEnabled(true);
      }
      /*
       * This method sets the total for player two based on the criterias.
       */
      public void setTotal(String a)
      {
         if (a.equals("2C.png")||a.equals("2D.png")||a.equals("2H.png")||a.equals("2S.png"))
         {
            total+=2;
         }
         else if(a.equals("3C.png")||a.equals("3D.png")||a.equals("3H.png")||a.equals("3S.png"))
         {
            total+=3;
         }
         else if(a.equals("4C.png")||a.equals("4D.png")||a.equals("4H.png")||a.equals("4S.png"))
         {
            total+=4;
         }
         else if(a.equals("5C.png")||a.equals("5D.png")||a.equals("5H.png")||a.equals("5S.png"))
         {
            total+=5;
         }
         else if(a.equals("6C.png")||a.equals("6D.png")||a.equals("6H.png")||a.equals("6S.png"))
         {
            total+=6;
         }
         else if(a.equals("7C.png")||a.equals("7D.png")||a.equals("7H.png")||a.equals("7S.png"))
         {
            total+=7;
         }
         else if(a.equals("8C.png")||a.equals("8D.png")||a.equals("8H.png")||a.equals("8S.png"))
         {
            total+=8;
         }
         else if(a.equals("9C.png")||a.equals("9D.png")||a.equals("9H.png")||a.equals("9S.png"))
         {
            total+=9;
         }
         else if(a.equals("10C.png")||a.equals("10D.png")||a.equals("10H.png")||a.equals("10S.png")||a.equals("JC.png")||a.equals("JD.png")||a.equals("JH.png")||a.equals("JS.png")||a.equals("KC.png")||a.equals("KD.png")||a.equals("KH.png")||a.equals("KS.png")||a.equals("QC.png")||a.equals("QD.png")||a.equals("QH.png")||a.equals("QS.png"))
         {
            total+=10;
         }
         else if(a.equals("AC.png")||a.equals("AD.png")||a.equals("AH.png")||a.equals("AS.png"))
         {
            total+=1;
         }
      }
      /*
       * This method returns a boolean based on the conditions.
       */
      public boolean getOption()
      {
         if(o1.isSelected())
         {
            option=true;
         }
         else
         {
            option=false;
         }
         return option;
      }
      /*
       * This method gets the total for player two.
       */
      public String getTotal()
      {
         return total+"";
      }
   }
   /*
    * This class creates a JFrame for the main menu of this game 
    * with its components and also handles the buttons events.
    */
   public class GameFrontScreen extends JFrame implements ActionListener
   {
      private JPanel jp1;
      private JLabel jl1;
      private JMenuBar jmb1;
      private JMenu jm1;
      private JMenuItem jmi1;
      private JMenuItem jmi2;
      private JButton jb1;
      private JButton jb2;
      private File f;
      private AudioInputStream ais;
      private Clip c;
      /*
       * This constructor creates a JFrame and adds or sets 
       * or both add and sets the components related to it.
       */
      public GameFrontScreen()
      {
         setTitle("BlackJack");
         setSize(470,370);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         try
         {
            f=new File("audio1.wav");
            ais=AudioSystem.getAudioInputStream(f);
            c=AudioSystem.getClip();
            c.open(ais);
            c.start();
         }      
         catch(UnsupportedAudioFileException uafe)
         {
            uafe.printStackTrace();
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
         jp1=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
         jl1=new JLabel(new ImageIcon("image1.jpg"));
         jl1.setLayout(new FlowLayout());
         add(jl1);
         jmb1=new JMenuBar();
         jm1=new JMenu("Volume");
         jmi1=new JMenuItem("Mute Volume");
         jmi2=new JMenuItem("Unmute Volume");
         jmi2.setEnabled(false);
         setJMenuBar(jmb1);
         jmb1.add(jm1);
         jm1.add(jmi1);
         jm1.add(jmi2);
         jb1=new JButton("Play");
         jb2=new JButton("Quit");
         add(jp1,BorderLayout.SOUTH);
         jp1.add(jb1);
         jp1.add(jb2);
         jb1.addActionListener(this);
         jb2.addActionListener(this);
         jmi1.addActionListener(this);
         jmi2.addActionListener(this);
         setVisible(true);
      }
      /*
       * This method handles the button events.
       */
      public void actionPerformed(ActionEvent ae)
      {
         if(ae.getSource()==jb1)
         {
            setVisible(false);
            visible();
         }
         else if(ae.getSource()==jb2)
         {         
            new Quit();
         }
         else if(ae.getSource()==jmi1)
         {
            c.stop();
            jmi1.setEnabled(false);
            jmi2.setEnabled(true);  
         }
         else if(ae.getSource()==jmi2)
         {
            c.start();
            jmi1.setEnabled(true);
            jmi2.setEnabled(false);
         }
      }
      /*
       * This class creates a JFrame for the quit part of the main menu of 
       * this game with its components and also handles the buttons events.
       */
      public class Quit extends JFrame implements ActionListener
      {
         private JPanel jp2;
         private JPanel jp3;
         private JLabel jl2;
         private JButton jb3;
         private JButton jb4;
         /*
          * This constructor creates a JFrame and adds or sets 
          * or both add and sets the components related to it.
          */
         public Quit()
         {
            setTitle("Quit");
            setSize(250,110);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setVisible(true);
            jp2=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
            jp3=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
            jl2=new JLabel("Are you sure you want to quit?");
            jl2.setLayout(new FlowLayout());
            jb3=new JButton("Yes");
            jb4=new JButton("No");
            jp2.add(jb3);
            jp2.add(jb4);
            jp3.add(jl2);
            add(jp2,BorderLayout.SOUTH);
            add(jp3,BorderLayout.CENTER);
            jb3.addActionListener(this);
            jb4.addActionListener(this);
         }
         /*
          * This method handles the button events.
          */
         public void actionPerformed(ActionEvent ae)
         {
            if(ae.getSource()==jb3)
            {
               System.exit(0);
            }
            else if(ae.getSource()==jb4)
            {
               setVisible(false);
            }
         }
      }    
   }
   /*
    * This main method calls the 'deal' method of the main class 'Dealer'.
    */
   public static void main(String[]args)
   {
      Dealer d1=new Dealer();
      d1.deal();
   }  
}