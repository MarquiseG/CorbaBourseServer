package bourse;

/**
* bourse/BourseHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Bourse.idl
* Tuesday, February 5, 2019 4:23:11 PM CET
*/

public final class BourseHolder implements org.omg.CORBA.portable.Streamable
{
  public bourse.Bourse value = null;

  public BourseHolder ()
  {
  }

  public BourseHolder (bourse.Bourse initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = bourse.BourseHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    bourse.BourseHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return bourse.BourseHelper.type ();
  }

}