package Controller.Manage;

import java.util.List;

public interface IFunction<E> {
    void insertItem(String index); // add new item

    void removeItem(String index); // remove old item

    void updateItem(String index); // update information old item;

    void displayItem(List<E> itemList); // show information old item;

    String findItemID(); // search information by code
}
