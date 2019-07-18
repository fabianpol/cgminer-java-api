package org.fablab.miner.api;

import java.util.Objects;

import com.google.common.base.MoreObjects;

public class Miner {

	private String ip;
	private int port;

	public Miner(String ip, int port) {
		this.ip = Objects.requireNonNull(ip);
		this.port = Objects.requireNonNull(port);
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Miner.class).add("ip", ip).add("port", port).toString();
	}

}
