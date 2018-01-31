package com.twanl.ticketsystem;

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



    public void onEnable() {
        LOAD();
        //mysqlSetup();
        loadConfig();



        Bukkit.getConsoleSender().sendMessage(Strings.logName + "Has been enabled " + PluginVersionOn);
    }



    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Strings.logName + ChatColor.RED + "Has been disabled " + PluginVersionOff);
    }

    public void LOAD() {

        // Register listeners
        //getServer().getPluginManager().registerEvents(new sqlSetterGetter(), this);

        // Register commands
        Commands commands = new Commands();
        getCommand("ticket").setExecutor((CommandExecutor) commands);
    }

    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}