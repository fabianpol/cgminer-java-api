[![Build Status](https://travis-ci.org/fabianpol/cgminer-java-api.svg?branch=master)](https://travis-ci.org/fabianpol/cgminer-java-api)
[![codecov](https://codecov.io/gh/fabianpol/cgminer-java-api/branch/master/graph/badge.svg)](https://codecov.io/gh/fabianpol/cgminer-java-api/branch/master)

# cgminer-java-api

## API Documentation

The library allows to run commands like: **version()**, **summary()**, **stats()**, **restart()**, **pools()**.
All of these methods were tested against: *cgminer=4.9.0, api=3.1, miner=1.0.1.3.*
In order to make restart() work, you should modify default permissions for the miner (https://github.com/ckolivas/cgminer/blob/master/API-README)



## Example usage

    public class Main {

		public static void main(String[] args) {
		
			CGMiner api = CGMinerFactory.create();
			Miner miner = new Miner("192.168.0.5", 4028);
			
			Version version = api.version(miner);
			System.out.println(version.getCgminer());
			
			Summary summary = api.summary(miner);
			System.out.println(summary.getTotalMH());
			
			List<Pool> pools = api.pools(miner);
			System.out.println(pools.get(0).getUrl());
			
			Stats stats = api.stats(miner);
			System.out.println(stats.getGhs5s());
			
			// Requires 'restart' permission
			UpdateStatus restartStatus = api.restart(miner);
			System.out.println(restartStatus.getDescription());
		}
	}
	
	
