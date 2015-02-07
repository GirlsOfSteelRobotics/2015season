package org.usfirst.frc.team3504.robot.commands.autonomous.plow;

import org.usfirst.frc.team3504.robot.Robot;
import org.usfirst.frc.team3504.robot.commands.ReleaseTote;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Author: Alexa, Corinne, Kyra, Sarah
 */
public class AutoDriveForward extends Command {
	
	double initialVal;

    public AutoDriveForward() {
       requires(Robot.chassis);
       
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {   	
    	initialVal = Robot.chassis.getFrontLeftEncoderDistance();
    	//Robot.chassis.resetEncoders();
    	//setTimeout(2.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.autoDriveForward(.75);// what is the speed, .5 is guestimate, speed is between 0 and 1
    	
    	SmartDashboard.putNumber("Drive Front Left Encoder ", Robot.chassis.getFrontLeftEncoderRate());
		SmartDashboard.putNumber("Drive Front Right Encoder ", Robot.chassis.getFrontRightEncoderRate());
		SmartDashboard.putNumber("Drive Rear Left Encoder ", Robot.chassis.getRearLeftEncoderRate());
		SmartDashboard.putNumber("Drive Rear Right Encoder ", Robot.chassis.getRearRightEncoderRate());
		
    	SmartDashboard.putNumber("Drive Front Left Encoder Distance ", Robot.chassis.getFrontLeftEncoderDistance());
		SmartDashboard.putNumber("Drive Front Right Encoder Distance ", Robot.chassis.getFrontRightEncoderDistance());
		SmartDashboard.putNumber("Drive Rear Left Encoder Distance ", Robot.chassis.getRearLeftEncoderDistance());
		SmartDashboard.putNumber("Drive Rear Right Encoder Distance ", Robot.chassis.getRearRightEncoderDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//return isTimedOut();
    	
    	if (Math.abs(Math.abs(Robot.chassis.getFrontLeftEncoderDistance())-Math.abs(initialVal)) > 6000) //Tote/Container Distances:
																//	Tote+Container(in): 26.9+18=44.9
																//	Tote(in): 26.9
																//	Distance Between w/o Container(in): 18+35.75=53.75
    		return true;
    	else 
    		return false;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
