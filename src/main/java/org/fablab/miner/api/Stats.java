package org.fablab.miner.api;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class Stats extends ResponseWithStatus {

	@SerializedName("ID")
	private String id;
	@SerializedName("Elapsed")
	private Long elapsed;
	@SerializedName("Calls")
	private Integer calls;
	@SerializedName("Wait")
	private Double wait;
	@SerializedName("Max")
	private Double max;
	@SerializedName("Min")
	private Double min;
	@SerializedName("GHS 5s")
	private Double ghs5s;
	@SerializedName("GHS av")
	private Double ghsAv;
	@SerializedName("miner_count")
	private Integer minerCount;
	@SerializedName("frequency")
	private Integer frequency;
	@SerializedName("fan_num")
	private Integer fanNum;
	@SerializedName("temp_num")
	private Integer tempNum;
	@SerializedName("temp_max")
	private Integer tempMax;

	public String getId() {
		return id;
	}

	public Long getElapsed() {
		return elapsed;
	}

	public Integer getCalls() {
		return calls;
	}

	public Double getWait() {
		return wait;
	}

	public Double getMax() {
		return max;
	}

	public Double getMin() {
		return min;
	}

	public Double getGhs5s() {
		return ghs5s;
	}

	public Double getGhsAv() {
		return ghsAv;
	}

	public Integer getMinerCount() {
		return minerCount;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public Integer getFanNum() {
		return fanNum;
	}

	public Integer getTempNum() {
		return tempNum;
	}

	public Integer getTempMax() {
		return tempMax;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Stats.class).add("status", status).add("id", id).add("elapsed", elapsed).add("calls", calls)
				.add("wait", wait).add("max", max).add("min", min).add("ghs 5s", ghs5s).add("ghs av", ghsAv)
				.add("miner_count", minerCount).add("frequency", frequency).add("fan_num", fanNum)
				.add("temp_num", tempNum).add("temp_max", tempMax).toString();
	}

}
