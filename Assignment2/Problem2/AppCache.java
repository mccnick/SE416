package Assignment2.Problem2;

/**
 * Nick McCullough - SE 416 - Assignment 2, Problem 2, Part 1: AppCache.java implementation
 */

public class AppCache 
{
    private static AppCache instance; // static instance
    private Map<EnhancementId, ConfigurationData> cache; // cache storage

    // private constructor prevents instantiation from outside
    private AppCache() 
    {
        cache = new HashMap<>();
    }

    // static method to get the singleton instance
    public static synchronized AppCache getInstance() 
    {
        if (instance == null) 
        {
            instance = new AppCache();
        }
        return instance;
    }

    public void set(EnhancementId enhancementId, ConfigurationData configurationData) 
    {
        cache.put(enhancementId, configurationData); // store or update cached data
    }

    public ConfigurationData get(EnhancementId enhancementId) 
    {
        return cache.get(enhancementId); // retrieve cached data
    }
}