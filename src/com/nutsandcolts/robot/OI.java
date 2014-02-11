package com.nutsandcolts.robot;

import com.nutsandcolts.commands.pneumatics.IdleCompressor;
import com.nutsandcolts.commands.pneumatics.RunCompressor;
import com.nutsandcolts.commands.pneumatics.LiftInTake;
import com.nutsandcolts.commands.pneumatics.LowerInTake;
import com.nutsandcolts.commands.pneumatics.StopLift;
import com.nutsandcolts.robot.commands.IntakePush;
import com.nutsandcolts.robot.commands.IntakeIdle;
import com.nutsandcolts.robot.commands.IntakePull;
import com.nutsandcolts.robot.commands.FullJaguar;
import com.nutsandcolts.robot.commands.IdleJaguar;
<<<<<<< HEAD

=======
import com.nutsandcolts.robot.commands.ZJaguar;
>>>>>>> Update to only work in positive direction, default to Idle, and run Z when button 7 is pressed.  Also, Displays to screen
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static final int JOYSTICK_PORT = 1;
<<<<<<< HEAD
    private Joystick stick = new Joystick(JOYSTICK_PORT);
    
    Button b1 = new JoystickButton(stick,1);
    Button b2 = new JoystickButton(stick,2);
    Button b3 = new JoystickButton(stick,3);
    Button b4 = new JoystickButton(stick,4);
    Button b5 = new JoystickButton(stick,5);
    Button b6 = new JoystickButton(stick,6);
    Button z  = new JoystickButton(stick,7);
    Button b8 = new JoystickButton(stick,8);
    Button b9 = new JoystickButton(stick,9);
    
    Button fullJag = new JoystickButton(stick,9);
    Button idleJag = new JoystickButton(stick,10);
    
    public OI() {
        b1.whenPressed(new IntakePull());
        b2.whenPressed(new IntakeIdle());
        b3.whenPressed(new IntakePush());
        
        b4.whenPressed(new LiftInTake());
        b5.whenPressed(new LowerInTake());
        b6.whenPressed(new StopLift());
        
        b8.whenPressed(new RunCompressor());
        b9.whenReleased(new IdleCompressor());
        
        fullJag.whileHeld(new FullJaguar());
        idleJag.whileHeld(new IdleJaguar());
        z.whileHeld(new ZJaguar());
    }
    
    public Joystick getJoystick() {
        return stick;
    }
    
}

