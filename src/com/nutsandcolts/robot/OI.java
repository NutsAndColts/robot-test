package com.nutsandcolts.robot;

import com.nutsandcolts.robot.commands.IntakePush;
import com.nutsandcolts.robot.commands.IntakeIdle;
import com.nutsandcolts.robot.commands.IntakePull;
import com.nutsandcolts.robot.commands.FullJaguar;
import com.nutsandcolts.robot.commands.IdleJaguar;
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
    
    Button intakePull = new JoystickButton(stick1,9);
    Button intakeIdle = new JoystickButton(stick1,10);
    Button intakePush = new JoystickButton(stick1,11);
    
    Button zJaguar  = new JoystickButton(stick1,7); 
    Button fullJag = new JoystickButton(stick1,3);
    Button idleJag = new JoystickButton(stick1,2);
    
    public OI() {
        intakePull.whenPressed(new IntakePull());
        intakeIdle.whenPressed(new IntakeIdle());
        intakePush.whenPressed(new IntakePush());
        
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

