package io.github.seggan.automation.commands

import io.github.seggan.automation.managers.DiskManager
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player
import java.nio.file.OpenOption
import java.nio.file.StandardOpenOption
import kotlin.io.path.inputStream
import kotlin.io.path.outputStream

object CreateCommand : TabExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        if (args.size != 1) return false

        if (!sender.isOp) {
            sender.sendMessage("你必须拥有 OP 权限。")
            return true
        }

        val size = args.first().toLongOrNull() ?: return false
        sender.inventory.addItem(DiskManager.createDisk(size))
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): MutableList<String> = mutableListOf()
}

object SfDosCommand : TabExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        val diskItem = sender.inventory.itemInMainHand
        val disk = DiskManager.getDisk(diskItem)
        if (disk == null) {
            sender.sendMessage("你必须手持磁盘才能使用该指令")
            return true
        }

        disk.getPath("init.metis").outputStream().buffered().use { out ->
            javaClass.getResourceAsStream("/init.metis")!!.use { it.copyTo(out) }
        }

        sender.sendMessage("该磁盘已格式化并安装了最新版本的 SF-DOS。")

        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): MutableList<String> = mutableListOf()
}