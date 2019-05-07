import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;



public class gameBoard extends JPanel {

    Deck deck = new Deck();
    //private Player player;
    Card hand = new Card();
    Card com_Hand = new Card();
    public JLabel jack_display;
    public JLabel queen_display;
    public JLabel king_display;
    public JLabel rBack_display;
    public JLabel gBack_display;
    public JPanel[][] panelHolder;
    public JButton[] choices;
    public JLabel display;
    public JButton check;
    public JButton call;
    public JButton raise;
    public JButton com;
    public JLabel pot_display;
    public JLabel turnIndicator;
    public JLabel player = new JLabel("Player: 19");
    public JLabel computer = new JLabel("Computer: 19");
    public String text = "pot: 2";
    public int turn = 0;
    public int money = 20;
    public int com_money = 20;
    public int hum_card;
    public int com_card;
    public int pot = 0;
    public int time = 0;
    public int delay = 1000;
    public Timer timer;
    public ImageIcon Jack;
    public ImageIcon Queen;
    public ImageIcon King;
    public ImageIcon rback;

    public gameBoard(){

        Color board = new Color (0,153,0);
        //System.out.println("here");
        setBackground(board);
        setLayout(new GridLayout(2,3));
        Deck deck = new Deck();
        //private Player player;
        Card hand = new Card();
        int i = 1;
        int j = 3;

        JPanel buttons = new JPanel();
          buttons.setLayout(new GridLayout(1,4));
//        buttons.setSize(600,100);
//        choices = new JButton[4];
//        choices[0] = new JButton("Check");
//        choices[1] = new JButton("Raise");
//        choices[2] = new JButton("Fold");
//        choices[3] = new JButton("Computer");
//        for (int v = 0; v<= 3; v++)
//        {
//            choices[v].addActionListener(new ButtonListener());
//            buttons.add(choices[v]);
//        }


        JPanel[][] panelHolder = new JPanel[i][j];

        setLayout(new BorderLayout());

        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++)
            {
                //panelHolder[m][n].setBackground(Color.DARK_GRAY);
                panelHolder[m][n] = new JPanel();
                add(panelHolder[m][n]);
            }
        }
        //setLayout(new GridLayout(3,3));
        //Player player = new Player();
//        JLabel table = new JLabel(new ImageIcon("images/poker-table-layout.jpg"));
//        add(table);

        //here
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("images/JH.png")); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon Jack = new ImageIcon(newimg);  // transform it back
        display = new JLabel(Jack);

        imageIcon = new ImageIcon(this.getClass().getResource("images/QS.png")); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        Queen = new ImageIcon(newimg);  // transform it back
        display = new JLabel(Queen);

        imageIcon = new ImageIcon(this.getClass().getResource("images/KD.png")); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        King = new ImageIcon(newimg);  // transform it back
        display = new JLabel(King);

        imageIcon = new ImageIcon(this.getClass().getResource("images/red_back.png")); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        rback = new ImageIcon(newimg);  // transform it back
        rBack_display = new JLabel(rback);

        imageIcon = new ImageIcon(this.getClass().getResource("images/green_back.png")); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon gck = new ImageIcon(newimg);  // transform it back
        gBack_display = new JLabel(gck);

        //add(gBack_display);

        deck.fillDeck();

        // shuffle
        deck.shuffle();

        // player draws
        hand = deck.deal();

        JPanel cards = new JPanel();
        cards.setLayout(new GridLayout());
        cards.setBackground(board);
        //evaluate(hand);
        if ((hand.face) == 1)
        {
            display.setIcon(Jack);
            cards.add(display);
            System.out.println("jack");
        }
        else if ((hand.face) == 2)
        {
            display.setIcon(Queen);
            cards.add(display);
            System.out.println("queen");
        }
        else if ((hand.face) == 3)
        {
            display.setIcon(King);
            cards.add(display);
            System.out.println("king");
        }
        cards.add(rBack_display);
        cards.add(gBack_display);

        //add(rBack_display, BorderLayout.LINE_START);
        //add(gBack_display, BorderLayout.LINE_END);
        add(cards, BorderLayout.CENTER);
        //-----------------

        check = new JButton("Check / Fold");
        check.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        check.setBackground(Color.gray);
        check.setOpaque(true);
        check.setForeground(Color.white);
        check.setBorderPainted(true);
        //choices[1] =
        raise = new JButton("Raise");
        raise.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        raise.setBackground(Color.gray);
        raise.setOpaque(true);
        raise.setForeground(Color.white);
        raise.setBorderPainted(true);
        //choices[2] =
        call = new JButton("Call");
        call.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        call.setBackground(Color.gray);
        call.setOpaque(true);
        call.setForeground(Color.white);
        call.setBorderPainted(true);

        com = new JButton("Computer");
        com.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        com.setBackground(Color.gray);
        com.setOpaque(true);
        com.setForeground(Color.white);
        com.setBorderPainted(true);

        buttons.add(check);
        buttons.add(raise);
        buttons.add(call);
        buttons.add(com);

        check.addActionListener(new ButtonListener());
        raise.addActionListener(new ButtonListener());
        call.addActionListener(new ButtonListener());
        com.addActionListener(new ComListener());


        pot_display = new JLabel();
        pot_display.setText(text);
        pot_display.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

        turnIndicator = new JLabel();
        turnIndicator.setText("Current Turn: 0");
        turnIndicator.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

        player.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        computer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        //add(buttons);

        JPanel info = new JPanel();
        info.setLayout(new GridLayout(1,4));
        info.add(pot_display);
        info.add(player);
        info.add(computer);
//        main.add(reset);
//        main.add(newGame);
//        main.add(exit);
//
//        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
//        status.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
//        status.add(statusLabel);
//        pack();
//        add(main, BorderLayout.CENTER);
//        add(status, BorderLayout.SOUTH);
        add(buttons, BorderLayout.PAGE_END);
        info.add(turnIndicator);
        add(info, BorderLayout.PAGE_START);
        setVisible(true);

    }

    public class ButtonListener implements ActionListener
    {

        /* public void updateScore()
         {
           //timer = new Timer(delay, this);
           //timer.start();
           //timer = new Timer(100000, this);
           //timer.start();
           String new_money;
           text = String.format("Pot: %02d", pot);
           pot_display.setText(text);
           new_money = String.format("Computer: %02d", com_money);
           computer.setText(new_money);
           new_money = String.format("Human: %02d", money);
           player.setText(new_money);
           //timer = new Timer();
           //timer.setInitialDelay(5000);
          // try {TimeUnit.SECONDS.sleep(1);}
           //catch (InterruptedException k) {System.err.format("IOException: %s%n", k);}
           //timer.stop();
         }*/
        public void actionPerformed(ActionEvent e)
        {
            Random rand = new Random();
            int n = rand.nextInt(50);
            hum_card = hand.face;
            //com_card = com_Hand.face;
            rBack_display.setIcon(rback);
            //while (money > 0 && com_money > 0)
            //{
            if(turn == 0){
                turnIndicator.setText("Current Turn: 0");
            }
            if(turn == 1){
                turnIndicator.setText("Current Turn: 1");
            }

            if (turn == 0)
            {
                pot+=2;
                money--;
                com_money--;
                updateScore();
                //try {TimeUnit.SECONDS.sleep(1);}
                //catch (InterruptedException k) {System.err.format("IOException: %s%n", k);}
                if (e.getSource() == raise)
                {
                    //pot_display= new JLabel();
                    pot++;
                    money--;
                }
                updateScore();
                turn = 1;
            }
            else if (turn == 1)
            {
                if (pot == 3)
                {

                    if ((e.getSource() == call) || (e.getSource() == raise))
                    {
                        pot++;
                        money--;
                        updateScore();
                        //Add delay
                        winConditions();
                        updateScore();
                    }
                    turn = 0;
                }
                else //pot == 2
                {

                    if ((e.getSource() == check) || (e.getSource() == call))
                    {
                        //Add delay
                        winConditions();
                        updateScore();
                        turn = 0;
                    }
                    else // raise pot by 1
                    {
                        pot++;
                        money--;
                        updateScore();
                    }
                }
            }


            //}



            //actionperformed bracket
        }




        //class bracket
    }
    public class ComListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Random rand = new Random();
            int n = rand.nextInt(50);
            hum_card = hand.face;
            com_card = com_Hand.face;
            rBack_display.setIcon(rback);

            //while (money > 0 && com_money > 0)
            //{
            if(turn == 0){
                turnIndicator.setText("Current Turn: 0");
            }
            if(turn == 1){
                turnIndicator.setText("Current Turn: 1");
            }

            int com_card2 = com_card;
            if (turn == 0)
            {
                if (time == 1)
                {
                    pot+=2;
                    money--;
                    com_money--;
                    updateScore();
                    if(com_card2 == 0)
                    {
                        if(n >= 40)
                        {
                            pot++;
                            com_money--;
                        }
                    }
                    else if(com_card2 == 1)
                    {
                        if (n >= 25)
                        {
                            pot++;
                            com_money--;
                        }
                    }
                    else
                    {
                        if (n > 10)
                        {
                            pot++;
                            com_money--;
                        }
                        updateScore();
                        time = 0;
                    }

                    turn = 1;
                }
            }
            else if (turn == 1)
            {
                if (pot == 3)
                {
                    if(com_card2 == 0)
                    {
                        money += pot;
                        pot = 0;
                        updateScore();
                    }
                    else
                    {
                        if (n >= 25 || ((com_card2 == 2) && (n > 10)))
                        {
                            pot++;
                            com_money--;
                            updateScore();
                            winConditions();
                        }
                        else
                        {
                            money += pot;
                            pot = 0;
                            updateScore();
                        }
                        time = 0;
                    }

                    turn = 0;
                }
                else //pot == 2
                {
                    if(com_card2 == 0)
                    {
                        if (n <= 40)
                        {
                            winConditions();
                            updateScore();
                        }
                        else
                        {
                            pot++;
                            com_money--;
                            updateScore();
                        }
                    }
                    else if(com_card2 == 1)
                    {
                        if (n >= 25) //|| ((com_card == 2) && (n > 10)))
                        {
                            winConditions();
                        }
                        else
                        {
                            pot++;
                            com_money--;
                            updateScore();
                        }
                    }
                    else
                    {
                        if (n >= 10)
                        {
                            winConditions();
                        }
                        else
                        {
                            pot++;
                            com_money--;
                            updateScore();
                        }
                    }
                    time = 0;
                }
            }


            //}



            //actionperformed bracket
        }
    }
    public void updateScore()
    {
        //timer = new Timer(delay, this);
        //timer.start();
        //timer = new Timer(100000, new ActionListener());
        //timer.start();
        String new_money;
        text = String.format("Pot: %02d", pot);
        pot_display.setText(text);
        new_money = String.format("Computer: %02d", com_money);
        computer.setText(new_money);
        new_money = String.format("Human: %02d", money);
        player.setText(new_money);
        //timer = new Timer();
        //timer.setInitialDelay(5000);
        //timer.stop();
    }

    public void winConditions()
    {
        //timer = new Timer(delay, this);
        //timer.start();
        //timer.start();
        hum_card = hand.face;
        System.out.println(hum_card);
        com_card = com_Hand.face;
        System.out.println(com_card);
        if (hum_card > com_card)
        {
            money += pot;
            pot = 0;
            turn = 0;
        }
        else
        {
            com_money += pot;
            pot = 0;
            turn = 1;
        }
        updateScore();
        if (com_Hand.face == 1)
        {
            //panelHolder[1][1].add(jack_display);
            rBack_display.setIcon(Jack);
        }
        else if (com_Hand.face == 2)
        {
            //panelHolder[1][1].add(queen_display);
            rBack_display.setIcon(Queen);
        }
        else if (com_Hand.face == 3)
        {
            //panelHolder[1][1].add(king_display);
            rBack_display.setIcon(King);
        }
        add(rBack_display);
        pot+=2;
        money--;
        com_money--;
        updateScore();
        redeal();
        //timer.stop();
    }

    public void redeal()
    {
        deck = new Deck();
        deck.fillDeck();
        deck.shuffle();
        hand = new Card();
        com_Hand = new Card();
        // player draws
        hand = deck.empty_deal();
        com_Hand = deck.cp_deal();
        if (hand.face == 1)
        {
            //panelHolder[1][1].add(jack_display);
            display.setIcon(Jack);
        }
        else if (hand.face == 2)
        {
            //panelHolder[1][1].add(queen_display);
            display.setIcon(Queen);
        }
        else if (hand.face == 3)
        {
            //panelHolder[1][1].add(king_display);
            display.setIcon(King);
        }

    }



}