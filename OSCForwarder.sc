OSCForwarder {

	var <>address;

	var oscFwdFunc;

	*new{ |addr|
		^super.new.init( addr );
	}

	init{ |addr|
		address = addr;
		oscFwdFunc = { |msg, time|
			address.sendMsg( *msg );
		};
		this.start;
	}

	start{
		thisProcess.addOSCRecvFunc( oscFwdFunc );
	}

	stop{
		thisProcess.removeOSCRecvFunc( oscFwdFunc );
	}



}