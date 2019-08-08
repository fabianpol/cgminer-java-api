package org.fablab.miner.api.inner.impl;

import javax.inject.Inject;
import org.fablab.miner.api.Miner;

public class UpdateService {

  private QueryService queryService;
  private ResponseParser responseParser;

  @Inject
  public UpdateService(QueryService queryService, ResponseParser responseParser) {
    this.queryService = queryService;
    this.responseParser = responseParser;
  }

  public UpdateStatus executeUpdate(Miner miner, String command) {
    String result = queryService.query(miner, command);
    return responseParser.parseUpdateStatus(result);
  }

}
