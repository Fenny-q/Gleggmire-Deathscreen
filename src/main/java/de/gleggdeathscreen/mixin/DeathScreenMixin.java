// GOEY

package de.gleggdeathscreen.mixin;

import de.gleggdeathscreen.GleggDeathScreen;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(DeathScreen.class)
public class DeathScreenMixin {

	@ModifyArg(
			method = "<init>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/screens/Screen;<init>(Lnet/minecraft/network/chat/Component;)V"
			),
			index = 0
	)
	private static Component gleggTitel(Component alt) {
		return Component.literal(GleggDeathScreen.zufall());
	}
}