package com.kosign.luna.model.weexpend;


import javax.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @SequenceGenerator(name="tokens_id_seq",
            sequenceName="tokens_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="tokens_id_seq")
    @Column(name = "id", updatable=false)
    private int id;
    private int userId;
    private String deviceToken;
    private String deviceName;
    private boolean isOn;

    public Token() {
    }

    public Token(int id, int userId, String deviceToken, String deviceName, boolean isOn) {
        this.id = id;
        this.userId = userId;
        this.deviceToken = deviceToken;
        this.deviceName = deviceName;
        this.isOn = isOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
