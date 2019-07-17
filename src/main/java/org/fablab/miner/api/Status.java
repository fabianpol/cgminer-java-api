package org.fablab.miner.api;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.common.base.MoreObjects;

public class Status {

  private static final String PATTERN =
      "STATUS=([WISEF]),When=(\\d+),Code=(\\d+),Msg=(.*),Description=(.*)";

  private String requestTime;
  private String code;
  private String message;
  private String description;

  public Status(String requestTime, String code, String message, String description) {
    this.requestTime = Objects.requireNonNull(requestTime);
    this.code = Objects.requireNonNull(code);
    this.message = Objects.requireNonNull(message);
    this.description = Objects.requireNonNull(description);
  }

  public static Status fromString(String value) {
    Pattern p = Pattern.compile(PATTERN);
    Matcher matcher = p.matcher(value);
    if (matcher.matches()) {
      return new Status(matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5));
    }
    throw new RuntimeException();
  }

  public String getRequestTime() {
    return requestTime;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(Status.class).add("requestTime", requestTime)
        .add("code", code).add("message", message).add("description", description).toString();
  }

}
