package com.twanl.ticketsystem;

import com.twanl.ticketsystem.util.Strings;
import net.minecraft.server.v1_12_R1.CommandExecute;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class Commands extends CommandExecute implements Listener, CommandExecutor {

    private Plugin plugin = TicketSystem.getPlugin(TicketSystem.class);




    /** USERS COMMANDS
     * /ticket create <type> <description>
     * /ticket
     *
     *
     *
     */

    /** ADMIN COMMANDS
     * /ticket status
     * /ticket status <number>
     *
     *
     */

    /**
     * TYPE:
     *   BUG, REPORT, OTHER
     *
     */



    @Override
    public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.logName + ChatColor.RED + "Only a player can execute commands!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("ticket")) {
            if (args.length == 0) {
                p.sendMessage(Strings.DgrayBIS + "                                    -\n" +
                        Strings.yellowB + "        TicketSystem " + Strings.whiteB + plugin.getDescription().getVersion() + "\n" +
                        Strings.yellow + "/ticket create " + Strings.white + "- create a new ticket\n" +
                        Strings.DgrayBIS + "                                    -\n");
            } else if (args[0].equalsIgnoreCase("create")) {


            }
        }


        return true;
    }

}
