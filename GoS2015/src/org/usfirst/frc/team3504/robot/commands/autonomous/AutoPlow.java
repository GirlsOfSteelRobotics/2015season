package org.usfirst.frc.team3504.robot.commands.autonomous;

import org.usfirst.frc.team3504.robot.commands.doors.DoorsOut;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *  Authors: Alexa, Corinne, Kyra, Sarah
 */
public class AutoPlow extends CommandGroup {
    
	//collects one container and three totes and takes them to the autozone
	
    public  AutoPlow() {
    	
    	addSequential(new AutoCollector());
    	addSequential(new Lifting()); 
    	addSequential(new AutoFirstPickup());
    	addSequential(new AutoCollector());
    	addSequential(new Lifting());
     	//used to get first can and tote

    	addSequential(new AutoCollector());
    	addSequential(new AutoDriveForward());
    	addSequential(new Lifting()); 
    	//gets middle tote assuming partner cleared second can
    	
    	addSequential(new AutoCollector());
    	addSequential(new AutoDriveForward());
    	addSequential(new Lifting());
    	//gets last tote assuming partner cleared third can  
    	
    	addSequential(new AutoTurnLeft());
    	addParallel(new DoorsOut());
    	addSequential(new Release()); 
    	addSequential(new AutoDriveBackwards());
    	//turn into the autozone to get robot set
        
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
