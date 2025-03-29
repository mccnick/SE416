package Assignment2.Problem2;

/**
 * Nick McCullough - SE 416 - Assignment 2, Problem 2, Part 3: Thread Safety
 */

public class AppCacheSafe 
{
    private static volatile AppCache instance;  // volatile <-- important
    private final ConcurrentHashMap<EnhancementId, ConfigurationData> cache; // final, thread-safe

    private AppCacheSafe() 
    {
        cache = new ConcurrentHashMap<>();
    }

    public static AppCache getInstance() 
    {
        if (instance == null) {
            synchronized (AppCache.class) 
            {
                if (instance == null) 
                {
                    instance = new AppCache();
                }
            }
        }
        return instance;
    }

    // methods are now thread-safe due to use of a ConcurrentHashMap
    public void set(EnhancementId enhancementId, ConfigurationData configurationData) {
        cache.put(enhancementId, configurationData);
    }

    
    public ConfigurationData get(EnhancementId enhancementId) {
        return cache.get(enhancementId);
    }
}