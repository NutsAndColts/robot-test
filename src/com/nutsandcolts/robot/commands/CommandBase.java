package com.nutsandcolts.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import com.nutsandcolts.robot.OI;
import com.nutsandcolts.robot.subsystems.Drive;
import com.nutsandcolts.robot.subsystems.Intake;
import com.nutsandcolts.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public static Drive drive = new Drive();
    public static Intake intake = new Intake();    
    public static Pneumatics pneumatics = new Pneumatics();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        SmartDashboard.putData(pneumatics);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
