package org.fablab.miner.inner.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.fablab.miner.api.Version;
import org.fablab.miner.api.inner.impl.ResponseParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.google.gson.GsonBuilder;

public class ResponseParserTest {

  private ResponseParser responseParser;

  @BeforeEach
  public void setup() {
    this.responseParser = new ResponseParser(new GsonBuilder().setLenient().create());
  }

  @Test
  public void parseResponse_errorStatusReturned() {
    final String input =
        "{\"STATUS\":[{\"STATUS\":\"E\",\"When\":1564141453,\"Code\":22,\"Msg\":\"custom message\",\"Description\":\"cgminer 4.9.0\"}],\"VERSION\":[{\"CGMiner\":\"4.9.0\",\"API\":\"3.1\",\"Miner\":\"1.0.1.3\",\"CompileTime\":\"Thu Apr 12 15:55:21 CST 2018\",\"Type\":\"Antminer L3++\"}],\"id\":1}";
    Version v = responseParser.parseResponse(input, "VERSION", Version.class);
    assertThat(v.getStatus().getStatus()).isEqualTo("E");
    assertThat(v.getCgminer()).isEqualTo(null);
    assertThat(v.getType()).isEqualTo(null);
    assertThat(v.getCompileTime()).isEqualTo(null);
    assertThat(v.getMiner()).isEqualTo(null);
  }

  @Test
  public void parseResponse_successStatusReturned() {
    final String input =
        "{\"STATUS\":[{\"STATUS\":\"S\",\"When\":1564141453,\"Code\":22,\"Msg\":\"custom message\",\"Description\":\"cgminer 4.9.0\"}],\"VERSION\":[{\"CGMiner\":\"4.9.0\",\"API\":\"3.1\",\"Miner\":\"1.0.1.3\",\"CompileTime\":\"Thu Apr 12 15:55:21 CST 2018\",\"Type\":\"Antminer L3++\"}],\"id\":1}";
    Version v = responseParser.parseResponse(input, "VERSION", Version.class);
    assertThat(v.getStatus().getStatus()).isEqualTo("S");
    assertThat(v.getCgminer()).isEqualTo("4.9.0");
    assertThat(v.getType()).isEqualTo("Antminer L3++");
    assertThat(v.getCompileTime()).isEqualTo("Thu Apr 12 15:55:21 CST 2018");
    assertThat(v.getMiner()).isEqualTo("1.0.1.3");
  }

}
