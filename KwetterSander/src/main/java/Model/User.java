/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sander
 */
@Entity
@Table(name = "UsersTweet")
@NamedQueries({
    @NamedQuery(name = "findAllUsers", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "findUsersByName", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "filterUsersBySnippet", query = "SELECT u FROM Users u WHERE u.username Like '%:snippet%'")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String username;

    private List<Tweet> Tweets;

    @ManyToMany
    private List<User> followers = new ArrayList<User>();
    @ManyToMany(mappedBy = "followers")
    private List<User> following = new ArrayList<User>();

    public User(String name, String password, String username) {
        this.name = name;
        this.password = password;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getFollowers() {
        return this.followers;
    }

    public void addFollower(User u) {
        this.followers.add(u);
    }

    public List<Tweet> getTweets() {
        return Tweets;
    }

    public void setTweets(List<Tweet> Tweets) {
        this.Tweets = Tweets;
    }
}
