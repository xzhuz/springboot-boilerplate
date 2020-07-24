package fun.baozi.web.dao.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "deleted")
    private Byte deleted;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "description")
    private String description;

    @Column(name = "email")
    private String email;

    @Column(name = "expire_time")
    private Date expireTime;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return deleted
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * @param deleted
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return expire_time
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

}