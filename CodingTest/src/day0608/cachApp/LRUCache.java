package day0608.cachApp;

import java.util.ArrayList;
import java.util.List;

public class LRUCache {
    private List<String> listCache;
    private int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        listCache = new ArrayList<String>();
    }

    public boolean getCity(String City) {
        boolean rtn = false;
        int idxCache = 0;
        if (listCache.size() == 0) {
            listCache.add(City);
        } else {
            while (idxCache < listCache.size()) {
                String cache = listCache.get(idxCache);
                if (cache.equalsIgnoreCase(City)) {
                    changeSlot(idxCache, City);
                    rtn = true;
                    break;
                } else {
                    idxCache++;
                }
            }
            if (!rtn) {
                if (listCache.size() < cacheSize) {
                    listCache.add(City);
                } else {
                    changeSlot(listCache.size(), City);
                }
            }
        }
        return rtn;
    }

    public void changeSlot(int numOfSlot, String value) {
        int idx = 0;
        if (numOfSlot == 0) {
            numOfSlot = listCache.size() - 1;
        }
        while (idx < numOfSlot) {
            listCache.set(idx, listCache.get(idx + 1));
            idx++;
        }
        listCache.set(numOfSlot, value);
        System.out.println("[changeSlot]" + listCache);
    }

}
