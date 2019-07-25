package org.fablab.miner.api.inner.impl;

import javax.inject.Inject;

import org.fablab.miner.api.Miner;

public class QueryService {

	private ResponseParser responseParser;
	private CommandService commandService;

	@Inject
	public QueryService(ResponseParser responseParser, CommandService commandService) {
		this.responseParser = responseParser;
		this.commandService = commandService;
	}

	public <T> T executeQueryCommand(Miner miner, String command, Class<T> clazz) {
		return executeQuery(miner, command, command.toUpperCase(), clazz);
	}

	public <T> T executeQuery(Miner miner, String command, String extraction, Class<T> clazz) {
		String result = query(miner, command);
		return responseParser.parseResponse(result, extraction, clazz);
	}

	public String query(Miner miner, String command) {
		String query = QueryFactory.create(command);
		return commandService.process(query, miner);
	}

}
