package me.aquabtw.cess

import me.aquabtw.cess.command.GamemodeCommand
import me.aquabtw.cess.listener.ConnectionListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class CESS : JavaPlugin() {

    override fun onEnable() {
        registerListeners()
        registerCommands()

        logger.info("CESS has started!")
    }

    private fun registerCommands() {
        setOf(
            GamemodeCommand(this)
        ).forEach {
            val command = getCommand(it.name)
                ?: return@forEach
            command.setExecutor(it)
            command.tabCompleter = it
        }
    }

    private fun registerListeners() {
        setOf(
            ConnectionListener(this)
        ).forEach {
            Bukkit.getPluginManager().registerEvents(it, this)
        }
    }

}