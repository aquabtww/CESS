package me.aquabtw.cess.listener

import me.aquabtw.cess.CESS
import me.aquabtw.cess.utils.mini
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class ConnectionListener(
    private val main: CESS
) : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        updateJoinMessage(event)
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        updateQuitMessage(event)
    }

    private fun updateJoinMessage(event: PlayerJoinEvent) {
        val player = event.player
        if (!player.hasPlayedBefore()) {
            val uniqueJoins = Bukkit.getOfflinePlayers().size
            event.joinMessage(mini("<green>+ <gray>${player.name} <dark_gray>(${uniqueJoins})"))
        } else {
            event.joinMessage(mini("<green>+ <gray>${player.name}"))
        }
    }

    private fun updateQuitMessage(event: PlayerQuitEvent) {
        event.quitMessage(mini("<red>- <gray>${event.player.name}"))
    }

}