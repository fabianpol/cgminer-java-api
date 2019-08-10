package org.fablab.miner.inner.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.fablab.miner.api.Miner;
import org.fablab.miner.api.inner.impl.QueryFactory;
import org.fablab.miner.api.inner.impl.QueryService;
import org.fablab.miner.api.inner.impl.ResponseParser;
import org.fablab.miner.api.inner.impl.UpdateService;
import org.fablab.miner.api.inner.impl.UpdateStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UpdateServiceTest {

  private static final String COMMAND = QueryFactory.create("summary");

  @Mock
  private ResponseParser responseParser;

  @Mock
  private QueryService queryService;

  private UpdateService updateService;

  private Miner miner;


  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    this.miner = new Miner("192.168.0.1");
    this.updateService = new UpdateService(queryService, responseParser);
  }

  @Test
  public void executeUpdate() {
    String result = "result";
    UpdateStatus updateStatus = new UpdateStatus();
    Mockito.when(queryService.query(miner, COMMAND)).thenReturn(result);
    Mockito.when(responseParser.parseUpdateStatus(result)).thenReturn(updateStatus);
    assertThat(updateService.executeUpdate(miner, COMMAND)).isEqualTo(updateStatus);
  }

}
