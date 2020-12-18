package net.evilblock.kits

import net.evilblock.kits.command.*
import net.evilblock.kits.command.parameter.KitParameterType
import net.evilblock.cubed.Cubed
import net.evilblock.cubed.CubedOptions
import net.evilblock.cubed.command.CommandHandler
import net.evilblock.kits.command.admin.*
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class KitsPlugin : JavaPlugin() {

    override fun onEnable() {
        instance = this

        saveDefaultConfig()

        Cubed.instance.configureOptions(CubedOptions(requireRedis = true, requireMongo = true))

        CommandHandler.registerClass(ReloadCommand.javaClass)
        CommandHandler.registerClass(EditorCommand.javaClass)
        CommandHandler.registerClass(CreateCommand.javaClass)
        CommandHandler.registerClass(GiveCommand.javaClass)
        CommandHandler.registerClass(LoadCommand.javaClass)
        CommandHandler.registerClass(SaveCommand.javaClass)
        CommandHandler.registerClass(ResetCooldownCommand.javaClass)

        CommandHandler.registerClass(KitCommand.javaClass)
        CommandHandler.registerClass(KitsCommand.javaClass)

        CommandHandler.registerParameterType(Kit::class.java, KitParameterType)

        KitHandler.initialLoad()
    }

    override fun onDisable() {
        KitHandler.saveData()
    }

    fun getChatPrefix(): String {
        return ChatColor.translateAlternateColorCodes('&', config.getString("chat-prefix"))
    }

    fun getMenuTitle(): String {
        return ChatColor.translateAlternateColorCodes('&', config.getString("menu-title"))
    }

    companion object {
        @JvmStatic
        lateinit var instance: KitsPlugin
    }

}