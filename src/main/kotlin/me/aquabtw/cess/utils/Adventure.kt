package me.aquabtw.cess.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver

private fun getResolvers(): TagResolver {
    return TagResolver.resolver(
        TagResolver.standard(),
        Placeholder.parsed("cess", "<bold><gradient:#ffafcc:#bde0fe>CESS<reset>"),
        Placeholder.parsed("dot", "<bold><dark_gray>•<reset>")
    )
}

val miniMessage: MiniMessage =
    MiniMessage.builder()
        .tags(getResolvers())
        .build()

internal fun mini(s: String): Component {
    val component = miniMessage.deserialize(s)
    if (!component.hasDecoration(TextDecoration.ITALIC)) {
        return component.decoration(TextDecoration.ITALIC, false)
    }
    return component
}