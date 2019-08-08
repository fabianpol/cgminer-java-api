package org.fablab.miner.api.inner.impl;

import org.json.JSONObject;

public class QueryFactory {

  public static String create(String command) {
    JSONObject json = new JSONObject();
    json.put("command", command);
    return json.toString();
  }

}
