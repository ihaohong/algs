package com.haohong.ch03;

import com.haohong.ch03.inter.ST;
import junit.framework.TestCase;

/**
 * Created by haohong on 13/12/2017.
 */
public class STTest extends TestCase {
    public void testST() {
        ST<String, String> st = new SequentialSearchST<String, String>();

        assert st.size() == 0;
        assert st.isEmpty();

        assert !st.contains("foo");

        st.put("foo", "bar");
        assert st.contains("foo");
        assert st.size() == 1;
        assert !st.isEmpty();

        st.put("foo2", "bar2");
        assert st.contains("foo2");
        assert st.size() == 2;

        assert st.get("foo").equals("bar");
        assert st.get("foo2").equals("bar2");

        st.put("foo", "barbar");
        assert st.size() == 2;
        assert st.get("foo").equals("barbar");
    }
}
