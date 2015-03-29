package com.viosng.asterix.db.adapter.thrift; /**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

import org.apache.thrift.TEnum;

public enum AttrValType implements TEnum {
  STR(1),
  DBL(2),
  LNG(3);

  private final int value;

  private AttrValType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static AttrValType findByValue(int value) { 
    switch (value) {
      case 1:
        return STR;
      case 2:
        return DBL;
      case 3:
        return LNG;
      default:
        return null;
    }
  }
}
