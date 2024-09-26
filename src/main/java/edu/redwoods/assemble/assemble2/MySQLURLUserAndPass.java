package edu.redwoods.assemble.assemble2;

public class MySQLURLUserAndPass {
    public String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_4524081_user"; //"connection refused"
    public String username = "freedb_4524081_user";
    public String password = "MP94YF&?qcbywwN";

    // Constructor
    public MySQLURLUserAndPass() {
    }

    // Getter for URL
    public String getUrl() {
        return url;
    }

    // Setter for URL
    public void setUrl(String url) {
        this.url = url;
    }

    // Getter for Username
    public String getUsername() {
        return username;
    }

    // Setter for Username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for Password
    public String getPassword() {
        return password;
    }

    // Setter for Password
    public void setPassword(String password) {
        this.password = password;
    }
}
