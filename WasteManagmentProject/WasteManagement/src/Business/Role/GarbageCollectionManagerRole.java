/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.GarbageCollectionManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.GCManagerRole.GCManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class GarbageCollectionManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new GCManagerWorkAreaJPanel(userProcessContainer, account, (GarbageCollectionManagerOrganization)organization, enterprise);
    }
    
    
}
