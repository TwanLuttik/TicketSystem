package com.twanl.ticketsystem;

import com.twanl.ticketsystem.util.ConfigManager;
import com.twanl.ticketsystem.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TicketSystem extends JavaPlugin {

    protected PluginDescriptionFile pdfFile = getDescription();
    private final String PluginVersionOn = ChatColor.GREEN + "(" + pdfFile.getVersion() + ")";
    private final String PluginVersionOff = ChatColor.RED + "(" + pdfFile.getVersion() + ")";
    public ConfigManager cfgM;

    private Connection connection;
    public String host, database, username, password;
    public int port;


    public void onEnable() {
        loadConfigManager();
        LOAD();
        mysqlSetup();

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

    public void mysqlSetup() {
        host = "localhost";
        port = 3306;
        database = "tickets";
        username = "root";
        password = "password";

        try {
            synchronized (this) {
                if (getConnection() != null && !getConnection().isClosed()) {
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection( DriverManager.getConnection("jdbc:mysql://" + this.host + ":"
                        + this.port + "/" + this.database, this.username, this.password ));

                Bukkit.getConsoleSender().sendMessage(Strings.green + "MYSQL CONNECTED");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}