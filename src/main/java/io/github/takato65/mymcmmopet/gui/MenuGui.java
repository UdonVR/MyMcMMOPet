package io.github.takato65.mymcmmopet.gui;

import io.github.takato65.mymcmmopet.Config;
import io.github.takato65.mymcmmopet.MyMCMMOPet;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class MenuGui implements Listener {
    private final Inventory inv;


    public MenuGui() {



        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 9, "Example");



        // Put the items into the inventory
        //initializeItems();
        resetItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {

        inv.addItem(configVarItem("petAttackGetExp"));
        inv.addItem(configVarItem("petLeashGetExp"));
        inv.addItem(configVarItem("petFallDamage"));
        inv.addItem(configVarItem("petReleaseLoseExp"));
        inv.addItem(createGuiItem(Material.WRITTEN_BOOK,"Reload Config"));


    }
    protected void resetItems() {

        inv.setItem(0,configVarItem("petAttackGetExp"));
        inv.setItem(1,configVarItem("petLeashGetExp"));
        inv.setItem(2,configVarItem("petFallDamage"));
        inv.setItem(3,configVarItem("petReleaseLoseExp"));
        inv.setItem(4,createGuiItem(Material.WRITTEN_BOOK,"Reload Config"));

    }
    protected ItemStack configVarItem(final String var){
        ItemStack item;
        switch (var){
            case "petAttackGetExp":
              item = configVarBoolItem(Material.DIAMOND_SWORD,var, "Does player get McMMO Taming Experience when a MyPet attacks");
              break;
            case "petLeashGetExp":
               item= configVarBoolItem(Material.LEAD, "petLeashGetExp","Does player get McMMO Taming Experience when Leashing a MyPet");
                break;
            case "petReleaseLoseExp":
                item= configVarBoolItem(Material.BIRCH_FENCE_GATE,"petReleaseLoseExp","Does player lose McMMO Taming Experience when Releasing a MyPet");
                break;
            case  "petFallDamage":
                item= configVarBoolItem(Material.BLUE_CONCRETE_POWDER,"petFallDamage","Does a MyPet take fall damage");
                break;
            default:
                item = createGuiItem(Material.BARRIER,"Error","config unknown");
                break;
        }
        return item;
    }

    protected ItemStack configVarBoolItem(final Material mat, final String varPath, final String description){
        return createGuiItem(mat,varPath,description,MyMCMMOPet.config.getString(varPath));
    }

    // Nice little method to create a gui item with a custom name, and description
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        if (name != null) {
            assert meta != null;
            meta.setDisplayName(name);
        }
        // Set the name of the item
        assert meta != null;
        meta.setDisplayName(" ");

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    public void handleClick(int slot){
        if(slot >= Config.menu.length)
            return;

        String clicked = Config.menu[slot];
        if(clicked.equals("Reload Config")){
            MyMCMMOPet.loadConfig(true);
            resetItems();
        }
        else if(slot < Config.menu.length-1){
            boolean value = MyMCMMOPet.config.getBoolean(clicked);
            MyMCMMOPet.config.set(clicked,!value);
            MyMCMMOPet.p.saveConfig();
            inv.setItem(slot,configVarItem(clicked));
            //MyMCMMOPet.p.
        }


    }
    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != inv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        int slot = e.getRawSlot();
        p.sendMessage("You clicked at slot " + slot);
        if(slot == 0){
            boolean value = MyMCMMOPet.config.getBoolean("petAttackGetExp");
            MyMCMMOPet.config.set("petAttackGetExp",!value);
            MyMCMMOPet.p.saveConfig();
            inv.setItem(slot,configVarItem("petAttackGetExp"));
        }
        else if (slot ==4){
            MyMCMMOPet.loadConfig(true);
            resetItems();
        }


    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}

