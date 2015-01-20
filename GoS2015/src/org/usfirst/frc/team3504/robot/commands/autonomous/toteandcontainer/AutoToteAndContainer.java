package org.usfirst.frc.team3504.robot.commands.autonomous.toteandcontainer;

import org.usfirst.frc.team3504.robot.commands.autonomous.Lifting;
import org.usfirst.frc.team3504.robot.commands.autonomous.plow.AutoFirstPickup;
import org.usfirst.frc.team3504.robot.commands.autonomous.plow.AutoSucker;
import org.usfirst.frc.team3504.robot.commands.autonomous.plow.AutoTurnLeft;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Authors: Alexa, Corinne, Sarah
 */
public class AutoToteAndContainer extends CommandGroup {
    
	//collects one tote and one container and takes them to the auto zone 
	
    public  AutoToteAndContainer() {
    	addSequential(new AutoSucker());
    	addSequential(new Lifting()); 
    	addSequential(new AutoFirstPickup());
    	addSequential(new AutoSucker());
    	addSequential(new Lifting());
    	addSequential(new AutoTurnLeft()); 
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
