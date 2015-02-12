package org.usfirst.frc.team3504.robot;

import org.usfirst.frc.team3504.robot.commands.autonomous.AutoCollector;
import org.usfirst.frc.team3504.robot.commands.autonomous.AutoDriveForward;
import org.usfirst.frc.team3504.robot.commands.autonomous.AutoFirstPickup;
import org.usfirst.frc.team3504.robot.commands.autonomous.AutoTurnLeft;
import org.usfirst.frc.team3504.robot.commands.camera.CameraSwitch;
import org.usfirst.frc.team3504.robot.commands.collector.AngleCollectorIn;
import org.usfirst.frc.team3504.robot.commands.collector.AngleCollectorOut;
import org.usfirst.frc.team3504.robot.commands.collector.CollectTote;
import org.usfirst.frc.team3504.robot.commands.collector.ReleaseTote;
import org.usfirst.frc.team3504.robot.commands.doors.DoorsIn;
import org.usfirst.frc.team3504.robot.commands.doors.DoorsOut;
import org.usfirst.frc.team3504.robot.commands.drive.DriveBackward;
import org.usfirst.frc.team3504.robot.commands.drive.DriveForward;
import org.usfirst.frc.team3504.robot.commands.drive.DriveLeft;
import org.usfirst.frc.team3504.robot.commands.drive.DriveRight;
import org.usfirst.frc.team3504.robot.commands.drive.GetGyro;
import org.usfirst.frc.team3504.robot.commands.drive.ResetGyro;
import org.usfirst.frc.team3504.robot.commands.fingers.FingerDown;
import org.usfirst.frc.team3504.robot.commands.fingers.FingerUp;
import org.usfirst.frc.team3504.robot.commands.lifter.LiftDown;
import org.usfirst.frc.team3504.robot.commands.lifter.LiftUp;
import org.usfirst.frc.team3504.robot.commands.shack.ShackIn;
import org.usfirst.frc.team3504.robot.commands.shack.ShackOut;
import org.usfirst.frc.team3504.robot.commands.tests.TestPhotoSensor;
import org.usfirst.frc.team3504.robot.commands.tests.TestUltrasonic;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	private Joystick operatorJoystick;
	private Joystick chassisJoystick;

	//Collector
	private JoystickButton collectTote;
	private JoystickButton releaseTote;
	private JoystickButton angleIn;
	private JoystickButton angleOut;
		
	//Finger
	private JoystickButton fingersDown;
	private JoystickButton fingersUp;
		
	//Lifting
	private JoystickButton liftUp;
	private JoystickButton liftDown; 
		
	//Doors
	private JoystickButton doorsOpen;
	private JoystickButton doorsClose;
	
	//Auto Buttons
	private JoystickButton autoDriveForward;
	private JoystickButton autoDriveForwardUltra;
	private JoystickButton autoFirstPickup;
	private JoystickButton autoInterval;
	private JoystickButton autoLiftUp;
	private JoystickButton autoPlow;
	private JoystickButton autoCollector;
	private JoystickButton autoTurnLeft;
	private JoystickButton autoTurnLeftTimer;
	
	//Drive Buttons
	private JoystickButton driveForward;
	private JoystickButton driveBackward;
	private JoystickButton driveRight;
	private JoystickButton driveLeft;
	
	//Shack Buttons
	private JoystickButton shackIn;
	private JoystickButton shackOut;
	
	
	//Sucker buttons
	private JoystickButton collectIn;
	private JoystickButton pushOut;
	private JoystickButton stopCollection;
	private JoystickButton stopCollectorAngle;
	private JoystickButton doorIn;
	private JoystickButton doorOut;
	
	//Ultrasonic buttons
	private JoystickButton getDistance;
	
	//Camera buttons
	private JoystickButton switchCamera;
	
	// Gyro Button
	private JoystickButton resetGyro;
	private JoystickButton getGyro;
	
	//photosensor button
	private JoystickButton testPSensor;
	
	public OI()
	{
		operatorJoystick = new Joystick(RobotMap.OPERATOR_JOYSTICK);
		chassisJoystick = new Joystick(RobotMap.CHASSIS_JOYSTICK);
				
		//Collectors
		collectTote = new JoystickButton(operatorJoystick, 1);
		collectTote.whileHeld(new CollectTote());
		releaseTote = new JoystickButton(operatorJoystick, 2);
		releaseTote.whileHeld(new ReleaseTote());
		angleIn = new JoystickButton(operatorJoystick, 3);
		angleIn.whenPressed(new AngleCollectorIn());
		angleOut = new JoystickButton(operatorJoystick, 4);
		angleOut.whenPressed(new AngleCollectorOut());
				
		//Fingers
		fingersDown = new JoystickButton(operatorJoystick, 5);
		fingersDown.whenPressed(new FingerDown());
		fingersUp = new JoystickButton(operatorJoystick, 10);
		fingersUp.whenPressed(new FingerUp());
		
		//Shack
		shackIn = new JoystickButton(operatorJoystick, 6);
		shackIn.whileHeld(new ShackIn());
		shackOut = new JoystickButton(operatorJoystick, 7);
		shackOut.whileHeld(new ShackOut());
				
		//Lifting
		liftUp = new JoystickButton(operatorJoystick, 8);
		liftUp.whileHeld(new LiftUp());
		liftDown = new JoystickButton(operatorJoystick, 9);
		liftDown.whileHeld(new LiftDown());
				
		//Doors
		doorsOpen = new JoystickButton(operatorJoystick, 10);
		doorsOpen.whenPressed(new DoorsOut());
		doorsClose = new JoystickButton(operatorJoystick, 11);
		doorsClose.whenPressed(new DoorsIn());
		
		//Drive buttons initialization
		driveForward = new JoystickButton(chassisJoystick, 5);
		driveForward.whileHeld(new DriveForward());
		driveBackward = new JoystickButton(chassisJoystick, 6);
		driveBackward.whileHeld(new DriveBackward());
		driveRight = new JoystickButton(chassisJoystick, 4);
		driveRight.whileHeld(new DriveRight());
		driveLeft = new JoystickButton(chassisJoystick, 3);
		driveLeft.whileHeld(new DriveLeft());
		
		//Gyro Button initialization
		resetGyro = new JoystickButton(chassisJoystick, 1);
		resetGyro.whenPressed(new ResetGyro());
		getGyro = new JoystickButton(chassisJoystick, 12);
		getGyro.whenPressed(new GetGyro());
		
		/**
		//Ultrasonic buttons initialization
		getDistance = new JoystickButton(chassisJoystick, 13);
		getDistance.whenPressed(new TestUltrasonic());
	
		//Autonomous
		autoDriveForward = new JoystickButton(chassisJoystick, 9);
		autoFirstPickup = new JoystickButton(chassisJoystick, 10);
		autoCollector = new JoystickButton(chassisJoystick, 11);
		autoTurnLeft = new JoystickButton(chassisJoystick, 8);
		
		autoDriveForward.whenPressed(new AutoDriveForward());
		autoFirstPickup.whenPressed(new AutoFirstPickup());
		autoCollector.whenPressed(new AutoCollector()); 
		autoTurnLeft.whenPressed(new AutoTurnLeft());
		
		//Camera buttons initialization	
		switchCamera = new JoystickButton(chassisJoystick, 2);
		switchCamera.whenPressed (new CameraSwitch());
		
		//Photosensor Buttons
		testPSensor = new JoystickButton(chassisJoystick, 7);
		testPSensor.whenPressed(new TestPhotoSensor());
		**/
	}
	
	public Joystick getOperatorJoystick()
	{
		return operatorJoystick;
	}
	
	public Joystick getChassisJoystick()
	{
		return chassisJoystick;
	}
}

