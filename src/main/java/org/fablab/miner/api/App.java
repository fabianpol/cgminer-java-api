package org.fablab.miner.api;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new GuiceModule());
    API api = injector.getInstance(API.class);
    Summary result = api.getSummary("192.168.0.4", 4028);
    System.out.println(result);
  }
}
