package xyz.komas19.komas19lib.inventory.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class Gui {

    public static Inventory make(int size, String name) {
        // Check if size is a multiple of 9
        if (size % 9 != 0) {
            Bukkit.getLogger().severe("GUI size must be a multiple of 9.");
        }

        // Create the GUI with the specified size and name
        return Bukkit.createInventory(null, size, name);
    }
}
