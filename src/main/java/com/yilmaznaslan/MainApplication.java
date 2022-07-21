package com.yilmaznaslan;

import de.bvg.Train;
public class MainApplication {

    public static void main(String [] args){
        Bus bus_1 = new Bus("M49", 30);
        Train train_1 = new Train("Urban Train");
        System.out.println("Main application is starting. Bus capacity: " +bus_1.getCapacity());
    }
}
