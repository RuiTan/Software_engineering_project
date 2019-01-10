package top.guitoubing.pojo.Data;

import top.guitoubing.pojo.Group;
import top.guitoubing.pojo.Message;
import top.guitoubing.pojo.User;

import java.util.List;

public class ProfileData {
    private User user;
    private List<Group> groups;
    private List<Group> invites;
    private List<ApplyData> applys;
    private int TaskCount;
    private int SVCount;
    private int NoticeCount;
    private List<MessageData> messageData;

    public ProfileData() {
    }

    public ProfileData(User user, List<Group> groups, List<Group> invites, List<ApplyData> applys, int taskCount, int SVCount, int noticeCount, List<MessageData> messageData) {
        this.user = user;
        this.groups = groups;
        this.invites = invites;
        this.applys = applys;
        TaskCount = taskCount;
        this.SVCount = SVCount;
        NoticeCount = noticeCount;
        this.messageData = messageData;
    }

    public List<Group> getInvites() {
        return invites;
    }

    public void setInvites(List<Group> invites) {
        this.invites = invites;
    }

    public List<MessageData> getMessageData() {
        return messageData;
    }

    public void setMessageData(List<MessageData> messageData) {
        this.messageData = messageData;
    }

    public List<ApplyData> getApplys() {
        return applys;
    }

    public void setApplys(List<ApplyData> applys) {
        this.applys = applys;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public int getTaskCount() {
        return TaskCount;
    }

    public void setTaskCount(int taskCount) {
        TaskCount = taskCount;
    }

    public int getSVCount() {
        return SVCount;
    }

    public void setSVCount(int SVCount) {
        this.SVCount = SVCount;
    }

    public int getNoticeCount() {
        return NoticeCount;
    }

    public void setNoticeCount(int noticeCount) {
        NoticeCount = noticeCount;
    }

    public List<MessageData> getmessageData() {
        return messageData;
    }

    public void setmessageData(List<MessageData> messageData) {
        this.messageData = messageData;
    }
}
