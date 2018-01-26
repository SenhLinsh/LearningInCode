package com.linsh.code.view.viewpger;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.linsh.code.R;
import com.linsh.code.nothing.Way;

/**
 * PagerAdapter 的使用教程
 * 传统的 PagerAdapter 在条目过多, 需要快速滑动的情况下, 会大量的生成和销毁 Item, 所以这种情况下需要自己设计缓存策略, 以保证性能.
 * JakeWharton 的 https://github.com/JakeWharton/salvage 中提供了不错的思路, 可以做到较好的缓存效果, 推荐在条目较多时使用.
 */
public class LicPagerAdapter extends PagerAdapter {

    /**
     * 获取条目数
     *
     * @return 条目数
     */
    @Override
    public int getCount() {
        return 0;
    }

    /**
     * 确认View与实例对象是否相互对应。ViewPager 内部用于获取 View 应的 ItemInfo
     *
     * @param view   ViewPager 显示的 View 内容
     * @param object 在 {@link LicPagerAdapter#instantiateItem(ViewGroup, int)} 中提交给 ViewPager 进行保存的实例对象
     * @return 是否相互对应
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        switch (Way.ways()) {
            case 1:
                // 一般我们可以直接在 instantiateItem 中保存 ItemView 对象, 这里就可以直接判断
                return view == object;
            case 2:
                // 其他的, 也可以保存 ViewHolder
                return view == ((ViewHolder) object).itemView;
        }
        return false;
    }

    /**
     * 初始化条目, 需要自行将 View 添加到 container 中
     *
     * @param container ViewPager 本身
     * @param position  位置
     * @return 提交给 ViewPager 进行保存的实例对象
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 如有需要, 在 destroyItem 对 Item 进行缓存, 就可以复用缓存中的 View
        View cache = Cache.getView(position);

        switch (Way.ways()) {
            case 1:
                // 在这里需要进行 View 的创建, 并主动添加到 container 中
                View view = View.inflate(container.getContext(), R.layout.item, null);
                container.addView(view);
                return view;
            case 2:
                // 也可以创建 ViewHolder, 以便减少 findViewById 的操作
                ViewHolder viewHolder = new ViewHolder();
                container.addView(viewHolder.itemView);
                return viewHolder;
        }
        return null;
    }

    /**
     * 移除指定位置的 Item
     *
     * @param container ViewPager 本身
     * @param position  位置
     * @param object    在 {@link LicPagerAdapter#instantiateItem(ViewGroup, int)} 中提交给 ViewPager 进行保存的实例对象
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // 一般, 我们在这里进行 Item 的 Remove
        View view = (View) object;
        container.removeView(view);
        // 如果有需要, 也可以将被 Remove 的 View 进行缓存
        Cache.saveView(view);
    }

    /**
     * ViewPager 调用该方法来通知 PageAdapter 当前 ViewPager 显示的主要项, 提供给用户对主要项进行操作的方法。
     *
     * @param container ViewPager 本身
     * @param position  给定的位置
     * @param object    在 {@link LicPagerAdapter#instantiateItem(ViewGroup, int)} 中提交给 ViewPager 进行保存的实例对象
     */
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }

    /**
     * 当 ViewPager 的内容变化结束时, 进行调用。当该方法被调用时, 必须确定所有的操作已经结束。
     *
     * @param container ViewPager 本身
     */
    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
    }

    /**
     * 当ViewPager的内容有所变化时,进行调用
     *
     * @param container ViewPager 本身
     */
    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
    }

    /**
     * 当 ViewPager 试图确定某个项的位置是否已更改时调用。默认有两个可选项: POSITION_UNCHANGED 和 POSITION_NONE。
     * POSITION_UNCHANGED : 给定项的位置未变更
     * POSITION_NONE : 给定项不再用于 PagerAdapter 中
     * 其他值: 可以根据具体的情况进行调整
     *
     * @param object 在 {@link LicPagerAdapter#instantiateItem(ViewGroup, int)} 中提交给 ViewPager 进行保存的实例对象
     * @return
     */
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    /**
     * 新增方法, 目前较多用于 Design 库中的 TabLayout 与 ViewPager 进行绑定时, 提供显示的标题。
     *
     * @param position 给定的位置
     * @return 显示的标题
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    /**
     * 获取给定位置的 View 的显示宽度比例, 该比例是相对于 ViewPager。
     *
     * @param position 给定的位置
     * @return View 显示的宽度比例
     */
    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }

    /////////////////////////////////////////////////////////////////////////////////
    public class ViewHolder {
        public View itemView;
    }

    private static class Cache {

        private static void saveView(View view) {
        }

        private static View getView(int position) {
            return null;
        }
    }
}
