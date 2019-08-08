package org.fablab.miner.inner.impl;


import static org.assertj.core.api.Assertions.assertThat;
import org.fablab.miner.api.inner.impl.JSONSyntaxCorrector;
import org.junit.jupiter.api.Test;

public class JSONSyntaxCorrectorTest {

  private static final String correctJson =
      "{\"commands\":[{\"command\":\"summary\"},{\"command\":\"version\"}]}";
  private static final String incorrectJson =
      "{\"commands\":[{\"command\":\"summary\"}{\"command\":\"version\"}]}";

  @Test
  public void correctSyntax_provideIncorrectSyntax() {
    String actual = JSONSyntaxCorrector.correctSyntax(incorrectJson);
    assertThat(actual).isEqualTo(correctJson);
  }

  @Test
  public void correctSyntax_provideCorrectSyntax() {
    String actual = JSONSyntaxCorrector.correctSyntax(correctJson);
    assertThat(actual).isEqualTo(correctJson);
  }

}
