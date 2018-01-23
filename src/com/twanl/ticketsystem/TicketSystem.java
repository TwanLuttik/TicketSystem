package com.twanl.ticketsystem;

import com.twanl.ticketsystem.util.ConfigManager;
import com.twanl.ticketsystem.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class TicketSystem extends JavaPlugin {

    protected PluginDescriptionFile pdfFile = getDescription();
    private final String PluginVersionOn = ChatColor.GREEN + "(" + pdfFile.getVersion() + ")";
    private final String PluginVersionOff = ChatColor.RED + "(" + pdfFile.getVersion() + ")";
    public ConfigManager cfgM;

    public void onEnable() {
        loadConfigManager();
        LOAD();

        Bukkit.getConsoleSender().sendMessage(Strings.logName + "Has been enabled " + PluginVersionOn);
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Strings.logName + ChatColor.RED + "Has been disabled " + PluginVersionOff);
    }

    public void LOAD() {

        // Register listeners
        //getServer().getPluginManager().registerEvents(new EventsClass(), this);

        // Register commands
        Commands commands = new Commands();
        getCommand("ticket").setExecutor((CommandExecutor) commands);


        //LoadConfig
        getConfig().options().copyDefaults(true);
    }


    public void loadConfigManager() {
        cfgM = new ConfigManager();
        cfgM.setup();
        cfgM.savePlayers();
        cfgM.reloadplayers();
    }
}