/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class TruncateTableRequest implements org.apache.thrift.TBase<TruncateTableRequest, TruncateTableRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TruncateTableRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TruncateTableRequest");

  private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("dbName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("tableName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PART_NAMES_FIELD_DESC = new org.apache.thrift.protocol.TField("partNames", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField WRITE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("writeId", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField VALID_WRITE_ID_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("validWriteIdList", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TruncateTableRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TruncateTableRequestTupleSchemeFactory());
  }

  private String dbName; // required
  private String tableName; // required
  private List<String> partNames; // optional
  private long writeId; // optional
  private String validWriteIdList; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DB_NAME((short)1, "dbName"),
    TABLE_NAME((short)2, "tableName"),
    PART_NAMES((short)3, "partNames"),
    WRITE_ID((short)4, "writeId"),
    VALID_WRITE_ID_LIST((short)5, "validWriteIdList");

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
        case 1: // DB_NAME
          return DB_NAME;
        case 2: // TABLE_NAME
          return TABLE_NAME;
        case 3: // PART_NAMES
          return PART_NAMES;
        case 4: // WRITE_ID
          return WRITE_ID;
        case 5: // VALID_WRITE_ID_LIST
          return VALID_WRITE_ID_LIST;
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
  private static final int __WRITEID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.PART_NAMES,_Fields.WRITE_ID,_Fields.VALID_WRITE_ID_LIST};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DB_NAME, new org.apache.thrift.meta_data.FieldMetaData("dbName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TABLE_NAME, new org.apache.thrift.meta_data.FieldMetaData("tableName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PART_NAMES, new org.apache.thrift.meta_data.FieldMetaData("partNames", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.WRITE_ID, new org.apache.thrift.meta_data.FieldMetaData("writeId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.VALID_WRITE_ID_LIST, new org.apache.thrift.meta_data.FieldMetaData("validWriteIdList", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TruncateTableRequest.class, metaDataMap);
  }

  public TruncateTableRequest() {
    this.writeId = -1L;

  }

  public TruncateTableRequest(
    String dbName,
    String tableName)
  {
    this();
    this.dbName = dbName;
    this.tableName = tableName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TruncateTableRequest(TruncateTableRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetDbName()) {
      this.dbName = other.dbName;
    }
    if (other.isSetTableName()) {
      this.tableName = other.tableName;
    }
    if (other.isSetPartNames()) {
      List<String> __this__partNames = new ArrayList<String>(other.partNames);
      this.partNames = __this__partNames;
    }
    this.writeId = other.writeId;
    if (other.isSetValidWriteIdList()) {
      this.validWriteIdList = other.validWriteIdList;
    }
  }

  public TruncateTableRequest deepCopy() {
    return new TruncateTableRequest(this);
  }

  @Override
  public void clear() {
    this.dbName = null;
    this.tableName = null;
    this.partNames = null;
    this.writeId = -1L;

    this.validWriteIdList = null;
  }

  public String getDbName() {
    return this.dbName;
  }

  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  public void unsetDbName() {
    this.dbName = null;
  }

  /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
  public boolean isSetDbName() {
    return this.dbName != null;
  }

  public void setDbNameIsSet(boolean value) {
    if (!value) {
      this.dbName = null;
    }
  }

  public String getTableName() {
    return this.tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public void unsetTableName() {
    this.tableName = null;
  }

  /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
  public boolean isSetTableName() {
    return this.tableName != null;
  }

  public void setTableNameIsSet(boolean value) {
    if (!value) {
      this.tableName = null;
    }
  }

  public int getPartNamesSize() {
    return (this.partNames == null) ? 0 : this.partNames.size();
  }

  public java.util.Iterator<String> getPartNamesIterator() {
    return (this.partNames == null) ? null : this.partNames.iterator();
  }

  public void addToPartNames(String elem) {
    if (this.partNames == null) {
      this.partNames = new ArrayList<String>();
    }
    this.partNames.add(elem);
  }

  public List<String> getPartNames() {
    return this.partNames;
  }

  public void setPartNames(List<String> partNames) {
    this.partNames = partNames;
  }

  public void unsetPartNames() {
    this.partNames = null;
  }

  /** Returns true if field partNames is set (has been assigned a value) and false otherwise */
  public boolean isSetPartNames() {
    return this.partNames != null;
  }

  public void setPartNamesIsSet(boolean value) {
    if (!value) {
      this.partNames = null;
    }
  }

  public long getWriteId() {
    return this.writeId;
  }

  public void setWriteId(long writeId) {
    this.writeId = writeId;
    setWriteIdIsSet(true);
  }

  public void unsetWriteId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __WRITEID_ISSET_ID);
  }

  /** Returns true if field writeId is set (has been assigned a value) and false otherwise */
  public boolean isSetWriteId() {
    return EncodingUtils.testBit(__isset_bitfield, __WRITEID_ISSET_ID);
  }

  public void setWriteIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __WRITEID_ISSET_ID, value);
  }

  public String getValidWriteIdList() {
    return this.validWriteIdList;
  }

  public void setValidWriteIdList(String validWriteIdList) {
    this.validWriteIdList = validWriteIdList;
  }

  public void unsetValidWriteIdList() {
    this.validWriteIdList = null;
  }

  /** Returns true if field validWriteIdList is set (has been assigned a value) and false otherwise */
  public boolean isSetValidWriteIdList() {
    return this.validWriteIdList != null;
  }

  public void setValidWriteIdListIsSet(boolean value) {
    if (!value) {
      this.validWriteIdList = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DB_NAME:
      if (value == null) {
        unsetDbName();
      } else {
        setDbName((String)value);
      }
      break;

    case TABLE_NAME:
      if (value == null) {
        unsetTableName();
      } else {
        setTableName((String)value);
      }
      break;

    case PART_NAMES:
      if (value == null) {
        unsetPartNames();
      } else {
        setPartNames((List<String>)value);
      }
      break;

    case WRITE_ID:
      if (value == null) {
        unsetWriteId();
      } else {
        setWriteId((Long)value);
      }
      break;

    case VALID_WRITE_ID_LIST:
      if (value == null) {
        unsetValidWriteIdList();
      } else {
        setValidWriteIdList((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DB_NAME:
      return getDbName();

    case TABLE_NAME:
      return getTableName();

    case PART_NAMES:
      return getPartNames();

    case WRITE_ID:
      return getWriteId();

    case VALID_WRITE_ID_LIST:
      return getValidWriteIdList();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DB_NAME:
      return isSetDbName();
    case TABLE_NAME:
      return isSetTableName();
    case PART_NAMES:
      return isSetPartNames();
    case WRITE_ID:
      return isSetWriteId();
    case VALID_WRITE_ID_LIST:
      return isSetValidWriteIdList();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TruncateTableRequest)
      return this.equals((TruncateTableRequest)that);
    return false;
  }

  public boolean equals(TruncateTableRequest that) {
    if (that == null)
      return false;

    boolean this_present_dbName = true && this.isSetDbName();
    boolean that_present_dbName = true && that.isSetDbName();
    if (this_present_dbName || that_present_dbName) {
      if (!(this_present_dbName && that_present_dbName))
        return false;
      if (!this.dbName.equals(that.dbName))
        return false;
    }

    boolean this_present_tableName = true && this.isSetTableName();
    boolean that_present_tableName = true && that.isSetTableName();
    if (this_present_tableName || that_present_tableName) {
      if (!(this_present_tableName && that_present_tableName))
        return false;
      if (!this.tableName.equals(that.tableName))
        return false;
    }

    boolean this_present_partNames = true && this.isSetPartNames();
    boolean that_present_partNames = true && that.isSetPartNames();
    if (this_present_partNames || that_present_partNames) {
      if (!(this_present_partNames && that_present_partNames))
        return false;
      if (!this.partNames.equals(that.partNames))
        return false;
    }

    boolean this_present_writeId = true && this.isSetWriteId();
    boolean that_present_writeId = true && that.isSetWriteId();
    if (this_present_writeId || that_present_writeId) {
      if (!(this_present_writeId && that_present_writeId))
        return false;
      if (this.writeId != that.writeId)
        return false;
    }

    boolean this_present_validWriteIdList = true && this.isSetValidWriteIdList();
    boolean that_present_validWriteIdList = true && that.isSetValidWriteIdList();
    if (this_present_validWriteIdList || that_present_validWriteIdList) {
      if (!(this_present_validWriteIdList && that_present_validWriteIdList))
        return false;
      if (!this.validWriteIdList.equals(that.validWriteIdList))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_dbName = true && (isSetDbName());
    list.add(present_dbName);
    if (present_dbName)
      list.add(dbName);

    boolean present_tableName = true && (isSetTableName());
    list.add(present_tableName);
    if (present_tableName)
      list.add(tableName);

    boolean present_partNames = true && (isSetPartNames());
    list.add(present_partNames);
    if (present_partNames)
      list.add(partNames);

    boolean present_writeId = true && (isSetWriteId());
    list.add(present_writeId);
    if (present_writeId)
      list.add(writeId);

    boolean present_validWriteIdList = true && (isSetValidWriteIdList());
    list.add(present_validWriteIdList);
    if (present_validWriteIdList)
      list.add(validWriteIdList);

    return list.hashCode();
  }

  @Override
  public int compareTo(TruncateTableRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDbName()).compareTo(other.isSetDbName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTableName()).compareTo(other.isSetTableName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTableName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, other.tableName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPartNames()).compareTo(other.isSetPartNames());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartNames()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partNames, other.partNames);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWriteId()).compareTo(other.isSetWriteId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWriteId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.writeId, other.writeId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValidWriteIdList()).compareTo(other.isSetValidWriteIdList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValidWriteIdList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.validWriteIdList, other.validWriteIdList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TruncateTableRequest(");
    boolean first = true;

    sb.append("dbName:");
    if (this.dbName == null) {
      sb.append("null");
    } else {
      sb.append(this.dbName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tableName:");
    if (this.tableName == null) {
      sb.append("null");
    } else {
      sb.append(this.tableName);
    }
    first = false;
    if (isSetPartNames()) {
      if (!first) sb.append(", ");
      sb.append("partNames:");
      if (this.partNames == null) {
        sb.append("null");
      } else {
        sb.append(this.partNames);
      }
      first = false;
    }
    if (isSetWriteId()) {
      if (!first) sb.append(", ");
      sb.append("writeId:");
      sb.append(this.writeId);
      first = false;
    }
    if (isSetValidWriteIdList()) {
      if (!first) sb.append(", ");
      sb.append("validWriteIdList:");
      if (this.validWriteIdList == null) {
        sb.append("null");
      } else {
        sb.append(this.validWriteIdList);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetDbName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'dbName' is unset! Struct:" + toString());
    }

    if (!isSetTableName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'tableName' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TruncateTableRequestStandardSchemeFactory implements SchemeFactory {
    public TruncateTableRequestStandardScheme getScheme() {
      return new TruncateTableRequestStandardScheme();
    }
  }

  private static class TruncateTableRequestStandardScheme extends StandardScheme<TruncateTableRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TruncateTableRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DB_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.dbName = iprot.readString();
              struct.setDbNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TABLE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tableName = iprot.readString();
              struct.setTableNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PART_NAMES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list78 = iprot.readListBegin();
                struct.partNames = new ArrayList<String>(_list78.size);
                String _elem79;
                for (int _i80 = 0; _i80 < _list78.size; ++_i80)
                {
                  _elem79 = iprot.readString();
                  struct.partNames.add(_elem79);
                }
                iprot.readListEnd();
              }
              struct.setPartNamesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // WRITE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.writeId = iprot.readI64();
              struct.setWriteIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // VALID_WRITE_ID_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.validWriteIdList = iprot.readString();
              struct.setValidWriteIdListIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TruncateTableRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.dbName != null) {
        oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
        oprot.writeString(struct.dbName);
        oprot.writeFieldEnd();
      }
      if (struct.tableName != null) {
        oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
        oprot.writeString(struct.tableName);
        oprot.writeFieldEnd();
      }
      if (struct.partNames != null) {
        if (struct.isSetPartNames()) {
          oprot.writeFieldBegin(PART_NAMES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.partNames.size()));
            for (String _iter81 : struct.partNames)
            {
              oprot.writeString(_iter81);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetWriteId()) {
        oprot.writeFieldBegin(WRITE_ID_FIELD_DESC);
        oprot.writeI64(struct.writeId);
        oprot.writeFieldEnd();
      }
      if (struct.validWriteIdList != null) {
        if (struct.isSetValidWriteIdList()) {
          oprot.writeFieldBegin(VALID_WRITE_ID_LIST_FIELD_DESC);
          oprot.writeString(struct.validWriteIdList);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TruncateTableRequestTupleSchemeFactory implements SchemeFactory {
    public TruncateTableRequestTupleScheme getScheme() {
      return new TruncateTableRequestTupleScheme();
    }
  }

  private static class TruncateTableRequestTupleScheme extends TupleScheme<TruncateTableRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TruncateTableRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.dbName);
      oprot.writeString(struct.tableName);
      BitSet optionals = new BitSet();
      if (struct.isSetPartNames()) {
        optionals.set(0);
      }
      if (struct.isSetWriteId()) {
        optionals.set(1);
      }
      if (struct.isSetValidWriteIdList()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetPartNames()) {
        {
          oprot.writeI32(struct.partNames.size());
          for (String _iter82 : struct.partNames)
          {
            oprot.writeString(_iter82);
          }
        }
      }
      if (struct.isSetWriteId()) {
        oprot.writeI64(struct.writeId);
      }
      if (struct.isSetValidWriteIdList()) {
        oprot.writeString(struct.validWriteIdList);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TruncateTableRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.dbName = iprot.readString();
      struct.setDbNameIsSet(true);
      struct.tableName = iprot.readString();
      struct.setTableNameIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list83 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.partNames = new ArrayList<String>(_list83.size);
          String _elem84;
          for (int _i85 = 0; _i85 < _list83.size; ++_i85)
          {
            _elem84 = iprot.readString();
            struct.partNames.add(_elem84);
          }
        }
        struct.setPartNamesIsSet(true);
      }
      if (incoming.get(1)) {
        struct.writeId = iprot.readI64();
        struct.setWriteIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.validWriteIdList = iprot.readString();
        struct.setValidWriteIdListIsSet(true);
      }
    }
  }

}

