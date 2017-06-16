package com.cgs.launcher;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TrimLauncher {

  public static void main(String[] args) {
    String path = "applicationContext.xml";
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
    context.start();
  }
}
