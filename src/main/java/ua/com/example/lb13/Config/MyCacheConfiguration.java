package ua.com.example.lb13.Config;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.com.example.lb13.Entity.Category;

import javax.cache.CacheManager;
import javax.cache.Caching;
import java.time.Duration;
import java.util.ArrayList;
@Configuration
@EnableJpaRepositories(basePackages = "ua.com.example.lb13")

public class MyCacheConfiguration {
    @Bean
    public CacheManager getCacheManager(){
        CacheConfiguration<Long, Category> cacheConfig =
                CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(
                                Long.class,
                                Category.class,
                                ResourcePoolsBuilder.newResourcePoolsBuilder() .offheap(10, MemoryUnit.MB)
                                        .build())
                        .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(60))) .build();
        var cacheProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cacheProvider.getCacheManager(); var configuration =
                Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig);
        cacheManager.createCache("category", configuration);
        var configuration1 =
                Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig);
        cacheManager.createCache("rate", configuration1);
        CacheConfiguration<String, ArrayList> cacheConfig2 =
                CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(
                                String.class,
                                ArrayList.class,
                                ResourcePoolsBuilder.newResourcePoolsBuilder() .offheap(5, MemoryUnit.MB)
                                        .build())
                        .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(120)))
                        .build();
        var configuration2 =
                Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig2);
        cacheManager.createCache("cat", configuration2);
        var configuration3 =
                Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfig2);
        cacheManager.createCache("dog", configuration3);
        return cacheManager;
    }
}