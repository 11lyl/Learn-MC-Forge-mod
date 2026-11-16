package com.lyl.learnmod.datagen;

import com.lyl.learnmod.LearnMod;
import com.lyl.learnmod.block.ModBlocks;
import com.lyl.learnmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

/**
 * 生成语言文件（assets/learn_mod/lang/&lt;locale&gt;.json）。
 *
 * <p>同一个类传入不同 locale 就能出不同语言，所以中英文各 new 一次。</p>
 */
public class ModLangProvider extends LanguageProvider {

    private final String locale;

    public ModLangProvider(PackOutput output, String locale) {
        super(output, LearnMod.MOD_ID, locale);
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        if ("zh_cn".equals(locale)) {
            // ---------- 物品 ----------
            addItem(ModItems.LEAD, "铅");
            addItem(ModItems.GRAPHITE, "石墨");
            addItem(ModItems.META_GLASS, "钢化玻璃");
            addItem(ModItems.PHASE_FABRIC, "相织布");
            addItem(ModItems.PLASTANIUM, "塑钢");

            // ---------- 方块 ----------
            addBlock(ModBlocks.LEAD_ORE, "铅矿石");
            addBlock(ModBlocks.GRAPHITE_ORE, "石墨矿石");
            addBlock(ModBlocks.LEAD_CRYSTAL, "铅晶簇");
            addBlock(ModBlocks.PHASE_FABRIC_WALL, "相织布墙");
            addBlock(ModBlocks.PLASTANIUM_WALL, "塑钢墙");
            addBlock(ModBlocks.COPPER_WALL, "铜墙");

            // ---------- 创造模式标签页 ----------
            add("itemGroup.mindustry_tab", "像素工厂");
        } else {
            // ---------- items ----------
            addItem(ModItems.LEAD, "Lead");
            addItem(ModItems.GRAPHITE, "Graphite");
            addItem(ModItems.META_GLASS, "Meta Glass");
            addItem(ModItems.PHASE_FABRIC, "Phase Fabric");
            addItem(ModItems.PLASTANIUM, "Plastanium");

            // ---------- blocks ----------
            addBlock(ModBlocks.LEAD_ORE, "Lead Ore");
            addBlock(ModBlocks.GRAPHITE_ORE, "Graphite Ore");
            addBlock(ModBlocks.LEAD_CRYSTAL, "Lead Crystal Cluster");
            addBlock(ModBlocks.PHASE_FABRIC_WALL, "Phase Fabric Wall");
            addBlock(ModBlocks.PLASTANIUM_WALL, "Plastanium Wall");
            addBlock(ModBlocks.COPPER_WALL, "Copper Wall");

            // ---------- creative tab ----------
            add("itemGroup.mindustry_tab", "Mindustry Tab");
        }
    }
}
