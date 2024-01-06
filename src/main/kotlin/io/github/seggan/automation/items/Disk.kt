package io.github.seggan.automation.items

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import org.bukkit.Material
import java.util.*

class Disk(
    size: Long,
    uuid: UUID
) : SlimefunItemStack(
    "AUTOMATION_FLOPPY_DISK",
    Material.MUSIC_DISC_5,
    "&f软盘",
    "",
    "&7一张可存储数据的软盘。",
    "",
    "&e容量：$size 字节",
    "&eID: $uuid",
)