package org.usfirst.frc.team3504.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//Joystick ports -> should align with driver station
	public static final int OPERATOR_JOYSTICK = 1;
	public static final int CHASSIS_JOYSTICK = 0;
	
	//Drive ports
	public static final int FRONT_LEFT_WHEEL_CHANNEL = 0; //Motors
    public static final int REAR_LEFT_WHEEL_CHANNEL	= 1;
    public static final int FRONT_RIGHT_WHEEL_CHANNEL = 3;
    public static final int REAR_RIGHT_WHEEL_CHANNEL = 2;
    public static final int GYRO_PORT = 0; //Gyro
    public static final int FRONT_LEFT_WHEEL_ENCODER_A = 6; //Encoders
    public static final int FRONT_LEFT_WHEEL_ENCODER_B = 7;
    public static final int REAR_LEFT_WHEEL_ENCODER_A = 4;
    public static final int REAR_LEFT_WHEEL_ENCODER_B = 5;
    public static final int FRONT_RIGHT_WHEEL_ENCODER_A = 0;
    public static final int FRONT_RIGHT_WHEEL_ENCODER_B = 1;
    public static final int REAR_RIGHT_WHEEL_ENCODER_A = 2;
    public static final int REAR_RIGHT_WHEEL_ENCODER_B = 3;
    
    //Forklift ports
    public static final int FORKLIFT_CHANNEL = 1;
    
    //Claw ports
    public static final int LEFT_CLAW_CHANNEL = 0; //Motors
    public static final int RIGHT_CLAW_CHANNEL = 1;
    

    //Sucker ports
    public static final int RIGHT_SUCKER_WHEEL = 0; //Motors
    public static final int LEFT_SUCKER_WHEEL = 1;
    public static final int RIGHT_SUCKER_ANGLE_WHEEL = 2;
    public static final int LEFT_SUCKER_ANGLE_WHEEL = 3;
}
