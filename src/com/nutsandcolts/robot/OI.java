package com.nutsandcolts.robot;

import com.nutsandcolts.robot.commands.IntakeIdle;
import com.nutsandcolts.robot.commands.IntakePull;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

import com.nutsandcolts.commands.pneumatics.IdleCompressor;
import com.nutsandcolts.commands.pneumatics.RunCompressor;
import com.nutsandcolts.commands.pneumatics.LiftInTake;
import com.nutsandcolts.commands.pneumatics.LowerInTake;
import com.nutsandcolts.commands.pneumatics.StopLift;
import com.nutsandcolts.robot.commands.IntakePush;
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
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
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
    
    public static final int JOYSTICK_PORT = 1;
    private Joystick stick = new Joystick(JOYSTICK_PORT);
    Button b1 = new JoystickButton(stick,1);
    Button b2 = new JoystickButton(stick,2);
    Button b3 = new JoystickButton(stick,3);
    Button b4 = new JoystickButton(stick,4);
    Button b5 = new JoystickButton(stick,5);
    Button b6 = new JoystickButton(stick,6);
    Button b7 = new JoystickButton(stick,7);
    Button b8 = new JoystickButton(stick,8);
    
    public OI() {
        b1.whenPressed(new IntakePull());
        b2.whenPressed(new IntakeIdle());
        b3.whenPressed(new IntakePush());
        
        b4.whenPressed(new LiftInTake());
        b5.whenPressed(new LowerInTake());
        b6.whenPressed(new StopLift());
        
        b7.whenPressed(new RunCompressor());
        b8.whenReleased(new IdleCompressor());
    }
    
    public Joystick getJoystick() {
        return stick;
    }
    
}

