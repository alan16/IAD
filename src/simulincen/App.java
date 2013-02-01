package simulincen;

import org.janusproject.kernel.agent.Kernel;
import org.janusproject.kernel.agent.Kernels;



/**
 * Hello world!
 *
 */
public class App 
{
    
    private static agente a;
    private static Agente2 b;
    
    public static void main( String[] args )
    {
         Kernel kernel = Kernels.get();
        
        a= new agente();
        b= new Agente2();
        
	kernel.launchLightAgent(a);
        kernel.launchLightAgent(b);
    }

   
}
