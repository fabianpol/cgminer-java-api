package org.fablab.miner.api;

import com.google.gson.annotations.SerializedName;

public abstract class ResponseWithStatus {

	@SerializedName("STATUS")
	protected Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
