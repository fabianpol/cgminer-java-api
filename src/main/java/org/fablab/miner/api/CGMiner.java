package org.fablab.miner.api;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.fablab.miner.api.inner.impl.JSONSyntaxCorrector;
import org.fablab.miner.api.inner.impl.QueryService;
import org.fablab.miner.api.inner.impl.ResponseParser;
import org.fablab.miner.api.inner.impl.UpdateService;
import org.fablab.miner.api.inner.impl.UpdateStatus;

public class CGMiner {

	private QueryService queryService;
	private UpdateService updateService;
	private ResponseParser responseParser;

	@Inject
	public CGMiner(QueryService queryService, UpdateService updateService, ResponseParser responseParser) {
		this.queryService = queryService;
		this.updateService = updateService;
		this.responseParser = responseParser;
	}

	public Summary summary(Miner miner) {
		return queryService.executeQueryCommand(miner, Commands.SUMMARY, Summary[].class)[0];
	}

	public List<Pool> pools(Miner miner) {
		Pool[] poolsArr = queryService.executeQueryCommand(miner, Commands.POOLS, Pool[].class);
		return Arrays.asList(poolsArr);
	}

	public Version version(Miner miner) {
		return queryService.executeQueryCommand(miner, Commands.VERSION, Version[].class)[0];
	}

	public UpdateStatus restart(Miner miner) {
		return updateService.executeUpdate(miner, Commands.RESTART);
	}

	public Stats stats(Miner miner) {
		String result = JSONSyntaxCorrector.correctSyntax(queryService.query(miner, Commands.STATS));
		return responseParser.parseResponse(result, Commands.STATS.toUpperCase(), 1, Stats.class);
	}

}
