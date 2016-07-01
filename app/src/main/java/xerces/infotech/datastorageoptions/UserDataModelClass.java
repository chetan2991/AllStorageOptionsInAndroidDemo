package xerces.infotech.datastorageoptions;

public class UserDataModelClass
{
    String mUserName;
    String mPassword;
    String mContact;

    public UserDataModelClass(String userName, String password, String contact)
    {
        mUserName = userName;
        mPassword = password;
        mContact = contact;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getContact() {
        return mContact;
    }

    public void setContact(String contact) {
        mContact = contact;
    }

}
