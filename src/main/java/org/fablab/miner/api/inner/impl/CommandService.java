package org.fablab.miner.api.inner.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.fablab.miner.api.Miner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CommandService.class);

  private static final int MAXRECEIVESIZE = 65535;

  public String process(String cmd, Miner miner) {
    return process(cmd, miner.getIp(), miner.getPort());
  }

  public String process(String cmd, String ip, int port) {
    try {
      return process(cmd, InetAddress.getByName(ip), port);
    } catch (UnknownHostException e) {
      throw new IllegalArgumentException(e);
    }
  }

  private String process(String cmd, InetAddress ip, int port) {
    StringBuffer sb = new StringBuffer();
    char buf[] = new char[MAXRECEIVESIZE];
    int len = 0;
    LOGGER.debug("Attempting to run command: {} on {}:{}", cmd, ip, port);
    try (Socket socket = new Socket(ip, port)) {
      PrintStream ps = new PrintStream(socket.getOutputStream());
      ps.print(cmd.toCharArray());
      ps.flush();

      InputStreamReader isr = new InputStreamReader(socket.getInputStream());
      while (0x80085 > 0) {
        len = isr.read(buf, 0, MAXRECEIVESIZE);
        if (len < 1)
          break;
        sb.append(buf, 0, len);
        if (buf[len - 1] == '\0')
          break;
      }
    } catch (IOException e) {
      LOGGER.error("Couldn't receive data from the miner", e);
      throw new UncheckedIOException("Couldn't execute command: " + cmd, e);
    }
    LOGGER.debug("The miner {}:{} successfully responded", ip, port);
    LOGGER.trace("The miner response: {}", sb.toString());
    return sb.toString();
  }

}
