package xyz.komas19.komas19lib.inventory.item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Item {

    private Material material;
    private String displayName;
    private List<String> lore;
    private Inventory inventory;

    public Item(Material material, String displayName, List<String> lore)  {
        if (material == null || displayName == null) {
            Bukkit.getLogger().severe("Material and display name are required settings.");
        }
        this.material = material;
        this.displayName = displayName;
        this.lore = lore != null ? lore : new ArrayList<>();
    }

    public static Item add(Material material, String displayName, List<String> lore) {
        return new Item(material, displayName, lore);
    }

    public static Item add(Material material, String displayName) {
        return new Item(material, displayName, new ArrayList<>());
    }

    public Item addToGui(int slot, Inventory inventory) {
        this.inventory = inventory;
        ItemStack item = build();
        inventory.setItem(slot, item);
        return this;
    }

    public Item give(Player player, int slot) {
        ItemStack item = build();
        player.getInventory().setItem(slot, item);
        return this;
    }

    private ItemStack build() {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(displayName);
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        return item;
    }
}
