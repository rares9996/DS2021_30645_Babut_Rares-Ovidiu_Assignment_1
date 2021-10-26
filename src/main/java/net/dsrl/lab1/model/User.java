package net.dsrl.lab1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UniqueUsername", columnNames = {"username"})})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  private String name;
  @Column(name = "birth_date")
  private Date birthdayDate;
  private String address;
  private String username;
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();
  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "user_device",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "device_id"))
  private Set<Device> devices = new HashSet<>();

  public User() {}

  public User(String name, Date birthdayDate, String address, String username, String password) {
    this.name = name;
    this.birthdayDate = birthdayDate;
    this.address = address;
    this.username = username;
    this.password = password;
  }
}
