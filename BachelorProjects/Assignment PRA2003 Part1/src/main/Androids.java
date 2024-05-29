package main;

import game.Game;
import game.GameView;
import game.Status;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * Assignment.
 * For PRA2003 (2020) Assignment part 1.
 * Juliette Maes i6230492
 */

public class Androids
{
    public static void main(String[] args)
    {
        Game myGame = new Game(1);
        GameView myView;
        JFrame frame;

        //try and load last saved state
        try {
            myGame.load();
        }
        catch (Exception e) {
            System.out.println("Had error reading file: " + e.getMessage() + "\nContinuing anyways");
        }


/**
 * Assignment.
 * For PRA2003 (2020) Assignment part 2.
 * Juliette Maes i6230492
 */
/*
        System.out.println(myGame.get_State().toString());

        System.out.println();

        myGame.nextLevel();
        System.out.println(myGame.get_State().toString());

        System.out.println();

        final Random rng = new Random();
        int steps = 1;
        while (myGame.get_State().get_status()== Status.Active)
        {
            Action action = Action.values()[rng.nextInt(Action.values().length)];
            myGame.get_State().apply(action);
            System.out.println("Steps: " + steps +"\n");
            System.out.println(myGame.get_State().toString()+"\n");
            steps++;



    }
*/

        /**
         * Assignment.
         * For PRA2003 (2020) Assignment part 3.
         * Juliette Maes i6230492
         */
        Runtime.getRuntime().addShutdownHook (
                new Thread()
                {
                    public void run()
                    {
                        try {
                            myGame.save();
                        } catch (IOException e) {
                            // e.printStackTrace();
                        }
                    }
                }
        );

        /**
         * Assignment.
         * For PRA2003 (2020) Assignment part 4.
         * Juliette Maes i6230492
         */
        frame = new JFrame("Androids");


        frame.setSize(new Dimension(1000, 600));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myView = null;
        try
        {
            myView = new GameView(myGame);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        myView.setSize(frame.getSize());
        frame.add(myView);
        frame.setVisible(true);
        frame.setContentPane(myView);
        frame.setLocation(200,50);
        myView.loadSprites();
        myView.SetUp_Canvas();
        myView.SetUpView();
        myView.Show();



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
