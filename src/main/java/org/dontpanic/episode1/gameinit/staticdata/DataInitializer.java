package org.dontpanic.episode1.gameinit.staticdata;

import org.dontpanic.episode1.logging.BaseDataLogger;

public interface DataInitializer {
    InitializedData initData(BaseDataLogger baseDataLogger);
}
