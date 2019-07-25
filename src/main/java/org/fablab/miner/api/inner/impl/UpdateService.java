package org.fablab.miner.api.inner.impl;

import org.fablab.miner.api.Miner;
import org.fablab.miner.api.Status;

public class UpdateService {
	
	private QueryService queryService;
	private ResponseParser responseParser;
	
	public UpdateService() {
		this.queryService = new QueryService();
		this.responseParser = new ResponseParser();
	}
	
	public Status executeUpdateCommand(Miner miner, String command) {
		return executeUpdate(miner, command);
	}
	
	public Status executeUpdate(Miner miner, String command) {
		String result = queryService.query(miner, command);
		return responseParser.parseStatus(result);
	}

}
