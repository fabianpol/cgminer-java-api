package org.fablab.miner.api;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class Status {

	@SerializedName("STATUS")
	private String status;

	@SerializedName("When")
	private Long when;

	@SerializedName("Code")
	private int code;

	@SerializedName("Msg")
	private String msg;

	@SerializedName("Description")
	private String description;

	public String getStatus() {
		return status;
	}

	public Long getWhen() {
		return when;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Status.class).add("status", status).add("when", when).add("code", code)
				.add("msg", msg).add("description", description).toString();
	}

}
