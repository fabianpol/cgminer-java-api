package org.fablab.miner.api;

import org.fablab.miner.api.inner.impl.CommandService;
import org.fablab.miner.api.inner.impl.JSONSyntaxCorrector;
import org.fablab.miner.api.inner.impl.QueryFactory;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CGMiner {

	private CommandService commandService;
	private Gson gson;

	public CGMiner() {
		this.commandService = new CommandService();
		this.gson = new GsonBuilder().setLenient().create();
	}

	public Summary summary(Miner miner) {
		return executeQueryCommand(miner, Commands.SUMMARY, Summary.class);
	}

	public Pools pools(Miner miner) {
		return executeQueryCommand(miner, Commands.POOLS, Pools.class);
	}

	public Version version(Miner miner) {
		return executeQueryCommand(miner, Commands.VERSION, Version.class);
	}

	public Status restart(Miner miner) {
		return executeUpdateCommand(miner, Commands.RESTART);
	}

	public Stats stats(Miner miner) {
		String result = JSONSyntaxCorrector.correctSyntax(query(miner, Commands.STATS));
		return parseResponse(result, Commands.STATS.toUpperCase(), 1, Stats.class);
	}

	private <T> T executeQueryCommand(Miner miner, String command, Class<T> clazz) {
		return executeQuery(miner, command, command.toUpperCase(), clazz);
	}

	private Status executeUpdateCommand(Miner miner, String command) {
		return executeUpdate(miner, command);
	}

	private <T> T executeQuery(Miner miner, String command, String extraction, Class<T> clazz) {
		String result = query(miner, command);
		return parseResponse(result, extraction, clazz);
	}

	private Status executeUpdate(Miner miner, String command) {
		String result = query(miner, command);
		return parseStatus(result);
	}

	private String query(Miner miner, String command) {
		String query = QueryFactory.create(command);
		return commandService.process(query, miner);
	}

	private <WithStatus> WithStatus parseResponse(String json, String arrayName, Class<WithStatus> type) {
		return parseResponse(json, arrayName, 0, type);
	}

	private Status parseStatus(String json) {
		JSONObject jsonObj = new JSONObject(json);
		return gson.fromJson(jsonObj.getJSONArray("STATUS").get(0).toString(), Status.class);
	}

	private <T> T parseResponse(String json, String arrayName, int index, Class<T> type) {
		JSONObject jsonObj = new JSONObject(json);
		T result = gson.fromJson(jsonObj.getJSONArray(arrayName).get(index).toString(), type);
		if (result instanceof ResponseWithStatus) {
			ResponseWithStatus withStatus = (ResponseWithStatus) result;
			withStatus.setStatus(parseStatus(json));
		}
		return result;
	}

}
