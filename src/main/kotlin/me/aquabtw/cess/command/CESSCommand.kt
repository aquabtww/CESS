package me.aquabtw.cess.command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

abstract class CESSCommand(
    val name: String
) : CommandExecutor, TabCompleter {

    override fun onCommand(sender: CommandSender, command: Command, alias: String, args: Array<out String>): Boolean {
        onCommand(sender, alias, args)
        return true
    }

    override fun onTabComplete(
        sender: CommandSender, command: Command, alias: String, args: Array<out String>
    ): List<String> {
        return onTabComplete(sender, alias, args)
    }

    abstract fun onCommand(sender: CommandSender, alias: String, args: Array<out String>)

    abstract fun onTabComplete(sender: CommandSender, alias: String, args: Array<out String>): List<String>

}