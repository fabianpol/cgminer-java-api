package org.fablab.miner.api;

import org.fablab.miner.api.impl.CommandService;

public class API {

	private static final String QUERY_PATTERN = "{\"command\":\"%s\",\"parameter\":\"0\"}";

	private CommandService commandService;

	public API() {
		this.commandService = new CommandService();
	}

	public String getSummary(Miner miner) {
		return commandService.process(String.format(QUERY_PATTERN, "summary"), miner);
	}

	public String getStats(Miner miner) {
		return commandService.process(String.format(QUERY_PATTERN, "stats"), miner);
	}
	
	public String getPools(Miner miner) {
		return commandService.process(String.format(QUERY_PATTERN, "pools"), miner);
	}

}
