package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shack extends Subsystem {

	private DoubleSolenoid shack;
	
	public Shack() {
		shack = new DoubleSolenoid(RobotMap.LEFT_SHACK_MODULE, RobotMap.LEFT_SHACK_CHANNEL_A, RobotMap.LEFT_SHACK_CHANNEL_B);
	}

	public void ShackIn() {
		shack.set(DoubleSolenoid.Value.kForward);
	}

	public void ShackOut() {
		shack.set(DoubleSolenoid.Value.kReverse);
	}

	@Override
	protected void initDefaultCommand() {
	}

}