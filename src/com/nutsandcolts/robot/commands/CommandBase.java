package com.nutsandcolts.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.nutsandcolts.robot.OI;
import com.nutsandcolts.robot.subsystems.DriveTrain;
import com.nutsandcolts.robot.subsystems.Intake;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DriveTrain driveTrain = new DriveTrain();
    public static Intake intake = new Intake();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
