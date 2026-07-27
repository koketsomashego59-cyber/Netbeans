package com.mycompany.digitalclock;

import javax.swing.*; //javax swing imports all the classes available in swing package
import java.time.LocalTime;// Gets your regions local time
import java.time.format.DateTimeFormatter; // self explanitory

/**
 *
 * @author koket
 */
public class DigitalClock extends JFrame {
private JLabel timeLabel;// This will show time
   
   public DigitalClock() {
       
       //Lets set up this window
       setTitle("Digital Clock");
       setSize(300, 100);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       timeLabel = new JLabel();
       
       timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
       add(timeLabel);
       
       updateTime();
       
       
  
       
       Timer timer = new Timer(1000, (var e) -> updateTime());
       timer.start();
       
       setVisible(true);
   }
   
private void updateTime() {
        String time = LocalTime.now()
            .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        timeLabel.setText(time);
    }
        
public static void main(String[] args) {
    DigitalClock Clock =new DigitalClock();
  }
}



