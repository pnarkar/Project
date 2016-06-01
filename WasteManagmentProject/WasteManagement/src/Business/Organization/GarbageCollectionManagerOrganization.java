/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.GarbageCollectionManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class GarbageCollectionManagerOrganization extends Organization{

    public GarbageCollectionManagerOrganization() {
        super(Organization.Type.GarbageCollectionManager.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GarbageCollectionManagerRole());
        return roles;
    }
     
}