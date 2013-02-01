/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulincen;

import org.janusproject.kernel.crio.core.Role;
import org.janusproject.kernel.message.Message;
import org.janusproject.kernel.message.StringMessage;
import org.janusproject.kernel.status.Status;
import org.janusproject.kernel.status.StatusFactory;

/**
 *
 * @author Lizondo
 */
public class RoleHola extends Role{

    private State estado;
    
    @Override
    public Status activate(Object... parameters) {
        this.estado = State.idle;
        return StatusFactory.ok(this);
    }
    
    @Override
    public Status live() {
        this.estado = Run();
        return StatusFactory.ok(this);
    }
    
    private State Run(){
     switch (this.estado) {
            case idle: {
                return this.estado= State.SendingMsj;
            }

            case SendingMsj: {
                sendMessage(RoleChau.class, new StringMessage("Hola RoleChauuu!!!"));
                return this.estado= State.FinRole;
            }

            case FinRole: {
                leaveMe();
            }

            default:
                return this.estado;
        }
}
    
    private enum State {

        /**
         * Esperando la recepcion de señales
         */
        idle,
        /**
         * Enviando la info necesaria para iniciar la Simulacion
         */
        SendingMsj,
        /**
         * Waiting contract group.
         */
        FinRole;
    }
    
}
