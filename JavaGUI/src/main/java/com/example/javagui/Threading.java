package com.example.javagui;

import javax.swing.*;

public class Threading extends JFrame
{
    private JProgressBar jpb = new JProgressBar();
    private Thread t1 = new Thread(new Runnable()
    {
        @Override
        public void run()
        {
            while(true)
            {
                System.out.println("Hello World");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    });

    private Thread t2 = new Thread((new Runnable()
    {
        @Override
        public void run()
        {
            while(true)
            {
                System.out.println("Good Morning");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }));

    public void updateProgressBar()
    {
        while(jpb.getValue() < jpb.getMaximum())
        {
            int progress = (int) (Math.random() * 100);
            int sleepProgress = (int) (Math.random() * 1000);
            System.out.println(jpb.getValue());
            jpb.setValue(jpb.getValue() + progress);
            try
            {
                Thread.sleep(sleepProgress);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    public Threading()
    {
//        t1.start();
//        t2.start();

        jpb.setStringPainted(true);
        jpb.setMaximum(1000);
        jpb.setValue(0);
        add(jpb);

        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new Threading().updateProgressBar();
    }

}
