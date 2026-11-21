// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Arm;


public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(Drive m_Drive, Arm m_Arm) {
    return Commands.run(
      () -> m_Drive.TankDrive(-0.5, -0.5)
      , m_Drive)
    .withTimeout(0.5)
    .andThen(Commands.run(() -> m_Arm.leftArmMethod(1), m_Arm));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
