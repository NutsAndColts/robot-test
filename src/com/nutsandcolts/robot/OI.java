package com.nutsandcolts.robot;

import com.nutsandcolts.robot.commands.DriveWithJoystick;
import com.nutsandcolts.robot.commands.IntakeUp;
import com.nutsandcolts.robot.commands.IntakeIdle;
import com.nutsandcolts.robot.commands.IntakeDown;
import com.nutsandcolts.robot.commands.FullJaguar;
import com.nutsandcolts.robot.commands.IdleJaguar;
import com.nutsandcolts.robot.commands.Launch;
import com.nutsandcolts.robot.commands.LaunchStop;
import com.nutsandcolts.robot.commands.ResetGyro;
import com.nutsandcolts.robot.commands.ZJaguar;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static final int JOYSTICK_PORT1 = 1;
    public static final int JOYSTICK_PORT2 = 2;
    private Joystick stick1 = new Joystick(JOYSTICK_PORT1);
    private Joystick stick2 = new Joystick(JOYSTICK_PORT2);
    
    Button resetDriving = new JoystickButton(stick1,10);
    
    Button intakeDown = new JoystickButton(stick2,9);
    Button intakeIdle = new JoystickButton(stick2,10);
    Button intakeUp = new JoystickButton(stick2,11);
    
    Button launchStop = new JoystickButton(stick2,6);
    
    Button launch = new JoystickButton(stick2,1);
    
    Button resetGyro = new JoystickButton(stick2,8);
    Button zJaguar  = new JoystickButton(stick2,7); 
    Button fullJag = new JoystickButton(stick2,2);
    Button idleJag = new JoystickButton(stick2,3);
    
    public OI() {
	resetDriving.whenPressed(new DriveWithJoystick());
        intakeDown.whileHeld(new IntakeDown());
        intakeIdle.whileHeld(new IntakeIdle());
        intakeUp.whileHeld(new IntakeUp());
        
	launchStop.whenPressed(new LaunchStop());
	
	launch.whenPressed(new Launch());
	
	resetGyro.whenPressed(new ResetGyro());
        fullJag.whileHeld(new FullJaguar());
        idleJag.whileHeld(new IdleJaguar());
        zJaguar.whileHeld(new ZJaguar());
    }
    
    public Joystick getJoystick1() {
        return stick1;
    }

    public Joystick getJoystick2() {
        return stick2;
    }
    
}

