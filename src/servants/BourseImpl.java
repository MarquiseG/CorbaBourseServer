package servants;

import bourse.BoursePOA;
import bourse.CCotation;
import metier.Cotation;
import metier.MetierBourse;

import java.util.List;

public class BourseImpl extends BoursePOA
{
    // extends the skeleton and implements the methods
    private MetierBourse metierBourse;

    public BourseImpl()
    {
        metierBourse = new MetierBourse();
    }

    @Override
    public CCotation[] getCotations(String cs)
    {
        List<Cotation> lCotationList = metierBourse.getCotations(cs);

        CCotation[] lCCotations = new CCotation[lCotationList.size()];
        for (int i = 0; i < lCotationList.size(); i++)
        {
            Cotation lCotation = lCotationList.get(i);
            CCotation lCCotation = new CCotation();
            lCCotation.numCotation = lCotation.getNumCotation();
            lCCotation.dateCotation = lCotation.getDateCotation().toString();
            lCCotation.valAction = lCotation.getValAction();
            lCCotation.codeSociete = lCotation.getCodeSociete();
            lCCotations[i] = lCCotation;
        }
        return lCCotations;
    }

    @Override
    public double getMoyennesCotations(String cs)
    {
        List<Cotation> lCotationList = metierBourse.getCotations(cs);
        double some = 0;

        for (Cotation lCotation : lCotationList)
        {
            some += lCotation.getValAction();
        }
        return some / lCotationList.size();
    }
}
