package bourse;


/**
* bourse/CCotationHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Bourse.idl
* Tuesday, February 5, 2019 4:23:11 PM CET
*/

abstract public class CCotationHelper
{
  private static String  _id = "IDL:bourse/CCotation:1.0";

  public static void insert (org.omg.CORBA.Any a, bourse.CCotation that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static bourse.CCotation extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [4];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_longlong);
          _members0[0] = new org.omg.CORBA.StructMember (
            "numCotation",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "dateCotation",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_double);
          _members0[2] = new org.omg.CORBA.StructMember (
            "valAction",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "codeSociete",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (bourse.CCotationHelper.id (), "CCotation", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static bourse.CCotation read (org.omg.CORBA.portable.InputStream istream)
  {
    bourse.CCotation value = new bourse.CCotation ();
    value.numCotation = istream.read_longlong ();
    value.dateCotation = istream.read_string ();
    value.valAction = istream.read_double ();
    value.codeSociete = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, bourse.CCotation value)
  {
    ostream.write_longlong (value.numCotation);
    ostream.write_string (value.dateCotation);
    ostream.write_double (value.valAction);
    ostream.write_string (value.codeSociete);
  }

}
