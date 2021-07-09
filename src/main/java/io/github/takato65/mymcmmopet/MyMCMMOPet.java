package io.github.takato65.mymcmmopet;

import io.github.takato65.mymcmmopet.bStats.Metrics;
import io.github.takato65.mymcmmopet.commands.MyMcMMOPetCommand;
//import io.github.takato65.mymcmmopet.commands.MyMcMMOPetTabComplete;
import io.github.takato65.mymcmmopet.gui.MenuGui;
import io.github.takato65.mymcmmopet.listeners.PetListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class MyMCMMOPet extends JavaPlugin {

    public static FileConfiguration config;
    public static MyMCMMOPet p;

    public MyMCMMOPet() {p = this;}

    public static void loadConfig(boolean reload){

        p.saveDefaultConfig();

        if(reload)
            p.reloadConfig();
        config = p.getConfig();
        config.options().copyDefaults(true);
        p.saveConfig();
    }
    public static void loadConfig(){
        loadConfig(false);
    }

    @Override
    public void onEnable() {
        //getLogger().info("[MyMCMMOPet] onEnable is called!");

        loadConfig();

        registerEvents();

        initMetrics();
       // getServer().getPluginManager().registerEvents(new PetAttackListener(), this);

        Objects.requireNonNull(getCommand("mmopet")).setExecutor(new MyMcMMOPetCommand());//tells bukkit to register a command
        //getCommand("mmopet").setTabCompleter(new MyMcMMOPetTabComplete());
    }

    public void  initMetrics(){
        Metrics metrics = new Metrics(this,11976);

        metrics.add("pet_attack_get_exp",config.getString(Config.menu[0]));


    }

    public void registerEvents(){
        if (config == null)
            loadConfig();
        PluginManager manager = getServer().getPluginManager();

        manager.registerEvents(new MenuGui(),this);
        //if(config.getBoolean("petAttackGetExp"))
        manager.registerEvents(new PetListener(),this);
//        if(config.getBoolean("petLeashGetExp"))
//            manager.registerEvents(new PetCreateListener(),this);
//        if(config.getBoolean("petReleaseLoseExp"))
//            manager.registerEvents(new PetReleseListener(),this);
//        if(config.getBoolean("petFallDamage"))
//            manager.registerEvents(new PetDamageListener(),this);


    }



    @Override
    public void onDisable() {
        getLogger().info("[MyMCMMOPet] onDisable is called!");
    }
}
