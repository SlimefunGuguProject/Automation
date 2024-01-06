package io.github.seggan.automation.registries

import io.github.seggan.automation.computing.peripherals.Sensor
import io.github.seggan.automation.items.Computer
import io.github.seggan.automation.items.Cpu
import io.github.seggan.automation.items.Disk
import io.github.seggan.automation.items.Peripheral
import io.github.seggan.automation.util.MaterialType
import io.github.seggan.automation.util.buildSlimefunItem
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import org.bukkit.Material
import java.util.*

@Suppress("MemberVisibilityCanBePrivate")
object Items {

    //<editor-fold desc="CPUs" defaultstate="collapsed">
    val IRON_CPU = buildSlimefunItem {
        name = "&f铁 CPU"
        id = "IRON_CPU"
        material = MaterialType.Head(Heads.IRON_CPU)
        +"&7由铁制成的 CPU。"
        +"&7时钟速度并不是很快，但是便宜。"
        +""
        +"&e主频：2 Hz"
    }

    val GOLD_CPU = buildSlimefunItem {
        name = "&6金 CPU"
        id = "GOLD_CPU"
        material = MaterialType.Head(Heads.GOLD_CPU)
        +"&7由金制成的 CPU。"
        +"&7时钟速度比铁制的快，但是还不够快。"
        +""
        +"&e主频：16 Hz"
    }

    val REDSTONE_CPU = buildSlimefunItem {
        name = "&4红石 CPU"
        id = "REDSTONE_CPU"
        material = MaterialType.Head(Heads.REDSTONE_CPU)
        +"&7由红石制成的 CPU。"
        +"&7一款物美价廉的 CPU。"
        +""
        +"&e主频：64 Hz"
    }

    val DIAMOND_CPU = buildSlimefunItem {
        name = "&b钻石 CPU"
        id = "DIAMOND_CPU"
        material = MaterialType.Head(Heads.DIAMOND_CPU)
        +"&7由钻石制成的处理器。"
        +"&7时钟速度很快，但是非常昂贵。"
        +""
        +"&e主频：256 Hz"
    }

    val REINFORCED_CPU = buildSlimefunItem {
        name = "&7强化合金 CPU"
        id = "REINFORCED_CPU"
        material = MaterialType.Head(Heads.REINFORCED_CPU)
        +"&7由强化合金制成的 CPU。"
        +"&7时钟速度极快，但也非常昂贵。"
        +""
        +"&e主频：1024 Hz"
    }

    val NPU = buildSlimefunItem {
        name = "&1纳米 CPU"
        id = "NPU"
        material = MaterialType.Head(Heads.NPU)
        +"&7运用了纳米科技的 CPU。"
        +"&7非常复杂且昂贵。也许会性能过剩。"
        +""
        +"&e主频：不止于快"
    }
    //</editor-fold>

    //<editor-fold desc="Peripherals" defaultstate="collapsed">
    val SENSOR_1 = buildSlimefunItem {
        name = "&f传感器 I"
        id = "SENSOR_1"
        material = MaterialType.Material(Material.BEACON)
        +"&7一台可获取周围"
        +"&7方块与实体信息的传感器。"
        +""
        +"&e范围：4 格"
    }

    val SENSOR_2 = buildSlimefunItem {
        name = "&f传感器 II"
        id = "SENSOR_2"
        material = MaterialType.Material(Material.BEACON)
        +"&7一台可获取周围"
        +"&7方块与实体信息的传感器。"
        +""
        +"&e范围：16 格"
    }

    val SENSOR_3 = buildSlimefunItem {
        name = "&f传感器 III"
        id = "SENSOR_3"
        material = MaterialType.Material(Material.BEACON)
        +"&7一台可获取周围"
        +"&7方块与实体信息的传感器。"
        +""
        +"&e范围：64 格"
    }
    //</editor-fold>

    val DISK: SlimefunItemStack = Disk(512, UUID(0, 0))

    val COMPUTER = buildSlimefunItem {
        name = "&f计算机"
        id = "COMPUTER"
        material = MaterialType.Head(Heads.PC)
        +"&7一台可以运行程序的计算机。"
    }

    fun register(addon: SlimefunAddon) {
        Cpu(Groups.COMPONENTS, IRON_CPU, 2, RecipeType.NULL, arrayOf()).register(addon)
        Cpu(Groups.COMPONENTS, GOLD_CPU, 16, RecipeType.NULL, arrayOf()).register(addon)
        Cpu(Groups.COMPONENTS, REDSTONE_CPU, 64, RecipeType.NULL, arrayOf()).register(addon)
        Cpu(Groups.COMPONENTS, DIAMOND_CPU, 256, RecipeType.NULL, arrayOf()).register(addon)
        Cpu(Groups.COMPONENTS, REINFORCED_CPU, 1024, RecipeType.NULL, arrayOf()).register(addon)
        Cpu(Groups.COMPONENTS, NPU, Int.MAX_VALUE, RecipeType.NULL, arrayOf()).register(addon)

        Peripheral(Groups.COMPONENTS, SENSOR_1, Sensor(4), RecipeType.NULL, arrayOf()).register(addon)
        Peripheral(Groups.COMPONENTS, SENSOR_2, Sensor(16), RecipeType.NULL, arrayOf()).register(addon)
        Peripheral(Groups.COMPONENTS, SENSOR_3, Sensor(64), RecipeType.NULL, arrayOf()).register(addon)

        SlimefunItem(Groups.COMPONENTS, DISK, RecipeType.NULL, arrayOf()).register(addon)
        Computer(Groups.MACHINES, COMPUTER, RecipeType.NULL, arrayOf()).register(addon)
    }
}