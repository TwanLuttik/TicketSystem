package com.twanl.ticketsystem.util;

import com.twanl.ticketsystem.TicketSystem;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private TicketSystem plugin = TicketSystem.getPlugin(TicketSystem.class);

    //Files & Config Files
    public FileConfiguration configC;
    public File configF;

    public FileConfiguration ticketC;
    public File ticketF;

    //--------------------


    public void setup() {
        ticketF = new File(plugin.getDataFolder(), "players.yml");
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }


        if (!ticketF.exists()) {
            try {
                ticketF.createNewFile();
                Bukkit.getServer().getConsoleSender().sendMessage(Strings.green + "The players.yml file has been created");
            } catch (IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(Strings.red + "Could not create the players.yml file");
            }
        }

        ticketC = YamlConfiguration.loadConfiguration(ticketF);

    }


    public FileConfiguration getPlayers() {
        return ticketC;

    }



    public void savePlayers() {
        ticketF = new File(plugin.getDataFolder(), "players.yml");

        try {
            ticketC.save(ticketF);
            Bukkit.getServer().getConsoleSender().sendMessage(Strings.green + "The players.yml file has been saved");

        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(Strings.red + "Could not save the players.yml file");

        }
    }


    public void reloadplayers() {
        ticketC = YamlConfiguration.loadConfiguration(ticketF);
        Bukkit.getServer().getConsoleSender().sendMessage(Strings.green + "The players.yml file has been reloaded");

    }

}
