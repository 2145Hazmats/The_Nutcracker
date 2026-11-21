// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  public SparkMax leftMotor = new SparkMax(Constants.DriveConstants.LEFT_MOTOR_ID, MotorType.kBrushless);
  public SparkMax rightMotor = new SparkMax(Constants.DriveConstants.RIGHT_MOTOR_ID, MotorType.kBrushless);
  public SparkMaxConfig config = new SparkMaxConfig();
  private final DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);
  private RelativeEncoder leftEncoder = leftMotor.getEncoder();
  private RelativeEncoder rightEncoder = rightMotor.getEncoder();

  private final ADIS16470_IMU gyro = new ADIS16470_IMU();
  /** Creates a new Drive. */
  public Drive() {
    resetEncoders();
    config.inverted(true);
    leftMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    config.inverted(false);
    rightMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void ArcadeDrive(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }

  public void TankDrive(double left, double right){
    leftMotor.set(left);
    rightMotor.set(right);

  }

  public void resetEncoders() {
      leftEncoder.setPosition(0);
      rightEncoder.setPosition(0);
    }

  public void stop() {
    drive.arcadeDrive(0, 0);
  }

  public void resetgyro() {
    gyro.reset();
  }

  public double getHeading() {
    return new Rotation2d(Units.degreesToRadians(gyro.getAngle())).getDegrees();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
