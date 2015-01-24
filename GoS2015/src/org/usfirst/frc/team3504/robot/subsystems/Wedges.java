package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.DriveByJoystick;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @authors Alexa, Corinne, Sarah
 */
public class Wedges extends Subsystem {
    
	private Talon leftTalon;
	private Talon rightTalon;
	private DigitalInput leftLimit;
	private DigitalInput rightLimit;
	
	
	public Wedges () {
	//	leftTalon = new Talon(RobotMap.LEFT_WEDGE_CHANNEL);
	//	rightTalon = new Talon(RobotMap.RIGHT_WEDGE_CHANNEL); 
	//	leftLimit = new DigitalInput(RobotMap.LEFT_WEDGE_LIMIT);
	//	rightLimit = new DigitalInput(RobotMap.RIGHT_WEDGE_LIMIT);
	}
	
	public void moveIn()
	{
		leftTalon.set(.5);
		rightTalon.set(-.5);
	}
	
	public void moveOut()
	{
		leftTalon.set(-.5);
		rightTalon.set(.5);
	}
	
	public void stop()
	{
		leftTalon.stopMotor();
		rightTalon.stopMotor();
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public boolean getLimit()
	{
		return (leftLimit.get() && rightLimit.get());
	}
}
