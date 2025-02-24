// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  TalonSRX LeftFront;
  TalonSRX RightFront;
  TalonSRX LeftBack;
  TalonSRX RightBack;
  /** Creates a new ExampleSubsystem. */
  public Drive() {
    LeftFront = new TalonSRX(4);
    LeftBack = new TalonSRX(2);
    RightFront = new TalonSRX(1);
    RightBack = new TalonSRX(3);

    LeftFront.follow(LeftBack);
    RightFront.follow(RightBack);
    }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command tankDrive(DoubleSupplier LeftPower, DoubleSupplier RightPower) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return run(
        () -> {
          LeftBack.set(TalonSRXControlMode.PercentOutput, -LeftPower.getAsDouble());
          RightBack.set(TalonSRXControlMode.PercentOutput, RightPower.getAsDouble());
        });
  }
  public Command tankDrive(Double LeftPower, Double RightPower) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return run(
        () -> {
          LeftBack.set(TalonSRXControlMode.PercentOutput, -LeftPower);
          RightBack.set(TalonSRXControlMode.PercentOutput, RightPower);
        });
  }
  
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
