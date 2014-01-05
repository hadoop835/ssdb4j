package org.nutz.ssdb.replication;

import org.nutz.ssdb.spi.Cmd;
import org.nutz.ssdb.spi.Respose;
import org.nutz.ssdb.spi.SSDBStream;

public class ReplicationSSDMStream implements SSDBStream {

	protected SSDBStream master;
	
	protected SSDBStream slave;
	
	public ReplicationSSDMStream(SSDBStream master, SSDBStream slave) {
		this.master = master;
		this.slave = slave;
	}

	public Respose req(Cmd cmd, byte[]... vals) {
		if (cmd.isSlave())
			return slave.req(cmd, vals);
		return master.req(cmd, vals);
	}

	@Override
	public SSDBStream doClone() {
		return null;
	}

}