package me.megabot.pvpcustomdmg.executor;

import me.megabot.pvpcustomdmg.config.DamageConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DamageConfigExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
            return true;
        }

        if (args.length > 2 || args.length < 1) return false;

        CommandArg cmdArg = CommandArg.getArgument(args[0]);
        if (cmdArg == null) {
            sender.sendMessage(
                    ChatColor.DARK_RED + "Uh oh! That's an invalid command.");
            return true;
        }

        switch(cmdArg) {
            case MULTIPLY:
                if (args.length == 2) multiplyHandler(sender, args[1]);
                else multiplyHandler(sender, "");
                break;
            case TOGGLE_BASE:
                if (args.length == 1) toggleBaseHandler(sender);
                else sender.sendMessage(ChatColor.DARK_RED + "Uh oh! That's an invalid command.");
                break;
            case SET_BASE:
                if (args.length == 2) setBaseHandler(sender, args[1]);
                else setBaseHandler(sender, "");
                break;
            default:
                sender.sendMessage(ChatColor.DARK_RED + "Uh oh! That's an invalid command.");
        }

        return true;
    }

    private void multiplyHandler(CommandSender sender, String value) {
        if (value.isEmpty()) {
            sender.sendMessage(ChatColor.DARK_RED + "Uh oh! That's an invalid command.");
            return;
        }

        int multiplier;
        try {
            multiplier = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.DARK_RED + "Uh oh! That's an invalid value.");
            return;
        }
        DamageConfig.setDmgPercentageMulti(multiplier);
        sender.sendMessage(ChatColor.DARK_GREEN + "Damage multiplier set to " + multiplier + "%.");
    }

    private void toggleBaseHandler(CommandSender sender) {
        DamageConfig.setIsBaseEnabled(!DamageConfig.isBaseEnabled());
        sender.sendMessage(
                ChatColor.DARK_GREEN +
                        "Base damage is " +
                        (DamageConfig.isBaseEnabled() ? "enabled" : "disabled") +
                        ".");
    }

    private void setBaseHandler(CommandSender sender, String value) {
        if (value.isEmpty()) {
            sender.sendMessage(ChatColor.DARK_RED + "Uh oh! That's an invalid command.");
            return;
        }

        double damage;
        try {
            damage = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.DARK_RED + "Uh oh! That's an invalid value.");
            return;
        }
        DamageConfig.setBaseDmg(damage);
        sender.sendMessage(ChatColor.DARK_GREEN + "Base damage set to " + damage + ".");
    }

    private enum CommandArg {
        MULTIPLY,
        TOGGLE_BASE,
        SET_BASE;

        public static CommandArg getArgument(String arg) {
            arg = arg.toLowerCase();
            return switch (arg) {
                case "multiply" -> MULTIPLY;
                case "toggle-base" -> TOGGLE_BASE;
                case "set-base" -> SET_BASE;
                default -> null;
            };
        }
    }
}
