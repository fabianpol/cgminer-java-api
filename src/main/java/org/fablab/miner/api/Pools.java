package org.fablab.miner.api;

import com.google.common.base.MoreObjects;
import com.google.gson.annotations.SerializedName;

public class Pools {

	@SerializedName("URL")
	private String url;
	@SerializedName("Status")
	private String status;
	@SerializedName("Priority")
	private Integer priority;
	@SerializedName("Long Poll")
	private String longPoll;
	@SerializedName("Getworks")
	private Integer getworks;
	@SerializedName("Accepted")
	private Integer accepted;
	@SerializedName("Rejected")
	private Integer rejected;
	@SerializedName("Discarded")
	private Integer discarded;
	@SerializedName("Stale")
	private Integer stale;
	@SerializedName("Get Failures")
	private Integer getFailures;
	@SerializedName("Remote Failures")
	private Integer remoteFailures;
	@SerializedName("User")
	private String user;
	@SerializedName("Last Share Time")
	private String lastShareTime;
	@SerializedName("Diff")
	private String diff;
	@SerializedName("Diff1 Shares")
	private Integer diff1Shares;
	@SerializedName("Proxy Type")
	private String proxyType;
	@SerializedName("Proxy")
	private String proxy;
	@SerializedName("Difficulty Accepted")
	private Float diffAccepted;
	@SerializedName("Difficulty Rejected")
	private Float diffRejected;
	@SerializedName("Difficulty Stale")
	private Float diffStale;
	@SerializedName("Last Share Difficulty")
	private Float lastShareDiff;
	@SerializedName("Has Stratum")
	private Boolean hasStratum;
	@SerializedName("Stratum Active")
	private Boolean stratumActive;
	@SerializedName("Stratum URL")
	private String stratumUrl;
	@SerializedName("Has GBT")
	private Boolean hasGbt;
	@SerializedName("Best Share")
	private Long bestShare;

	public String getUrl() {
		return url;
	}

	public String getStatus() {
		return status;
	}

	public Integer getPriority() {
		return priority;
	}

	public String getLongPoll() {
		return longPoll;
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

	public Integer getDiscarded() {
		return discarded;
	}

	public Integer getStale() {
		return stale;
	}

	public Integer getGetFailures() {
		return getFailures;
	}

	public Integer getRemoteFailures() {
		return remoteFailures;
	}

	public String getUser() {
		return user;
	}

	public String getLastShareTime() {
		return lastShareTime;
	}

	public String getDiff() {
		return diff;
	}

	public Integer getDiff1Shares() {
		return diff1Shares;
	}

	public String getProxyType() {
		return proxyType;
	}

	public String getProxy() {
		return proxy;
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

	public Float getLastShareDiff() {
		return lastShareDiff;
	}

	public Boolean getHasStratum() {
		return hasStratum;
	}

	public Boolean getStratumActive() {
		return stratumActive;
	}

	public String getStratumUrl() {
		return stratumUrl;
	}

	public Boolean getHasGbt() {
		return hasGbt;
	}

	public Long getBestShare() {
		return bestShare;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Pools.class).add("URL", url).add("status", status).add("priority", priority)
				.add("Long Poll", longPoll).add("Getworks", getworks).add("Accepted", accepted)
				.add("Rejected", rejected).add("Discarded", discarded).add("stale", stale)
				.add("Get Failures", getFailures).add("Remote Failures", remoteFailures).add("User", user)
				.add("Last Share Time", lastShareTime).add("Diff", diff).add("Diff1 Shares", diff1Shares)
				.add("Proxy Type", proxyType).add("Proxy", proxy).add("Difficulty Accepted", diffAccepted)
				.add("Difficulty Rejected", diffRejected).add("Difficulty Stale", diffStale)
				.add("Last Share Difficulty", lastShareDiff).add("Has Stratum", hasStratum)
				.add("Stratum Active", stratumActive).add("Stratum URL", stratumUrl).add("Has GBT", hasGbt)
				.add("Best Shares", bestShare).toString();
	}

}
