package org.fablab.miner.api.inner.impl;

import org.fablab.miner.api.Miner;

public class QueryService {

	private ResponseParser responseParser;
	private CommandService commandService;

	public QueryService() {
		this.responseParser = new ResponseParser();
		this.commandService = new CommandService();
	}

	public <T> T executeQueryCommand(Miner miner, String command, Class<T> clazz) {
		return executeQuery(miner, command, command.toUpperCase(), clazz);
	}

	public <T> T executeQuery(Miner miner, String command, String extraction, Class<T> clazz) {
		String result = query(miner, command);
		return parseResponse(result, extraction, clazz);
	}

	private <T> T parseResponse(String json, String arrayName, Class<T> type) {
		return responseParser.parseResponse(json, arrayName, 0, type);
	}

	public String query(Miner miner, String command) {
		String query = QueryFactory.create(command);
		return commandService.process(query, miner);
	}

}
