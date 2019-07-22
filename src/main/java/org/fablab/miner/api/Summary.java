package org.fablab.miner.api;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class Summary {

	@SerializedName("Elapsed")
	private Integer elapsed;
	@SerializedName("GHS 5s")
	private Float ghs5s;
	@SerializedName("GHS av")
	private Float mhsav;
	@SerializedName("Found Blocks")
	private int foundBlocks;
	@SerializedName("Getworks")
	private Integer getworks;
	@SerializedName("Accepted")
	private Integer accepted;
	@SerializedName("Rejected")
	private Integer rejected;
	@SerializedName("Hardware Errors")
	private Integer hwErrors;
	@SerializedName("Utility")
	private Float utility;
	@SerializedName("Discarded")
	private Integer discarded;
	@SerializedName("Stale")
	private Integer stale;
	@SerializedName("Get Failures")
	private Integer getFailures;
	@SerializedName("Local Work")
	private Integer localWork;
	@SerializedName("Remote Failures")
	private Integer remoteFailures;
	@SerializedName("Network Blocks")
	private Integer networkBlocks;
	@SerializedName("Total MH")
	private Float totalMH;
	@SerializedName("Work Utility")
	private Float workUtility;
	@SerializedName("Difficulty Accepted")
	private Float diffAccepted;
	@SerializedName("Difficulty Rejected")
	private Float diffRejected;
	@SerializedName("Difficulty Stale")
	private Float diffStale;
	@SerializedName("Best Share")
	private Long bestShare;

	public Integer getElapsed() {
		return elapsed;
	}

	public Integer getFoundBlocks() {
		return foundBlocks;
	}

	public Integer getGetworks() {
		return getworks;
	}

	public Integer getAccepted() {
		return accepted;
	}

	public Integer getRejected() {
		return rejected;
	}

	public Integer getHwErrors() {
		return hwErrors;
	}

	public Float getUtility() {
		return utility;
	}

	public Integer getDiscarded() {
		return discarded;
	}

	public Integer getStale() {
		return stale;
	}

	public Integer getGetFailures() {
		return getFailures;
	}

	public Integer getLocalWork() {
		return localWork;
	}

	public Integer getRemoteFailures() {
		return remoteFailures;
	}

	public Integer getNetworkBlocks() {
		return networkBlocks;
	}

	public Float getTotalMH() {
		return totalMH;
	}

	public Float getWorkUtility() {
		return workUtility;
	}

	public Float getDiffAccepted() {
		return diffAccepted;
	}

	public Float getDiffRejected() {
		return diffRejected;
	}

	public Float getDiffStale() {
		return diffStale;
	}

	public Long getBestShare() {
		return bestShare;
	}

	public Float getGhs5s() {
		return ghs5s;
	}

	public Float getMhsav() {
		return mhsav;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Summary.class).add("elapsed", elapsed).add("GHS 5s", ghs5s)
				.add("GHS av", mhsav).add("Found Blocks", foundBlocks).add("Found Blocks", foundBlocks)
				.add("Getworks", getworks).add("Accepted", accepted).add("Rejected", rejected)
				.add("Hardware Errors", hwErrors).add("Utility", utility).add("Discarded", discarded)
				.add("Stale", stale).add("Get Failures", getFailures).add("Local Work", localWork)
				.add("Remote Failures", remoteFailures).add("Network Blocks", networkBlocks).add("Total MH", totalMH)
				.add("Work Utility", workUtility).add("Difficulty Accepted", diffAccepted)
				.add("Difficulty Rejected", diffRejected).add("Difficulty Stale", diffStale)
				.add("Best Share", bestShare).toString();
	}

}
