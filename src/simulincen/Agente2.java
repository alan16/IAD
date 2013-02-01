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
public class Agente2 extends Agent{
     public Status activate() {
        Status status = super.activate(); //To change body of generated methods, choose Tools | Templates.
        GroupAddress ga = getOrCreateGroup(MyOrg.class);
        requestRole(RoleChau.class, ga);
        return status;
        
    }
    
    @Override
    public Status end() {
    print("Me fui Agente2!\n");
    return null;
  }
}
