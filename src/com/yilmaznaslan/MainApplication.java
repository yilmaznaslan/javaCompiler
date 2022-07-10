package com.yilmaznaslan;


import de.bvg.Train;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApplication {
    private final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String [] args){
        System.out.println("Starting main application");
        Bus bus_1 = new Bus("M49", 30);

        Train train_1 = new Train("Urban Train");
    }
}
