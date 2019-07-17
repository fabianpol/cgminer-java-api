package org.fablab.miner.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Summary {

  private static final String PATTERN =
      "Elapsed=(\\d+),GHS 5s=([0-9.]+),GHS av=([0-9.]+),Found Blocks=(\\d+),Getworks=(\\d+),Accepted=(\\d+),Rejected=(\\d+),Hardware Errors=(\\d+),Utility=([0-9.]+),Discarded=(\\d+),Stale=(\\d+),Get Failures=(\\d+),Local Work=(\\d+),Remote Failures=(\\d+),Network Blocks=(\\d+),Total MH=([0-9.]+),Work Utility=([0-9.]+),Difficulty Accepted=([0-9.]+),Difficulty Rejected=([0-9.]+),Difficulty Stale=([0-9.]+),Best Share=(\\d+),Device Hardware%=([0-9.]+),Device Rejected%=([0-9.]+),Pool Rejected%=([0-9.]+),Pool Stale%=([0-9.]+),Last getwork=(\\d+).*";

  private String elapsed;
  private String ghs5s;
  private String foundBlocks;
  private String getworks;
  private String accepted;
  private String rejected;
  private String hardwareErrors;
  private String utility;
  private String discarded;
  private String stale;
  private String getFailures;
  private String localWork;
  private String remoteFailures;
  private String networkBlocks;
  private String totalMh;
  private String workUtility;
  private String difficultyAccepted;
  private String difficultyRejected;
  private String difficultyStale;
  private String bestShare;
  private String deviceHardware;
  private String deviceRejected;
  private String poolRejected;
  private String poolStale;
  private String lastGetwork;

  public Summary(String elapsed, String gHS5s, String foundBlocks, String getworks, String accepted,
      String rejected, String hardwareErrors, String utility, String discarded, String stale,
      String getFailures, String localWork, String remoteFailures, String networkBlocks,
      String totalMh, String workUtility, String difficultyAccepted, String difficultyRejected,
      String difficultyStale, String bestShare, String deviceHardware, String deviceRejected,
      String poolRejected, String poolStale, String lastGetwork) {

    this.elapsed = elapsed;
    this.ghs5s = gHS5s;
    this.foundBlocks = foundBlocks;
    this.getworks = getworks;
    this.accepted = accepted;
    this.rejected = rejected;
    this.hardwareErrors = hardwareErrors;
    this.utility = utility;
    this.discarded = discarded;
    this.stale = stale;
    this.getFailures = getFailures;
    this.localWork = localWork;
    this.remoteFailures = remoteFailures;
    this.networkBlocks = networkBlocks;
    this.totalMh = totalMh;
    this.workUtility = workUtility;
    this.difficultyAccepted = difficultyAccepted;
    this.difficultyRejected = difficultyRejected;
    this.difficultyStale = difficultyStale;
    this.bestShare = bestShare;
    this.deviceHardware = deviceHardware;
    this.deviceRejected = deviceRejected;
    this.poolRejected = poolRejected;
    this.poolStale = poolStale;
    this.lastGetwork = lastGetwork;
  }

  public static Summary fromString(String value) {
    Pattern p = Pattern.compile(PATTERN);
    Matcher matcher = p.matcher(value);
    if (matcher.matches()) {
      return new Summary(matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5),
          matcher.group(6), matcher.group(7), matcher.group(8), matcher.group(9), matcher.group(10),
          matcher.group(11), matcher.group(12), matcher.group(13), matcher.group(14),
          matcher.group(15), matcher.group(16), matcher.group(17), matcher.group(18),
          matcher.group(19), matcher.group(20), matcher.group(21), matcher.group(22),
          matcher.group(23), matcher.group(24), matcher.group(25), matcher.group(26));
    }
    throw new RuntimeException();
  }

  @Override
  public String toString() {
    return "Summary [elapsed=" + elapsed + ", ghs5s=" + ghs5s + ", foundBlocks=" + foundBlocks
        + ", getworks=" + getworks + ", accepted=" + accepted + ", rejected=" + rejected
        + ", hardwareErrors=" + hardwareErrors + ", utility=" + utility + ", discarded=" + discarded
        + ", stale=" + stale + ", getFailures=" + getFailures + ", localWork=" + localWork
        + ", remoteFailures=" + remoteFailures + ", networkBlocks=" + networkBlocks + ", totalMh="
        + totalMh + ", workUtility=" + workUtility + ", difficultyAccepted=" + difficultyAccepted
        + ", difficultyRejected=" + difficultyRejected + ", difficultyStale=" + difficultyStale
        + ", bestShare=" + bestShare + ", deviceHardware=" + deviceHardware + ", deviceRejected="
        + deviceRejected + ", poolRejected=" + poolRejected + ", poolStale=" + poolStale
        + ", lastGetwork=" + lastGetwork + "]";
  }



}
