package com.example.csm.talktome;

/**
 * Created by CSH on 2017-12-04.
 */

public class ListItem {

    String ItemTitle;
    String ItemContent;
    String ItemDate;

    public ListItem(String itemtitle, String itemcontent, String itemdate) {
        ItemTitle = itemtitle;
        ItemContent = itemcontent;
        ItemDate = itemdate;
    }

    public String getItemTitle() {
        return ItemTitle;
    }

    public void setItemTitle(String itemTitle) {
        ItemTitle = itemTitle;
    }

    public String getItemcontent() {
        return ItemContent;
    }

    public void setItemcontent(String itemcontent) {
        ItemContent = itemcontent;
    }

    public String getItemdate() {
        return ItemDate;
    }

    public void setItemdate(String itemdate) {
        ItemDate = itemdate;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "ItemTitle='" + ItemTitle + '\'' +
                ", Itemcontent='" + ItemContent + '\'' +
                ", Itemdate='" + ItemDate + '\'' +
                '}';
    }
}
