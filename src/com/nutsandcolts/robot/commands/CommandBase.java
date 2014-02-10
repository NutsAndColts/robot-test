package com.nutsandcolts.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.nutsandcolts.robot.OI;
import com.nutsandcolts.robot.subsystems.Drive;

import com.nutsandcolts.robot.subsystems.Intake;
import com.nutsandcolts.robot.subsystems.Compress;
import com.nutsandcolts.robot.subsystems.Pneumatics;
import com.nutsandcolts.robot.subsystems.JagTester;

public abstract class CommandBase extends Command {

    public static OI oi;
    public static Drive drive = new Drive();
    public static Intake intake = new Intake();    
    public static Pneumatics pneumatics = new Pneumatics();
    public static Compress compressor = new Compress();
    public static JagTester jagTester = new JagTester();

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
