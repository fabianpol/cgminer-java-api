package org.fablab.miner.api;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class Version extends ResponseWithStatus {

	@SerializedName("CGMiner")
	private String cgminer;
	@SerializedName("API")
	private String api;
	@SerializedName("Miner")
	private String miner;
	@SerializedName("CompileTime")
	private String compileTime;
	@SerializedName("Type")
	private String type;

	public String getCgminer() {
		return cgminer;
	}

	public String getApi() {
		return api;
	}

	public String getMiner() {
		return miner;
	}

	public String getCompileTime() {
		return compileTime;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Version.class).add("status", status).add("cgminer", cgminer).add("api", api).add("miner", miner)
				.add("compileTime", compileTime).add("type", type).toString();
	}

}
