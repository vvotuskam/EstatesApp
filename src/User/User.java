package User;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phone;
    private int money;

    public User(Integer id, String name, String surname, String password, String email, String phone, int money) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public static boolean suitablePassword(String password) {
        if (password.length() < 8)
            return false;

        boolean oneDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                oneDigit = true;
                break;
            }
        }

        if (!oneDigit)
            return false;
        boolean oneUpperCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                oneUpperCase = true;
                break;
            }
        }

        if (!oneUpperCase)
            return false;
        boolean oneLowerCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                oneLowerCase = true;
                break;
            }
        }
        if (!oneLowerCase)
            return false;

        // does not match with punctuation characters
        String punctuations = "{}[]:;\"'?/.,><@#$%^&*()_-+= !";
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < punctuations.length(); j++) {
                if (password.charAt(i) == punctuations.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public static boolean suitablePhone(String phone) {
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) < '0' || phone.charAt(i) > '9')
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Name = " + name +
                "\nSurname = " + surname +
                "\nEmail = " + email +
                "\nPhone = " + phone +
                "\nPassword = " + password +
                "\nMoney = " + money;
    }
}
