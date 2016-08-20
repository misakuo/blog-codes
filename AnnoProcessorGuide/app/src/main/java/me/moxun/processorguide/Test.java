package me.moxun.processorguide;

import com.moxun.anno.AnotherMeta;
import com.moxun.anno.Meta;

/**
 * Created by moxun on 16/8/18.
 */
public class Test {
    @Meta(repeat = 3, id = "sss")
    public String test;

    @AnotherMeta
    public String meta;
}
