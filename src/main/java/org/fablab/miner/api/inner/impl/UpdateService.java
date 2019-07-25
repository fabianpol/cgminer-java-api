package org.fablab.miner.api.inner.impl;

import javax.inject.Inject;

import org.fablab.miner.api.Miner;
import org.fablab.miner.api.Status;

public class UpdateService {
	
	private QueryService queryService;
	private ResponseParser responseParser;
	
	@Inject
	public UpdateService(QueryService queryService, ResponseParser responseParser) {
		this.queryService = queryService;
		this.responseParser = responseParser;
	}
		
	public Status executeUpdate(Miner miner, String command) {
		String result = queryService.query(miner, command);
		return responseParser.parseStatus(result);
	}

}
