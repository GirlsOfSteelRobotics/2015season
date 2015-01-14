package org.usfirst.frc.team3504.robot.commands;

import org.usfirst.frc.team3504.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LiftDown extends Command{
	Timer down = new Timer();

	public LiftDown() {
		requires(Robot.forklift);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		setTimeout(2);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.forklift.down(-0.5);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		//Stop talons
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}