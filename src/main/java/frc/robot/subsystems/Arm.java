// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  public TalonSRX leftArmMotor1 = new TalonSRX(Constants.ArmConstants.LEFT_ARM_MOTOR_1_ID);
  public TalonSRX leftArmMotor2 = new TalonSRX(Constants.ArmConstants.LEFT_ARM_MOTOR_2_ID);
  public TalonSRX rightArmMotor1 = new TalonSRX(Constants.ArmConstants.RIGHT_ARM_MOTOR_1_ID);
  public TalonSRX rightArmMotor2 = new TalonSRX(Constants.ArmConstants.RIGHT_ARM_MOTOR_2_ID);
  
  /** Creates a new Arm. */
  public Arm() {

  // armMotor.configContinuousCurrentLimit(40); // Hold current in amps after peak triggers
  // armMotor.configPeakCurrentLimit(60); // Peak current threshold in amps
  // armMotor.configPeakCurrentDuration(200); // Time over peak in ms before limiting starts
  // armMotor.enableCurrentLimit(true); // Turn current limiting on
  }
  
  public void leftArmMethod(double speed) {
    leftArmMotor1.set(ControlMode.PercentOutput, speed * 0.5);
    leftArmMotor2.set(ControlMode.PercentOutput, speed * 0.5);
  }

  public void rightArmMethod(double speed) {
    rightArmMotor1.set(ControlMode.PercentOutput, speed * 0.5);
    rightArmMotor2.set(ControlMode.PercentOutput, speed * 0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
