package org.fablab.miner.api;

import java.util.Objects;
import com.google.common.base.MoreObjects;

public class Miner {

  private final static int DEFAULT_PORT = 4028;

  private final String ip;
  private final int port;

  public Miner(String ip) {
    this(ip, DEFAULT_PORT);
  }

  public Miner(String ip, int port) {
    this.ip = Objects.requireNonNull(ip);
    this.port = port;
  }

  public String getIp() {
    return ip;
  }

  public int getPort() {
    return port;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(Miner.class).add("ip", ip).add("port", port).toString();
  }

}
