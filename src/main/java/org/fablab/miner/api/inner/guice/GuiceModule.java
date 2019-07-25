package org.fablab.miner.api.inner.guice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Gson.class).toInstance(new GsonBuilder().setLenient().create());
	}

}
