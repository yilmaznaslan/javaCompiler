package com.yilmaznaslan;


import de.bvg.Train;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApplication {
    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        System.out.println("Starting main application");
        logger.info("Creating Bus");
        Bus bus_1 = new Bus("M49", 30);

        logger.debug("Creating train");
        Train train_1 = new Train("Urban Train");

    }
}
