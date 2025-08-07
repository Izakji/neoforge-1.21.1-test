package com.izakji.testmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class BlackOpalLampBlock extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public BlackOpalLampBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        boolean currentState = state.getValue(CLICKED);

        if(!level.isClientSide) {
            level.setBlock(pos, state.setValue(CLICKED, !currentState), 3);
        }

        if(currentState) {
            level.playSound(player, pos, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundSource.BLOCKS, 1f, 1f);
        }

        level.playSound(player, pos, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundSource.BLOCKS, 1f, 1f);

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }
}
