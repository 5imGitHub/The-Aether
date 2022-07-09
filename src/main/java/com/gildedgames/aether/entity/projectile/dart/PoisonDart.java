package com.gildedgames.aether.entity.projectile.dart;

import com.gildedgames.aether.entity.AetherEntityTypes;
import com.gildedgames.aether.item.AetherItems;
import com.gildedgames.aether.effect.AetherEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;

public class PoisonDart extends AbstractDart {
    public PoisonDart(EntityType<? extends PoisonDart> type, Level level) {
        super(type, level);
        this.setBaseDamage(2.0);
    }

    public PoisonDart(Level level) {
        super(AetherEntityTypes.POISON_DART.get(), level);
        this.setBaseDamage(2.0);
    }

    @Override
    protected void doPostHurtEffects(@Nonnull LivingEntity living) {
        super.doPostHurtEffects(living);
        if (!this.level.isClientSide) {
            living.addEffect(new MobEffectInstance(AetherEffects.INEBRIATION.get(), 500, 0, false, false));
        }
    }

    @Nonnull
    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(AetherItems.POISON_DART.get());
    }
}