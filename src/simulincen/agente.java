/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulincen;

import org.janusproject.kernel.agent.Agent;
import org.janusproject.kernel.crio.core.GroupAddress;
import org.janusproject.kernel.status.Status;

/**
 *
 * @author Lizondo
 */
public class agente extends Agent{

   
    public Status activate() {
        Status status = super.activate(); //To change body of generated methods, choose Tools | Templates.
        GroupAddress ga = getOrCreateGroup(MyOrg.class);
        
        print("Negri!!! llegue al activate");
        //CapacityContainer cc = getCapacityContainer();
        
        requestRole(RoleHola.class, ga);
        return status;
        
    }
    
    @Override
    public Status end() {
    print("Me fui!!!!\n");
    return null;
  }
}
