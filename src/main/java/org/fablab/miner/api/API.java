package org.fablab.miner.api;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class API {

  private static final Logger LOGGER = LoggerFactory.getLogger(API.class);

  private CommandService commandService;

  @Inject
  public API(CommandService commandService) {
    this.commandService = commandService;
  }

  public Summary getSummary(String ip, int port) {
    String result = commandService.process("summary", ip, port);
    String[] splitted = result.split("SUMMARY");
    Status status = Status.fromString(splitted[0]);
    return Summary.fromString(splitted[1].substring(1));
  }


}
