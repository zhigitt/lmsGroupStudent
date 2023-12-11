package sevice.impl;

import models.GenerateId;
import models.Group;
import models.db.DataBase;
import sevice.GroupService;

import java.util.Iterator;

public class GroupServiceImpl implements GroupService {

    DataBase dataBase;

    public GroupServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void addGroup(Group groupName) {
        groupName.setIdGroup(GenerateId.generateIdGroup());
        dataBase.groups.add(groupName);
        System.out.println("Жаны группа тузулду!");
    }

    @Override
    public void findGroupByName(String groupName) {
        for (Group group : dataBase.groups) {
            if (group.getGoupName().equalsIgnoreCase(groupName)){
                System.out.println(group);
                return;
            }
        }
        System.out.println("Мындай группа жок!");
    }

    @Override
    public void updateGroupByName(String groupName, String newName) {
        for (Group group : dataBase.groups) {
            if (group.getGoupName().equalsIgnoreCase(groupName)){
                group.setGoupName(newName);
                System.out.println("Группын аты озгорулду");
                return;
            }
        }
        System.out.println("Сиз издеген группа жок");
    }

    @Override
    public void getAllGroups() {
        System.out.println("Бардык группалар: ");
        System.out.println(dataBase.groups);
    }


    @Override
    public void deleteGroupByName(String groupName) {
        Iterator<Group> iteratorGroup = dataBase.groups.iterator();
        while (iteratorGroup.hasNext()){
            Group group = iteratorGroup.next();
            if (group.getGoupName().equalsIgnoreCase(groupName)){
                iteratorGroup.remove();
                System.out.println("Группа очурулду");
                return;
            }
        }
        System.out.println("Мындай группа жок!");
    }
}
