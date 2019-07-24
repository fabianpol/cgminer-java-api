package org.fablab.miner.inner.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.fablab.miner.api.inner.impl.QueryFactory;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class QueryFactoryTest {
	
	@Test
	public void create() {
		String command = "summary";
		String jsonStr = QueryFactory.create(command);
		JSONObject jsonObject = new JSONObject(jsonStr);
		assertThat(jsonObject.getString("command")).isEqualTo(command);
	}

}
