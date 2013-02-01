/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulincen;

import org.janusproject.kernel.crio.core.Role;
import org.janusproject.kernel.message.StringMessage;
import org.janusproject.kernel.status.Status;
import org.janusproject.kernel.status.StatusFactory;

/**
 *
 * @author Lizondo
 */
public class RoleChau extends Role{
 private State estado = null;
 StringMessage m = null;
  
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
                /**
                 * En este estado el role se queda esperando a recibir un 
                 * mensaje del GuiControlerRole para recien comenzar
                 * a capturar el archivo de audio.
                 */
                m = (StringMessage) getMailbox().removeFirst();
                if (m!= null) {
                    if("Hola RoleChauuu!!!".equals(m.getContent())) {
                        print("Chauuu RoleHola");
                    }
                    
                    this.estado = State.endTask;
                }

                return this.estado;
            }

            case endTask: {
                /**
                 * Una vez terminado la captura total del archivo se recibe la señal
                 * SignalEndDataCatch para volver al estado Idle.
                 */
                leaveMe();

                return this.estado;
            }

        }

        return this.estado;
    }
    
    
    
     private enum State {

        /**
         * Esperando la recepcion de señales.
         */
        idle,
        /**
         * Fin de la captura del Archivo de Audio.
         */
        endTask;
    }
    
}
