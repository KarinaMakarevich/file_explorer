package com.epam.test_task.model;

import com.epam.test_task.model.util.Role;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends Model {

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "surname", length = 128, nullable = false)
    private String surname;

    @Column(name = "login", length = 128, nullable = false)
    private String login;

    @Column(name = "mail", length = 128, nullable = false)
    private String mail;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Transient
    private String passwordConfirmation;

    @Column(name = "enabled", columnDefinition = "TINYINT", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20, nullable = false)
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (getClass() != o.getClass()) return false;
        User user = (User) o;
        if (name == null) {
            if (user.name != null) {
                return false;
            }
        } else if (!name.equals(user.name)) {
            return false;
        }
        if (surname == null) {
            if (user.surname != null) {
                return false;
            }
        } else if (!surname.equals(user.surname)) {
            return false;
        }
        if (login == null) {
            if (user.login != null) {
                return false;
            }
        } else if (!login.equals(user.login)) {
            return false;
        }
        if (mail == null) {
            if (user.mail != null) {
                return false;
            }
        } else if (!mail.equals(user.mail)) {
            return false;
        }
        if (password == null) {
            if (user.password != null) {
                return false;
            }
        } else if (!password.equals(user.password)) {
            return false;
        }
        if (passwordConfirmation == null) {
            if (user.passwordConfirmation != null) {
                return false;
            }
        } else if (!passwordConfirmation.equals(user.passwordConfirmation)) {
            return false;
        }
        if (enabled == null) {
            if (user.enabled != null) {
                return false;
            }
        } else if (!enabled.equals(user.enabled)) {
            return false;
        }
        if (role == null) {
            if (user.role != null) {
                return false;
            }
        } else if (!role.equals(user.role)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int factor = 31;
        int result = super.hashCode();
        result = factor * result + ((name == null) ? 0 : name.hashCode());
        result = factor * result + ((surname == null) ? 0 : surname.hashCode());
        result = factor * result + ((login == null) ? 0 : login.hashCode());
        result = factor * result + ((mail == null) ? 0 : mail.hashCode());
        result = factor * result + ((password == null) ? 0 : password.hashCode());
        result = factor * result + ((passwordConfirmation == null) ? 0 : passwordConfirmation.hashCode());
        result = factor * result + ((enabled == null) ? 0 : enabled.hashCode());
        result = factor * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                ", enabled='" + enabled + '\'' +
                ", role=" + role +
                '}';
    }
}
