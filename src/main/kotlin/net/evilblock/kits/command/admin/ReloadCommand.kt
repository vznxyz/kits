/*
 * Copyright (c) 2020. Joel Evans
 *
 * Use and or redistribution of compiled JAR file and or source code is permitted only if given
 * explicit permission from original author: Joel Evans
 */

package net.evilblock.kits.command.admin

import net.evilblock.kits.KitsPlugin
import net.evilblock.cubed.command.Command
import org.bukkit.ChatColor
import org.bukkit.entity.Player

object ReloadCommand {

    @Command(
        names = ["kit reload", "kits reload", "kit rl", "kits rl"],
        description = "Reloads the Kits configuration",
        permission = "kits.reload"
    )
    @JvmStatic
    fun execute(player: Player) {
        KitsPlugin.instance.reloadConfig()
        player.sendMessage("${ChatColor.GREEN}Reloaded Kits configuration!")
    }

}