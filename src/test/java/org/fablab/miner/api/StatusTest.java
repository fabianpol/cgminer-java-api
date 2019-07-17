package org.fablab.miner.api;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class StatusTest {

  @Test
  public void fromString() {
    final String input = "STATUS=S,When=1563384501,Code=11,Msg=Summary,Description=cgminer 4.9.0|";
    Status status = Status.fromString(input);
    assertThat(status.getCode()).isEqualTo("11");
    assertThat(status.getDescription()).isEqualTo("cgminer 4.9.0|");
    assertThat(status.getMessage()).isEqualTo("Summary");
    assertThat(status.getRequestTime()).isEqualTo("1563384501");
  }

}
