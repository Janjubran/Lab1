public class User {
    private String username;
    private String password;


    public User(String username, String password) {    //Constructor


            if (username.length()>50) {                 //Username length check///
                throw new IllegalArgumentException(
                        "Username is too long, try something shorter"
                );
            }

            if (!username.matches(                 //checking username validality using the matches() built in function
                    "[A-Za-z0-9_.]+@[A-Za-z0-9][A-Za-z0-9.-]*\\.[A-Za-z]{2,}"
            )) {
                throw new IllegalArgumentException(
                        "Please enter a valid Email as username"
                );
            }


            if (password.length() < 8) {         //Password length check 'under 8 char'
                throw new IllegalArgumentException(
                        "Your password is too short, add more characters"
                );
            }


            if (password.length() > 12){         //password length check 'above 12 char'
                throw new IllegalArgumentException(
                        "Your password is too long, try a shorter one"
                );
            }



        boolean hasLetter = false;                //password syntax check
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for ( int i=0;i<password.length(); i++) {
            char c = password.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                hasLetter = true;
            } else if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else if (c >= '!' && c <= '~') {       //ranging with ASSCI
                hasSymbol = true;
            } else {
                throw new IllegalArgumentException("Please enter a valid password");
            }
        }

        if (!hasLetter || !hasDigit || !hasSymbol) {
            throw new IllegalArgumentException("Please enter a valid password");
        }


        this.username = username;
        this.password = password;


    }




    public String getName(){return this.username;}      //username getter
    public String getPassword() {return this.password;}    //password getter
}
