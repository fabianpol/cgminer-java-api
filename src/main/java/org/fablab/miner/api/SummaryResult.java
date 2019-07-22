package org.fablab.miner.api;

public class SummaryResult {

	private Status status;
	private Summary summary;

	public SummaryResult(Status status, Summary summary) {
		this.status = status;
		this.summary = summary;
	}

	public Status getStatus() {
		return status;
	}

	public Summary getSummary() {
		return summary;
	}

}
