package Assignment2.Problem2;
import Assignment2.Problem2.AppCache;

/**
 * Nick McCullough - SE 416 - Assignment 2, Problem 2, Part 2: Usage Example
 */

public class AppCacheTest 
{
    // getting data from cache
    public ConfigurationData getConfiguration(EnhancementId enhancementId) 
    {
        AppCache cache = AppCache.getInstance(); // get the singleton instance
        ConfigurationData data = cache.get(enhancementId);  // try to get data from cache

        // if not in cache, load from database and cache it
        if (data == null) 
        {
            data = loadConfigurationFromDatabase(enhancementId);
            cache.set(enhancementId, data);
        }
        return data;
    }

    // updating cache with new data
    public void updateConfiguration(EnhancementId enhancementId, ConfigurationData newData) 
    {
        saveConfigurationToDatabase(enhancementId, newData); // update database
        AppCache.getInstance().set(enhancementId, newData);  // update cache
    }
}
