// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Ejector extends SubsystemBase {
  SparkMax ejectorMotor;
  /** Creates a new ExampleSubsystem. */
  public Ejector() {
     ejectorMotor = new SparkMax(5, SparkLowLevel.MotorType.kBrushed);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command runEjector() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return run(
        () -> {
          ejectorMotor.setVoltage (8);
          /* one-time action goes here */
        });
  }
  public Command stopEjector() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return run(
        () -> {
          ejectorMotor.setVoltage (0);
          /* one-time action goes here */
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
