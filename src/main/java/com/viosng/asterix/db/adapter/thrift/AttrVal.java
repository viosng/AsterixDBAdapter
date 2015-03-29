package com.viosng.asterix.db.adapter.thrift; /**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import javax.annotation.Generated;
import java.util.*;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-3-29")
public class AttrVal implements org.apache.thrift.TBase<AttrVal, AttrVal._Fields>, java.io.Serializable, Cloneable, Comparable<AttrVal> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AttrVal");

  private static final org.apache.thrift.protocol.TField SV_FIELD_DESC = new org.apache.thrift.protocol.TField("sv", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField IV_FIELD_DESC = new org.apache.thrift.protocol.TField("iv", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField DV_FIELD_DESC = new org.apache.thrift.protocol.TField("dv", org.apache.thrift.protocol.TType.DOUBLE, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AttrValStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AttrValTupleSchemeFactory());
  }

  public String sv; // optional
  public long iv; // optional
  public double dv; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SV((short)1, "sv"),
    IV((short)2, "iv"),
    DV((short)3, "dv");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SV
          return SV;
        case 2: // IV
          return IV;
        case 3: // DV
          return DV;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __IV_ISSET_ID = 0;
  private static final int __DV_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.SV, _Fields.IV, _Fields.DV};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SV, new org.apache.thrift.meta_data.FieldMetaData("sv", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IV, new org.apache.thrift.meta_data.FieldMetaData("iv", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DV, new org.apache.thrift.meta_data.FieldMetaData("dv", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AttrVal.class, metaDataMap);
  }

  public AttrVal() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AttrVal(AttrVal other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSv()) {
      this.sv = other.sv;
    }
    this.iv = other.iv;
    this.dv = other.dv;
  }

  public AttrVal deepCopy() {
    return new AttrVal(this);
  }

  @Override
  public void clear() {
    this.sv = null;
    setIvIsSet(false);
    this.iv = 0;
    setDvIsSet(false);
    this.dv = 0.0;
  }

  public String getSv() {
    return this.sv;
  }

  public AttrVal setSv(String sv) {
    this.sv = sv;
    return this;
  }

  public void unsetSv() {
    this.sv = null;
  }

  /** Returns true if field sv is set (has been assigned a value) and false otherwise */
  public boolean isSetSv() {
    return this.sv != null;
  }

  public void setSvIsSet(boolean value) {
    if (!value) {
      this.sv = null;
    }
  }

  public long getIv() {
    return this.iv;
  }

  public AttrVal setIv(long iv) {
    this.iv = iv;
    setIvIsSet(true);
    return this;
  }

  public void unsetIv() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __IV_ISSET_ID);
  }

  /** Returns true if field iv is set (has been assigned a value) and false otherwise */
  public boolean isSetIv() {
    return EncodingUtils.testBit(__isset_bitfield, __IV_ISSET_ID);
  }

  public void setIvIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __IV_ISSET_ID, value);
  }

  public double getDv() {
    return this.dv;
  }

  public AttrVal setDv(double dv) {
    this.dv = dv;
    setDvIsSet(true);
    return this;
  }

  public void unsetDv() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DV_ISSET_ID);
  }

  /** Returns true if field dv is set (has been assigned a value) and false otherwise */
  public boolean isSetDv() {
    return EncodingUtils.testBit(__isset_bitfield, __DV_ISSET_ID);
  }

  public void setDvIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DV_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SV:
      if (value == null) {
        unsetSv();
      } else {
        setSv((String)value);
      }
      break;

    case IV:
      if (value == null) {
        unsetIv();
      } else {
        setIv((Long)value);
      }
      break;

    case DV:
      if (value == null) {
        unsetDv();
      } else {
        setDv((Double)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SV:
      return getSv();

    case IV:
      return Long.valueOf(getIv());

    case DV:
      return Double.valueOf(getDv());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SV:
      return isSetSv();
    case IV:
      return isSetIv();
    case DV:
      return isSetDv();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AttrVal)
      return this.equals((AttrVal)that);
    return false;
  }

  public boolean equals(AttrVal that) {
    if (that == null)
      return false;

    boolean this_present_sv = true && this.isSetSv();
    boolean that_present_sv = true && that.isSetSv();
    if (this_present_sv || that_present_sv) {
      if (!(this_present_sv && that_present_sv))
        return false;
      if (!this.sv.equals(that.sv))
        return false;
    }

    boolean this_present_iv = true && this.isSetIv();
    boolean that_present_iv = true && that.isSetIv();
    if (this_present_iv || that_present_iv) {
      if (!(this_present_iv && that_present_iv))
        return false;
      if (this.iv != that.iv)
        return false;
    }

    boolean this_present_dv = true && this.isSetDv();
    boolean that_present_dv = true && that.isSetDv();
    if (this_present_dv || that_present_dv) {
      if (!(this_present_dv && that_present_dv))
        return false;
      if (this.dv != that.dv)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_sv = true && (isSetSv());
    list.add(present_sv);
    if (present_sv)
      list.add(sv);

    boolean present_iv = true && (isSetIv());
    list.add(present_iv);
    if (present_iv)
      list.add(iv);

    boolean present_dv = true && (isSetDv());
    list.add(present_dv);
    if (present_dv)
      list.add(dv);

    return list.hashCode();
  }

  @Override
  public int compareTo(AttrVal other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSv()).compareTo(other.isSetSv());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSv()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sv, other.sv);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIv()).compareTo(other.isSetIv());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIv()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iv, other.iv);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDv()).compareTo(other.isSetDv());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDv()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dv, other.dv);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("AttrVal(");
    boolean first = true;

    if (isSetSv()) {
      sb.append("sv:");
      if (this.sv == null) {
        sb.append("null");
      } else {
        sb.append(this.sv);
      }
      first = false;
    }
    if (isSetIv()) {
      if (!first) sb.append(", ");
      sb.append("iv:");
      sb.append(this.iv);
      first = false;
    }
    if (isSetDv()) {
      if (!first) sb.append(", ");
      sb.append("dv:");
      sb.append(this.dv);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AttrValStandardSchemeFactory implements SchemeFactory {
    public AttrValStandardScheme getScheme() {
      return new AttrValStandardScheme();
    }
  }

  private static class AttrValStandardScheme extends StandardScheme<AttrVal> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AttrVal struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // SV
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.sv = iprot.readString();
              struct.setSvIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // IV
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.iv = iprot.readI64();
              struct.setIvIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DV
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.dv = iprot.readDouble();
              struct.setDvIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, AttrVal struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.sv != null) {
        if (struct.isSetSv()) {
          oprot.writeFieldBegin(SV_FIELD_DESC);
          oprot.writeString(struct.sv);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetIv()) {
        oprot.writeFieldBegin(IV_FIELD_DESC);
        oprot.writeI64(struct.iv);
        oprot.writeFieldEnd();
      }
      if (struct.isSetDv()) {
        oprot.writeFieldBegin(DV_FIELD_DESC);
        oprot.writeDouble(struct.dv);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AttrValTupleSchemeFactory implements SchemeFactory {
    public AttrValTupleScheme getScheme() {
      return new AttrValTupleScheme();
    }
  }

  private static class AttrValTupleScheme extends TupleScheme<AttrVal> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AttrVal struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSv()) {
        optionals.set(0);
      }
      if (struct.isSetIv()) {
        optionals.set(1);
      }
      if (struct.isSetDv()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetSv()) {
        oprot.writeString(struct.sv);
      }
      if (struct.isSetIv()) {
        oprot.writeI64(struct.iv);
      }
      if (struct.isSetDv()) {
        oprot.writeDouble(struct.dv);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AttrVal struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.sv = iprot.readString();
        struct.setSvIsSet(true);
      }
      if (incoming.get(1)) {
        struct.iv = iprot.readI64();
        struct.setIvIsSet(true);
      }
      if (incoming.get(2)) {
        struct.dv = iprot.readDouble();
        struct.setDvIsSet(true);
      }
    }
  }

}

