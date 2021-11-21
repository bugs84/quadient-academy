package com.quadient.academy.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ExpensiveObjectCache {

    private static final long HOLD_TIME = 5 * 1000;

    private Collection<CachedObject> cache = new ArrayList<>();

    public synchronized void add(ExpensiveObject expensiveObject) {
        CachedObject cachedObject = new CachedObject(System.currentTimeMillis(), expensiveObject);
        cache.add(cachedObject);
    }

    public synchronized Collection<ExpensiveObject> getCachedObjects() {
        removeOldObjects();
        return cache.stream().map(co -> co.cachedObject).collect(Collectors.toList());
    }

    private void removeOldObjects() {
        long threshold = System.currentTimeMillis() - HOLD_TIME;
        cache.removeIf(cachedObject -> cachedObject.additionTime < threshold);
    }

    private class CachedObject {
        long additionTime;
        ExpensiveObject cachedObject;

        CachedObject(long addedTime, ExpensiveObject cachedObject) {
            this.additionTime = addedTime;
            this.cachedObject = cachedObject;
        }
    }


}
