package io.github.takato65.mymcmmopet;

import io.github.takato65.mymcmmopet.listeners.EntityListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MyMCMMOPet extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[MyMCMMOPet] onEnable is called!");
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
    }
    @Override
    public void onDisable() {
        getLogger().info("[MyMCMMOPet] onDisable is called!");
    }
}
