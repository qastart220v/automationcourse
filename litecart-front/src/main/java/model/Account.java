package model;

public class Account {

    private String firstName;
    private String lastName ;
    private String country ;
    private String email;
    private String desiredPassword;
    private String confirmPassword;
    private String state;


    public Account(AccountBuilder accountBuilder) {
        this.firstName = accountBuilder.firstName;
        this.lastName = accountBuilder.lastName;
        this.country = accountBuilder.country;
        this.email = accountBuilder.email;
        this.desiredPassword = accountBuilder.desiredPassword;
        this.confirmPassword = accountBuilder.confirmPassword;
        this.state = accountBuilder.state;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesiredPassword() {
        return desiredPassword;
    }

    public void setDesiredPassword(String desiredPassword) {
        this.desiredPassword = desiredPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public static class AccountBuilder {
        private String firstName;
        private String lastName;
        private String country;
        private String email;
        private String desiredPassword;
        private String confirmPassword;
        private String state;

        public AccountBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AccountBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AccountBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AccountBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder desiredPassword(String desiredPassword) {
            this.desiredPassword = desiredPassword;
            return this;
        }

        public AccountBuilder confirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public AccountBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public Account createAccount() {
            return new Account(this);
        }
    }
}
