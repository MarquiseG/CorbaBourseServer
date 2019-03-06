package metier;

import java.io.Serializable;
import java.util.Date;

public class Cotation implements Serializable
{
    private long numCotation;
    private String codeSociete;
    private Date dateCotation;
    private double valAction;

    public Cotation()
    {
    }

    public Cotation(long aInNumCotation, String aInCodeSociete, Date aInDateCotation, double aInValAction)
    {
        numCotation = aInNumCotation;
        codeSociete = aInCodeSociete;
        dateCotation = aInDateCotation;
        valAction = aInValAction;
    }

    public long getNumCotation()
    {
        return numCotation;
    }

    public void
    setNumCotation(long aInNumCotation)
    {
        numCotation = aInNumCotation;
    }

    public String getCodeSociete()
    {
        return codeSociete;
    }

    public void setCodeSociete(String aInCodeSociete)
    {
        codeSociete = aInCodeSociete;
    }

    public Date getDateCotation()
    {
        return dateCotation;
    }

    public void setDateCotation(Date aInDateCotation)
    {
        dateCotation = aInDateCotation;
    }

    public double getValAction()
    {
        return valAction;
    }

    public void setValAction(double aInValAction)
    {
        valAction = aInValAction;
    }

    @Override
    public String
    toString()
    {
        return "Cotation{" +
                "numCotation=" + numCotation +
                ", codeSociete='" + codeSociete + '\'' +
                ", dateCotation=" + dateCotation +
                ", valAction=" + valAction +
                '}';
    }
}

