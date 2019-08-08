package org.fablab.miner.api;

import org.fablab.miner.api.inner.impl.CommandService;
import org.fablab.miner.api.inner.impl.QueryService;
import org.fablab.miner.api.inner.impl.ResponseParser;
import org.fablab.miner.api.inner.impl.UpdateService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CGMinerFactory {

  public static CGMiner create() {
    Gson gson = new GsonBuilder().setLenient().create();
    ResponseParser responseParser = new ResponseParser(gson);
    CommandService commandService = new CommandService();
    QueryService queryService = new QueryService(responseParser, commandService);
    return new CGMiner(queryService, new UpdateService(queryService, responseParser),
        responseParser);
  }

}
