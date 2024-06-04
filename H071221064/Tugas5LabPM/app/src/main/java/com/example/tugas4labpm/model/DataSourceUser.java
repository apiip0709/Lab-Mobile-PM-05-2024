package com.example.tugas4labpm.model;

import com.example.tugas4labpm.R;

import java.util.ArrayList;

public class DataSourceUser {
    private static DataSourceUser instance;
    private ArrayList<User> users;

    private DataSourceUser() {
        users = generateDummyStory();
    }

    public static synchronized DataSourceUser getInstance() {
        if (instance == null) {
            instance = new DataSourceUser();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(0, user);
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public int getUserCount() {
        return users.size();
    }

    // Metode untuk mengenerate data dummy
    private ArrayList<User> generateDummyStory() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Monkey D Luffy", "Luffy", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Semper auctor neque vitae tempus quam pellentesque nec. Donec massa sapien faucibus et. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada proin. Dignissim enim sit amet venenatis urna.",
                R.drawable.pp_luffy, R.drawable.post_luffy));
        users.add(new User("Roronoa Zoro", "Zoro", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                R.drawable.pp_zoro, R.drawable.post_zoro));
        users.add(new User("Akagami no Shanks", "Shanks", "Viverra mauris in aliquam sem fringilla.",
                R.drawable.pp_shanks, R.drawable.post_shanks));
        users.add(new User("Flame Emperor", "Sabo", "turpis massa tincidunt dui ut ornare lectus sit amet est placerat in egestas erat imperdiet sed euismod nisi porta lorem mollis aliquam ut porttitor.",
                R.drawable.pp_sabo, R.drawable.post_sabo));
        users.add(new User("Tony Tony Chopper", "Chopper", "augue mauris augue neque gravida in fermentum et sollicitudin.",
                R.drawable.pp_chopper, R.drawable.post_chopper));
        users.add(new User("Dorobou Neko no Nami", "Nami", "malesuada fames ac turpis egestas sed tempus urna et pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna eget est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas integer eget aliquet nibh praesent tristique magna sit amet purus gravida quis blandit turpis cursus in hac habitasse.",
                R.drawable.pp_nami, R.drawable.post_nami));

        return users;
    }
}

