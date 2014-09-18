package com.nutsandcolts.robot;

import com.nutsandcolts.robot.commands.DriveWithJoystick;
import com.nutsandcolts.robot.commands.FullJaguar;
import com.nutsandcolts.robot.commands.IdleJaguar;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to he commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static final int JOYSTICK_PORT1 = 1;
    private Joystick stick1 = new Joystick(JOYSTICK_PORT1);
    
    Button resetDriving = new JoystickButton(stick1, 10);
    
    Button fullJag = new JoystickButton(stick1, 2); // Catapault arm (second mode)
    Button idleJag = new JoystickButton(stick1, 3); // Catapault arm idle
    
    public OI() {
	resetDriving.whenPressed(new DriveWithJoystick());

        fullJag.whileHeld(new FullJaguar());
        idleJag.whileHeld(new IdleJaguar());
    }
    
    public Joystick getJoystick1() {
        return stick1;
    }  
}