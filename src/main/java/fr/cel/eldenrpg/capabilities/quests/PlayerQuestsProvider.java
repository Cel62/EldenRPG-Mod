package fr.cel.eldenrpg.capabilities.quests;

import fr.cel.eldenrpg.quest.Quest;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerQuestsProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerQuests> PLAYER_QUESTS = CapabilityManager.get(new CapabilityToken<PlayerQuests>() { });

    private PlayerQuests quests = null;
    private final LazyOptional<PlayerQuests> optional = LazyOptional.of(this::createPlayerQuests);

    private final Player player;

    public PlayerQuestsProvider(Player player) {
        this.player = player;
    }

    private PlayerQuests createPlayerQuests() {
        if (this.quests == null) {
            this.quests = new PlayerQuests(player);
//            this.quests.addQuest(new Quest("beginning", Component.translatable("eldenrpg.quest.beginning"), Quest.QuestState.ACTIVE));
        }

        return this.quests;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_QUESTS) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerQuests().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerQuests().loadNBTData(nbt);
    }
}