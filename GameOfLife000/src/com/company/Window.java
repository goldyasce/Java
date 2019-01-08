package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {
    JFrame frame;
    Box[][] boxes;

    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTimer();
    }

    public void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.SIZE * Config.WIDTH, Config.SIZE * Config.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Game of life");
    }

    public void initBoxes() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];

        for(int x = 0; x < Config.WIDTH; x++)
            for(int y = 0; y < Config.HEIGHT; y++){
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }


        for(int x = 0; x < Config.WIDTH; x++)
            for(int y = 0; y < Config.HEIGHT; y++)
                for(int sx = -1; sx <= +1; sx++)
                    for(int sy = -1; sy <= +1; sy++){
                        if(!(sx == 0 && sy == 0)){
                            boxes[x][y].cell.addNear(boxes
                                    [(x + sx + Config.WIDTH) % Config.WIDTH]
                                    [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell);
                        }
                    }
    }

    private void initTimer(){
        TimerListener tl = new TimerListener();
        Timer timer = new Timer(Config.SLEEPMS, tl);
        timer.start();
    }

    private class TimerListener implements ActionListener {
        boolean flag;

        @Override
        public void actionPerformed(ActionEvent e) {
            flag = !flag;

            for(int x = 0; x < Config.WIDTH; x++){
                for(int y = 0; y < Config.HEIGHT; y++) {
                    if(flag)
                        boxes[x][y].step1();
                    else
                        boxes[x][y].step2();
                }
            }
        }
    }
}
