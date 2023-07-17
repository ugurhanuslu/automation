package com.findeks.kkb.logs;

import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Ipek Cinar
 * Date: 17.07.2023
 */

public class Logs {

    public Logs() {
        PropertyConfigurator
                .configure(Logs.class.getClassLoader().getResource("log4j.properties"));
    }
}
