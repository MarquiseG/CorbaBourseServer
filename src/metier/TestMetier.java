package metier;

import java.util.Iterator;

public class TestMetier
{
    public static void main(String[] args)
    {
        MetierBourse lMetierBourse = new MetierBourse();
        Iterator<Cotation> lCotationIterator = lMetierBourse.getCotations("SGMP").iterator();
        while (lCotationIterator.hasNext()){
            Cotation lCotation = lCotationIterator.next();
            System.out.println(lCotation.getDateCotation() + "\t" + lCotation.getValAction());
        }
    }
}
