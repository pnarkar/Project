/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BioRecyclingServiceRole;
import Business.Role.GarbageCollectorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pranalinarkar
 */
public class BioRecyclingOrganization extends Organization{

    public BioRecyclingOrganization() {
        super(Organization.Type.BioRecyclingService.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new BioRecyclingServiceRole());
        return roles;
    }
    
}
