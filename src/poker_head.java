/*
Date: 04.26.19
Names: Jackson Ricks
       Michael Peters
 */


import javax.swing.*;    // Needed for Swing classes
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import java.io.File.*;
import javax.imageio.ImageIO;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class poker_head extends JFrame {


//
//    private JFrame frame = new JFrame();
//    private JLayeredPane lpane = new JLayeredPane();
//    private JPanel panelBlue = new JPanel();
//    private JPanel panelGreen = new JPanel();
//    public static gameBoard gameBoard;
//
//    public poker_head()
//    {
//        frame.setTitle("Poker Town");
//        Color board = new Color (0,153,0);
//        frame.setPreferredSize(new Dimension(600, 600));
//        frame.setLayout(new BorderLayout());
//        frame.add(lpane, BorderLayout.CENTER);
//        lpane.setBounds(0, 0, 600, 600);
//        gameBoard = new gameBoard();
//        JLabel background = new JLabel(new ImageIcon(this.getClass().getResource("images/table.png")));
//        //panelBlue.setBackground(board);
//        panelBlue.setBounds(0, 0, 600, 600);
//
//        panelBlue.setOpaque(false);
//        panelGreen.setBackground(board);
//        panelGreen.setBounds(0, 0, 600, 600);
//        panelGreen.setOpaque(false);
//        panelGreen.add(gameBoard);
//        panelBlue.add(background);
//
//
//
//        lpane.add(panelBlue, new Integer(0), 0);
//        lpane.add(panelGreen, new Integer(1), 0);
//        frame.pack();
//        frame.setVisible(true);
//    }


    //public static player1 One;
    //public static player2 Two;
    public static gameBoard gameBoard;
    //private menuPanel menu;
    private final int WINDOW_WIDTH = 470; // Window width
    private final int WINDOW_HEIGHT = 250; // Window height
    private static JPanel p;



    /**
     Constructor
     */

    public poker_head()
    {
        // Set the title bar text.
        setTitle("Poker Town");
        Color board = new Color (0,153,0);
        setBackground(board);
        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel p = new JPanel();
        //p.setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon(this.getClass().getResource("images/table.png")));
        background.setBounds(0,0,400,200);
        //background.setLayout();
        //add(background);
//        p.setBackground(board);
//        p.setLayout(new GridLayout(3,3));

        // Create the three buttons.
        //One = new player1();
        //Two = new player2();
        gameBoard = new gameBoard();
        //menu = new menuPanel();

        //p.add(One);
        //p.add(Two);

        //add(p ,BorderLayout.NORTH);
        add(gameBoard);
        //add(menu, BorderLayout.SOUTH);

        // Display the window.
        //pack();
        setVisible(true);
    }





    /**
     main method
     */

    public static void main(String[] args)
    {
        new poker_head();


        //One.textField.setEditable(false);
        //Two.textField.setEditable(false);

        //there was an attempt to make the text box uneditable! :)

    }
}