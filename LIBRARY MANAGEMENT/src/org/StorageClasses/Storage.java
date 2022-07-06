package org.StorageClasses;
import org.Stock.stockStorageClass;
import org.User.bookStorageClass;
import org.User.userStorageClass;
import org.librarian.LibrarianStorageClass;

import java.util.HashMap;
import java.util.TreeMap;

public interface Storage {
    TreeMap<String, LibrarianStorageClass> librarianStore(String adminPath);

    TreeMap<String, stockStorageClass> stockStore(String stockPath);

    TreeMap<String, userStorageClass> userStore(String userPath);

    TreeMap<String, HashMap<String, bookStorageClass>> userBooksStore(String tempUserPath);

}
