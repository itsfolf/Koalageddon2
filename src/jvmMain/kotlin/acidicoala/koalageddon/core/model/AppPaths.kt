package acidicoala.koalageddon.core.model

import acidicoala.koalageddon.BuildConfig
import acidicoala.koalageddon.core.model.KoalaTool.Koaloader
import net.harawata.appdirs.AppDirsFactory
import kotlin.io.path.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.div

class AppPaths {
    private val userDataDir = Path(
        AppDirsFactory.getInstance().getUserDataDir(
            BuildConfig.APP_NAME,
            "", // appVersion
            BuildConfig.APP_AUTHOR
        )
    )

    val dataDir get() = userDataDir.createDirectories()

    val settings = dataDir / "Koalageddon.settings.json"

    val log = dataDir / "Koalageddon.log.log"

    val cacheDir get() = (dataDir / "cache").createDirectories()

    private val unlockersDir get() = (dataDir / "unlockers").createDirectories()

    private fun getUnlockerDir(unlocker: KoalaTool) = (unlockersDir / unlocker.name).createDirectories()

    fun getKoaloaderConfig(store: Store) = store.directory / Koaloader.configName

    fun getKoaloaderDll(store: Store) = store.directory / "${Koaloader.originalName}.dll"

    fun getUnlockerConfig(unlocker: KoalaTool) = getUnlockerDir(unlocker) / unlocker.configName

    fun getUnlockerLog(unlocker: KoalaTool) = getUnlockerDir(unlocker) / unlocker.logName

    fun getUnlockerDll(unlocker: KoalaTool) = getUnlockerDir(unlocker) / "${unlocker.name}_.dll"

    fun getCacheAsset(filename: String) = cacheDir / filename

    fun getStoreExecutablePath(store: Store) = store.directory / store.executable

}