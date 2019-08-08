package org.fablab.miner.api.inner.impl;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class UpdateStatus {

  @SerializedName("STATUS")
  private String status;

  @SerializedName("id")
  private int id;

  public String getStatus() {
    return status;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(UpdateStatus.class).add("status", status).add("id", id)
        .toString();
  }

}
