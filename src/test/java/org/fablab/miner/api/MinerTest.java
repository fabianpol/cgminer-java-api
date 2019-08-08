package org.fablab.miner.api;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class MinerTest {

  @Test
  public void constructor_defaultPort() {
    final String host = "192.168.0.1";
    Miner miner = new Miner(host);
    assertThat(miner.getIp()).isEqualTo(host);
    assertThat(miner.getPort()).isEqualTo(4028);
  }

  @Test
  public void constructor() {
    final String host = "192.168.0.1";
    final int port = 1111;
    Miner miner = new Miner(host, port);
    assertThat(miner.getIp()).isEqualTo(host);
    assertThat(miner.getPort()).isEqualTo(port);
  }

}
