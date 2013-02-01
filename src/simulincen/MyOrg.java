/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulincen;

import org.janusproject.kernel.crio.core.CRIOContext;
import org.janusproject.kernel.crio.core.Organization;

/**
 *
 * @author Lizondo
 */
public class MyOrg extends Organization{
    public MyOrg(CRIOContext Cctxt){
        super(Cctxt);
        addRole(RoleHola.class);
        addRole(RoleChau.class);
    }
}
