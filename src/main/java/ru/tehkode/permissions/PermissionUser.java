/*
 * PermissionsEx - Permissions plugin for Bukkit
 * Copyright (C) 2011 t3hk0d3 http://www.tehkode.ru
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package ru.tehkode.permissions;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author code
 */
public abstract class PermissionUser extends PermissionEntity {

    public PermissionUser(String playerName, PermissionManager manager) {
        super(playerName, manager);
    }

    public boolean inGroup(PermissionGroup group) {
        return this.inGroup(group.getName());
    }

    public boolean inGroup(String groupName) {
        for (String matchingGroupName : this.getGroupsNamesImpl()) {
            if (groupName.equalsIgnoreCase(matchingGroupName)) {
                return true;
            }
        }

        return false;
    }

    public PermissionGroup[] getGroups() {
        Set<PermissionGroup> groups = new LinkedHashSet<PermissionGroup>();

        for (String group : this.getGroupsNamesImpl()) {
            groups.add(this.manager.getGroup(group.trim()));
        }

        if(groups.isEmpty()){
            groups.add(this.manager.getDefaultGroup());
        }

        return groups.toArray(new PermissionGroup[]{});
    }

    public String[] getGroupsNames() {
        List<String> groups = new LinkedList<String>();
        for (PermissionGroup group : this.getGroups()){
            groups.add(group.getName());
        }

        return groups.toArray(new String[0]);
    }

    @Override
    public boolean has(String permission, String world) {
        if(permission != null && permission.isEmpty()){ // empty permission for public access :)
            return true;
        }

        String expression = this.getMatchingExpression(permission, world);
        if (expression != null) {
            return this.explainExpression(expression);
        }

        for (PermissionGroup group : this.getGroups()) {
            if (group.has(permission, world)) {
                return true;
            }
        }

        return false;
    }

    public void addGroup(String groupName) {
        if (groupName == null || groupName.isEmpty()) {
            return;
        }

        this.addGroup(this.manager.getGroup(groupName));
    }

    public void addGroup(PermissionGroup group) {
        if (group == null) {
            return;
        }

        List<PermissionGroup> groups = Arrays.asList(this.getGroups());

        if (!groups.contains(group)) {
            groups.add(group);

            this.setGroups(groups.toArray(new PermissionGroup[]{}));
        }
    }

    public void removeGroup(String groupName) {
        if (groupName == null || groupName.isEmpty()) {
            return;
        }

        this.removeGroup(this.manager.getGroup(groupName));
    }

    public void removeGroup(PermissionGroup group) {
        if (group == null) {
            return;
        }

        List<PermissionGroup> groups = Arrays.asList(this.getGroups());

        if (groups.contains(group)) {
            groups.remove(group);

            this.setGroups(groups.toArray(new PermissionGroup[]{}));
        }
    }

    public abstract void setGroups(PermissionGroup[] groups);

    protected abstract String[] getGroupsNamesImpl();


}
