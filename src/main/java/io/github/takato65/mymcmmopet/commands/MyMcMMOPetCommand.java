package io.github.takato65.mymcmmopet.commands;

import io.github.takato65.mymcmmopet.gui.MenuGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MyMcMMOPetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length ==0) {
            if (sender instanceof Player) {

                new MenuGui().openInventory((HumanEntity) sender);
                return true;
            }
            sender.sendMessage("Error Not Player can't open Menu");
            return false;
        }

        sender.sendMessage("Still WIP");

        return false;
    }

}
