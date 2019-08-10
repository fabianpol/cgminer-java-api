package org.fablab.miner.inner.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.fablab.miner.api.Miner;
import org.fablab.miner.api.inner.impl.CommandService;
import org.fablab.miner.api.inner.impl.QueryFactory;
import org.fablab.miner.api.inner.impl.QueryService;
import org.fablab.miner.api.inner.impl.ResponseParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class QueryServiceTest {

  private QueryService queryService;

  @Mock
  private ResponseParser responseParser;

  @Mock
  private CommandService commandService;

  private Miner miner;


  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    this.miner = new Miner("localhost");
    this.queryService = new QueryService(responseParser, commandService);
  }

  @Test
  public void executeQueryCommand() {
    final String extraction = "extraction";
    final String command = "command";
    final String json = "{}";
    final String result = "result";
    Mockito.when(commandService.process(QueryFactory.create(command), miner)).thenReturn(json);
    Mockito.when(responseParser.parseResponse(json, extraction, String.class)).thenReturn(result);
    String actual = queryService.executeQuery(miner, command, extraction, String.class);
    assertThat(actual).isEqualTo(result);
  }



}
