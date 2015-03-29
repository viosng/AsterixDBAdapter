package com.viosng.asterix.db.adapter.thrift; /**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

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
public class Record implements org.apache.thrift.TBase<Record, Record._Fields>, java.io.Serializable, Cloneable, Comparable<Record> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Record");

  private static final org.apache.thrift.protocol.TField ATTRS_FIELD_DESC = new org.apache.thrift.protocol.TField("attrs", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RecordStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RecordTupleSchemeFactory());
  }

  public List<AttrVal> attrs; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ATTRS((short)1, "attrs");

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
        case 1: // ATTRS
          return ATTRS;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ATTRS, new org.apache.thrift.meta_data.FieldMetaData("attrs", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AttrVal.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Record.class, metaDataMap);
  }

  public Record() {
  }

  public Record(
    List<AttrVal> attrs)
  {
    this();
    this.attrs = attrs;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Record(Record other) {
    if (other.isSetAttrs()) {
      List<AttrVal> __this__attrs = new ArrayList<AttrVal>(other.attrs.size());
      for (AttrVal other_element : other.attrs) {
        __this__attrs.add(new AttrVal(other_element));
      }
      this.attrs = __this__attrs;
    }
  }

  public Record deepCopy() {
    return new Record(this);
  }

  @Override
  public void clear() {
    this.attrs = null;
  }

  public int getAttrsSize() {
    return (this.attrs == null) ? 0 : this.attrs.size();
  }

  public java.util.Iterator<AttrVal> getAttrsIterator() {
    return (this.attrs == null) ? null : this.attrs.iterator();
  }

  public void addToAttrs(AttrVal elem) {
    if (this.attrs == null) {
      this.attrs = new ArrayList<AttrVal>();
    }
    this.attrs.add(elem);
  }

  public List<AttrVal> getAttrs() {
    return this.attrs;
  }

  public Record setAttrs(List<AttrVal> attrs) {
    this.attrs = attrs;
    return this;
  }

  public void unsetAttrs() {
    this.attrs = null;
  }

  /** Returns true if field attrs is set (has been assigned a value) and false otherwise */
  public boolean isSetAttrs() {
    return this.attrs != null;
  }

  public void setAttrsIsSet(boolean value) {
    if (!value) {
      this.attrs = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ATTRS:
      if (value == null) {
        unsetAttrs();
      } else {
        setAttrs((List<AttrVal>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ATTRS:
      return getAttrs();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ATTRS:
      return isSetAttrs();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Record)
      return this.equals((Record)that);
    return false;
  }

  public boolean equals(Record that) {
    if (that == null)
      return false;

    boolean this_present_attrs = true && this.isSetAttrs();
    boolean that_present_attrs = true && that.isSetAttrs();
    if (this_present_attrs || that_present_attrs) {
      if (!(this_present_attrs && that_present_attrs))
        return false;
      if (!this.attrs.equals(that.attrs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_attrs = true && (isSetAttrs());
    list.add(present_attrs);
    if (present_attrs)
      list.add(attrs);

    return list.hashCode();
  }

  @Override
  public int compareTo(Record other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAttrs()).compareTo(other.isSetAttrs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAttrs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attrs, other.attrs);
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
    StringBuilder sb = new StringBuilder("Record(");
    boolean first = true;

    sb.append("attrs:");
    if (this.attrs == null) {
      sb.append("null");
    } else {
      sb.append(this.attrs);
    }
    first = false;
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RecordStandardSchemeFactory implements SchemeFactory {
    public RecordStandardScheme getScheme() {
      return new RecordStandardScheme();
    }
  }

  private static class RecordStandardScheme extends StandardScheme<Record> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Record struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // ATTRS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.attrs = new ArrayList<AttrVal>(_list0.size);
                AttrVal _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new AttrVal();
                  _elem1.read(iprot);
                  struct.attrs.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setAttrsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Record struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.attrs != null) {
        oprot.writeFieldBegin(ATTRS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.attrs.size()));
          for (AttrVal _iter3 : struct.attrs)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RecordTupleSchemeFactory implements SchemeFactory {
    public RecordTupleScheme getScheme() {
      return new RecordTupleScheme();
    }
  }

  private static class RecordTupleScheme extends TupleScheme<Record> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Record struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAttrs()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetAttrs()) {
        {
          oprot.writeI32(struct.attrs.size());
          for (AttrVal _iter4 : struct.attrs)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Record struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.attrs = new ArrayList<AttrVal>(_list5.size);
          AttrVal _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new AttrVal();
            _elem6.read(iprot);
            struct.attrs.add(_elem6);
          }
        }
        struct.setAttrsIsSet(true);
      }
    }
  }

}

