package com.nutsandcolts.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //PWM
    public static final int leftMotor = 1;
    public static final int rightMotor = 2;
    public static final int intakeMotor = 3;
    
    //Solenoids
    public static final int solenoidForward = 1;
    public static final int solenoidReverse = 2;
    
    //Relays
    public static final int compressorSpike = 1;
    public static final int stopper = 2;
    
    //Digital IO
    public static final int compressorSwitch = 1;
}
