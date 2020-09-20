package com.itheima.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo01 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Demo01.class);

    public static void main(String[] args) {
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
    }

}