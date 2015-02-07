
package org.usfirst.frc.team3504.robot;

import org.usfirst.frc.team3504.robot.commands.ExampleCommand;
import org.usfirst.frc.team3504.robot.commands.autonomous.plow.AutoDriveForward;
import org.usfirst.frc.team3504.robot.subsystems.Camera;
import org.usfirst.frc.team3504.robot.subsystems.Chassis;
import org.usfirst.frc.team3504.robot.subsystems.Collector;
import org.usfirst.frc.team3504.robot.subsystems.Doors;
import org.usfirst.frc.team3504.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3504.robot.subsystems.Fingers;
import org.usfirst.frc.team3504.robot.subsystems.Lifter;
import org.usfirst.frc.team3504.robot.subsystems.PhotoSensor;
import org.usfirst.frc.team3504.robot.subsystems.Pusher;
import org.usfirst.frc.team3504.robot.subsystems.Shack;
import org.usfirst.frc.team3504.robot.subsystems.UltrasonicSensor;
import org.usfirst.frc.team3504.robot.subsystems.Grippers;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static ExampleSubsystem exampleSubsystem; //Need to remove eventually
	public static Chassis chassis;
	public static Camera camera;
	public static Collector collector;
	public static Fingers fingers;
	public static Grippers gripper;
	public static Lifter forklift;
	public static Doors doors;
	public static UltrasonicSensor ultrasonicsensor; 
	public static Pusher pusher;
	public static OI oi;
	public static PhotoSensor photosensor;
	public static Shack shack; 
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//RobotMap.init();
		exampleSubsystem = new ExampleSubsystem();
		chassis = new Chassis();
		camera = new Camera();
		collector = new Collector();
		fingers = new Fingers();
		gripper = new Grippers(); 
		forklift = new Lifter();
		doors = new Doors();
		ultrasonicsensor = new UltrasonicSensor();
		pusher = new Pusher();
		photosensor = new PhotoSensor();
		shack = new Shack(); 
		Robot.chassis.resetGyro();
        autonomousCommand = new AutoDriveForward();
        
        oi = new OI();
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
}
