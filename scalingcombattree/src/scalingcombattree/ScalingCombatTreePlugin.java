package scalingcombattree;

import com.fs.starfarer.api.BaseModPlugin;

public class ScalingCombatTreePlugin extends BaseModPlugin {
    @Override
    public void onNewGame() {
        onGameLoad(true);
    }

    @Override
    public void onGameLoad(boolean newGame) {
        new AptitudeChange();
    }

}
