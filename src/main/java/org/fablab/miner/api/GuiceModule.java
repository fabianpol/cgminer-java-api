package org.fablab.miner.api;

import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    requestStaticInjection(App.class);
  }

}
