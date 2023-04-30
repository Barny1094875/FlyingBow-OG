package me.barny1094875.flyingbowog.Commands;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;

public class giveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        // if the command is /flyingbow
        if(command.getName().equalsIgnoreCase("flyingbow")){
            // if the command is just /flyingbow give
            if(args.length == 1) {
                if (args[0].equalsIgnoreCase("give")) {
                    Player player = (Player) sender;
                    // if the player is in creative mode, allow them to
                    // give bows
                    if (player.hasPermission("flyingbow.cangive")) {
                        // create the flying bow item
                        ItemStack flyingBowItem = new ItemStack(Material.BOW);
                        ItemMeta bowMeta = flyingBowItem.getItemMeta();
                        bowMeta.displayName(Component.text("Flying Bow")
                                .color(TextColor.color(0, 255, 255))
                                .decorate(TextDecoration.ITALIC));
                        bowMeta.lore(Collections.singletonList(Component.text("Shoot this bow to FLY")));
                        flyingBowItem.setItemMeta(bowMeta);
                        flyingBowItem.addItemFlags(ItemFlag.HIDE_DYE);

                        player.getInventory().addItem(flyingBowItem);
                    }
                    // tell the player that they don't have permission to use this command
                    else{
                        sender.sendMessage(Component.text("[FlyingBow]")
                                .color(TextColor.color(0, 255, 0))
                                .append(Component.text(" You Don't Have Permission to do That!")
                                        .color(TextColor.color(255, 0, 0))));
                    }
                }
            }
        }

        return true;

    }



}
