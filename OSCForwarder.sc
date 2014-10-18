/*
/// fill in the processing port where you want to have the data:
~oscforwarder = OSCForwarder.new( NetAddr.new( "127.0.0.1", 8000 ) );
// stop forwarding
~oscforwarder.stop;
// start forwarding again
~oscforwarder.start;
*/

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