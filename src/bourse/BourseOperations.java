package bourse;


/**
* bourse/BourseOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Bourse.idl
* Tuesday, February 5, 2019 4:23:11 PM CET
*/

public interface BourseOperations 
{
  bourse.CCotation[] getCotations (String cs);
  double getMoyennesCotations (String cs);
} // interface BourseOperations
