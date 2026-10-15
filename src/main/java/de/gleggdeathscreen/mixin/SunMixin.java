package de.gleggdeathscreen.mixin;



import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.shaders.UniformType;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SkyRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SkyRenderer.class)
public class SunMixin {

    private static final RenderPipeline GLEGG_SONNE = RenderPipeline.builder()
            .withLocation("gleggdeathscreen/pipeline/glegg_sonne")
            .withVertexShader("core/position_tex")
            .withFragmentShader("core/position_tex")
            .withUniform("DynamicTransforms", UniformType.UNIFORM_BUFFER)
            .withUniform("Projection", UniformType.UNIFORM_BUFFER)
            .withSampler("Sampler0")
            .withBlend(BlendFunction.TRANSLUCENT)
            .withDepthWrite(false)
            .withVertexFormat(DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS)
            .build();

    @Inject(method = "renderSun", at = @At("HEAD"))
    private void start(float alpha, PoseStack p, CallbackInfo ci) {
        p.pushPose();

        Minecraft mc = Minecraft.getInstance();

        if (mc.level != null) {
            long zeit = mc.level.getDayTime() % 24000L;

            if (zeit >= 6000L) {
                p.mulPose(Axis.YP.rotationDegrees(180f));
            }
        }
    }

    @ModifyArg(
            method = "renderSun",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/systems/RenderPass;setPipeline(Lcom/mojang/blaze3d/pipeline/RenderPipeline;)V"
            )
    )
    private RenderPipeline andereFarben(RenderPipeline original) {
        return GLEGG_SONNE;
    }

    @Inject(method = "renderSun", at = @At("TAIL"))
    private void ende(float alpha, PoseStack p, CallbackInfo ci) {
        p.popPose();
    }
}