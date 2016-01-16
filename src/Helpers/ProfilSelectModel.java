/*
 * Copyright (C) 2015 programmer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Helpers;

import Controllers.Profil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author programmer
 */
public class ProfilSelectModel extends AbstractListModel implements ComboBoxModel {

    List<Profil> profiles = new ArrayList<Profil>();
    String selection = null;
    
    public ProfilSelectModel(List<Profil> profiles) {
        this.profiles = profiles;
    }

    @Override
    public int getSize() {
        return profiles.size();
    }

    @Override
    public Object getElementAt(int index) {
        return profiles.get(index).getNip();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem; 
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

}
