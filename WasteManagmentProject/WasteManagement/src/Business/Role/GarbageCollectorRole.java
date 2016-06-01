/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.GarbageCollectorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.GarbageCollectorRole.GarbageCollectorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class GarbageCollectorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new GarbageCollectorWorkAreaJPanel(userProcessContainer, account,(GarbageCollectorOrganization)organization, enterprise);
    }
    
}
