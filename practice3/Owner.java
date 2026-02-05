public class Owner {
    private String cccd;
    private String fullName;
    private String email;

    public Owner(String cccd, String fullName, String email) {
        this.cccd = cccd;
        this.fullName = fullName;
        this.email = email;
    }

    public String getCccd() {
        return cccd;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Owner[Name: " + fullName + ", CCCD: " + cccd + ", Email: " + email + "]";
    }
}
