package ie.getgyps;

import com.google.common.collect.Lists;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import ie.getgyps.commands.CommandUtil;
import ie.getgyps.events.PackInitialization;
import ie.getgyps.obtainables.SimpleBlockItem;
import ie.getgyps.obtainables.block.SimpleBlock;
import ie.getgyps.obtainables.item.SimpleItem;
import ie.getgyps.registry.GypsiRegistry;
import net.minecraft.command.CommandSource;

import java.util.List;


public class Main {
    public static void main() {
        SimpleItem sitem = new SimpleItem().register("modabc", "itemdef");
        SimpleBlock sblock = new SimpleBlock().register("modabc", "blockdef");
        SimpleBlockItem sblockitem = new SimpleBlockItem(sblock).register("modabc", "blockdef");
        List<String> pathsItem = Lists.newArrayList("itemdef.png");
        List<String> pathsBlock = Lists.newArrayList("itemdef.png");
        List<String> itemnames = Lists.newArrayList("itemdef");
        List<String> blocknames = Lists.newArrayList("blockdef");
        List<String> types = Lists.newArrayList("block", "item");
        List<String> givenames = Lists.newArrayList("blockdef", "itemdef");
        List<String> fullnames = Lists.newArrayList("Test Block", "Test Item");
        PackInitialization.resourcePackItemData(pathsItem, itemnames, "modabc", "modabc", "test pack", true);
        PackInitialization.resourcePackBlockData(pathsBlock, blocknames, "modabc", "modabc", "test pack", true);
        PackInitialization.resourcePackLanguageData(types, givenames, fullnames, "modabc", "modabc", "test pack", "en_us", true);

        GypsiRegistry.register("helloworld", 4, (CommandContext<CommandSource> src)-> {
            CommandUtil.reply(src, "bruh");
            return 0;
        });
    }
}
