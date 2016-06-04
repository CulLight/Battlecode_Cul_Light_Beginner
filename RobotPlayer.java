// Ideas
// Before Robot dies, pass over supply, otherwise this is destroyed with him.

package Cul_Light_BeginnerStar;


import battlecode.common.*;

public class RobotPlayer {
	public static void run(RobotController rc) {		
		
		RobotType thisRobotType = rc.getType();
		
		while (true) { //this loop must run for ever for the robot not to die
			switch (thisRobotType){
				case HQ:
					run_HQ(rc);
					break;
				case BEAVER:
					run_BEAVER(rc);
					break;
			default:	
				try {
					throw new Exception("Unknown robot type!!! :(");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	private static void run_BEAVER(RobotController rc) {
		if (rc.isCoreReady())
			if (rc.canMove(Direction.NORTH))
				try {
					rc.move(Direction.NORTH);
				} catch (GameActionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		rc.yield();		
	}


	private static void run_HQ(RobotController rc) {
		if (rc.isCoreReady() && rc.getTeamOre() > 100)
			if (rc.canSpawn(Direction.NORTH, RobotType.BEAVER))
				try {
					rc.spawn(Direction.NORTH, RobotType.BEAVER);
				} catch (GameActionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		rc.yield();
	}
}