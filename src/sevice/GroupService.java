package sevice;

import models.Group;

public interface GroupService {
    void addGroup(Group groupName);

    void findGroupByName(String groupName);

    void updateGroupByName(String groupName, String newName);

    void getAllGroups();

    void deleteGroupByName(String groupName);
}