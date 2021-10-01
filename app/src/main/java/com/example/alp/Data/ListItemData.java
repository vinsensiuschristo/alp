package com.example.alp.Data;

import com.example.alp.R;

import java.util.ArrayList;

public class ListItemData {
    private static String[] heroNames = {
            "Project Example 1",
            "Project Example 2",
            "Project Example 3",
            "Project Example 4",
    };

    private static String[] heroDetails = {
            "Detail Project Example 1",
            "Detail Project Example 2",
            "Detail Project Example 3",
            "Detail Project Example 4",
    };

    private static int[] heroesImages = {
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
    };

    public static ArrayList<ListItem> getListData() {
        ArrayList<ListItem> list = new ArrayList<>();
        for (int position = 0; position < heroNames.length; position++) {
            ListItem listItem = new ListItem();
            listItem.setName(heroNames[position]);
            listItem.setDetail(heroDetails[position]);
            listItem.setPhoto(heroesImages[position]);
            list.add(listItem);
        }
        return list;
    }
}
