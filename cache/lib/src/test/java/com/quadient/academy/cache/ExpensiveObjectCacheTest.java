package com.quadient.academy.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@SuppressWarnings({"WeakerAccess", "SameParameterValue"})
@RunWith(MockitoJUnitRunner.class)
public class ExpensiveObjectCacheTest {

    public static final int CACHE_EXPIRATION_TIME = 5000;

    @Mock
    TimeProvider timeProvider;

    @InjectMocks
    ExpensiveObjectCache expensiveObjectCache;

    ExpensiveObject expensiveObject1 = mock(ExpensiveObject.class);
    ExpensiveObject expensiveObject2 = mock(ExpensiveObject.class);

    long currentTime = getTimeInMillis("21.3.2009 10:00:00");

    public ExpensiveObjectCacheTest() throws ParseException {
    }

    @Test
    public void getCachedObjectsReturnsEmptyCollectionWhenNothingWasAdded() {
        // when
        Collection<ExpensiveObject> cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects, is(emptyList()));
    }

    @Test
    public void getCachedObjectsReturnsAddedObject() {
        // given
        addObjectIntoCache(expensiveObject1);

        // when
        Collection<ExpensiveObject> cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects, equalTo(singletonList(expensiveObject1)));
    }

    @Test
    public void getCachedObjectsDoNotReturnExpiredObject() {
        // given
        addObjectIntoCache(expensiveObject1);
        wait(CACHE_EXPIRATION_TIME + 1);

        // when
        Collection<ExpensiveObject> cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects, is(emptyList()));
    }

    @Test
    public void objectIsHoldForWholeCacheExpirationPeriod() {
        // given
        addObjectIntoCache(expensiveObject1);
        wait(CACHE_EXPIRATION_TIME);

        // when
        Collection<ExpensiveObject> cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects, is(singletonList(expensiveObject1)));
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
        assertThat(cachedObjects, is(asList(expensiveObject1, expensiveObject2)));

        // when
        wait(101);
        cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects, is(singletonList(expensiveObject2)));

        // when
        wait(CACHE_EXPIRATION_TIME - 100);
        cachedObjects = expensiveObjectCache.getCachedObjects();

        // then
        assertThat(cachedObjects, is(emptyList()));
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