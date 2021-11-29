package paulevs.betternether.world.features;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import paulevs.betternether.biomes.NetherBiome;
import paulevs.betternether.world.BNWorldGenerator;
import ru.bclib.world.features.DefaultFeature;

import java.util.Random;
import java.util.function.Supplier;

public class NetherChunkPopulatorFeature extends DefaultFeature {
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
		final Random random = featurePlaceContext.random();
		final BlockPos worldPos = featurePlaceContext.origin();
		final WorldGenLevel level = featurePlaceContext.level();
		//final ChunkPos cPos = level.getChunk(pos).getPos();
		
		final int sx = (worldPos.getX() >> 4) << 4;
		final int sz = (worldPos.getZ() >> 4) << 4;
		
		BNWorldGenerator.prePopulate(level, sx, sz, random);
		BNWorldGenerator.populate(level, sx, sz, random);
		BNWorldGenerator.cleaningPass(level, sx, sz);
		
		return true;
	}
}
