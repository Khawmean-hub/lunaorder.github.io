package com.kosign.luna.model.weexpend;


import javax.persistence.*;
@Entity
@Table(name = "group_permission")
public class GroupPermission {
    @Id
    @SequenceGenerator(name="group_permission_id_seq",
            sequenceName="group_permission_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="group_permission_id_seq")
    @Column(name = "id", updatable=false)
    private int id;
    private int groupId;
    private int usersId;
    private boolean active;

    public GroupPermission() {
    }

    public GroupPermission(int id, int groupId, int usersId, boolean active) {
        this.id = id;
        this.groupId = groupId;
        this.usersId = usersId;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
