/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nutsandcolts.robot.subsystems;

import com.nutsandcolts.robot.Preseason2014;
import com.nutsandcolts.robot.RobotMap;
import com.nutsandcolts.robot.commands.IntakeIdle;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Anthony
 */
public class Intake extends Subsystem {

    Victor intake1;
    Victor intake2;
    RobotDrive control;

    public Intake() {
        //intake1 = new Victor(RobotMap.intakeMotor1);
        //intake2 = new Victor(RobotMap.intakeMotor2);
        control = new RobotDrive(RobotMap.intakeMotor1, RobotMap.intakeMotor2);
    }

    public void set(int value) {
        //intake1.set(value);
        //intake2.set(value);
        control.arcadeDrive(value,0);
    }

    public void driveWithJoystick(Joystick stick) {
        control.arcadeDrive(stick.getY(), 0.0);
        Preseason2014.disp(1, "" + stick.getY());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new IntakeIdle());
    }
}
