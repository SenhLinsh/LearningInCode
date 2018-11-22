package com.linsh.code.view.viewpger;

import android.support.v4.view.ViewPager;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/01/09
 *    desc   :
 * </pre>
 */
public class LearnUsingViewPager {

    public void demo(ViewPager viewPager) {
        // 设置 Adapter
        viewPager.setAdapter(new LearnExtendingPagerAdapter());
        // 设置当前选择的页面
        // 参数1: 指定页面的位置
        // 参数2: 是否平滑滚动至该页
        viewPager.setCurrentItem(1);
        viewPager.setCurrentItem(1, false);
        // 设置缓存页面，当前页面的相邻左侧和右侧共 N * 2 个页面会被缓存 (默认为 1)
        viewPager.setOffscreenPageLimit(1);

        // 添加页面改变监听
        viewPager.addOnPageChangeListener(new LearnImplementingViewPagerOnPageChangeListener());
        // 设置页面切换的效果(切换特效 duangduangduang 就看这里了)
        viewPager.setPageTransformer(false, new LearnImplementingPageTransformer());
        viewPager.setPageTransformer(false, new LearnImplementingPageTransformer(), 1);
    }

}
