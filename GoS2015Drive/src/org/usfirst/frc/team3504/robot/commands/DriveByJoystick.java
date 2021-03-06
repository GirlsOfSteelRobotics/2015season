package org.usfirst.frc.team3504.robot.commands;
import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Sonia
 */
public class DriveByJoystick extends Command {

	Joystick chassisJoystick;
	
    public DriveByJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	chassisJoystick = Robot.oi.getChassisJoystick();
    	
    	SmartDashboard.putNumber("Right Rear Encoder", Robot.chassis.getRightBackEncoderRate());
    	SmartDashboard.putNumber("Right Front Encoder", Robot.chassis.getRightFrontEncoderRate());
    	SmartDashboard.putNumber("Left Rear Encoder", Robot.chassis.getLeftBackEncoderRate());
    	SmartDashboard.putNumber("Left Front Encoder", Robot.chassis.getLeftFrontEncoderRate());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.moveByJoystick(chassisJoystick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}