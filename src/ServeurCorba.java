import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import servants.BourseImpl;

public class ServeurCorba
{

    public static void main(String[] args)
    {
        try
        {
            //Initialize l'ORB
            ORB lORB = ORB.init(args, null);
            //Create POA Manager
            POA lPOA = POAHelper.narrow(lORB.resolve_initial_references("RootPOA"));
            //Activate POA Manager
            lPOA.the_POAManager().activate();

            //Create the object that offers the distant service
            BourseImpl lBourse = new BourseImpl();
            //Create the context
            org.omg.CORBA.Object objRef = lORB.resolve_initial_references("NameService");
            NamingContext lContext = NamingContextHelper.narrow(objRef);
            //Create the array names that will be assigned to the object
            NameComponent[] lNameComponents = new NameComponent[1];
            lNameComponents[0] = new NameComponent("BOURSE", "");
            //Register the reference of the distant object in the naming service
            lContext.rebind(lNameComponents, lPOA.servant_to_reference(lBourse));
            lORB.run();
        }
        catch (AdapterInactive | ServantNotActive | WrongPolicy | CannotProceed | NotFound | InvalidName | org.omg.CosNaming.NamingContextPackage.InvalidName aInAdapterInactive)
        {
            aInAdapterInactive.printStackTrace();
        }
    }
}
