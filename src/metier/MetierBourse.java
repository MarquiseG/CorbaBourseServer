
package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierBourse
{
    public List<Cotation> getCotations(String codeSoc)
    {
        List<Cotation> lCotations = new ArrayList<>();
        try
        {
            //Charger le pilote jdbc
            Class.forName("com.mysql.jdbc.Driver");

            //Créer un objet de connexion
            Connection lConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bourse_ws", "mkaroune", "Mkaroune@77");
            //Créer un objet de requette
            PreparedStatement lPreparedStatement =
                    lConnection.prepareStatement("SELECT * FROM cotations WHERE CODE_SOCIETE=? ");
            //On remplace le premier . de la requête par la valeur de codeSoc
            lPreparedStatement.setString(1, codeSoc);
            //Exécuter la requête et récupérer le résultat
            ResultSet lResultSet = lPreparedStatement.executeQuery();
            //Faire le mapping  objet relationnel pour chaque ligne de rs, on crée un objet de cotations
            while (lResultSet.next())
            {
                //Créer l'objet de création
                Cotation lCotation = new Cotation();
                lCotation.setNumCotation(lResultSet.getLong("NUM_COTATION"));
                lCotation.setValAction(lResultSet.getDouble("VAL_ACTION"));
                lCotation.setDateCotation(lResultSet.getDate("DATE_COTATION"));
                lCotation.setCodeSociete(lResultSet.getString("CODE_SOCIETE"));
                lCotations.add(lCotation);
            }

        }
        catch (SQLException | ClassNotFoundException aInE)
        {
            aInE.printStackTrace();
        }
        return lCotations;
    }

}
