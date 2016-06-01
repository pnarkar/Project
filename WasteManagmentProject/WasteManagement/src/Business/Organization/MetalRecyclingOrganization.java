/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BioTransportationServiceRole;
import Business.Role.MetalRecyclingServiceRole;
import Business.Role.PlasticRecyclingServiceRole;
import Business.Role.Role;
import Business.WorkQueue.MetalRecyclingWorkRequest;
import java.util.ArrayList;

/**
 *
 * @author pranalinarkar
 */
public class MetalRecyclingOrganization extends Organization {

 
    public MetalRecyclingOrganization() {
        super(Organization.Type.MetalRecyclingService.getValue());
    }

    @Override
   public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MetalRecyclingServiceRole());
        return roles;
    }
    
}
