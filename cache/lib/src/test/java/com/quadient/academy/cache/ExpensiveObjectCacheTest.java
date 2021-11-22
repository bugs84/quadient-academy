package com.quadient.academy.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ExpensiveObjectCacheTest {

    public static final int CACHE_EXPIRATION_TIME = 5000;

    @Mock
    TimeProvider timeProvider;

    @InjectMocks
    ExpensiveObjectCache expensiveObjectCache;

    ExpensiveObject expensiveObject1 = mock(ExpensiveObject.class);
    ExpensiveObject expensiveObject2 = mock(ExpensiveObject.class);

    long currentTime = getTimeInMillis("21.3.2009 10:00:00");

    @Test
    public void getCachedObjectsReturnsEmptyCollectionWhenNothingWasAdded() {
        // when
        Collection<ExpensiveObject> cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects).isEmpty();
    }

    @Test
    public void getCachedObjectsReturnsAddedObject() {
        // given
        addObjectIntoCache(expensiveObject1);

        // when
        Collection<ExpensiveObject> cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects).isEqualTo(singletonList(expensiveObject1));
    }

    @Test
    public void getCachedObjectsDoNotReturnExpiredObject() {
        // given
        addObjectIntoCache(expensiveObject1);
        wait(CACHE_EXPIRATION_TIME + 1);

        // when
        Collection<ExpensiveObject> cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects).isEmpty();
    }

    @Test
    public void objectIsHoldForWholeCacheExpirationPeriod() {
        // given
        addObjectIntoCache(expensiveObject1);
        wait(CACHE_EXPIRATION_TIME);

        // when
        Collection<ExpensiveObject> cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects).isEqualTo(singletonList(expensiveObject1));
    }

    @Test
    public void expirationOfMultipleObjects() {
        // given
        addObjectIntoCache(expensiveObject1);
        wait(CACHE_EXPIRATION_TIME - 100);
        addObjectIntoCache(expensiveObject2);

        // when
        Collection<ExpensiveObject> cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects).isEqualTo(asList(expensiveObject1, expensiveObject2));

        // when
        wait(101);
        cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects).isEqualTo(singletonList(expensiveObject2));

        // when
        wait(CACHE_EXPIRATION_TIME - 100);
        cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects).isEmpty();
    }

    private void addObjectIntoCache(ExpensiveObject expensiveObject) {
        given(timeProvider.getCurrentTime()).willReturn(currentTime);
        expensiveObjectCache.add(expensiveObject);
    }

    private void wait(int millisToWait) {
        currentTime += millisToWait;
        given(timeProvider.getCurrentTime()).willReturn(currentTime);
    }

    long getTimeInMillis(String dateTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            return sdf.parse(dateTime).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}