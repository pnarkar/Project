/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.MetalRecyclingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.MetalRecyclingServiceRole.MetalRecyclingServiceJPanel;
import javax.swing.JPanel;

/**
 *
 * @author pranalinarkar
 */
public class MetalRecyclingServiceRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new MetalRecyclingServiceJPanel(userProcessContainer, account, (MetalRecyclingOrganization)organization, enterprise);
    }
    
}
