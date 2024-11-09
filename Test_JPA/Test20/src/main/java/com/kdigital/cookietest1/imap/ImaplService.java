package com.kdigital.cookietest1.imap;

import jakarta.mail.Folder;
import jakarta.mail.Session;
import jakarta.mail.Store;

import java.util.Properties;

public class ImaplService {
    private Session session;
    private Store store;
    private Folder folder;

    // hardcoding protocol and the folder
    // it can be parameterized and enhanced as required
    private String protocol = "imaps";
    private String file = "INBOX";

    public void IMAPMailService() {
        // Initialize the session
        Properties props = new Properties();
        props.put("mail.store.protocol", protocol);
        this.session = Session.getInstance(props);
    }

    // Method to log in to the email account
    public boolean login(String userName, String password) {
        try {
            store = session.getStore(protocol);
            store.connect("imap.gmail.com", userName, password);
            folder = store.getFolder(file);
            folder.open(Folder.READ_ONLY);
            return isLoggedIn();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLoggedIn() {
        return store != null && store.isConnected();
    }

    public void logout() {
        try {
            if (folder != null && folder.isOpen()) {
                folder.close(false);
            }
            if (store != null) {
                store.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
