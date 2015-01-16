package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;
import org.usfirst.frc.team3504.robot.commands.DriveByJoystick;
import org.usfirst.frc.team3504.robot.lib.PIDSpeedController;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Sonia
 */
public class Chassis extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private RobotDrive gosDrive;
	private Gyro robotGyro;
 
    private Encoder frontLeftEncoder;
    private Encoder rearLeftEncoder;
    private Encoder frontRightEncoder;
    private Encoder rearRightEncoder;
    
    double Kp;
    double Ki;
    double Kd;
	
	public Chassis()
	{
		Kp = .0001;//SmartDashboard.getNumber("p value");
	    Ki = .0000001;//SmartDashboard.getNumber("i value");
	    Kd = .0000001;//SmartDashboard.getNumber("d value");
		
		frontLeftEncoder = new Encoder(RobotMap.FRONT_LEFT_WHEEL_ENCODER_A, RobotMap.FRONT_LEFT_WHEEL_ENCODER_B);
    	rearLeftEncoder = new Encoder(RobotMap.REAR_LEFT_WHEEL_ENCODER_A, RobotMap.REAR_LEFT_WHEEL_ENCODER_B);
    	frontRightEncoder = new Encoder(RobotMap.FRONT_RIGHT_WHEEL_ENCODER_A, RobotMap.FRONT_RIGHT_WHEEL_ENCODER_B);
    	rearRightEncoder = new Encoder(RobotMap.REAR_RIGHT_WHEEL_ENCODER_A, RobotMap.REAR_RIGHT_WHEEL_ENCODER_B);
		
    	frontLeftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
    	rearLeftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
    	frontRightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
    	rearRightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
    	
       // gosDrive = new RobotDrive(RobotMap.FRONT_LEFT_CHANNEL, RobotMap.REAR_LEFT_CHANNEL,
        						//	RobotMap.FRONT_RIGHT_CHANNEL, RobotMap.REAR_RIGHT_CHANNEL);
        gosDrive = new RobotDrive(new PIDSpeedController(new Talon(RobotMap.FRONT_LEFT_WHEEL_CHANNEL), Kp, Ki, Kd, frontLeftEncoder), 
        							new PIDSpeedController(new Talon(RobotMap.REAR_LEFT_WHEEL_CHANNEL), Kp, Ki, Kd, rearLeftEncoder), 
        							new PIDSpeedController(new Talon(RobotMap.FRONT_RIGHT_WHEEL_CHANNEL), Kp, Ki, Kd, frontRightEncoder),
        							new PIDSpeedController(new Talon(RobotMap.REAR_RIGHT_WHEEL_CHANNEL), Kp, Ki, Kd, rearRightEncoder));
        gosDrive.setInvertedMotor(MotorType.kFrontRight, true);	// invert the left side motors
    	gosDrive.setInvertedMotor(MotorType.kRearRight, true);		// may need to change or remove this to match robot
    	gosDrive.setExpiration(0.1);
    	gosDrive.setSafetyEnabled(true);
    	
    	
    	
        robotGyro = new Gyro(RobotMap.GYRO_PORT);
	}
	
	public double twistDeadZone(double rawVal)
	{
		if(Math.abs(rawVal) > .9)
			return rawVal/5;
		else
			return 0.0;
	}
	
	public void moveByJoystick(Joystick stick)
	{
		//if(stick.getMagnitude() > 0.02)
		gosDrive.mecanumDrive_Polar(stick.getMagnitude() * ((stick.getThrottle() + 1) / 2), stick.getDirectionDegrees(), stick.getTwist());
		//gosDrive.mecanumDrive_Cartesian(stick.getX(), stick.getY(), twistDeadZone(stick.getTwist()), 0);//robotGyro.getAngle());
		
	}
	
	public void driveForward(Joystick stick)
	{
		gosDrive.mecanumDrive_Cartesian(0, -((stick.getThrottle() + 1) / 2), 0, 0); //-.5
	}

	public void driveBackward(Joystick stick)
	{
		gosDrive.mecanumDrive_Cartesian(0, ((stick.getThrottle() + 1) / 2), 0, 0); //.5
	}
	
	public void driveRight(Joystick stick)
	{
		gosDrive.mecanumDrive_Cartesian(((stick.getThrottle() + 1) / 2), 0, 0, 0); //.5
	}
	
	public void driveLeft(Joystick stick)
	{
		gosDrive.mecanumDrive_Cartesian(-((stick.getThrottle() + 1) / 2), 0, 0,0); //.-5
		
	}
	
	public void driveInCircle()
	{
		gosDrive.mecanumDrive_Cartesian(75, 25, 0, robotGyro.getAngle()); //May be equal -> change x and y vals
	}
	
	public void stop()
	{
		gosDrive.stopMotor();
	}
	
	public double getGyroAngle()
	{
		return robotGyro.getAngle();
	}
	
	public double getFrontLeftEncoderRate()
	{
		return frontLeftEncoder.getRate();
	}
	
	public double getFrontLeftEncoderDistance(){
		return frontLeftEncoder.getDistance();
	}
	
	public double getRearLeftEncoderRate()
	{
		return rearLeftEncoder.getRate();
	}
	
	public double getRearLeftEncoderDistance(){
		return rearLeftEncoder.getDistance();
	}
	
	public double getFrontRightEncoderRate()
	{
		return frontRightEncoder.getRate();
	}
	
	public double getFrontRightEncoderDistance(){
		return frontRightEncoder.getDistance();
	}
	
	public double getRearRightEncoderRate()
	{
		return rearRightEncoder.getRate();
	}
	
	public double getRearRightEncoderDistance(){
		return rearRightEncoder.getDistance();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveByJoystick());
    }
}
