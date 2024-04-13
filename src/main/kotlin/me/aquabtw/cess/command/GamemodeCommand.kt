package me.aquabtw.cess.command

import me.aquabtw.cess.CESS
import me.aquabtw.cess.utils.mini
import org.bukkit.GameMode
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GamemodeCommand(
    private val main: CESS
) : CESSCommand("gmc") {

    override fun onCommand(sender: CommandSender, alias: String, args: Array<out String>) {
        if (sender !is Player) return

        val gameMode = when (alias) {
            "gmc" -> GameMode.CREATIVE
            "gms" -> GameMode.SURVIVAL
            "gmsp" -> GameMode.SPECTATOR
            "gma" -> GameMode.ADVENTURE
            else -> GameMode.SURVIVAL
        }

        sender.gameMode = gameMode
        sender.sendMessage(mini("<cess> <dot> <green>Set your gamemode to ${gameMode.name}"))
    }

    override fun onTabComplete(sender: CommandSender, alias: String, args: Array<out String>): List<String> {
        return emptyList()
    }
}